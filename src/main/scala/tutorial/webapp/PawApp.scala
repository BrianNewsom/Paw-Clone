package tutorial.webapp

import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.html.{Div, Select}
import org.scalajs.jquery.jQuery
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._

object PawApp extends JSApp {
  val currentValue = 6
  val numParamInputs = 3

  val queryParams = div(
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
    queryParams,
    button(
      id := "submit-query-btn",
      onclick := { () =>
        val url = jQuery("#query-url").value.toString
        val withParams = (1 to numParamInputs).foldLeft(s"$url?") { (str, int) =>
          val param =  jQuery(s"#parameter-$int").value.toString
          val value = jQuery(s"#value-$int").value.toString
          if (param == "" || value == "") {
            str
          } else {
            // TODO: Fix trailing &
            str + param + "=" + value + "&"
          }
        }
        Ajax.get(withParams).map { response =>
          jQuery("#response").text(response.responseText.toString)
        }
      },
      "Submit!"
    ),
    responseTag()
  )

  def responseTag() = div(
    textarea(
      id := "response",
      rows := 20,
      cols := 100
    )
  )

  def setupUI(): Unit = {
    jQuery("body").append(mainElement.render)
  }

  def main(): Unit = {
    jQuery(setupUI _)
  }
}