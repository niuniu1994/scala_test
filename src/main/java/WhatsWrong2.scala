import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case  class CeoEnterpriseDto(ceo:Option[CEO], enterprise:Option[Enterprise])

object EnterpriseDao {
  val enterprises = List(
    Enterprise("1", "Google", "1"),
    Enterprise("2", "Facebook", "2")
  )

  def byId(id: String): Future[Option[Enterprise]] = Future { enterprises.find(_.id == id) }
  def byCEOId(ceo_id: String): Future[Option[Enterprise]] = Future { enterprises.find(_.ceo_id == ceo_id) }
}

object WhatsWrong2 {
  //Review this code. What could be done better ? How would you do it ?
  //it seems good to me but I prefer return a DTO because it can contain more info and easy to use than a tuple
  def getCEOAndEnterprise(ceo_id: Option[String]): Future[CeoEnterpriseDto] = {
    for {
      ceo <- CEODao.byId(ceo_id.get)
      enterprise <- EnterpriseDao.byCEOId(ceo_id.get)
    } yield {
      CeoEnterpriseDto(ceo,enterprise)
    }
  }
}
