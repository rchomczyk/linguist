package moe.rafal.linguist.key

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class StringMessageKeyParserTests {

    private val messageKeyParser = StringMessageKeyParser()
    private val messageKey = MessageKey("example.message.key")
    private val messageKeyToken = "<example.message.key>"
    private val messageKeyTokenInvalid = "(example.message.key)"

    @Test
    fun `Verify whether message key parser accepts valid token`() {
        assertTrue(messageKeyParser.valid(messageKeyToken))
    }

    @Test
    fun `Verify whether message key parser declines invalid token`() {
        assertFalse(messageKeyParser.valid(messageKeyTokenInvalid))
    }

    @Test
    fun `Verify whether message key parser parses valid token`() {
        val receivedMessageKey = messageKeyParser.parse(messageKeyToken)
        assertAll({
            assertNotNull(receivedMessageKey)
            assertEquals(messageKey, receivedMessageKey)
        })
    }

    @Test
    fun `Verify whether message key parser returns null when receives invalid token`() {
        assertNull(messageKeyParser.parse(messageKeyTokenInvalid))
    }
}