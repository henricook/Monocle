package monocle.function

import monocle.std._
import monocle.syntax._
import org.specs2.scalaz.Spec

import scalaz.IList

class InitOptionExample extends Spec {

  "tail creates a Traversal from a List, IList, Vector or Stream to its tail" in {
    (List(1, 2, 3)    applyOptional initOption getOption) ==== Some(List(1, 2))
    (List(1)          applyOptional initOption getOption) ==== Some(Nil)
    ((Nil: List[Int]) applyOptional initOption getOption) ==== None

    (List(1, 2, 3)    applyOptional initOption set List(4, 5, 6))   ==== List(4, 5, 6, 3)
    (IList(1, 2, 3)   applyOptional initOption set IList(4, 5, 6))  ==== IList(4, 5, 6, 3)
    (Vector(1, 2, 3)  applyOptional initOption set Vector(4, 5, 6)) ==== Vector(4, 5, 6, 3)
    (Stream(1, 2, 3)  applyOptional initOption set Stream(4, 5, 6)) ==== Stream(4, 5, 6, 3)
  }

  "tail creates a Traversal from a String to its tail" in {
    ("hello" applyOptional initOption modify (_.toUpperCase)) ==== "HELLo"
  }

}
