package cl.bootcamp.individual9.model


import java.time.LocalDateTime

data class RegisterPacient (
    var id: Int = 0,
    var name: String = "",
    var showModal: Boolean = false,
    var namePacient: String = "",
    var gender: String = "",
    var age: Int = 0,
    var imc: Double = 0.0,
    var clasification: String = "",
    val weight: Double = 0.0,
    val height: Double = 0.0,
    val time: LocalDateTime = LocalDateTime.now()
)

data class WelcomeData (
    val image: Int = 0,
    val title: String = "",
    val description: String = ""
)
