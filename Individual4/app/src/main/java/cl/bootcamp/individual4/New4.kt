package cl.bootcamp.individual4

fun new(){

    class usuario (val nombre : String,
                   val edad : Int,
                   val trabajo : String?,
                   val refencia : usuario?){
        fun showProfile() {
            println("nombre: $nombre")
            println("edad: $edad")
            if (trabajo != null) {
                println("trabajo: $trabajo")
            }
            if (refencia != null) {
                println("fue citado por: ${refencia.nombre} de ${refencia.edad} años")
                println("")
            } else {
                println("")
            }
        }
    }

    val Walter = usuario("Walter White", 60, "Profesor", null)
    val Jesse = usuario("Jesse Pinkman", 27, "Estudiante", Walter)


    class userList (val users : MutableList<usuario> = mutableListOf()){
        fun addUser(user : usuario){
            users.add(user)
        }
        fun removeUser(user : usuario) {
            users.remove(user)
        }
        fun showUsers(){
            var i = 0
            for (user in users){
                i++
                println(i)
                user.showProfile()
            }
        }
    }

    val Rick = usuario("Rick Grimes", 45, "Sheriff", Walter)
    val Shane = usuario("Shane Walsh", 43, null, Rick)
    val Saul = usuario("Saul Goodman", 40, "Abogado", null)

    val personajes : userList = userList()

    personajes.addUser(Rick)
    personajes.addUser(Shane)
    personajes.addUser(Saul)
    personajes.addUser(Jesse)
    personajes.addUser(Walter)

    personajes.showUsers()

    personajes.removeUser(Saul)

    personajes.showUsers()


}