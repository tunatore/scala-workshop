package practise.chapter2collections

//read https://twitter.github.io/scala_school/collections.html
//hint: collections have many nice methods, like filter.
class Exercise1Filter extends org.scalatest.FunSuite {
  object Exercise {
    //return all even numbers from the list
    def allEvenNumbers(list: List[Int]): List[Int] = {      
        
        list.filter((i: Int) => i % 2 == 0)
        list.filter(isEven(_))
        
    }
    
    def isEven(i: Int): Boolean = i % 2 == 0
  }
  import Exercise._

  test("allEvenNumbers - none") {
    assert(allEvenNumbers(List()) === List())
  }

  test("allEvenNumbers - 1") {
    assert(allEvenNumbers(List(1)) === List())
  }

  test("allEvenNumbers - 2") {
    assert(allEvenNumbers(List(2)) === List(2))
  }

  test("allEvenNumbers - many") {
    assert(allEvenNumbers(List(1, 2, 3, 4, 5, 6)) === List(2, 4, 6))
  }

}