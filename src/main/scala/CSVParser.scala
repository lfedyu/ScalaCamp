import scala.collection.mutable.ListBuffer
import scala.io.Source

object CSVParser {


  def parseCrimes(path: String): Seq[Crime] = {
    var crimesList: ListBuffer[Crime] = ListBuffer()
    val bufferedSource = Source.fromFile(path)

    for (line <- bufferedSource.getLines.drop(1)) {
      val cols: List[String] = line.split(",").map(_.trim).toList

      if (cols(0) != "" & cols(4) != "" & cols(5) != "" & cols(9) != "") {
        val loc: Location = new Location(cols(4).toDouble, cols(5).toDouble)
        val crime: Crime = new Crime(cols(0), loc, cols(9))
        crimesList += crime
        //println(crime.toString)
      }
    }
    bufferedSource.close
    crimesList
  }


  def mapLocationToCrimes(crimes: Seq[Crime]): Map[Location, Tuple2[Int, ListBuffer[Crime]]] = {
    var map: Map[Location, Tuple2[Int, ListBuffer[Crime]]] = Map()
    val locations = crimes.map(_.location).toSet
    locations.foreach(l => {
      val crimesInLocation: ListBuffer[Crime] = ListBuffer()
      crimes.foreach(
        c => if (c.location.equals(l)) {
            //println(c.location.equals(l) + "  " + crimesInLocation)
            crimesInLocation += c
          })
      //println("crimesInLocation " + crimesInLocation)
      map+=(l -> (crimesInLocation.size, crimesInLocation))
    })
    //println("map " + map)
    map
  }


}
