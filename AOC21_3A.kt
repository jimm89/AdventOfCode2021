import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.lang.AssertionError
 
private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readLong() = readLn().toLong() // single long
private fun readDouble() = readLn().toDouble() // single double
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles
private fun readInput(name: String) = File("$name.txt").readLines()
private fun List<String>.asInts() = this.map { it.toInt() }.toTypedArray()

 
private fun myAssert(x: Boolean) {
    if (!x) {
        throw AssertionError()
    }
}
 
fun main(args: Array<String>) {
    var F = readInput("AOC21_3A_in")
    var n = F.size
    var x = F[0].length
    var bit = IntArray(x){0}
    for (f in F) {
        for (j in 0 until x) {
            if (f[x - j - 1] == '1') bit[j]++
        }
    }
    var ans = 0.toLong()
    for(i in 0 until x) {
        if (bit[i] * 2 >= n) ans += (1.toLong() shl i)
    }
    var ans2 = (1.toLong() shl x) - (ans + 1)
    println(ans * ans2)
}
