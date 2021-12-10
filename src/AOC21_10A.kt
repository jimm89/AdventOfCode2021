import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.lang.AssertionError
import kotlin.system.exitProcess
import kotlin.math.min
import kotlin.math.max
import kotlin.math.abs
 
private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readInput(name: String) = File("Input", "$name.txt").readLines()
private fun List<String>.asInts() = this.map { it.toInt() }.toTypedArray()

 
private fun myAssert(x: Boolean) {
    if (!x) {
        throw AssertionError()
    }
}
 
fun main(args: Array<String>) {
    var F = readInput("AOC21_10A_in")
    var ans = 0
    var x = "([{<".toCharArray()
    var y = ")]}>".toCharArray()
    var z: Array<Int> = arrayOf(3,57,1197,25137)
    for (f in F) {
        var stack: MutableList<Int> = mutableListOf()
        for (c in f) {
            var idx = x.indexOf(c)
            if (idx != -1) {
                stack.add(idx)
            }
            else {
                var idx2 = y.indexOf(c)
                if (stack.size == 0 || idx2 != stack[stack.size-1]) {
                    ans += z[idx2]
                    break
                }
                else {
                    stack.removeAt(stack.size - 1)
                }
            }
        }
    }
    println(ans)
}
