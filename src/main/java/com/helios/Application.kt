package com.helios

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = ["com.helios.mapper"])
open class Application

fun main(vararg args: String) {
    SpringApplication.run(Application::class.java, *args)
}
