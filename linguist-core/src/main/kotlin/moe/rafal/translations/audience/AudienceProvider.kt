package moe.rafal.translations.audience

interface AudienceProvider<S> {

    fun getAudience(source: S): Audience
}