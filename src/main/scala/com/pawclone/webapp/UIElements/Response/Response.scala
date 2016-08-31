package com.pawclone.webapp.UIElements.Response

import com.pawclone.webapp.UIElements.UIComponent
import org.scalajs.dom._
import org.scalajs.jquery._
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
    ResponseText.tag

  )

  def render(completedRequest: XMLHttpRequest) = {
    jQuery(s"#$responseStatusElementId").text("Response Code: " + completedRequest.status.toString)
    ResponseHeaders.render(ResponseHeaders.tag(Some(completedRequest.getAllResponseHeaders)))
    ResponseText.render(completedRequest)
  }
}

