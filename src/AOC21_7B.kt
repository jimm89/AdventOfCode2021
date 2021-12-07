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
    var inp = readInput("AOC21_7A_in")[0]
    var F = inp.split(",").map{it.toLong()}
    F = F.sortedBy{it}
    var best = 1000000000000000000L
    var min_F = F[0]
    var max_F = F[F.size-1]
    for(targ in min_F until max_F + 1) {
        var ans = 0L
        for (f in F) {
            var y = abs(targ - f)
            ans += y*(y+1)/2
        }
        best = min(ans, best)
    }
    println(best)
}
