package com.example.data.repository.remote.error

import java.io.IOException

// ExpiredTokenException must be extended from IOException
class ExpiredTokenException : IOException("Expired Refresh Token!")
