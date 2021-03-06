import com.typesafe.sbt.SbtStartScript
import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys._

val page = project.in(file("page"))

val client = project.in(file("client")).dependsOn(page)

val server = project.in(file("server"))

SbtStartScript.stage in Compile := Unit

(crossTarget in (client, Compile, optimizeJS)) := (classDirectory in (server, Compile)).value

(crossTarget in (client, Compile, preoptimizeJS)) := (classDirectory in (server, Compile)).value

(crossTarget in (page, Compile, packageBin)) := (classDirectory in (server, Compile)).value

(crossTarget in (page, Compile, optimizeJS)) := (classDirectory in (server, Compile)).value

scalaVersion := "2.10.3"