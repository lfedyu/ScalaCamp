import scala.collection.immutable.ListMap

object CrimesSolver extends App{
  val cSVParser = CSVParser

  val crimes = cSVParser.parseCrimes("src/crimes/2018-12-thames-valley-street.csv")
  val map = cSVParser.mapLocationToCrimes(crimes)
  val res = map.toSeq.sortWith(_._2._1 > _._2._1)
  //res.foreach(println)
  res.take(5).foreach(res => {
    println("(" + res._1 + "): " + res._2._1)
    res._2._2.foreach(r22 => if(r22.crimeType.contains("heft"))println(r22.crimeType))
  }
  )
}
