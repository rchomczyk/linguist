repositories {
    maven("https://repo.panda-lang.org/releases/")
}

dependencies {
    api(project(":linguist-bukkit"))
    api("dev.rollczi.litecommands:bukkit-adventure:2.8.8")
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}