package com.pawclone.webapp.UIElements.Request

import com.pawclone.webapp.UIElements.UIComponent
import org.scalajs.dom.html.Div
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._

object Authorization extends UIComponent {
  override val elementId: String = "request-auth"

  val oauthVersion = "1.0"
  val oauthSignatureMetho = "HMAC-SHA1"

  def tag: TypedTag[Div] = div(
    `class` := "form-group",
    `id` := elementId,
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

  def nonce: String = {
    timestamp + "a"
  }

  def timestamp: String = {
    java.time.Instant.now.toEpochMilli.toString
  }
}