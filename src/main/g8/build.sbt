organization := "com.example"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

val unusedWarnings = (
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

val unfilteredVersion = "$unfiltered_version$"

libraryDependencies ++= Seq(
  "ws.unfiltered" %% "unfiltered-filter" % unfilteredVersion,
  "ws.unfiltered" %% "unfiltered-specs2" % unfilteredVersion,
  "javax.servlet" % "servlet-api" % "2.3" % "provided",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container"
)

enablePlugins(JettyPlugin)
