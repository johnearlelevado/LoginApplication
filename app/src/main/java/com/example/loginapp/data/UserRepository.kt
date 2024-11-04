package com.example.loginapp.data

import com.example.loginapp.data.models.User
import kotlinx.coroutines.delay

// UserRepository.kt
class UserRepository {
    // Simulating API call
    suspend fun login(username: String, password: String): User {
        // Simulate network delay
        delay(1000)
        
        return when {
            username.isEmpty() || password.isEmpty() -> 
                throw Exception("Username and password cannot be empty")
            
            username == "test" && password == "password" -> 
                User(username, "Test User")
                
            else -> throw Exception("Invalid credentials")
        }
    }
}