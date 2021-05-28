package com.helios

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
open class Application

fun main(vararg args: String) {
    SpringApplication.run(Application::class.java, *args)
}
