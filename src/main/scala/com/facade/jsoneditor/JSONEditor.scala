package com.facade.jsoneditor

import scala.scalajs.js

@js.native
class JSONEditor extends js.Object {
  def this(div: js.Any, obj: js.Any) = this()

  def set(jsonObject: js.Any): js.Any = js.native

  def get(): js.Object = js.native

  def collapseAll(): js.Any = js.native

  def destroy(): js.Any = js.native

  def expandAll(): js.Any = js.native

  def focus(): js.Any = js.native

  def setMode(mode: String): js.Any = js.native

  def setName(name: String): js.Any = js.native

  def setSchema(schema: js.Any): js.Any = js.native

  def setText(jsonString: String): js.Any = js.native

  def getMode(): js.Any = js.native

  def getName(): js.Any = js.native

  def getText(): js.Any = js.native
}