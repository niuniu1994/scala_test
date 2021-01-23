/**
  * This is basic language questions so don't use external library or build in function
  */
object BasicScala {


  /**
    * Encode parameter in url format
    *
    * Example:
    *
    * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
    * output : "?sort_by=name&order_by=asc&user_id=12"
    *
    * input  : Map()
    * output : ""
    */
  def encodeParamsInUrl(params: Map[String, String]): String = {

    if (params == null && params.isEmpty){
      return "";
    }

    val buf = new StringBuilder()
    buf.append("?")
    params foreach{
      case (k,v) =>
        buf.append(k)
        buf.append("=")
        buf.append(v)
        buf.append("&")
    }
    buf.delete(buf.length() - 1,buf.length())
    buf.toString
  }


  /**
    * Test if a String is an email
    */
  def isEmail(maybeEmail: String): Boolean = maybeEmail.matches("^[A-Za-z0-9]+([_\\.][A-Za-z0-9]+)*@([A-Za-z0-9\\-]+\\.)+[A-Za-z]{2,6}$")



  /**
    * Compute i ^ n
    *
    * Example:
    *
    * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
    * output : 8
    *
    * input : (i = 99, n = 38997)
    * output : 1723793299
    */
  def power(i:Int, n:Int):Int = {
    if (n <= 0) return 0
    var res: Int = 1;
    0 until n foreach(_ => res *= i)
    res
  }

}
