package com.pawclone.webapp.UIElements

import org.scalajs.jquery._
import scalatags.JsDom.all._

object QueryParams {
  val numParamInputs = 3

  val tag = div(
    tr(
      td(
        "parameter"
      ),
      td(
        "value"
      )
    ), (1 to numParamInputs).map { i =>
      tr(
        td(
          input(id := s"parameter-$i")
        ), td(
          input(id := s"value-$i")
        )
      )
    }
  )

  def appendQueryParams(url: String): String = {
    (1 to QueryParams.numParamInputs).foldLeft(s"$url?") { (str, int) =>
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