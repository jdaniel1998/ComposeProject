package com.example.composeadmin.utils

object StringUtils {

    fun String.trimTrailingZero(): String {
        return if (this.isNotEmpty()) {
            if (this.indexOf(".") < 0) {
                this

            } else {
                this.replace("0*$".toRegex(), "").replace("\\.$".toRegex(), "")
            }

        } else {
            this
        }
    }
}