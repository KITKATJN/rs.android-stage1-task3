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
//package subtask6
//
//data class Row(var count:Int, var parent: Row?, var value: Array<String> = arrayOf())
//
//class FullBinaryTrees {
//
//    fun stringForNodeCount(count: Int): String {
//        if(1 > count) {
//            return "[]"
//        }
//        if(0 == count % 2) {
//            return "[]"
//        }
//
//        val root = Row(count-1, null, arrayOf("0"))
//        val children = getChildren(root)
//        var result: Array<String> = arrayOf()
//        for(child in children) {
//            var row: Array<String> = arrayOf()
//            var node: Row? = child
//            while(null != node) {
//                row = node.value + row
//                node = node.parent
//            }
//            result += arrayOf("[" + row.joinToString(",") + "]")
//        }
//        //result.forEach { println(it) }
//        return "[" + result.joinToString(" ") + "]"
//    }
//
//    private fun getChildren(parent: Row): Array<Row> {
//        val count: Int = parent.count
//        if( 0 == count ) {
//            return arrayOf(Row(0, parent, arrayOf()))
//        }
//        val row = parent.value
//        val size = row.size - 1
//        var result: Array<Row> = arrayOf()
//        for(i in 0..size) {
//            if("0" == row[i]) {
//                if(0 == result.size) {
//                    result += arrayOf(Row(count, parent)) + arrayOf(Row(count, parent))
//                } else {
//                    result = duplicateRowArray(result)
//                }
//                for(j in 0..(result.size / 2 - 1)) {
//                    if(1 < result[j*2].count) {
//                        result[j*2].value += arrayOf("0","0")
//                        result[j*2].count -= 2
//                        result[j*2 + 1].value += arrayOf("null","null")
//                    }
//                }
//            }
//        }
//        var withChildren: Array<Row> = arrayOf()
//        for(r in result) {
//            if(2 > r.count) {
//                if(r.value.size > 0) {
//                    withChildren += r
//                }
//            } else {
//                withChildren += getChildren(r)
//            }
//        }
//
//        return withChildren
//    }
//
//    private fun duplicateRowArray(rowArray: Array<Row>): Array<Row> {
//        var newArray: Array<Row> = arrayOf()
//        for(row in rowArray) {
//            newArray += row
//            if(0 == row.count) {
//                newArray += Row(row.count, row.parent, arrayOf())
//            } else {
//                newArray += Row(row.count, row.parent, row.value)
//            }
//        }
//        return newArray
//    }
//package subtask6
//
//class FullBinaryTrees {
//
//    fun stringForNodeCount(count: Int): String {
//
//        val arrayOfNodes = getNodes(count)
//        val result = StringBuilder()
//
//        arrayOfNodes?.map { el ->
//            val node = "[0,$el]"
//            val nodeWithoutNull = node.replace("(null,)+]".toRegex(), "]")
//            result.append(nodeWithoutNull).deleteCharAt(result.length - 2)
//        }
//        println("[${result}]")
//        return "[${result}]"
//    }
//
//    class Node(var root: Int = 0) {
//
//        var left: Node? = null
//        var right: Node? = null
//
//        override fun toString(): String {
//            return if (left == null && right == null)
//                "${left},${right},"
//            else
//                "${left?.root},${right?.root},$left$right"
//        }
//    }
//
//    fun getNodes(n: Int): List<Node>? {
//
//        val list = mutableListOf<Node>()
//        var i = 1
//
//        if (n % 2 == 0) return list
//        if (n == 1) {
//            list.add(Node())
//            return list
//        }
//
//        while (i < n) {
//            for (left in getNodes(i)!!)
//                for (right in getNodes(n - i - 1)!!) {
//                    val root = Node()
//                    root.left = left
//                    root.right = right
//                    list.add(root)
//                }
//            i += 2
//        }
//        return list
//    }
//}

//package subtask6
//
//import kotlin.collections.ArrayList
//
//class FullBinaryTrees {
//
//    fun stringForNodeCount(count: Int): String {
//        val result = ArrayList<ArrayList<Int?>>()
//
//        for(node in allPossibleFullBinaryTrees(count)){
//            val list = convertToList(node)
//            while (list[list.size - 1] == null) list.removeAt(list.size - 1)
//            result.add(list)
//        }
//        return result.toString()
//    }
//
//    private fun allPossibleFullBinaryTrees(nodeCount: Int): ArrayList<Node>{
//        if(nodeCount == 1) return arrayListOf(Node())
//        if(nodeCount % 2 == 0) return ArrayList()
//        val result = ArrayList<Node>()
//        for(i in 1 until nodeCount step 2){
//            val left = allPossibleFullBinaryTrees(i)
//            val right = allPossibleFullBinaryTrees(nodeCount - (i + 1))
//            for(leftNode in left){
//                for(rightNode in right)
//                    result.add(Node(maxOf(leftNode.depth, rightNode.depth)+1,leftNode,rightNode))
//            }
//        }
//        return result
//    }
//
//    private fun convertToList(node: Node):ArrayList<Int?>{
//        var currentLevel = 0
//        val result = ArrayList<Int?>()
//        result.add(0)
//        val children = ArrayList<Node?>()
//        children.add(node.left)
//        children.add(node.right)
//        while(children.isNotEmpty()){
//            val newChildren = ArrayList<Node?>()
//            for(childrenNode in children){
//                if(childrenNode == null){
//                    if(currentLevel != node.depth) result.add(null)
//                }else{
//                    result.add(0)
//                    newChildren.add(childrenNode.left)
//                    newChildren.add(childrenNode.right)
//                }
//            }
//            currentLevel++
//            children.clear()
//            children.addAll(newChildren)
//            newChildren.clear()
//        }
//        return result
//    }
//}
//
//class Node(var depth: Int = 0, var left: Node? = null, var right: Node? = null)