package moe.rafal.linguist.audience

import java.util.Locale

class BukkitAudience(private val locale: Locale): Audience {

    override fun locale(): Locale {
        return locale
    }
}