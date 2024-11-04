package com.example.loginapp

import app.cash.turbine.test
import com.example.loginapp.data.UserRepository
import com.example.loginapp.data.models.User
import com.example.loginapp.login.LoginUiState
import com.example.loginapp.login.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {
    
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    
    @Mock
    private lateinit var userRepository: UserRepository
    
    private lateinit var viewModel: LoginViewModel
    
    @Before
    fun setup() {
        viewModel = LoginViewModel()
        viewModel.userRepository = userRepository
    }
    
    @Test
    fun `initial state is Initial`() = runTest {
        assertEquals(LoginUiState.Initial, viewModel.uiState.value)
    }
    
    @Test
    fun `empty credentials shows error`() = runTest {
        viewModel.login("", "")
        
        viewModel.uiState.test {
            assertEquals(LoginUiState.Initial, awaitItem())
            assertEquals(LoginUiState.Loading, awaitItem())
            assertTrue(awaitItem() is LoginUiState.Error)
        }
    }
    
    @Test
    fun `valid credentials returns success`() = runTest {
        val testUser = User("test", "Test User")
        `when`(userRepository.login("test", "password"))
            .thenReturn(testUser)
            
        viewModel.login("test", "password")
        
        viewModel.uiState.test {
            assertEquals(LoginUiState.Initial, awaitItem())
            assertEquals(LoginUiState.Loading, awaitItem())
            assertEquals(LoginUiState.Success(testUser), awaitItem())
        }
    }
    
    @Test
    fun `invalid credentials returns error`() = runTest {
        `when`(userRepository.login("wrong", "wrong"))
            .thenThrow(IllegalArgumentException("Invalid credentials"))
            
        viewModel.login("wrong", "wrong")
        
        viewModel.uiState.test {
            assertEquals(LoginUiState.Initial, awaitItem())
            assertEquals(LoginUiState.Loading, awaitItem())
            assertTrue(awaitItem() is LoginUiState.Error)
        }
    }
    
    @Test
    fun `reset state returns to initial`() = runTest {
        viewModel.login("test", "wrong")
        viewModel.uiState.test {
            assertEquals(LoginUiState.Initial, awaitItem())
            assertEquals(LoginUiState.Loading, awaitItem())
            assertTrue(awaitItem() is LoginUiState.Error)
        }
        
        viewModel.resetState()
        assertEquals(LoginUiState.Initial, viewModel.uiState.value)
    }
}