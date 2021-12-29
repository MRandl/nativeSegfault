val usingScalaVersion = "3.1.0"

resolvers += Resolver.sonatypeRepo("snapshots")

import scala.scalanative.build._
nativeConfig ~= {
  _.withMode(Mode.debug) //replace 'debug' with 'releaseFull' when ready (longer compile time)
    .withLTO(LTO.none)   //replace 'none' with 'thin' when ready (longer linking time). never use 'full', it's deprecated
    .withGC(GC.commix) 
}

lazy val hello = (project in file("."))
  .enablePlugins(ScalaNativePlugin)
  .settings(
    name := "Hello",
    scalaVersion := usingScalaVersion
  )
