package moe.rafal.linguist.definition

import moe.rafal.linguist.key.MessageKey
import moe.rafal.linguist.placeholder.Placeholder
import java.util.Locale

data class TranslationDefinition(var target: Locale, var key: MessageKey, var placeholders: List<Placeholder> = emptyList())