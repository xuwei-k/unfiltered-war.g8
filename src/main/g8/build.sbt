organization := "com.example"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

libraryDependencies ++= Seq(
  "ws.unfiltered" %% "unfiltered-filter" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-specs2" % "$unfiltered_version$",
  "javax.servlet" % "servlet-api" % "2.3" % "provided",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container"
)

enablePlugins(JettyPlugin)
