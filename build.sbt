val usingScalaVersion = "3.1.0"

import scala.scalanative.build._
nativeConfig ~= {
  _.withMode(Mode.debug)
    .withLTO(LTO.none) 
    .withGC(GC.commix) 
}

lazy val hello = (project in file("."))
  .enablePlugins(ScalaNativePlugin)
  .settings(
    name := "Hello",
    scalaVersion := usingScalaVersion
  )
