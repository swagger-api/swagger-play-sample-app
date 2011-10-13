package controllers

import com.wordnik.swagger.sample.resource.JavaRestResourceUtil
import com.wordnik.swagger.core._
import com.wordnik.swagger.sample.model.Order
import com.wordnik.swagger.sample.data.StoreData
import play.mvc.results._
import scala.Predef._

/**
  * @author ayush
  * @since 10/9/11 10:29 PM
  *
  */
@Api(value = "/store", description = "Operations about store")
object PetStoreController extends ApiController {

  private val storeData = new StoreData
  private val ru = new JavaRestResourceUtil

  @ApiOperation(value = "Find purchase order by ID", notes = "For valid response try integer IDs with value <= 5. " + "Anything above 5 or nonintegers will generate API errors", responseClass = "com.wordnik.swagger.sample.model.Order")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid ID supplied"), new ApiError(code = 404, reason = "Order not found")))
  def getOrderById(@ApiParam(value = "ID of pet that needs to be fetched", required = true) orderId: String) = {
    val order: Order = storeData.findOrderById(ru.getLong(0, 10000, 0, orderId))
    if (null != order) {
      if (returnXml) Xml(marshallToXml(order)) else Json(order)
    } else {
      NotFound
    }
  }

  @ApiOperation(value = "Place an order for a pet", responseClass = "com.wordnik.swagger.sample.model.Order")
  @ApiErrors(Array(new ApiError(code = 400, reason = "Invalid Order")))
  def placeOrder(@ApiParam(value = "order placed for purchasing the pet", required = true) order: Order) = {
    storeData.placeOrder(order)
    Ok
  }

  @ApiOperation(value = "Delete purchase order by ID", notes = "For valid response try integer IDs with value < 1000. " + "Anything above 1000 or nonintegers will generate API errors")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid ID supplied"), new ApiError(code = 404, reason = "Order not found")))
  def deleteOrder(@ApiParam(value = "ID of the order that needs to be deleted", required = true) orderId: String) = {
    storeData.deleteOrder(ru.getLong(0, 10000, 0, orderId))
    Ok
  }

}
