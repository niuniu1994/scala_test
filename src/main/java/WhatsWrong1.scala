object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {
    override val city = "Paris"
    override val support: String = s"Ici c'est $city !"
  }

  Supporter.city //What does this print ?
//  //response : Paris
  Supporter.support //What does this print and why ? How to fix it ?
  /**
    * I just started to learn scala when I received this test, so I am sorry for that I can't explain the reason using Scala way
    *
    * I will explain the reason according to the decompiled java code from this class
    *
    * 1, to print Supported.support  it will call
    *  .MODULE$.println(WhatsWrong1.Supporter$.MODULE$.support());
    *  so it's method support() in supporter
    *
    *2, And I found out the result of support() is decided by another method  $this.com$particeep$test$WhatsWrong1$Interface$_setter_$support_$eq((new StringBuilder(12)).append("Ici c'est ").append($this.city).append(" !").toString)
    *  which is in interface , and I called it the goal method
    *
    * 3, Actually, the goal method will be called during the class loading period of supporter , because it was putting in a static block.
    *
    * static {
         WhatsWrong1.Interface.$init$(MODULE$);// this one will init the interface
         Product.$init$(MODULE$);
         city = "Paris";
      }
    *
    * 4,!!!!!!!!!  So obviously the value of support is result of "new StringBuilder(12)).append("Ici c'est ").append($this.city).append(" !").toString" and $this.city is always null in the interface
    */

}
