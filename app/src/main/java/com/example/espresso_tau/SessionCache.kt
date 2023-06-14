package com.example.espresso_tau

interface SessionCache {
    fun saveSession(data: Data)
    fun getActiveSession(): Data?
    fun clearSession()
}