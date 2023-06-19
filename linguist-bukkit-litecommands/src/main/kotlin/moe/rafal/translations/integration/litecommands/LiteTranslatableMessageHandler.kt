package moe.rafal.translations.integration.litecommands

import dev.rollczi.litecommands.command.LiteInvocation
import dev.rollczi.litecommands.handle.Handler
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import moe.rafal.translations.LinguistBukkit
import moe.rafal.translations.audience.Audience
import moe.rafal.translations.audience.AudienceProvider
import moe.rafal.translations.definition.TranslationDefinition

class LiteTranslatableMessageHandler(
    private val linguist: LinguistBukkit,
    private val audienceConsole: Audience,
    private val audienceProvider: AudienceProvider<Player>
): Handler<CommandSender, LiteTranslatableMessage> {

    override fun handle(sender: CommandSender, invocation: LiteInvocation, message: LiteTranslatableMessage) {
        val viewer = if (sender is Player) audienceProvider.getAudience(sender) else audienceConsole
        val result = linguist.translate(TranslationDefinition(viewer, message.messageKey, message.placeholders))
        sender.sendMessage(result)
    }
}