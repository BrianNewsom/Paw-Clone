package com.pawclone.webapp.UIElements.Response

import com.pawclone.webapp.UIElements.UIComponent
import org.scalajs.dom._
import org.scalajs.jquery._
import scalatags.JsDom.all._

object Response extends UIComponent {
  override val elementId = "response"

  val responseStatusElementId = "response-status"

  def tag = div(
    `id` := elementId,
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

object FailedResponse extends UIComponent {
  override val elementId = "response"
  val responseStatusElementId = "response-status"

  def tag = div(
    `id` := elementId,
    div(
      textAlign := "center",
      h3(
        id := responseStatusElementId,
        "Response Code: 404"
      )
    ),
    ResponseHeaders.tag,
    ResponseText.tag
  )
}