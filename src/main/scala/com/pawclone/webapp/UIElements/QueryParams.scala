package com.pawclone.webapp.UIElements

import org.scalajs.jquery._
import scalatags.JsDom.all._

object QueryParams extends UIComponent {
  val elementId = "request-params"

  var numParamInputs = 1

  def  additionalElement(intId: Int) =
    tr(
      td(
        input(
          `class` := "form-control",
          id := s"parameter-$intId"
        )
      ), td(
        input(
          `class` := "form-control",
          id := s"value-$intId"
        )
      )
    )

  val plusButton = Seq(
    // TODO: css to the side
    button(
      span(
        `class` := "glyphicon glyphicon-plus"
      ),
      onclick := { () =>
        numParamInputs = numParamInputs + 1
        jQuery(s"#$elementId").append(additionalElement(numParamInputs).render)
      }
    )
  )

  def tag = div(
    `class` := "col-md-8 col-md-offset-2",
    id := elementId,
    tr(
      td(
        h5("Parameter")
      ),
      td(
        h5("Value")
      )
    ),
    plusButton,
    additionalElement(numParamInputs)
  )

  def appendQueryParams(url: String): String = {
    (1 to numParamInputs).foldLeft(s"$url?") { (str, int) =>
      val param = jQuery(s"#parameter-$int").value.toString
      val value = jQuery(s"#value-$int").value.toString
      if (param == "" || value == "") {
        str
      } else {
        // TODO: Fix trailing &
        str + param + "=" + value + "&"
      }
    }
  }
}