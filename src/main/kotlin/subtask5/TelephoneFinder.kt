package subtask5

class TelephoneFinder {

    private val resultMas = mutableListOf<String>()

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        if(number.matches(Regex("[0-9]*"))) { //приводим к регульярному выражению и дальше ищем полное соответсвие
            number.forEachIndexed { index, char ->
                when(char) {
                    '0' -> neighbourNumbers(index, number, listOf('8'))
                    '1' -> neighbourNumbers(index, number, listOf('2','4'))
                    '2' -> neighbourNumbers(index, number, listOf('1','3','5'))
                    '3' -> neighbourNumbers(index, number, listOf('2','6'))
                    '4' -> neighbourNumbers(index, number, listOf('1','5','7'))
                    '5' -> neighbourNumbers(index, number, listOf('2','4','6','8'))
                    '6' -> neighbourNumbers(index, number, listOf('3','5','9'))
                    '7' -> neighbourNumbers(index, number, listOf('4','8'))
                    '8' -> neighbourNumbers(index, number, listOf('5','7','9','0'))
                    else -> neighbourNumbers(index, number, listOf('6','8'))
                }
            }
        }
        else return null

        return resultMas.toTypedArray()
    }

    private fun neighbourNumbers(index: Int, number: String, neighbors: List<Char>) {

        for(element in neighbors) {
            val str = number.replace(number[index], element)
            resultMas.add(str)
        }
    }
}