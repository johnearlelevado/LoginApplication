package com.example.loginapp

import com.example.loginapp.data.UserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class UserRepositoryTest {
    
    private lateinit var repository: UserRepository
    
    @Before
    fun setup() {
        repository = UserRepository()
    }
    
    @Test
    fun `login with valid credentials returns user`() = runTest {
        val result = repository.login("test", "password")
        assertEquals("test", result.username)
        assertEquals("Test User", result.displayName)
    }
    
    @Test
    fun `login with empty credentials throws exception`() = runTest {
        assertFailsWith<Exception> {
            repository.login("", "")
        }
    }
    
    @Test
    fun `login with invalid credentials throws exception`() = runTest {
        assertFailsWith<Exception> {
            repository.login("wrong", "wrong")
        }
    }
}