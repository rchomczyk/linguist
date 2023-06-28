package moe.rafal.linguist

import moe.rafal.linguist.definition.TranslationDefinition

fun interface MessageWriter {

    fun write(definition: TranslationDefinition): String
}