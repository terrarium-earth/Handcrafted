import net.msrandom.unifiedbuilds.UnifiedBuildsPlugin
import net.msrandom.unifiedbuilds.platforms.Fabric
import net.msrandom.unifiedbuilds.platforms.Forge

plugins {
    id("unifiedbuilds") version "0.7+"
}

subprojects {
    apply<UnifiedBuildsPlugin>()
}

unifiedModule {
    common.set("Common")

    platforms {
        val forge_version: String by project
        val fabric_version: String by project
        val fabric_loader_version: String by project

        add(Fabric("Fabric", fabric_loader_version, fabric_version))
        add(Forge("Forge", forge_version))
    }

    info {
        val mod_id: String by project

        modId.set(mod_id)
        name.set("Comfort Magic")
        description.set("fancy furniture :)")
        authors.add("kekie6")
        contributors.addAll("MsRandom", "CodexAdrian")
    }
}

unifiedBuilds {
    val version: String by project
    val minecraft_version: String by project

    minecraftVersion.set(minecraft_version)
    license.set("CC0-1.0")
    modVersion.set(version)
    baseProject.set(project)
}
