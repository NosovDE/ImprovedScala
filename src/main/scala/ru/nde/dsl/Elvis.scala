package ru.nde.dsl

/**
 * Author:      Dmitriy E. Nosov <br>
 * Date:        22.02.13, 17:56 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
class Elvis {

  implicit def nullity_implicits[A >: Null](nullity: => A) = new {

    // poor man's safe navigation operators
    //-------------------------------------
    // when the res is nullable
    // usage:
    // rewrite the code: if(a != null && a.b != null && a.b.c != null) { a.b.c.d } else null
    // to: a ?! {_.b} ?! {_.c} ?! {_.d}
    def ?![B >: Null](f: A => B): B = {
      nullity match {
        case null => null.asInstanceOf[B]
        case v => f(v)
      }
    }

    // when the res is not nullable
    // usage:
    // rewrite the code: if(a != null && a.b != null && a.b.c != null) { a.b.c.d } else 0
    // to: a ?! {_.b} ?! {_.c} ?!! {_.d} getOrElse 0
    def ?!![B](f: A => B): Option[B] = {
      nullity match {
        case null => None
        case v => Some(f(v))
      }
    }

    // groovy elvis operator
    // NB: the args are inverted as it ends in ':'  !
    // usage:
    // rewrite the code: if(a != null) a else b
    // to: a ?: b
    def ?:[B >: A](pred: B) = if (pred == null) nullity else pred
  }
}
