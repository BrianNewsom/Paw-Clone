name := "paw-clone"
enablePlugins(ScalaJSPlugin)

version := "1.0"
scalaVersion := "2.11.8"

scalaJSUseRhino in Global := false

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.0"

skip in packageJSDependencies := false
jsDependencies +=
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"


persistLauncher in Compile := true
persistLauncher in Test := false

libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.0"
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.0"
libraryDependencies += "org.scalaj" % "scalaj-http_2.11" % "2.3.0"
libraryDependencies += "org.scala-js" %%% "scalajs-java-time" % "0.2.0"