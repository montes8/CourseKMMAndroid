package com.gb.vale.coursekmmandroid

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform