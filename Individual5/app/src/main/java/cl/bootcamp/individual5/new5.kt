package cl.bootcamp.individual5

fun new () {


    println("ingrese edad minima de usuarios a mostrar")
    val minimumAge = readln().toInt()

    class usuario(
        val nombre: String,
        val edad: Int,
        val trabajo: String?,
        val refencia: usuario?
    ) {
        fun showProfile() {
            print("$nombre - $edad años ")
            if (trabajo != null) {
                print("- $trabajo ")
            }
            if (refencia != null) {
                print("- fue citado por: ${refencia.nombre} de ${refencia.edad} años")
                println("")
            } else {
                println("")
            }
        }

        fun showFilterProfile(){
            println("$nombre - $edad años")
        }
    }

    class userList(val users: MutableList<usuario> = mutableListOf()) {
        fun addUser(user: usuario) {
            users.add(user)
        }

        fun removeUser(user: usuario) {
            users.remove(user)
        }

        fun showUsers() {
            var i = 0
            for (user in users) {
                i++
                println(i)
                user.showProfile()
            }
        }

        fun showUsersFilter(){
            var i = 0
            for (user in users) {
                i++
                println(i)
                user.showFilterProfile()
            }
        }

        fun filterAgeUser() {
            var i = 0
            val filterAgeList = userList()
            for (user in users) {
                if (user.edad > minimumAge) {
                    i++
                    filterAgeList.addUser(user)
                }
            }
            if (i == 0) {
                println("no hay usuarios con edad mayor a $minimumAge")
            }else{
                filterAgeList.showUsersFilter()
            }
        }
    }

    val Walter = usuario("Walter White", 60, "Profesor", null)
    val Jesse = usuario("Jesse Pinkman", 27, "Estudiante", Walter)
    val Rick = usuario("Rick Grimes", 45, "Sheriff", Walter)
    val Shane = usuario("Shane Walsh", 43, null, Rick)
    val Saul = usuario("Saul Goodman", 40, "Abogado", null)

    val personajes: userList = userList()

    personajes.addUser(Rick)
    personajes.addUser(Shane)
    personajes.addUser(Saul)
    personajes.addUser(Jesse)
    personajes.addUser(Walter)

    personajes.filterAgeUser()

    println("saliendo del ejercicio")
    println("")
}