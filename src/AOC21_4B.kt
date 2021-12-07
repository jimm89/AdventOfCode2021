import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.lang.AssertionError
import kotlin.system.exitProcess
 
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
    var F = readInput("AOC21_4A_in")
    var nums = F[0].split(",").asInts()
    var num_cards = 0
    var rows = 0
    var cols = 0
    for (j in 1 until F.size) {
        if (F[j].length < 2) {
            if (rows == 0) continue
            else break
        }
        if (cols == 0) {
            var x = F[j].split(" ")
            for (k in 0 until x.size) {
                if (x[k] == "") continue
                cols++
            }
        }
        rows++
    }
    num_cards = (F.size - 1)/(rows+1)
    var cards = Array(num_cards) { Array (rows) { IntArray(cols) {0} } }
    var card_num = -1
    var curr_row = 0
    for (j in 1 until F.size) {
        if (F[j].length < 2) {
            card_num++
            curr_row = 0
            continue
        }
        var x = F[j].split(" ")
        var curr_col = 0
        for (k in 0 until x.size) {
            if (x[k] == "") continue
            cards[card_num][curr_row][curr_col] = x[k].toInt()
            curr_col++
        }
        curr_row++
    }
    var score = Array(num_cards) { Array (rows) { BooleanArray(cols) {false} } }
    var num_wins = 0
    var won  = BooleanArray(num_cards) {false}
    for (num in nums) {
        for (i in 0 until num_cards) {
            if (won[i]) continue
            for (j in 0 until rows) {
                for (k in 0 until cols) {
                    if (num == cards[i][j][k]) {
                        score[i][j][k] = true
                        var win_row = true
                        var win_col = true
                        for (l in 0 until cols) {
                            if (!score[i][j][l]) win_row = false
                        }
                        for (l in 0 until rows) {
                            if (!score[i][l][k]) win_col = false
                        }
                        if (win_row || win_col) {
                            num_wins++
                            won[i] = true
                            if (num_wins == num_cards) {
                                var ans = 0
                                for (l in 0 until rows) {
                                    for (m in 0 until cols) {
                                        if (!score[i][l][m]) ans += cards[i][l][m]
                                    }
                                }
                                ans *= num
                                println(ans)
                                exitProcess(0)
                            }
                        }
                    }
                }
            }
        }
    }
}
