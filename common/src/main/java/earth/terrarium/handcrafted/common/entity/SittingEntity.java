package earth.terrarium.handcrafted.common.entity;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import earth.terrarium.handcrafted.common.block.SittableBlock;
import earth.terrarium.handcrafted.common.registry.ModEntityTypes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
public class SittingEntity extends Entity {

    public static final Multimap<ResourceKey<Level>, BlockPos> SITTING_POSITIONS = ArrayListMultimap.create();

    private AABB shape;
    private boolean remove;
    private boolean canRotate;

    public SittingEntity(EntityType<? extends Entity> entityType, Level level) {
        super(entityType, level);
        this.setLevelCallback(EntityInLevelCallback.NULL);
    }

    public SittingEntity(Level level, AABB shape) {
        super(ModEntityTypes.SEAT.get(), level);
        this.shape = copyAABB(shape);
    }

    public static SittingEntity of(Level level, BlockPos pos, Direction dir) {
        BlockState state = level.getBlockState(pos);
        AABB shape = new AABB(pos);
        if (state.getBlock() instanceof SittableBlock seat) {
            shape = seat.getSeatSize(state);
        }
        SittingEntity entity = new SittingEntity(level, shape);
        if (dir != null) {
            entity.setYRot(dir.toYRot());
        } else {
            entity.canRotate = true;
        }
        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        return entity;
    }

    private static AABB copyAABB(AABB aabb) {
        return new AABB(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, canRotate ? 1 : 0);
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.canRotate = packet.getData() == 1;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean isVehicle() {
        return true;
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return false;
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
        return RespawnAnchorBlock.findStandUpPosition(passenger.getType(), this.level(), this.blockPosition())
            .orElse(super.getDismountLocationForPassenger(passenger));
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide() && (!(this.level().getBlockState(this.blockPosition()).getBlock() instanceof SittableBlock) || remove)) {
            removeSeat();
        }
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (!level().isClientSide() && this.getPassengers().isEmpty()) {
            remove = true;
        }
    }

    public void removeSeat() {
        SITTING_POSITIONS.get(this.level().dimension()).remove(this.blockPosition());
        this.discard();
    }

    @Override
    protected AABB makeBoundingBox() {
        if (shape == null) {
            return super.makeBoundingBox();
        }
        return shape.move(this.blockPosition());
    }

    @Override
    public double getPassengersRidingOffset() {
        if (shape == null) {
            return super.getPassengersRidingOffset();
        }
        return shape.getYsize() * 0.75;
    }

    protected void clampRotation(Entity entityToUpdate) {
        entityToUpdate.setYBodyRot(this.getYRot());
        float f = Mth.wrapDegrees(entityToUpdate.getYRot() - this.getYRot());
        float g = Mth.clamp(f, -105.0F, 105.0F);
        entityToUpdate.yRotO += g - f;
        entityToUpdate.setYRot(entityToUpdate.getYRot() + g - f);
        entityToUpdate.setYHeadRot(entityToUpdate.getYRot());
    }

    @Override
    public void onPassengerTurned(Entity entityToUpdate) {
        if (!canRotate) {
            this.clampRotation(entityToUpdate);
        }
    }

    @Override
    public void setLevelCallback(EntityInLevelCallback levelCallback) {
        super.setLevelCallback(new WrapedLevelCallBack(levelCallback));

    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
    }

    private class WrapedLevelCallBack implements EntityInLevelCallback {
        private final EntityInLevelCallback callback;

        public WrapedLevelCallBack(EntityInLevelCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onMove() {
            if (callback != null) {
                callback.onMove();
                if (level().getBlockState(blockPosition()).getBlock() instanceof SittableBlock seat) {
                    shape = seat.getSeatSize(level().getBlockState(blockPosition()));
                }
            } else {
                SittingEntity.this.shape = null;
            }
        }

        @Override
        public void onRemove(RemovalReason reason) {
            if (callback != null) {
                callback.onRemove(reason);
            }
        }
    }
}