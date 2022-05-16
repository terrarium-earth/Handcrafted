rootProject.name = "Handcrafted"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://maven.msrandom.net/repository/root")
        maven(url = "https://files.minecraftforge.net/maven")
        maven(url = "https://gitlab.com/api/v4/projects/26758973/packages/maven")
        maven(url = "https://maven.fabricmc.net/")
    }
}

include("Fabric", "Forge")
