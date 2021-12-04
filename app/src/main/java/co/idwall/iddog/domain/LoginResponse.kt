package co.idwall.iddog.domain

data class LoginResponse(val user: User)

data class User(val token: String)