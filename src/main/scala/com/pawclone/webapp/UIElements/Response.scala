package com.pawclone.webapp.UIElements

import org.scalajs.dom._
import org.scalajs.jquery._
import scalatags.JsDom.all._

object Response{
  private val elementId = "responseText"
  def tag = div(
    div(
      textAlign := "center",
      h3(
        id := "responseStatus",
        "Response Code: "
      )
    ),
    div(
      h4("Headers"),
      textarea(
        `class` := "form-control",
        id := "responseHeaders",
        disabled := true,
        rows := 5
      )
    ),
    div(
      h4("Reponse Text"),

      textarea(
        `class` := "form-control",
        id := elementId,
        disabled := true,
        rows := 10
      )
    )
  )
}

case class Response(completedRequest: XMLHttpRequest){
  def render() = {
    jQuery("#responseStatus").text("Response Code: " + completedRequest.status.toString)
    jQuery("#responseHeaders").text(completedRequest.getAllResponseHeaders)
    jQuery(s"#${Response.elementId}").text(completedRequest.responseText.toString)
  }
}