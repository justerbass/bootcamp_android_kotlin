package cl.bootcamp.individual9.model

data class RegisterPacient(
    var id: Int = 0,
    var name: String = "",
    var showModal: Boolean = false,
    var namePacient: String = "",
    var gender: String = "",
    var age: Int = 0,
    var imc: Double = 0.0,
    var clasification: String = ""

)

