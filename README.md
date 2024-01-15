# Handcrafted

To add this library to your project, do the following:

Kotlin DSL:
```kotlin
repositories {
    maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
}

dependencies {
    "modImplementation"(group = "earth.terrarium.handcrafted", name = "handcrafted-$modLoader-$minecraftVersion", version = handcraftedVersion)
}
```

Groovy DSL:
```groovy
repositories {
    maven {
        url "https://maven.teamresourceful.com/repository/maven-public/"
    }
}

dependencies {
    "modImplementation" group: "earth.terrarium.handcrafted", name: "handcrafted-$modLoader-$minecraftVersion", version: handcraftedVersion
}
```
