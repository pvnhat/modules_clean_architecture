package com.example.domain.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.rules.Timeout

@HiltAndroidTest
open class BaseUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val globalTestRule: TestRule = Timeout.seconds(20)

    @Before
    open fun setup() {
    }

    @After
    open fun tearDown() {
    }
}
