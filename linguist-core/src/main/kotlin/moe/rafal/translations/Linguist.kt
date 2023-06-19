package moe.rafal.translations

import moe.rafal.translations.audience.AudienceProvider
import moe.rafal.translations.definition.TranslationDefinition
import moe.rafal.translations.key.MessageKey
import moe.rafal.translations.key.MessageKeyParser
import moe.rafal.translations.key.StringMessageKeyParser
import moe.rafal.translations.placeholder.Placeholder
import moe.rafal.translations.placeholder.PlaceholderParser
import moe.rafal.translations.placeholder.StringPlaceholderParser
import moe.rafal.translations.repository.TranslationRepository
import java.util.function.Function

open class Linguist<T, S>(
    translationRepository: TranslationRepository, placeholderParser: PlaceholderParser = StringPlaceholderParser(),
    private val audienceProvider: AudienceProvider<S>,
    private val messageKeyParser: MessageKeyParser = StringMessageKeyParser(),
    private val messageMapper: Function<String, T>) {
    private val messageWriter = MessageWriterImpl(translationRepository, placeholderParser)

    fun translate(viewer: S, messageKey: String, vararg placeholders: Placeholder): T {
        return translate(viewer, messageKeyParser.parse(messageKey)!!, *placeholders)
    }

    fun translate(viewer: S, messageKey: MessageKey, vararg placeholders: Placeholder): T {
        return translate(TranslationDefinition(audienceProvider.getAudience(viewer), messageKey, placeholders.toList()))
    }

    fun translate(definition: TranslationDefinition): T {
        return messageMapper.apply(messageWriter.write(definition))
    }

    fun parseMessageKey(text: String): MessageKey? {
        return messageKeyParser.parse(text)
    }
}