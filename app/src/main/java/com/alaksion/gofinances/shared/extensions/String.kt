package com.alaksion.gofinances.shared.extensions

fun String.makeMonetaryString(): String {
    return "R$ ${"%.2f".format(this.toDouble())}".replace(".", ",")
}