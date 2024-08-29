package cl.bootcamp.individual6

import android.provider.ContactsContract

fun old(){
    println("seleccione perte del ejercicio a visualizar")
    println("1. parte A")
    println("2. parte B")
    val part = readln().toInt()
    if (part == 1 || part == 2){
        if(part == 1){
            a()
            println("saliendo del ejercicio")
            println("")
        }else{
            b()
            println("saliendo del ejercicio")
            println("")
        }
    }else{
        println("seleccion no valida")
    }
}

fun a() {

    println("ingrese operacion a utilizar")
    println("1. suma")
    println("2. redondeo")
    println("3. moneda")
    val operacion = readln().toInt()

    when (operacion) {
        1 -> sumar()
        2-> redondeo()
        3-> moneda()
        else -> println("seleccion no valida")

    }
}

fun sumar(){
    println("ingrese primer numero")
    val n1 = readln().toDouble()
    println("ingrese segundo numero")
    val n2 = readln().toFloat()
    suma(n1,n2)
}

fun suma (num1: Double, num2: Float){
  val num2Double = num2.toDouble()
  val resultado = num1 + num2Double
    println("el resultado de la suma es: $resultado")
}

fun redondeo(){
    println("ingrese numero a redondear")
    val nr = readln().toDouble()
    round(nr)
}

fun round(num: Double){
    val resultado = Math.round(num)
    println("el numero $num redondeado es: $resultado")
}

fun moneda(){
    println("ingrese cantidad de dinero")
    val dinero = readln().toDouble()
    println("el monto ingresado es: $${dinero.toInt()}")
}

data class Superhero(val superhero:String,
                val publisher:String,
                val realName:String,
                val photo:String){
    fun showhero(){
        println("$superhero - $publisher - $realName - $photo")
    }
}

class superheroList(val superheros: MutableList<Superhero> = mutableListOf()){
    fun addhero(superhero: Superhero){
        superheros.add(superhero)
    }

    fun showheroes(){
        for (hero in superheros){
            hero.showhero()
        }
    }
}

fun b(){
    println("ingrese numero de superheroe a ingresar")
    val numero = readln().toInt()
    val hero : superheroList = superheroList()
    for (i in 1..numero){
        println("ingrese superheroe numero $i")
        val superhero = readln()
        println("ingrese publisher numero $i")
        val publisher = readln()
        println("ingrese realName numero $i")
        val realName = readln()
        println("ingrese photo numero $i")
        val photo = readln()
        hero.addhero(Superhero(superhero,publisher,realName,photo))
    }

    println("desea mostrar los supoerherores ingresados")
    println("1. si")
    println("2. no")
    val show = readln()
    if (show == "1"){
        hero.showheroes()
    }
}