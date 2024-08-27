package cl.bootcamp.individual4

fun old () {

    open class Phone(var isScreenLightOn: Boolean = false){
        fun switchOn() {
            isScreenLightOn = true
        }
        fun switchOff() {
            isScreenLightOn = false
        }
        fun checkPhoneScreenLight() {
            val phoneScreenLight = if (isScreenLightOn) "on" else "off"
            println("The phone screen's light is $phoneScreenLight.")
        }
    }

    class FoldablePhone(var isFolded: Boolean = true) : Phone() {
        fun fold() {
            isFolded = true
            switchOff()
        }

        fun unfold() {
            isFolded = false
            switchOn()

        }

        fun checkPhoneFolded(){
            val phoneFolded = if (isFolded) "folded" else "unfolded"
            println("The phone is $phoneFolded.")
            checkPhoneScreenLight()
        }
    }

    var statusPhone : FoldablePhone = FoldablePhone(true)

    statusPhone.checkPhoneFolded()
    statusPhone.unfold()
    statusPhone.checkPhoneFolded()

}