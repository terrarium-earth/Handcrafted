import net.msrandom.unifiedbuilds.platforms.Fabric

fabricEntrypoints {
    add(Fabric.Entrypoint("main", listOf("earth.terrarium.handcrafted.Handcrafted")))
    add(Fabric.Entrypoint("client", listOf("earth.terrarium.handcrafted.HandcraftedFabricClient")))
}
