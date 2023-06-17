package moe.rafal.translations.repository

import moe.rafal.translations.key.MessageKey
import java.util.Locale

interface TranslationRepository {

    fun translation(locale: Locale, key: MessageKey): String?
}