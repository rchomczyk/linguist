package moe.rafal.translations

import moe.rafal.translations.audience.BukkitAudienceProvider
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import moe.rafal.translations.key.MessageKey
import moe.rafal.translations.placeholder.Placeholder

class LinguistBukkitExtensions {

    companion object {

        private val audienceProvider = BukkitAudienceProvider()

        fun LinguistBukkit.translate(player: Player, messageKey: String, vararg placeholders: Placeholder): Component {
            return translate(audienceProvider.getAudience(player), messageKey, *placeholders)
        }

        fun LinguistBukkit.translate(player: Player, messageKey: MessageKey, vararg placeholders: Placeholder): Component {
            return translate(audienceProvider.getAudience(player), messageKey, *placeholders)
        }
    }
}