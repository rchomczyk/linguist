package moe.rafal.linguist.integration.litecommands

import dev.rollczi.litecommands.command.LiteInvocation
import dev.rollczi.litecommands.handle.Handler
import moe.rafal.linguist.LinguistBukkit
import moe.rafal.linguist.definition.TranslationDefinition
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.Locale

class LiteTranslatableMessageHandler(private val linguist: LinguistBukkit): Handler<CommandSender, LiteTranslatableMessage> {

    companion object {
        private val DEFAULT_LANGUAGE = Locale.forLanguageTag("en-US")
    }

    override fun handle(sender: CommandSender, invocation: LiteInvocation, message: LiteTranslatableMessage) {
        val viewer = if (sender is Player) sender.locale() else DEFAULT_LANGUAGE
        val result = linguist.translate(TranslationDefinition(viewer, message.messageKey, message.placeholders))
        sender.sendMessage(result)
    }
}
