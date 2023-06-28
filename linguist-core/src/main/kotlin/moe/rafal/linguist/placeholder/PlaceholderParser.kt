package moe.rafal.linguist.placeholder

fun interface PlaceholderParser {

    fun parse(originMessage: String, vararg placeholders: Placeholder): String
}
