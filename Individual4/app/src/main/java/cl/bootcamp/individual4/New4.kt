package cl.bootcamp.individual4

fun new(){

    class usuario (val nombre : String,
                   val edad : Int,
                   val trabajo : String?,
                   val refencia : usuario?){
        fun showProfile() {
            println("nombre: $nombre")
            println("edad: $edad")
            println("trabajo: $trabajo")
            if (refencia != null) {
                println("fue citado por: ${refencia.nombre} de ${refencia.edad} años")
                println("")
            } else {
                println("")
            }
        }
    }

    val Walter = usuario("Walter White", 60, "Profesor", null)
    var Jesse = usuario("Jesse Pinkman", 27, "Estudiante", Walter)

    Walter.showProfile()
    Jesse.showProfile()

}