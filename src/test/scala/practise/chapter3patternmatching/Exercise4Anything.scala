package practise.chapter3patternmatching

import org.scalatest.FunSuite

class Exercise4Anything extends FunSuite {
  case class Singer(name: String)
  object SwimmingTrunks
  object RhymingDictionary

  object Exercise {
    def matchAnything(o: Any): String = {
      
      o match {
          case s : Singer => "a singer called " + s.name
          case i : Int if i>=1 && i <=99 => i.toString()  
          case i100 : Int if i100>=101 && i100 <=200 => "too much" 
          case o if o == RhymingDictionary => "rhyming dictionary"
          case s if s == SwimmingTrunks => "swimming trunks"
          case l : List[Any] => "a list with "+l.size+" elements"
          case f : Function[_,_] => "a function"
          case _ => "something else"
      }
    }
  }
  import Exercise._

  test("numbers - Anything under 100 returns itself as a String") {
    (1 to 99).foreach { i =>
      assert(matchAnything(i) === i.toString)
    }
  }

  test("numbers - Anything above 100 returns too much") {
    (101 to 200).foreach { i =>
      assert(matchAnything(i) === "too much")
    }
  }

  test("objects") {
    assert(matchAnything(SwimmingTrunks) === "swimming trunks")
    assert(matchAnything(RhymingDictionary) === "rhyming dictionary")
  }

  test("toppers") {
    assert(matchAnything(Singer("René Froger")) === "a singer called René Froger")
    assert(matchAnything(Singer("Gerard Joling")) === "a singer called Gerard Joling")
  }

  test("List") {
    assert(matchAnything(List(1, 2, 3)) === "a list with 3 elements")
    assert(matchAnything(List(1, 2, 3, 4, 5, 6)) === "a list with 6 elements")
  }

  test("functions") {
    val f1: Function[Int, Int] = { i: Int => i + 1 }
    assert(matchAnything(f1) === "a function")
    assert(matchAnything({ i: Int => i.toString }) === "a function")
  }

  test("anything else") {
    val long: Long = 2L
    assert(matchAnything(long) === "something else")
  }

}