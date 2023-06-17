package moe.rafal.translations.audience

import java.util.Locale

class BukkitAudience(private val locale: Locale): Audience {

    override fun locale(): Locale {
        return locale
    }
}