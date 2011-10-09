package controllers

import play.mvc.Controller
import views.Application.html

/**
  * @author ayush
  * @since 10/7/11 10:20 PM
  *
  */
object Application extends Controller {
  def index = {
    Redirect("/swagger-ui/")
  }
}
