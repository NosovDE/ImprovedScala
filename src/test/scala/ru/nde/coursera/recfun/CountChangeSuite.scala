package ru.nde.coursera.recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * Author:      Dmitriy E. Nosov <br>
 * Date:        23.02.13, 23:40 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {

  import ru.nde.coursera.RecFun.countChange

  test("example from instructions") {
    assert(countChange(4, List(1, 2)) === 3)
  }

  test("sorted CHF") {
    assert(countChange(300, List(5, 10, 20, 50, 100, 200, 500)) === 1022)
  }

  test("no pennies") {
    assert(countChange(301, List(5, 10, 20, 50, 100, 200, 500)) === 0)
  }

  test("unsorted CHF") {
    assert(countChange(300, List(500, 5, 50, 100, 20, 200, 10)) === 1022)
  }
}
