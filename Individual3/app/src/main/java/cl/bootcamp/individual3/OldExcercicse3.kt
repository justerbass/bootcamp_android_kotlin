package cl.bootcamp.individual3

fun old(){

        while (true) {
                println("este ejercicio consta de 3 partes, cual quiere ver?")
                println("1. parte 1")
                println("2. parte 2")
                println("3. parte 3")
                println("4. salir")

                var parte = readln()
                if (parte == "1" || parte == "2" || parte == "3" || parte == "4") {

                        when (parte.toInt()) {
                                1 -> parte1()
                                2 -> parte2()
                                3 -> parte3()
                                4 -> break
                        }

                }else{
                        println("seleccion no valida")
                }
        }

}

fun  parte1(){
        var num_1 = 10
        var num_2 = 33
        var num_3 = 66

        var sum = num_1 + num_2 + num_3

        println("el resultado de la suma es: $sum")

        num_1 = 55

        sum = num_1 + num_2 + num_3

        println("el resultado de la suma es: $sum")

        var promedio = sum / 3

        println("el promedio es: $promedio")
}

fun parte2(){
        val amanda = Person("Amanda", 33, "play tennis", null)
        val atiqah = Person("Atiqah", 28, "climb", amanda)
        amanda.showProfile()
        atiqah.showProfile()

}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
        fun showProfile() {
                println("name: $name")
                println("age: $age")
                println("hobby: $hobby")
                if (referrer != null) {
                        println("referrer: ${referrer.name}")
                        println("referrer hobby: ${referrer.hobby}")
                } else {
                        println("referrer: No referrer")
                }
                println("")
        }
}

fun parte3(){

        val winningBid = Bid(5000, "Private Collector")
        println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
        println("Item B is sold at ${auctionPrice(null, 3000)}.")


}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
        if (bid != null) {
                return bid.amount
        } else {
                return minimumPrice

        }
}