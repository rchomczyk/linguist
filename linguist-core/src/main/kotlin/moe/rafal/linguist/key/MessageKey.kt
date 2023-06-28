package moe.rafal.linguist.key

import moe.rafal.linguist.key.MessageKeyParserConstants.Companion.BEGIN_TOKEN
import moe.rafal.linguist.key.MessageKeyParserConstants.Companion.DITCH_TOKEN

data class MessageKey(val key: String) {

    internal fun token(): String {
        return "$BEGIN_TOKEN$key$DITCH_TOKEN"
    }
}