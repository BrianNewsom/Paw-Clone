package com.pawclone.webapp.UIElements.Response

import com.pawclone.webapp.UIElements.UIComponent
import org.scalajs.dom._
import org.scalajs.jquery._
import scala.scalajs.js
import scala.scalajs.js.JSON
import scalatags.JsDom.all._

object Response extends UIComponent {
  override val elementId = "response"

  val responseStatusElementId = "response-status"
  val responseTextElementId = "response-text"

  def tag = div(
    div(
      textAlign := "center",
      h3(
        id := responseStatusElementId,
        "Response Code: "
      )
    ),
    ResponseHeaders.tag,
    div(
      id := responseTextElementId
    )
  )

  def render(completedRequest: XMLHttpRequest) = {
    jQuery(s"#$responseStatusElementId").text("Response Code: " + completedRequest.status.toString)
    ResponseHeaders.render(ResponseHeaders.tag(Some(completedRequest.getAllResponseHeaders)))

    if (completedRequest.getResponseHeader("Content-Type") == "application/json"){
      val jsonEditor = new JSONEditor(document.getElementById(responseTextElementId), js.Object())
      jsonEditor.set(JSON.parse(completedRequest.responseText))
    } else {
      jQuery(s"#$responseTextElementId").text(completedRequest.responseText)
    }

  }
}

@js.native
class JSONEditor extends js.Object {
  def this(div: js.Any, obj: js.Object) = this()

  def set(jsonObject: js.Any): Nothing = js.native
}