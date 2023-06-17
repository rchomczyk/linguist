package moe.rafal.translations

import moe.rafal.translations.audience.Audience
import moe.rafal.translations.definition.TranslationDefinition
import moe.rafal.translations.key.MessageKey
import moe.rafal.translations.key.MessageKeyParser
import moe.rafal.translations.key.StringMessageKeyParser
import moe.rafal.translations.placeholder.Placeholder
import moe.rafal.translations.placeholder.PlaceholderParser
import moe.rafal.translations.placeholder.StringPlaceholderParser
import moe.rafal.translations.repository.TranslationRepository
import java.util.function.Function

open class Linguist<T>(
    translationRepository: TranslationRepository, placeholderParser: PlaceholderParser = StringPlaceholderParser(),
    private val messageKeyParser: MessageKeyParser = StringMessageKeyParser(),
    private val messageMapper: Function<String, T>) {
    private val messageWriter = MessageWriterImpl(translationRepository, placeholderParser)

    fun translate(audience: Audience, messageKey: String, vararg placeholders: Placeholder): T {
        return translate(audience, messageKeyParser.parse(messageKey)!!, *placeholders)
    }

    fun translate(audience: Audience, messageKey: MessageKey, vararg placeholders: Placeholder): T {
        return translate(TranslationDefinition(audience, messageKey, placeholders.toList()))
    }

    fun translate(definition: TranslationDefinition): T {
        return messageMapper.apply(messageWriter.write(definition))
    }
}