package com.example.domain.entities

data class UserModel(
    val id: Int? = null,
    val name: String? = null,
    val username: String? = null,
    val url: String? = null,
    val avatar: String? = null,
    val following: Boolean? = null,
    val reputation: Int? = null,
    val followersCount: Int? = null,
    val postsCount: Int? = null,
    val answersCount: Int? = null,
    val questionsCount: Int? = null,
    val bannedAt: String? = null,
    val levelPartner: String? = null,
    val totalPostViews: Int? = null,
    val postsStats: HashMap<String, Int>? = null
) : BaseModel()
