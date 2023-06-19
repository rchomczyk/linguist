package moe.rafal.translations

import moe.rafal.translations.key.MessageKeyParser
import moe.rafal.translations.key.StringMessageKeyParser
import moe.rafal.translations.placeholder.PlaceholderParser
import moe.rafal.translations.placeholder.StringPlaceholderParser
import moe.rafal.translations.repository.FileTranslationRepository
import moe.rafal.translations.repository.TranslationRepository
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.plugin.Plugin
import pl.auroramc.lobby.file.FileUtils
import java.nio.file.Path
import java.util.function.Function

class LinguistBukkit(translationRepository: TranslationRepository,
                     placeholderParser: PlaceholderParser = StringPlaceholderParser(),
                     messageKeyParser: MessageKeyParser = StringMessageKeyParser(),
                     messageMapper: Function<String, Component> = Function { message -> MiniMessage.miniMessage().deserialize(message) }):
    Linguist<Component>(translationRepository, placeholderParser, messageKeyParser, messageMapper) {

        companion object {

            fun <T> setup(plugin: T, dataPath: Path, directoryName: String = "translations"): LinguistBukkit where T: Plugin {
                FileUtils.saveResourcesFromClasspath(plugin, plugin::class.java, directoryName)

                val translationRepository = FileTranslationRepository(plugin.name, dataPath.resolve(directoryName))
                    translationRepository.parseTranslations()

                return LinguistBukkit(translationRepository)
            }
        }
    }