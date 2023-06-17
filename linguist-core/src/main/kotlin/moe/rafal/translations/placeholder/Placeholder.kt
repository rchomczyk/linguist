package moe.rafal.translations.placeholder

import moe.rafal.translations.placeholder.PlaceholderParserConstants.Companion.BEGIN_TOKEN
import moe.rafal.translations.placeholder.PlaceholderParserConstants.Companion.DITCH_TOKEN

data class Placeholder(val key: String, val replacement: String) {

    internal fun token(): String {
        return "$BEGIN_TOKEN$key$DITCH_TOKEN"
    }
}