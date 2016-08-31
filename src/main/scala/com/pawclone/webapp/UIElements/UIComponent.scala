package com.pawclone.webapp.UIElements

import org.scalajs.dom
import org.scalajs.jquery.jQuery
import scalatags.JsDom.TypedTag

trait UIComponent {
  val elementId: String
  // Full tag of component, to be redrawn if changed
  def tag: TypedTag[dom.Element]

  def selector = {
    jQuery(s"#$elementId")
  }

  def render(element: TypedTag[dom.Element] = tag) = {
    selector.replaceWith(element.render)
  }
}
