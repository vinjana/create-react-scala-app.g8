enablePlugins(ScalaJSBundlerPlugin)

name := "$name$"

scalaVersion := "2.13.8"

scalacOptions += "-Ymacro-annotations"

// Core and built-system libraries
Compile / npmDependencies += "react" -> "16.14.0"
Compile / npmDependencies += "react-dom" -> "16.14.0"
Compile / npmDependencies += "react-proxy" -> "1.1.8"

Compile / npmDevDependencies += "style-loader" -> "3.3.1"
Compile / npmDevDependencies += "css-loader" -> "6.7.1"
Compile / npmDevDependencies += "html-webpack-plugin" -> "5.5.0"
Compile / npmDevDependencies += "copy-webpack-plugin" -> "11.0.0"
Compile / npmDevDependencies += "webpack-merge" -> "5.8.0"

libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.7.2"
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.7.2"

webpack / version := "5.74.0"
webpackCliVersion := "4.10.0"
startWebpackDevServer / version := "4.11.1"

webpackResources := baseDirectory.value / "webpack" * "*"

fastOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
fullOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")
Test / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-core.config.js")

fastOptJS / webpackDevServerExtraArgs := Seq("--hot")
fastOptJS / webpackBundlingMode := BundlingMode.LibraryOnly()

Test / requireJsDomEnv := true

addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")

addCommandAlias("build", "fullOptJS::webpack")


// Application libraries
libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.14" % Test
