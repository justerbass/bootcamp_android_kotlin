package cl.bootcamp.individual6

fun new(){

    val juan = CuentaBancaria("Juan", 500)
    val pedro = CuentaBancaria("Pedro", 1000)
    val maria = CuentaBancaria("Maria", 2000)


    juan.deposito(500)
    juan.retiro(1000)
    juan.deposito(200)
    juan.retiro(3000)
    juan.deposito(100)

    pedro.deposito(1000)
    pedro.retiro(500)
    pedro.deposito(400)
    pedro.retiro(100)
    pedro.retiro(800)

    maria.deposito(2000)
    maria.retiro(1500)
    maria.deposito(300)
    maria.retiro(500)
    maria.deposito(700)

    println("Ingrese opcion de que usuario quiere ver su historial")
    println("1. juan")
    println("2. pedro")
    println("3. maria")
    val opcion = readln().toInt()

    when (opcion){
        1 -> {juan.mostrarHistorial()
            juan.mostrarSaldo()}
        2 -> {pedro.mostrarHistorial()
            pedro.mostrarSaldo()}
        3 -> {maria.mostrarHistorial()
            maria.mostrarSaldo()}
        else -> println("opcion no valida")
    }
    println("")
    println("saliendo del ejercicio")
    println("")

}