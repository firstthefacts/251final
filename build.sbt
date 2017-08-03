lazy val root = (project in file(".")).
  settings(
    name := "final",
    version := "1.0",
    scalaVersion := "2.11.8"
    //mainClass in Compile := Some("final.main")        
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0",
)

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

// META-INF discarding
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}
