package moe.rafal.linguist.audience

import com.github.benmanes.caffeine.cache.Caffeine
import org.bukkit.entity.Player
import java.time.Duration
import java.util.UUID

class BukkitAudienceProvider: AudienceProvider<Player> {

    internal val audienceCache = Caffeine.newBuilder()
        .expireAfterWrite(Duration.ofSeconds(20))
        .build<UUID, Audience>()

    override fun getAudience(source: Player): Audience {
        var audience = audienceCache.getIfPresent(source.uniqueId)
        if (audience == null) {
            audience = createAudience(source)
            audienceCache.put(source.uniqueId, audience)
        }
        return audience
    }

    private fun createAudience(source: Player): Audience {
        return BukkitAudience(source.locale())
    }
}