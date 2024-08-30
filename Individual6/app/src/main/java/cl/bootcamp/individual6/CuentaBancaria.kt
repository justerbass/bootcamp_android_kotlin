package cl.bootcamp.individual6

class CuentaBancaria (val nombreCuenta:String, var saldoDisponible:Int){

    val historial : MutableList<String> = mutableListOf()

    fun deposito(income:Int){
        saldoDisponible += income
        historial.add("${nombreCuenta} depositó $$income")
    }

    fun retiro(outcome:Int){
        if (saldoDisponible < outcome){
            historial.add("${nombreCuenta} retiró fallido")
        }else {
            saldoDisponible -= outcome
            historial.add("${nombreCuenta} retiró $$outcome")
        }
    }

    fun mostrarSaldo(){
        println("${nombreCuenta}: su saldo disponible es de: $$saldoDisponible")
    }

    fun mostrarHistorial(){
        println("--------------------------------------------------------")
        println("Historial de transacciones de cuenta de $nombreCuenta")
        println("--------------------------------------------------------")
        historial.forEach {
            println(it)
        }
        println("--------------------------------------------------------")

    }


}

