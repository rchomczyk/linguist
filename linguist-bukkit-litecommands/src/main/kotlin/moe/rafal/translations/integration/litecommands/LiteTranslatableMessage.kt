package moe.rafal.translations.integration.litecommands

import moe.rafal.translations.key.MessageKey
import moe.rafal.translations.placeholder.Placeholder

data class LiteTranslatableMessage(var messageKey: MessageKey, var placeholders: List<Placeholder> = listOf())

