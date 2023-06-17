package moe.rafal.translations

import moe.rafal.translations.definition.TranslationDefinition

interface MessageWriter {

    fun write(definition: TranslationDefinition): String
}