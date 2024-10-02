package cl.bootcamp.spint5.model

import java.io.Serializable

data class CardItem(
    val product : ProductItem,
    val count : Int,
    val size : Int
): Serializable
