package ru.nde.coursera

import ru.nde.coursera.common._
import scala.collection._


/**
 * Author:      Dmitriy E. Nosov <br>
 * Date:        22.02.13, 13:19 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
object RecFun {

  def main(args: Array[String]) {
    println(countChange(4, List(1, 2)))

  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = ???

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def fun(chars: List[Char], c: Int): Boolean = {

      if (chars.isEmpty) {
        c == 0
      } else if (chars.head == '(') {
        fun(chars.tail, c + 1)
      } else if (chars.head == ')') {
        if (c != 0) fun(chars.tail, c - 1) else false
      } else
        fun(chars.tail, c)
    }
    fun(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    if (money == 0) 1
    else if (money < 0) 0
    else {
      if (coins.isEmpty) 0
      else {
        countChange(money, coins.tail) + countChange(money - coins.head, coins)
      }
    }
  }
}





