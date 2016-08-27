package com.pawclone.webapp.UIElements

import org.scalajs.dom._
import org.scalajs.jquery._
import scalatags.JsDom.all._

object Response{
  private val elementId = "responseText"
  val tag = div(
    h1(
      id := "responseStatus"
    ),
    textarea(
      id := "responseHeaders",
      rows := 10,
      cols := 100
    ),
    textarea(
      id := elementId,
      rows := 20,
      cols := 100
    )
  )
}

case class Response(completedRequest: XMLHttpRequest){
  def render() = {
    jQuery("#responseStatus").text(completedRequest.status.toString)
    jQuery("#responseHeaders").text(completedRequest.getAllResponseHeaders)
    jQuery(s"#${Response.elementId}").text(completedRequest.responseText.toString)
  }
}