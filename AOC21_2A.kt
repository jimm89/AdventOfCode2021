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
    var F = readInput("AOC21_2A_in")
    var x = 0
    var y = 0
    for (f in F) {
        var (a,b) = f.split(" ")
        if (a[0] == 'f') x += b.toInt()
        if (a[0] == 'd') y += b.toInt()
        if (a[0] == 'u') y -= b.toInt()
    }
    println(x * y)
}
