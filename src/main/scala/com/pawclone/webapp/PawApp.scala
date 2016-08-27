package com.pawclone.webapp

import com.pawclone.webapp.UIElements.{Authorization, QueryParams, Response}
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.html.{Div, Select}
import org.scalajs.jquery._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._

object PawApp extends JSApp {
  val currentValue = 6
  val selectMethod: TypedTag[Select] =
    select(
      id := "query-method",
      option(
        value := "GET",
        "GET"
      ),option(
        value := "POST",
        "POST"
      )
    )
  val mainElement: TypedTag[Div] = div(
    selectMethod,
    input(
      id := "query-url",
      `type`    := "text"
    ),
    Authorization.tag,
    br(),
    QueryParams.tag,
    button(
      id := "submit-query-btn",
      onclick := { () =>
        val url = jQuery("#query-url").value.toString
        Ajax.get(
          QueryParams.appendQueryParams(url),
          headers = Authorization.requestHeader
        ).map { completedRequest =>
          Response(completedRequest).render()
        }
      },
      "Submit!"
    ),
    Response.tag
  )

  def setupUI(): Unit = {
    jQuery("body").append(mainElement.render)
  }

  def main(): Unit = {
    jQuery(setupUI _)
  }
}