package moe.rafal.linguist

import moe.rafal.linguist.definition.TranslationDefinition
import moe.rafal.linguist.placeholder.PlaceholderParser
import moe.rafal.linguist.repository.TranslationRepository

class MessageWriterImpl(private val translationRepository: TranslationRepository, private val placeholderParser: PlaceholderParser):
    MessageWriter {

    override fun write(definition: TranslationDefinition): String {
        var message = translationRepository.translation(definition.target, definition.key) ?: definition.key.token()
            message = placeholderParser.parse(message, *definition.placeholders.toTypedArray())
        return message
    }
}