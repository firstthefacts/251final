import org.apache.spark._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession

//
// first get the json data from an api call to the mongoDB
//

object Main extends App{

  // create SparkConf
  
  // val conf = new SparkConf().setAppName("honey-pot").setMaster("spark1")
  val conf = new SparkConf().setAppName("honey-pot")
  
  val sc = new SparkContext(conf)

  val sqlContext = new SQLContext(sc)
  import sqlContext.implicits._
  val spark =sqlContext.sparkSession

  val rawDF = spark.read.json(sc.wholeTextFiles("data_file/small_session.json").values)

  val flatDF=rawDF.select($"_id.*",$"destination_port",$"honeypot",$"hpfeed_id.*",$"identifier",$"protocol",$"source_ip",$"source_port",$"timestamp.*")

  val renamedFlatDF =  flatDF.toDF("oid","destination_port","honeypot","hpfeed_oid","identifier","protocol","source_ip","source_port","date")

}


