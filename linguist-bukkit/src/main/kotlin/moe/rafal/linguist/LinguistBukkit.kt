package moe.rafal.linguist

import moe.rafal.linguist.key.MessageKeyParser
import moe.rafal.linguist.key.StringMessageKeyParser
import moe.rafal.linguist.placeholder.PlaceholderParser
import moe.rafal.linguist.placeholder.StringPlaceholderParser
import moe.rafal.linguist.repository.FileTranslationRepository
import moe.rafal.linguist.repository.TranslationRepository
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import pl.auroramc.lobby.file.FileUtils
import java.nio.file.Path
import java.util.function.Function

class LinguistBukkit(translationRepository: TranslationRepository,
                     placeholderParser: PlaceholderParser = StringPlaceholderParser(),
                     messageKeyParser: MessageKeyParser = StringMessageKeyParser(),
                     messageMapper: Function<String, Component> = Function { message -> MiniMessage.miniMessage().deserialize(message) }):
    Linguist<Component, Player>(translationRepository, placeholderParser, messageKeyParser, messageMapper) {

        companion object {

            fun <T> setup(plugin: T, dataPath: Path, directoryName: String = "translations"): LinguistBukkit where T: Plugin {
                FileUtils.saveResourcesFromClasspath(plugin, plugin::class.java, directoryName)

                val translationRepository = FileTranslationRepository(plugin.name, dataPath.resolve(directoryName))
                    translationRepository.parseTranslations()

                return LinguistBukkit(translationRepository)
            }
        }
    }