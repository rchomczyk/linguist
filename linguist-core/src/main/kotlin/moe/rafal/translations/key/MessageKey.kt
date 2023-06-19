package moe.rafal.translations.key

import moe.rafal.translations.key.MessageKeyParserConstants.Companion.BEGIN_TOKEN
import moe.rafal.translations.key.MessageKeyParserConstants.Companion.DITCH_TOKEN

data class MessageKey(val key: String) {

    internal fun token(): String {
        return "$BEGIN_TOKEN$key$DITCH_TOKEN"
    }
}