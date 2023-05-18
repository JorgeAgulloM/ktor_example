package com.example.routes

import com.example.models.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val users = mutableListOf(
    User(0, "Jorge Agulló", 40, "agullojorge@mail.com"),
    User(1, "SoftYorch", 1, "softyorch@mail.com")
)

fun Route.userRouting() {
    route("/user") {
        get {
            if (users.isNotEmpty()) {
                call.respond(users)
            } else {
                call.respondText("No hay susuarios", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Id no encotrado",
                status = HttpStatusCode.BadRequest
            )
            val user = users.find { it.id == id.toInt() } ?: return@get call.respondText(
                "Usuario con id($id) no encontrado",
                status = HttpStatusCode.BadRequest
            )
            call.respond(user)
        }
        post {
            val user = call.receive<User>()
            users.add(user)
            call.respondText("Usuario creado correctamente", status = HttpStatusCode.OK)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "Id no encontrada",
                status = HttpStatusCode.BadRequest
            )
            if (users.removeIf { it.id == id.toInt()}) {
                call.respondText("Usuario eliminado correctamente", status = HttpStatusCode.OK)
            } else {
                call.respondText("Usuario no encontrado", status = HttpStatusCode.NotFound)
            }
        }
    }
}