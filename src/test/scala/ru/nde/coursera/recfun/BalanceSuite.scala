package ru.nde.coursera.recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * Author:      Dmitriy E. Nosov <br>
 * Date:        23.02.13, 23:24 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {

  import ru.nde.coursera.RecFun.balance

  test("'(if (zero? x) max (/ 1 x))' is balanced.") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("'I told him ...' is balanced.") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("':-)' is unbalanced.") {
    assert(!balance(":-)".toList))
  }

  test("Counting is not enough.") {
    assert(!balance("())(".toList))
  }
}

