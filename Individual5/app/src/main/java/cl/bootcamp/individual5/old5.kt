package cl.bootcamp.individual5

fun old (){
    ingreso()
    println("saliendo de ejercicio")
    println("")
}

fun ingreso(){

    var nombre = ""
    var apellido = ""
    var edad = 0
    var email = ""
    var salud = ""

    val registro : userList = userList()
    println("ingrese cantidad de usuarios a registrar")
    var user_number = readln().toInt()

    for (i in 1 .. user_number){
        while (true){

            println("ingrese nombre de usuario nª$i")
            nombre = readln()

            println("ingrese apellido de usuario nª$i")
            apellido = readln()

            try {
                println("ingrese edad de usuario nª$i")
                edad = readln().toInt()
            }catch (e: NumberFormatException){
                println("edad mal ingresada")
                println("")
            }

            println("ingrese correo del usuario nª$i")
            email = readln()

            try {
                println("ingrese sistema de salud")
                println("1. Fonasa")
                println("2. Isapre")
                println("3. Particular")
                val sistema = readln().toInt()
                when (sistema) {
                    1 -> salud = "Fonasa"
                    2 -> salud = "Isapre"
                    3 -> salud = "Particular"
                }

                if (nombre.length<21 && nombre.length>0){
                    if(apellido.all { it.isLetter() }){
                        if(edad > 0){
                            if("^[A-Za-z](.*)([@])(.+)(\\.)(.+)".toRegex().matches(email)){
                                if(sistema>0 && sistema<4){
                                    break
                                }else{
                                    println("salud mal ingresado")
                                    println("")
                                }
                            }else{
                                println("correo mal ingresado")
                                println("")
                            }
                        }else{
                            println("edad mal ingresada")
                            println("")
                        }
                    }else{
                        println("apellido mal ingresado")
                        println("")
                    }
                }else{
                    println("nombre mal ingresado")
                    println("")
                }
            }catch (e: NumberFormatException){
                println("salud mal ingresado")
                println("")
            }
        }
        val i = usuario(nombre, apellido, edad, email, salud)
        registro.addUser(i)

    }

    println("desea mostrar el registro de usuarios")
    println("1. si")
    println("2. no")
    val show = readln().toInt()
    if (show == 1){
        registro.showUsers()
    }

}

class usuario (val nombre:String,
               val apellido:String,
               val edad:Int,
               val email:String,
               val salud:String){
    fun mostrarUsuario(){
        println("$nombre - $apellido - $edad años - $email - $salud")
    }
}

class userList (val users : MutableList<usuario> = mutableListOf()){

    fun addUser(user : usuario){
        users.add(user)
    }

    fun showUsers(){

        val sortedUsers = users.sortedBy { it.edad }

        for(user in sortedUsers){
            user.mostrarUsuario()
        }
    }

}