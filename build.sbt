name := "scala-cfg"

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.12.4", "2.11.11")

version := sys.props.getOrElse("tag", default = "0.0.0")

organization := "com.github.rehei"

resolvers += "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "staging" at "https://oss.sonatype.org/content/repositories/staging"
resolvers += "releases" at "https://oss.sonatype.org/content/repositories/releases"
resolvers += Resolver.bintrayRepo("rehei", "maven")


licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

libraryDependencies ++= {
  Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value
  )
}

EclipseKeys.withSource := true

