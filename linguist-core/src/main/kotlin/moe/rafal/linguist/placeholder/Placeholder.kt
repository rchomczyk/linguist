package moe.rafal.linguist.placeholder

import moe.rafal.linguist.placeholder.PlaceholderParserConstants.Companion.BEGIN_TOKEN
import moe.rafal.linguist.placeholder.PlaceholderParserConstants.Companion.DITCH_TOKEN

data class Placeholder(val key: String, val replacement: String) {

    internal fun token(): String {
        return "$BEGIN_TOKEN$key$DITCH_TOKEN"
    }
}