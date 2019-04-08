class Crime(val crimeId: String, val location: Location, val crimeType: String) {

  override def toString: String = {
    return "%s %s %s".format(crimeId, location, crimeType)
  }
}
