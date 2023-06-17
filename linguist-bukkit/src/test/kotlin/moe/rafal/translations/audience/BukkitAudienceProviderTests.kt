package moe.rafal.translations.audience

import org.bukkit.entity.Player
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.util.Locale
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@TestInstance(Lifecycle.PER_CLASS)
class BukkitAudienceProviderTests {

    private val player: Player = mock<Player> {
        on { uniqueId } doReturn UUID(0, 0)
        on { locale() } doReturn Locale.ENGLISH
    }
    private val audienceProvider = BukkitAudienceProvider()

    @BeforeEach
    fun clearAudienceCache() {
        val audienceCache = audienceProvider.audienceCache
            audienceCache.invalidateAll()
    }

    @Test
    fun `Verify whether audience provider creates audience if not exists in cache`() {
        assertAll({
            assertNull(audienceProvider.audienceCache.getIfPresent(player.uniqueId))
            assertNotNull(audienceProvider.getAudience(player))
        })
    }

    @Test
    fun `Verify whether audience provider stores audience in cache`() {
        assertAll({
            assertNotNull(audienceProvider.getAudience(player))
            assertNotNull(audienceProvider.audienceCache.getIfPresent(player.uniqueId))
        })
    }

    @Test
    fun `Verify whether audience provider returns expected player locale`() {
        val audience = audienceProvider.getAudience(player)
        assertAll({
            assertNotNull(audience)
            assertEquals(Locale.ENGLISH, audience.locale())
        })
    }
}