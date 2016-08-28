package com.pawclone.webapp.UIElements

import org.scalajs.dom.html.Div
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._

object Authorization {
  def tag: TypedTag[Div] = div(
    `class` := "form-group",
    h5("OAuth"),
    div(
      label(
        `for` := "oauth-consumer-key",
        "Consumer Key: "
      ),
      input(
        `class` := "form-control",
        id := "oauth-consumer-key"
      )
    ),
    div(
      label(
        `for` := "oauth-consumer-secret",
        "Consumer Secret: "
      ),
      input(
        `class` := "form-control",
        id := "oauth-consumer-secret"
      )
    ),
    div(
      label(
        `for` := "oauth-user-token",
        "User Token: "
      ),
      input(
        `class` := "form-control",
        id := "oauth-user-token"
      )
    ),
    div(
      label(
        `for` := "oauth-user-token-secret",
        "User Token Secret: "
      ),
      input(
        `class` := "form-control",
        id := "oauth-user-token-secret"
      )
    )
  )

  val requestHeader = {
    // TODO: Make this work
    Map("Authorization" -> "None")
  }
}