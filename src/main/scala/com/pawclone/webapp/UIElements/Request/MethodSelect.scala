package com.pawclone.webapp.UIElements.Request

import com.pawclone.webapp.UIElements.UIComponent
import org.scalajs.dom.html._
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._

object MethodSelect extends UIComponent {
  val elementId = "query-method"

  def tag: TypedTag[Select] =
    select(
      `class` := "form-control",
      id := elementId,
      GetMethod.tag,
      PostMethod.tag
    )

  def selected: HttpMethod = {
    selector.find(":selected").text.toString match {
      case PostMethod.selectText =>
        PostMethod
      case GetMethod.selectText =>
        GetMethod
      case _ =>
        throw new Exception("Unsupported method chosen")
    }
  }
}

object PostMethod extends HttpMethod {
  override val selectValue = "POST"
  override val selectText = "POST"
}

object GetMethod extends HttpMethod {
  override val selectValue = "GET"
  override val selectText = "GET"
}

trait HttpMethod {
  val selectValue: String
  val selectText: String

  def tag = option(
    value := selectValue,
    selectText
  )
}