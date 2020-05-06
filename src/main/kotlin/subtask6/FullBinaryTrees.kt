package subtask6

class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        return when{
            count%2==0-> "[]"
            count==0-> "[]"
            count==1-> "[[0]]"
            else-> ""
        }
    }
}
