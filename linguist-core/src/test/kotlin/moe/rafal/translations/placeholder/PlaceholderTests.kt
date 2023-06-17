package moe.rafal.translations.placeholder

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlaceholderTests {

    private val placeholder = Placeholder("example_placeholder", "lorem ipsum")
    private val placeholderToken = "[example_placeholder]"

    @Test
    fun `Verify whether placeholder returns expected token`() {
        Assertions.assertEquals(placeholderToken, placeholder.token())
    }
}