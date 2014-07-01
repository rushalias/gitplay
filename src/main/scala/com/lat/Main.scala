package com.lat

import scalaz._
import org.slf4j._

/* Memoization, douchebag way of saying caching */
/* Description	Resource	Path	Location	Type
scalaz-core_2.10-7.0.6.jar is cross-compiled with an incompatible version of Scala (2.10). 
In case of errorneous report, 
this check can be disabled in the compiler preference page.	

ScalaZ		Unknown	Scala Classpath Problem
 *  
 */
object Main {

  val LOG = LoggerFactory.getLogger(getClass.getName)

  def expensive(sleepTime: Long): Int = {
    Thread.sleep(sleepTime)
    42
  }

  val memo = Memo.immutableHashMapMemo {
    sleepTime: Long => expensive(sleepTime)
  }


  def main (args: Array[String]) {
    LOG.info("Start")
    LOG.info(s"First = ${memo(2000)}")
    LOG.info(s"Second= ${memo(2000)}")
  }
}
