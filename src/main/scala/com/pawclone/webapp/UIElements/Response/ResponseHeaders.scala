package com.pawclone.webapp.UIElements.Response

import com.pawclone.webapp.UIElements.UIComponent
import scalatags.JsDom.all._

object ResponseHeaders extends UIComponent{
  override val elementId = "response-headers"

  def tag = {
    tag(None)
  }

  def tag(responseHeadersOpt: Option[String] = None) = {

    val headerMap = responseHeadersOpt.map { responseHeaders =>
      responseHeaders.split("\n").map { line =>
        val split = line.split(":")
        split(0) -> split(1).stripPrefix(" ")
      }
    } getOrElse {
      Array.empty
    }

    div(
      `id` := elementId,
      h4("Headers"),
      table(
        `class` := "table table-bordered table-striped",
        thead(
          tr(
            td(
              "Header"
            ), td(
              "Value"
            )
          )
        ), tbody(
          headerMap.map {
            case (headerName: String, valueName: String) =>
              tr(
                td(
                  headerName
                ), td(
                  valueName
                )
              )
          }
        )
      )
    )
  }
}
