package controllers

import play.mvc.Controller
import com.wordnik.swagger.sample.resource.JavaRestResourceUtil
import com.wordnik.swagger.sample.data.UserData
import com.wordnik.swagger.core._
import com.wordnik.swagger.sample.model.User

/**
  * @author ayush
  * @since 10/9/11 10:43 PM
  *
  */

@Api(value = "/user", description = "Operations about user")
object UserController extends ApiController {
  private val userData = new UserData
  private val ru = new JavaRestResourceUtil

  @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.")
  def createUser(@ApiParam(value = "Created user object", required = true) user: User) = {
    userData.addUser(user)
    Ok
  }

  @ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid user supplied"), new ApiError(code = 404, reason = "User not found")))
  def updateUser(@ApiParam(value = "name that need to be deleted", required = true) username: String, @ApiParam(value = "Updated user object", required = true) user: User) = {
    userData.addUser(user)
    Ok
  }

  @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid username supplied"), new ApiError(code = 404, reason = "User not found")))
  def deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) username: String) = {
    userData.removeUser(username)
    Ok
  }

  @ApiOperation(value = "Get user by user name", responseClass = "com.wordnik.swagger.sample.model.User")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid username supplied"), new ApiError(code = 404, reason = "User not found")))
  def getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) username: String) = {
    val user: User = userData.findUserByName(username)
    if (null != user) {
      if (returnXml) Xml(marshallToXml(user)) else Json(user)
    } else {
      NotFound
    }
  }

  @ApiOperation(value = "Logs user into the system", responseClass = "String")
  @ApiErrors(value = Array(new ApiError(code = 400, reason = "Invalid username/password supplied")))
  def loginUser(@ApiParam(value = "The user name for login", required = true) username: String, @ApiParam(value = "The password for login in clear text", required = true) password: String) = {
    var o = "logged in user session:" + System.currentTimeMillis
    if (returnXml) Xml(marshallToXml(o)) else Json(o)
  }

  @ApiOperation(value = "Logs out current logged in user session")
  def logoutUser = {
    Ok
  }
}