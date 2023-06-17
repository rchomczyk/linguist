package moe.rafal.translations

import moe.rafal.translations.definition.TranslationDefinition
import moe.rafal.translations.placeholder.PlaceholderParser
import moe.rafal.translations.repository.TranslationRepository

class MessageWriterImpl(private val translationRepository: TranslationRepository, private val placeholderParser: PlaceholderParser):
    MessageWriter {

    override fun write(definition: TranslationDefinition): String {
        var message = translationRepository.translation(definition.audience.locale(), definition.key) ?: definition.key.token()
            message = placeholderParser.parse(message, *definition.placeholders.toTypedArray())
        return message
    }
}