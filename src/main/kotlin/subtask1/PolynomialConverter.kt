package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        var sizeOfArray=numbers.size
        if(numbers.isEmpty())return null
        var returnString=if (numbers[numbers.size-1]>0){
            numbers[0].toString()+"x^" + (sizeOfArray - 1).toString()
        }else{
           " - "+ numbers[0].toString()+"x^" + (sizeOfArray - 1).toString()
        }
        for (i in (1) until  numbers.size-2) {
            when {
                numbers[i]>0 -> {
                    returnString +=" + "+numbers[i].toString() + "x^" + (sizeOfArray - 2).toString()
                    sizeOfArray --
                }
                numbers[i]<0 -> {
                    returnString += " - "+numbers[i].absoluteValue.toString() + "x^" + (sizeOfArray - 2).toString()
                   sizeOfArray --
                }

                else -> {
                    returnString +=  ""
                    sizeOfArray--
                }
            }
        }
        returnString += when {
            numbers[numbers.size-2]>1 -> {
                " + "+numbers[numbers.size-2].toString()+"x"
            }
            numbers[numbers.size-2]==1 -> {
                " + "+"x"
            }
            numbers[numbers.size-2]==-1 -> {
                " - "+"x"
            }

            else -> {
                ""
            }
        }
        returnString += if(numbers[numbers.size-1]>0) {
            " + "+numbers[numbers.size-1].toString()
        }else{
            " - "+numbers[numbers.size-1].toString()
        }
        return returnString
    }
}
