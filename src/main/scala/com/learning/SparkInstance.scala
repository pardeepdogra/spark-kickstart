package com.learning

import com.learning.helper.DataFrameHelper
import org.apache.spark.SparkContext
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{SQLContext, SparkSession}

package object SparkInstance {

  implicit lazy val session: SparkSession = SparkSession.builder()
    .master("local[*]")
    .config("spark.sql.autoBroadcastJoinThreshold", "100000")
    .enableHiveSupport()
    .getOrCreate()
  implicit lazy val sparkContext: SparkContext = session.sparkContext
  implicit lazy val sqlContext: SQLContext = session.sqlContext

  implicit lazy val upper = udf(DataFrameHelper.toUpper)
}
