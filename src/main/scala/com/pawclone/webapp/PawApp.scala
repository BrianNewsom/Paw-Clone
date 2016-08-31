package com.pawclone.webapp

import com.pawclone.webapp.UIElements.{Response, _}
import org.scalajs.dom.XMLHttpRequest
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.html.Div
import org.scalajs.jquery._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.scalajs.js.JSApp
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._


object PawApp extends JSApp {
  def main(): Unit = {
    MainUIComponent.render
  }
}

object MainUIComponent extends UIComponent {
  override val elementId = "main-element"

  def tag: TypedTag[Div] = div(
    `class` := "container",
    `id` := elementId,
    div(
      `class` := "col-md-6",
      h3("Request"),
      MethodSelect.tag,
      div(
        `class` := "form-group",
        label(
          `for` := "query-url",
          "Url: "
        ),
        input(
          `class` := "form-control",
          id := "query-url",
          `type`    := "text",
          value := "http://www.outloud.io:8080/api/feed"
        )
      ),
      //  Authorization.tag,
      br(),
      QueryParams.tag,
      button(
        `class` := "btn btn-default col-md-offset-4 col-md-4",
        id := "submit-query-btn",
        onclick := { () =>
          AjaxFactory(MethodSelect.selected).map { completedRequest =>
            Response.Response.render(completedRequest)
          }
        },
        "Send Request!"
      )
    ), div(
      `class` := "col-md-6",
      h3("Response"),
      Response.Response.tag
    )
  )

  def render = {
    jQuery("body").append(tag.render)
  }
}

object AjaxFactory {
  def apply(method: HttpMethod): Future[XMLHttpRequest] = {
    val finalUrl = QueryParams.appendQueryParams(jQuery("#query-url").value.toString)
    method match {
      case GetMethod =>
        Ajax.get(
          finalUrl,
          headers = Authorization.requestHeader
        )
      case PostMethod =>
        Ajax.post(
          finalUrl,
          headers = Authorization.requestHeader
        )
      case _ =>
        throw new Exception("This method is not currently supported")
    }

  }
}