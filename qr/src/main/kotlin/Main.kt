package org.example

import DataProvider
import QRCreator

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val dataToEncode = DataProvider.retrieveData()
    QRCreator.createQR(dataToEncode)
}