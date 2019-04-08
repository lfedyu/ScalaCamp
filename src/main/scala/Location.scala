class Location(val longitude: Double, val latitude: Double) {

  override def toString: String =
    return longitude + " " + latitude

  def canEqual(other: Any): Boolean = other.isInstanceOf[Location]

  override def equals(other: Any): Boolean = other match {
    case that: Location =>
      (that canEqual this) &&
        longitude == that.longitude &&
        latitude == that.latitude
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(longitude, latitude)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
