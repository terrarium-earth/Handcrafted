## Warning

**This update introduces multiple breaking changes. Please back up you world
before updating.**

- Shelves, counters, drawers, and cupboards have had a change in their id.
  Because of this, they will be deleted from the world and must be placed again.
  Make sure to remove inventory contents before updating.
- Some furniture may lose some of their blockstates, thus
  may look weird and should be broken and placed again.
- Furniture will lose any sheets/pillows attached to them.


- Substantial performance improvements to all blocks.
  Furniture should now be as performant as normal blocks.
- Removed boards. The reason they existed in the first place was to prevent recipe conflicts. If you're a pack dev, you
  may need to check for recipe conflicts now.
- Redid all the recipes.
- All furniture is now done via blockstates and block models. this allows
  them to be changed via resource packs.
- Pillar trims now attack to block faces, allowing for both horizontal and vertical trims.
- Trims now have proper voxel shapes.
- Add more trim types.
- Add better tooltips to make it more clear what's hammerable, what can hold cushions, and what can hold sheets.
- Shelf variants are now controlled via hammer.
- Fixed fancy bed incompatibility with better beds
- Optimized fancy beds. Fancy beds are no longer block entities which improves their performance substantially,
  far beyond even vanilla beds.
- Add highlight support to furniture. This improves the visual outline box of the furniture.
- Add hammer sounds.
- Fix crockery combos not dropping the item on the plate.
- Counters now have inventories.
- Fix cats not sleeping on fancy beds.
- Fix villagers not sleeping on fancy beds. Fancy beds are now a villager POI. (Fabric only currently)
- Fix mobs not pathfinding through furniture properly.