package moe.rafal.linguist.repository

import moe.rafal.linguist.key.MessageKey
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.util.Locale
import java.util.PropertyResourceBundle
import java.util.ResourceBundle
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.inputStream
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.walk

class FileTranslationRepository(private val bundleKey: String, private val translationsPath: Path):
    TranslationRepository {

    private val translations = HashMap<Locale, ResourceBundle>()

    override fun translation(locale: Locale, key: MessageKey): String? {
        return translations[locale]?.getString(key.key)
    }

    override fun supportedLocales(): List<Locale> {
        return translations.keys.toList()
    }

    fun parseTranslations() {
        searchForTranslationPaths()
            .map { translationPath -> parseTranslation(translationPath) }
            .forEach { translation -> translations[translation.first] = translation.second }
    }

    private fun parseTranslation(translationPath: Path): Pair<Locale, ResourceBundle> {
        val localeTag = getIEFTLocaleTag(translationPath.nameWithoutExtension.removePrefix("${bundleKey}_"))
        val locale = Locale.forLanguageTag(localeTag)
        return translationPath.inputStream()
            .use { input -> InputStreamReader(input, StandardCharsets.UTF_8)
            .use { inputReader -> Pair(locale, PropertyResourceBundle(inputReader)) } }
    }

    private fun getIEFTLocaleTag(localeTag: String): String {
        return localeTag.replace("_", "-")
    }

    @OptIn(ExperimentalPathApi::class)
    private fun searchForTranslationPaths(): Sequence<Path> {
        return translationsPath.walk()
    }
}