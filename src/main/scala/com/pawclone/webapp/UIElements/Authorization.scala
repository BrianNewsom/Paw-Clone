package com.pawclone.webapp.UIElements

import scalatags.JsDom.all._

object Authorization {
  val tag = div(
    h5("OAuth"),
    div(
      "Consumer Key: ",
      input(
        id := "oauth-consumer-key"
      )
    ),
    div(
      "Consumer Secret: ",
      input(
        id := "oauth-consumer-secret"
      )
    ),
    div(
      "User Token: ",
      input(
        id := "oauth-user-token"
      )
    ),
    div(
      "User Token Secret: ",
      input(
        id := "oauth-user-token-secret"
      )
    )
  )

  val requestHeader = {
    // TODO: Make this work
    Map("Authorization" -> "None")
  }
}