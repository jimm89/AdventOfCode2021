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
    var most = F
    var least = F
    for(i in 0 until x) {
        var cnt = 0
        for (S in most) {
            if (S[i] == '1') cnt++
        }
        var targ = '0'
        if (cnt * 2 >= most.size) targ = '1'
        var new_: MutableList<String> = mutableListOf()
        for (S in most) {
            if (S[i] == targ) new_.add(S)
        }
        most = new_
    }
    for(i in 0 until x) {
        var cnt = 0
        for (S in least) {
            if (S[i] == '1') cnt++
        }
        var targ = '0'
        if (cnt * 2 >= least.size) targ = '1'
        var new_: MutableList<String> = mutableListOf()
        for (S in least) {
            if (S[i] != targ) new_.add(S)
        }
        least = new_
        if (least.size == 1) break
    }
    var ans = 0
    var ans2 = 0
    for(i in 0 until x) {
        if (most[0][x-i-1] == '1') ans += (1 shl i)
        if (least[0][x-i-1] == '1') ans2 += (1 shl i)
    }
    println(ans * ans2)
}
