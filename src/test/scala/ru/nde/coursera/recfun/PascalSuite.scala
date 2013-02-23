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
class PascalSuite extends FunSuite {

  import ru.nde.coursera.RecFun.pascal

  test("col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }
}

