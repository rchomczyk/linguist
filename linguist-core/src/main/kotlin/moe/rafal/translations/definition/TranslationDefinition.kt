package moe.rafal.translations.definition

import moe.rafal.translations.audience.Audience
import moe.rafal.translations.key.MessageKey
import moe.rafal.translations.placeholder.Placeholder

data class TranslationDefinition(var audience: Audience, var key: MessageKey, var placeholders: List<Placeholder>)