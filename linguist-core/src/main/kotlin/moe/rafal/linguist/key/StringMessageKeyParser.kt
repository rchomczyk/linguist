package moe.rafal.linguist.key

import moe.rafal.linguist.key.MessageKeyParserConstants.Companion.BEGIN_TOKEN
import moe.rafal.linguist.key.MessageKeyParserConstants.Companion.DITCH_TOKEN

class StringMessageKeyParser: MessageKeyParser {

    override fun valid(text: String): Boolean {
        return text.startsWith(BEGIN_TOKEN) && text.endsWith(DITCH_TOKEN)
    }

    override fun parse(text: String): MessageKey? {
        if (valid(text)) {
            return text
                .removePrefix(BEGIN_TOKEN)
                .removeSuffix(DITCH_TOKEN)
                .let { key -> MessageKey(key) }
        }

        return null
    }
}