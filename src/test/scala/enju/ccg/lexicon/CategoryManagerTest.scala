package enju.ccg.lexicon
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class CategoryManagerTest extends FunSuite {
  AVMInitializer.init

  test("the same child node should be assiged the same id") {
    val manager = new CategoryManager // Constructor automatically creates unknown category which is assigned id 0

    val cat = CategoryParser.parse("NP[o,nm]／NP[o,nm]")
    manager.assignID(cat) match {
      case ComplexCategory(id, left, right, _) => {
        left.id should equal (1)
        right.id should equal (1)
        id should equal (2)
      }
      case _ => fail() // should not occur
    }
  }
}
