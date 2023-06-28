package moe.rafal.linguist.integration.litecommands

import moe.rafal.linguist.key.MessageKey
import moe.rafal.linguist.placeholder.Placeholder

data class LiteTranslatableMessage(var messageKey: MessageKey, var placeholders: List<Placeholder> = listOf())

