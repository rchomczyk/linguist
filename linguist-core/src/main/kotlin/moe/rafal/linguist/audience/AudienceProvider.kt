package moe.rafal.linguist.audience

interface AudienceProvider<S> {

    fun getAudience(source: S): Audience
}