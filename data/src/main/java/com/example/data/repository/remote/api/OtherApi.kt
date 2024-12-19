package com.sun.viblo.android.data.repository.remote.api

import com.sun.viblo.android.shared.helper.GithubHelper.GITHUB_ACCESS_TOKEN_URL
import com.sun.viblo.android.shared.helper.GithubHelper.GITHUB_USER_EMAILS_URL
import com.sun.viblo.android.shared.helper.GithubHelper.GITHUB_USER_URL
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface OtherApi {

    @POST
    suspend fun getGithubAccessToken(
        @Url url: String = GITHUB_ACCESS_TOKEN_URL,
        @Body request: GithubRequest
    ): GithubTokenData

    @GET
    suspend fun getGithubUserInfo(
        @Url url: String = GITHUB_USER_URL,
        @Header("Authorization") accessToken: String
    ): GithubInfoData

    @GET
    suspend fun getGithubUserEmails(
        @Url url: String = GITHUB_USER_EMAILS_URL,
        @Header("Authorization") accessToken: String
    ): List<GithubEmailData>
}
