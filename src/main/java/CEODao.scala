import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, _}

object CEODao {
  val ceos = List(
    CEO("1", "Mark", "Zuckerberg"),
    CEO("2", "Sundar", "Pichai")
  )

  def byId(id: String): Future[Option[CEO]] = Future {
    ceos.find(_.id == id)
  }
}
