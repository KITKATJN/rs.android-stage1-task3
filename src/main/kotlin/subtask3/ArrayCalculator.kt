package subtask3

import kotlin.math.max
import kotlin.math.min

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val intItems=itemsFromArray.filterIsInstance<Int>().toTypedArray()

        if (intItems.isEmpty()) return 0

        if(intItems.size<numberOfItems){
            var result=1
            for (i in 1..intItems.size) result*=intItems[i-1]
            return result
        }
val sizeOfArray=intItems.size-1
        var maxElement=max(intItems[0],intItems[1])
        var lowElement= min(intItems[0],intItems[1])
        var hProductOfTwo=intItems[0]*intItems[1]
        var hProductOfThree = 0
        var hProductOfFour = 0
        when(intItems.size){
            3->  hProductOfThree = intItems[0] * intItems[1] * intItems[2]
            4->hProductOfFour = intItems[0] * intItems[1] * intItems[2]*intItems[3]
        }

        var lProductOfTwo  = intItems[0] * intItems[1]
        when(numberOfItems){
            1->return intItems[0]
            2,3->{

                for (i in 2..sizeOfArray){
                    hProductOfThree= max(hProductOfThree,intItems[i]*hProductOfTwo)
                    hProductOfThree= max(hProductOfThree,intItems[i]*lProductOfTwo)

                    hProductOfTwo= max(hProductOfTwo,intItems[i]*maxElement)
                    hProductOfTwo= max(hProductOfTwo,intItems[i]*lowElement)

                    lProductOfTwo= min(lProductOfTwo,intItems[i]*maxElement)
                    lProductOfTwo= min(lProductOfTwo,intItems[i]*lowElement)

                    maxElement = max(maxElement, intItems[i])

                    lowElement = min(lowElement, intItems[i])
                }
                return hProductOfThree
            }
            4->{
                for (i in 2..sizeOfArray){
                    hProductOfFour= max(hProductOfFour,intItems[i]*hProductOfThree)
                    hProductOfFour= max(hProductOfFour,intItems[i]*hProductOfThree)

                    hProductOfThree= max(hProductOfThree,intItems[i]*hProductOfTwo)
                    hProductOfThree= max(hProductOfThree,intItems[i]*lProductOfTwo)

                    hProductOfTwo= max(hProductOfTwo,intItems[i]*maxElement)
                    hProductOfTwo= max(hProductOfTwo,intItems[i]*lowElement)

                    lProductOfTwo= min(lProductOfTwo,intItems[i]*maxElement)
                    lProductOfTwo= min(lProductOfTwo,intItems[i]*lowElement)

                    maxElement = max(maxElement, intItems[i])

                    lowElement = min(lowElement, intItems[i])
                }
                return hProductOfFour

            }
            else->{
                return intItems[0]
            }
        }

    }
}
