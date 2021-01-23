import scala.collection.mutable._

/**
  * Tell developer names by the department code
  * Expected result:
  * Map(frontend -> List(Remy, Alexandre), analytics -> List(Pierre), api -> List(Noe))
  */
object MapYourMap {

  val devNames = Map("dev1" -> "Pierre", "dev2" -> "Remy", "dev3" -> "Noe", "dev4" -> "Alexandre")
  val devDepartments = Map("dev1" -> "analytics", "dev2" -> "frontend", "dev3" -> "api", "dev4" -> "frontend")

  val namesInDepartments: Unit = {
    val group = devDepartments.groupMap { case (x, y) => y } { case (x, y) => x }
    var res: Map[String, List[String]] = Map()
    group.keys.foreach(key => {
      var list = ListBuffer[String]()
      val devs = devNames.keys.filter(a => group(key).toList.contains(a)).foreach(list += devNames(_))
      res(key) = list.toList
    }
    )
    print(res)
  }

}

//Map[String, List[String]]