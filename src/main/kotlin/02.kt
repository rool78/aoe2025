package org.example

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val test = Solution2()
    println(test.solve("12077-25471,4343258-4520548,53-81,43661-93348,6077-11830,2121124544-2121279534,631383-666113,5204516-5270916,411268-591930,783-1147,7575717634-7575795422,8613757494-8613800013,4-19,573518173-573624458,134794-312366,18345305-18402485,109442-132958,59361146-59451093,1171-2793,736409-927243,27424-41933,93-216,22119318-22282041,2854-4778,318142-398442,9477235089-9477417488,679497-734823,28-49,968753-1053291,267179606-267355722,326-780,1533294120-1533349219"))
}

class Solution2 {

    data class Range(val start: Long, val end: Long)

    fun solve(input: String): Long {
        val ranges = parseRanges(input)
        var invalidNumbersSum = 0L
        ranges.forEach { range ->
            for (i in range.start..range.end) {
                if (isNumberRepeatedTwice(i)) {
                    invalidNumbersSum += i
                }
            }
        }

        return invalidNumbersSum
    }

    //    11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
    //    1698522-1698528,446443-446449,38593856-38593862,565653-565659,
    //    824824821-824824827,2121212118-2121212124
    fun parseRanges(input: String): List<Range> =
         input.split(',')
            .map {
                it.split('-').let { r ->
                    Range(r[0].toLong(), r[1].toLong())
                }
            }

    fun isNumberRepeatedTwice(n: Long): Boolean {
        val number = n.toString()
        if (number.length % 2 != 0) {
            return false
        }
        val first = number.take(number.length / 2)
        val second = number.substring(number.length / 2)
        return first == second
    }

}

class TestSolution2 {

    private val solution2 = Solution2()

    @Test
    fun isNumberRepeatedTwice() {
        val n1 = 11L
        val n2 = 123123123123
        val n3 = 7839978399

        assertTrue(solution2.isNumberRepeatedTwice(n1))
        assertTrue(solution2.isNumberRepeatedTwice(n2))
        assertTrue(solution2.isNumberRepeatedTwice(n3))
    }

    @Test
    fun numberIsNotRepeatedTwice() {
        val n1 = 3492349832
        val n2 = 78L
        val n3 = 99999991L

        assertFalse(solution2.isNumberRepeatedTwice(n1))
        assertFalse(solution2.isNumberRepeatedTwice(n2))
        assertFalse(solution2.isNumberRepeatedTwice(n3))
    }

}