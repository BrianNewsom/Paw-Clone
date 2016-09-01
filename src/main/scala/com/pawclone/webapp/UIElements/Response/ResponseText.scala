package com.pawclone.webapp.UIElements.Response

import com.facade.jsoneditor.JSONEditor
import com.pawclone.webapp.UIElements.UIComponent
import org.scalajs.dom._
import scala.scalajs.js.JSON
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._

object ResponseText extends UIComponent {
  override val elementId: String = "response-text"

  // Full tag of component, to be redrawn if changed
  override def tag: TypedTag[Element] = {
    div(
      id := elementId
    )
  }

  def render(completedRequest: XMLHttpRequest) = {
    if (completedRequest.getResponseHeader("Content-Type").contains("application/json")){
      selector.empty()
      val jsonEditor = new JSONEditor(document.getElementById(elementId), JSON.parse("{\"mode\": \"view\"}"))
      jsonEditor.set(JSON.parse(completedRequest.responseText))
      jsonEditor.collapseAll()
    } else {
      selector.text(completedRequest.responseText)
    }
  }
}