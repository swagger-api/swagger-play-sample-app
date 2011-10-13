package controllers

import play.mvc.Controller
import javax.xml.bind.JAXBContext
import scala.Predef._
import com.wordnik.swagger.sample.model._
import java.io.StringWriter

/**
  * @author ayush
  * @since 10/13/11 9:56 PM
  *
  */
class ApiController extends Controller {
  private val jaxbContext = JAXBContext.newInstance(classOf[Order], classOf[Category], classOf[Order], classOf[Pet], classOf[Tag], classOf[User])

  protected def returnXml = request.path.contains(".xml")

  protected def marshallToXml(o: Any) = {
    val stringWriter = new StringWriter()
    jaxbContext.createMarshaller().marshal(o, stringWriter)
    stringWriter.toString
  }
}