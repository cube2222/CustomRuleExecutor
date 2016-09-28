import org.apache.spark.sql.{SparkSession, _}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution._

/**
  * Created by jakub on 28.09.2016.
  */
object MyModule {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").getOrCreate()

    //spark.range(5).write.saveAsTable("five")

    spark.experimental.extraStrategies = Seq(MyStrategy)


    val query = spark.catalog.listTables.filter(x => x.name == "five")
    query.explain(true)

  }
}
object MyStrategy extends Strategy {
  def apply(plan: LogicalPlan): Seq[SparkPlan] = {
      println("Hello world!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
      Nil
  }
}
