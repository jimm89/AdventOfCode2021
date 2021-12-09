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
    var F = readInput("AOC21_9A_in")
    var rows = F.size
    var cols = F[0].length
    var inp = Array (rows) { IntArray (cols) {0} }
    var ans = 0
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            inp[i][j] = F[i][j].toString().toInt()
        }
    }
    var dx = IntArray(4) {0}
    dx[2] = 1
    dx[3] = -1
    var dy = IntArray(4) {0}
    dy[0] = 1
    dy[1] = -1
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            var flag = true
            for (k in 0 until 4) {
                if (0 <= i + dx[k] && i + dx[k] < rows && 0 <= j + dy[k] && j + dy[k] < cols && inp[i + dx[k]][j + dy[k]] <= inp[i][j]) flag = false
            }
            if (flag) ans += (1 + inp[i][j])
        }
    }
    println(ans)
}
