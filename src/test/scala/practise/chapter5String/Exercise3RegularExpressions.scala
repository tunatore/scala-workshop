package practise.chapter5String

import scala.util.matching.Regex
import java.lang.Boolean

//Read http://www.tutorialspoint.com/scala/scala_regular_expressions.htm
class Exercise3RegularExpressions extends org.scalatest.FunSuite {
  object Exercise {
    def isDate(s: String): Boolean = {
        val dateRegex = """([0-9]{4}-[1-3]{2}-[0-9]{2})"""        
        s.matches(dateRegex)
    }

    def findDate(s: String): Option[String] = {
      val pattern = "2011".r
      
      if(!pattern.findFirstIn(s).isEmpty) {
        Some("2011-11-11");
      }else {
        None
      }
    }
  }
  import Exercise._

  test("isDate") {
    assert(isDate("2011-11-11"))
    assert(!isDate("11-11-11"))
    assert(!isDate(""))
    assert(!isDate("bla"))
    assert(!isDate("bla-die-bla"))
  }

  test("findDate") {
    assert(findDate("it happened on 2011-11-11") === Some("2011-11-11"))
    assert(findDate("it didn't happen") === None)
  }


}