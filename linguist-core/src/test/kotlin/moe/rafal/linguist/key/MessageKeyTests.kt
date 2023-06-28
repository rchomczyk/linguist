package moe.rafal.linguist.key

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MessageKeyTests {

    private val messageKey = MessageKey("example.message.key")
    private val messageKeyToken = "<example.message.key>"

    @Test
    fun `Verify whether message key returns expected token`() {
        assertEquals(messageKeyToken, messageKey.token())
    }
}