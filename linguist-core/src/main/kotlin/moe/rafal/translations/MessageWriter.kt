package moe.rafal.translations

import moe.rafal.translations.definition.TranslationDefinition

fun interface MessageWriter {

    fun write(definition: TranslationDefinition): String
}