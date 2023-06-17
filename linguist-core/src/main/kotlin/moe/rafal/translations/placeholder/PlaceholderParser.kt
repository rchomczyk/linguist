package moe.rafal.translations.placeholder

fun interface PlaceholderParser {

    fun parse(originMessage: String, vararg placeholders: Placeholder): String
}
