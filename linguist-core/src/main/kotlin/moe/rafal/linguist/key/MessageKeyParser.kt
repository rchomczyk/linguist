package moe.rafal.linguist.key

interface MessageKeyParser {

    fun valid(text: String): Boolean

    fun parse(text: String): MessageKey?
}