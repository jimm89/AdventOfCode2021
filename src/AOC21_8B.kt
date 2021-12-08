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
    var F = readInput("AOC21_8A_in")
    var ans = 0
    var rev_map: MutableMap<String,Int> = HashMap()
    rev_map["abcefg"] = 0
    rev_map["cf"] = 1
    rev_map["acdeg"] = 2
    rev_map["acdfg"] = 3
    rev_map["bcdf"] = 4
    rev_map["abdfg"] = 5
    rev_map["abdefg"] = 6
    rev_map["acf"] = 7
    rev_map["abcdefg"] = 8
    rev_map["abcdfg"] = 9
    for (f in F) {
        var (in_, out_) = f.split(" | ")
        var lookups = in_.split(" ")
        var let_map: MutableMap<Char,Char> = HashMap()
        var cnt: MutableMap<Char,Int> = HashMap()
        var dg = mutableListOf<Char>()
        var ac = mutableListOf<Char>()
        for (word in lookups) {
            for (letter in word) {
                when (val count = cnt[letter]) {
                    null -> cnt[letter] = 1
                    else -> cnt[letter] = count + 1
                }
            }
        }
        for ((key, value) in cnt) {
            if (value == 9) let_map[key] = 'f'
            if (value == 4) let_map[key] = 'e'
            if (value == 6) let_map[key] = 'b'
            if (value == 7) dg.add(key)
            if (value == 8) ac.add(key)
        }
        for (word in lookups) {
            if (word.length == 2) {
                for (letter in word) {
                    for (letter2 in ac) {
                        if (letter == letter2) {
                            let_map[letter] = 'c'
                        }
                    }
                }
            }
            if (word.length == 4) {
                for (letter in word) {
                    for (letter2 in dg) {
                        if (letter == letter2) {
                            let_map[letter] = 'd'
                        }
                    }
                }
            }
        }
        for (letter in ac) {
            if (!let_map.containsKey(letter)) let_map[letter] = 'a'
        }
        for (letter in dg) {
            if (!let_map.containsKey(letter)) let_map[letter] = 'g'
        }
        var nums = out_.split(" ")
        var X = 0
        var mult = 1000
        for (word in nums) {
            var S = ""
            var C = mutableListOf<Char>()
            for (letter in word) {
                C.add(let_map[letter]!!.toChar())
            }
            var D = C.sortedWith(compareBy {it})
            for (c in D) S += c
            var Z = rev_map[S]
            X += mult*Z!!.toInt()
            mult /= 10
        }
        ans += X
        //ans += X.toInt()
    }
    println(ans)
}
