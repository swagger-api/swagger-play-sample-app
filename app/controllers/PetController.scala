package controllers

import play.mvc._
import com.wordnik.swagger.core._
import com.wordnik.swagger.sample.data.PetData
import com.wordnik.swagger.sample.resource.JavaRestResourceUtil
import com.wordnik.swagger.sample.model.Pet
import scala.Predef._

@Api(value = "/pet", description = "Operations about pets")
object PetController extends ApiController {

  private val petData = new PetData
  private val ru = new JavaRestResourceUtil

  @ApiOperation(value = "Find pet by ID", notes = "Returns a pet when ID < 10. " + "ID > 10 or nonintegers will simulate API error conditions", responseClass = "com.wordnik.swagger.sample.model.Pet")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid ID supplied"), new ApiError(code = 404, reason = "Pet not found")))
  def getPetById(@ApiParam(value = "ID of pet that needs to be fetched", required = true) petId: String) = {
    var pet: Pet = petData.getPetbyId(ru.getLong(0, 100000, 0, petId))
    if (null != pet) {
      if (returnXml) Xml(marshallToXml(pet)) else Json(pet)
    } else {
      NotFound("Pet not found for " + petId)
    }
  }

  @ApiOperation(value = "Add a new pet to the store")
  @ApiErrors(value = Array(new ApiError(code = 405, reason = "Invalid input")))
  def addPet(@ApiParam(value = "Pet object that needs to be added to the store", required = true) pet: Pet) = {
    petData.addPet(pet)
    Ok
  }

  @ApiOperation(value = "Update an existing pet")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid ID supplied"), new ApiError(code = 404, reason = "Pet not found"), new ApiError(code = 405, reason = "Validation exception")))
  def updatePet(@ApiParam(value = "Pet object that needs to be added to the store", required = true) pet: Pet) = {
    petData.addPet(pet)
    Ok
  }

  @ApiOperation(value = "Finds Pets by status", notes = "Multiple status values can be provided with comma seperated strings", responseClass = "com.wordnik.swagger.sample.model.Pet", multiValueResponse = true)
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid status value")))
  def findPetsByStatus(@ApiParam(value = "Status values that need to be considered for filter", required = true, defaultValue = "available", allowableValues = "available,pending,sold", allowMultiple = true) status: String) = {
    val o = petData.findPetByStatus(status)
    if (returnXml) Xml(marshallToXml(o)) else Json(o)
  }

  @ApiOperation(value = "Finds Pets by tags", notes = "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.", responseClass = "com.wordnik.swagger.sample.model.Pet", multiValueResponse = true)
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid tag value")))
  @Deprecated
  def findPetsByTags(@ApiParam(value = "Tags to filter by", required = true, allowMultiple = true) tags: String) = {
    val o = petData.findPetByTags(tags)
    if (returnXml) Xml(marshallToXml(o)) else Json(o)
  }

}
