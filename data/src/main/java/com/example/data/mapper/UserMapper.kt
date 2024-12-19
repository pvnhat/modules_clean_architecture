package com.example.data.mapper

import com.example.data.model.UserData
import com.example.domain.entities.UserModel
import javax.inject.Inject

class UserMapper @Inject constructor() : DataMapper<UserData, UserModel>() {
    override fun map(data: UserData): UserModel {
        return UserModel(
            id = data.id,
            url = data.url,
            name = data.name,
            username = data.username,
            followersCount = data.followersCount,
            reputation = data.reputation,
            postsCount = data.postsCount,
            following = data.following,
            answersCount = data.answersCount,
            questionsCount = data.questionsCount,
            bannedAt = data.bannedAt,
            levelPartner = data.levelPartner,
            totalPostViews = data.totalPostViews,
            postsStats = data.postsStats
        )
    }
}
