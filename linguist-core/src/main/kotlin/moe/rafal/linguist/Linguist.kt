package moe.rafal.linguist

import moe.rafal.linguist.audience.AudienceProvider
import moe.rafal.linguist.definition.TranslationDefinition
import moe.rafal.linguist.key.MessageKey
import moe.rafal.linguist.key.MessageKeyParser
import moe.rafal.linguist.key.StringMessageKeyParser
import moe.rafal.linguist.placeholder.Placeholder
import moe.rafal.linguist.placeholder.PlaceholderParser
import moe.rafal.linguist.placeholder.StringPlaceholderParser
import moe.rafal.linguist.repository.TranslationRepository
import java.util.Locale
import java.util.function.Function

open class Linguist<T, S>(
    private val translationRepository: TranslationRepository,
    placeholderParser: PlaceholderParser = StringPlaceholderParser(),
    private val audienceProvider: AudienceProvider<S>,
    private val messageKeyParser: MessageKeyParser = StringMessageKeyParser(),
    private val messageMapper: Function<String, T>) {
    private val messageWriter = MessageWriterImpl(translationRepository, placeholderParser)

    fun supportedLocales(): List<Locale> {
        return translationRepository.supportedLocales()
    }

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