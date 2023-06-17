package moe.rafal.translations.placeholder

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringPlaceholderParserTests {

    private val placeholderParser = StringPlaceholderParser()
    private val placeholders = arrayOf(Placeholder("name", "John Smith"))
    private val message = "Hello [name]"
    private val messageWithValues = "Hello John Smith"

    @Test
    fun `Verify whether placeholder parser returns same message when not received any placeholders`() {
        assertEquals(message, placeholderParser.parse(message))
    }

    @Test
    fun `Verify whether placeholder parser returns message with replaced placeholders`() {
        assertEquals(messageWithValues, placeholderParser.parse(message, *placeholders))
    }
}