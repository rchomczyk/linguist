package moe.rafal.translations.placeholder

class StringPlaceholderParser: PlaceholderParser {

    override fun parse(originMessage: String, vararg placeholders: Placeholder): String {
        var message = originMessage
        for (placeholder in placeholders) {
            message = message.replace(placeholder.token(), placeholder.replacement)
        }
        return message
    }
}