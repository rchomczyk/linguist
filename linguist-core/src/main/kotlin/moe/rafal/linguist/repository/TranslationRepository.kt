package moe.rafal.linguist.repository

import moe.rafal.linguist.key.MessageKey
import java.util.Locale

interface TranslationRepository {

    fun supportedLocales(): List<Locale>

    fun translation(locale: Locale, key: MessageKey): String?
}