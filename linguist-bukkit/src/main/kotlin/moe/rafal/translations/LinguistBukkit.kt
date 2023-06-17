package moe.rafal.translations

import moe.rafal.translations.key.MessageKeyParser
import moe.rafal.translations.key.StringMessageKeyParser
import moe.rafal.translations.placeholder.PlaceholderParser
import moe.rafal.translations.placeholder.StringPlaceholderParser
import moe.rafal.translations.repository.TranslationRepository
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import java.util.function.Function

class LinguistBukkit(translationRepository: TranslationRepository,
                     placeholderParser: PlaceholderParser = StringPlaceholderParser(),
                     messageKeyParser: MessageKeyParser = StringMessageKeyParser(),
                     messageMapper: Function<String, Component> = Function { message -> MiniMessage.miniMessage().deserialize(message) }):
    Linguist<Component>(translationRepository, placeholderParser, messageKeyParser, messageMapper)