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
    var inp = readInput("AOC21_6A_in")[0]
    var F = inp.split(",").map{it.toInt()}
    var start = LongArray (9) {0L}
    for (f in F) start[f]++
    for(k in 0 until 80) {
        var new_ = LongArray (9) {0L}
        for (x in 0 until 9) {
            if (x == 0) {
                new_[6] += start[x]
                new_[8] += start[x]
            }
            else {
                new_[x-1] += start[x]
            }
        }
        start = new_
    }
    var ans = 0L
    for(x in start) ans += x
    println(ans)
}
