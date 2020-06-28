package com.example.mapstruct

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MapStructApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val port = System.getenv("PORT") ?: "23146"
			val app = SpringApplication(MapStructApplication::class.java)
			app.setDefaultProperties(
					mapOf("server.port" to port)
			)
			app.run(*args)
		}
	}
}
