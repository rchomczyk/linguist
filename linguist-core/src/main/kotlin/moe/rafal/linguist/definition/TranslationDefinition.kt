package moe.rafal.linguist.definition

import moe.rafal.linguist.audience.Audience
import moe.rafal.linguist.key.MessageKey
import moe.rafal.linguist.placeholder.Placeholder

data class TranslationDefinition(var audience: Audience, var key: MessageKey, var placeholders: List<Placeholder> = emptyList())