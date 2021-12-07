import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.lang.AssertionError
import kotlin.system.exitProcess
import kotlin.math.min
import kotlin.math.max
 
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
    var F = readInput("AOC21_5A_in")
    var grid = Array (1000) { Array (1000) {0} }
    for (f in F) {
        var pair = f.split(" -> ")
        var x = pair[0].split(",").asInts()
        var y = pair[1].split(",").asInts()
        if (x[0] == y[0] || x[1] == y[1]) {
            var i0 = min(x[0],y[0])
            var i1 = max(x[0],y[0])+1
            var j0 = min(x[1],y[1])
            var j1 = max(x[1],y[1])+1
            for(i in i0 until i1) {
                for(j in j0 until j1) {
                    grid[i][j]++
                }
            }
        }
    }
    var ans = 0
    for(i in 0 until 1000) {
        for(j in 0 until 1000) {
            if (grid[i][j] > 1) ans++
        }
    }
    println(ans)
}
