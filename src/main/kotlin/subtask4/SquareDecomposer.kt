package subtask4

import kotlin.math.floor
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decomposeValue(number * number, number - 1)
    }

    private fun decomposeValue(squareOfGivenNumber: Int, prevNumber: Int): Array<Int>? {
        var penNumber=prevNumber
        while(  penNumber >=1 ) {
            val desiredSquare = penNumber * penNumber
            val currentSquare = squareOfGivenNumber - desiredSquare
            var sqrt = floor( sqrt(currentSquare.toDouble()) ).toInt()//округление в нижнюю сторону
            when{
                currentSquare== 0-> return arrayOf(penNumber)
                currentSquare < 0-> return null
                else-> {
                    if (sqrt >= penNumber) {
                        sqrt = penNumber - 1
                    }
                    val decomposed = decomposeValue(currentSquare, sqrt)//рекурсия
                    if (null != decomposed) {
                        return decomposed + arrayOf(penNumber)
                    }
                }
            }
            penNumber--
        }
        return null
    }
}