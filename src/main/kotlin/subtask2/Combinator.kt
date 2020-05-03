package subtask2

class Combinator {
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m=array[0]
        var n=array[1]
        var result = 1
        for(x in 1..n) {
            result = result * n / x
            if( m == result ) {
                return x
            }
            n -= 1
        }
        return null
    }
}

// some problem with Long
//    fun checkChooseFromArray(array: Array<Int>): Long {
//       val m=array[0]
//        val n=array[1]
//        var x =1
//        //val factorialN=factorial(n)
//        while ((factorial(n))<(m.toLong()*factorial(x)*factorial(n-x))){
//            x++
//        }
//        return if ((factorial(n))>=(m.toLong()*factorial(x)*factorial(n-x))) factorial(n)
//        else factorial(n)
//    }
//    private fun factorial(num: Int): Long {
//        var result = 1L
//        for (i in 2..num) result *= i
//        return result
//    }
//}
