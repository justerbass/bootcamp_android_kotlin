package cl.bootcamp.individual2

fun main() {
    var celcius = 0.0
    var kelvin = 0.0
    var fahrenheit = 0.0

    while (true) {
        try {
            println("indique numero de la escala a usar")
            println("1. celcius")
            println("2. kelvin")
            println("3. fahrenheit")
            var escala = readln().toInt()

            when (escala) {

                1 -> try {
                    println("ingrese temperatura en celcius")
                    celcius = readln().toDouble()

                    kelvin = celcius + 273.15
                    fahrenheit = celcius * 1.8 + 32

                    println("la temperatura en kelvin es: $kelvin")
                    println("la temperatura en fahrenheit es: $fahrenheit")
                    break
                } catch (e: NumberFormatException) {
                    println("temperatura ingresada invalida")
                }

                2 -> try {
                    println("ingrese temperatura en kelvin")
                    kelvin = readln().toDouble()

                    celcius = kelvin - 273.15
                    fahrenheit = celcius * 1.8 + 32

                    println("la temperatura en celcius es: $celcius")
                    println("la temperatura en fahrenheit es: $fahrenheit")
                    break
                } catch (e: NumberFormatException) {
                    println("temperatura ingresada invalida")
                }

                3 -> try {
                    println("ingrese temperatura en fahrenheit")
                    fahrenheit = readln().toDouble()

                    celcius = (fahrenheit - 32) / 1.8
                    kelvin = celcius + 273.15

                    println("la temperatura en celcius es: $celcius")
                    println("la temperatura en kelvin es: $kelvin")
                    break
                } catch (e: NumberFormatException) {
                    println("temperatura ingresada invalida")
                }

                else -> println("seleccione una opcion valida")

            }


        } catch (e: NumberFormatException) {
            println("seleccione una opcion valida")

        }
    }

}