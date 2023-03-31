<center>

![Handcrafted](https://cdn.discordapp.com/attachments/721407493351407646/1053489346797379634/handcrafted_page_top.png)

[![Requires Resourceful Lib](https://cdn.discordapp.com/attachments/1073717602880327761/1073717942014972034/RLib_vector.svg)](http://modrinth.com/mod/resourceful-lib)

[![Made by Terrarium](https://cdn.discordapp.com/attachments/1073717602880327761/1073718144910233691/Terrarium_vector.svg)](https://discord.terrarium.earth)
[![Modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)](https://modrinth.com/mod/handcrafted)
[![CurseForge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/curseforge_vector.svg)](https://www.curseforge.com/minecraft/mc-mods/handcrafted)
<hr>

### 📖About 📖

<hr>
</center>

From the creators of Chipped, we now present Handcrafted! A mod to make your house into your
home! :D

Are you looking for a fantasy, steampunk or medieval feel? Or do you want to stick to a more vanilla decor? Look no
further! We've created over 250 furniture pieces for you to choose from. Be it chairs, tables, benches or desks;
we got it all packaged neatly into a single mod. This mod will provide all the furniture you could ever need to make
your blocky house a home!

![Credits](https://cdn.discordapp.com/attachments/721407493351407646/1053489347111956601/handcrafted_page_credits.png)
#### Programmers:
Alex Nijjar, CodexAdrian, MsRandom, ThatGravyBoat
#### Artists:
Kekie6, Facu, Marc-IceBlade

<center>

## ✨Socials✨

[![YouTube](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/youtube-plural_vector.svg)](https://youtube.terrarium.earth)
[![Twitch](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/twitch-plural_vector.svg)](https://www.twitch.tv/terrariumearth)
[![Twitter](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/twitter-plural_vector.svg)](https://twitter.terrarium.earth)
[![Kofi](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/donate/kofi-plural_vector.svg)](https://kofi.terrarium.earth)
[![Discord-plural](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/discord-plural_vector.svg)](https://discord.terrarium.earth)
[![Modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/available/modrinth_vector.svg)](https://modrinth.com/user/Terrarium)
[![CurseForge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/available/curseforge_vector.svg)](https://www.curseforge.com/members/terrariumearth/projects)
<hr>
</center>

## Developers

To add this library to your project, do the following:

```groovy
repositories {
  maven {
    // Location of the maven that hosts Terrarium and Team Resourceful's files.
    name = "Team Resourceful Maven"
    url = "https://maven.resourcefulbees.com/repository/maven-public/"
  }
}
```

In an Architectury project, you would implement it like so:

Common

```groovy
dependencies {
    modImplementation "earth.terrarium:handcrafted-common-$rootProject.minecraft_version:$rootProject.handcrafted_version"
}
```

Fabric

```groovy
dependencies {
    modImplementation "earth.terrarium:handcrafted-fabric-$rootProject.minecraft_version:$rootProject.handcrafted_version"
}
```

Forge

```groovy
dependencies {
    modImplementation "earth.terrarium:handcrafted-forge-$rootProject.minecraft_version:$rootProject.handcrafted_version"
}
```

---

<div align="center">

![Version](https://img.shields.io/maven-metadata/v?label=Handcrafted%20Version&metadataUrl=https%3A%2F%2Fnexus.resourcefulbees.com%2Frepository%2Fmaven-public%2Fearth%2Fterrarium%2Fhandcrafted-common-1.19.2%2Fmaven-metadata.xml)
</div>