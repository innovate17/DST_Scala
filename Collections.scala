import scala.collection.mutable
import scala.collection.mutable
object Collections{
	def main(args: Array[String]): Unit = {
		/*
		*
		*  Working with list
		*
		*/
		val list_example = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
		println(list_example)
		val list_example2 = 1 ::(2 ::(3 :: (4 ::(5 :: Nil))))
		println(list_example2)
		val list_example3 = List(1,2,3,4,5)
		println(list_example3)
		val list_example4 = List.range(1,5,1)
		println(list_example4)
		val list_example5 = List.fill(5)("foo")
		println(list_example5)
		val list_example6 = List.tabulate(5)( n => n*n)
		println(list_example6)

		/*
		*
		* Working with Set
		*
		*/
		val words = mutable.Set.empty[String]
		words += "What"
		words += "are"
		words ++= List("you","looking","for","?")
		println(words)
		println(words.size)
		println(words.contains("looking"))
		words -= "looking"
		println(words.contains("looking"))
		words --= List("you","?")
		println(words)

		/*
		*
		* working with Map
		*
		*/
		val map = mutable.Map.empty[String,Int]
		map += ("Physics" -> 90)
		map += ("Maths" -> 100)
		map += ("Biology" -> 89)

		println(map)

		map ++= List(("Chemistry" -> 90),
					 ("Computer Science" -> 100)
					)
		println(map)
		println(map("Chemistry"))
		println(map.size)
		println(map.keys)

	}
}