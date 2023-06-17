package moe.rafal.translations.audience

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Locale

class BukkitAudienceTests {

    private val audience = BukkitAudience(Locale.ENGLISH)

    @Test
    fun `Verify whether bukkit audience returns expected locale`() {
        assertEquals(Locale.ENGLISH, audience.locale())
    }
}