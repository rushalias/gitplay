package com.lat

import scalaz._
import org.slf4j._

object Main {

  val LOG = LoggerFactory.getLogger(getClass.getName)

  def expensive(sleepTime: Long): String = {
    Thread.sleep(sleepTime)
    s"we just slept for ${sleepTime}"
  }

  val memo = Memo.immutableHashMapMemo {
    sleepTime: Long => expensive(sleepTime)
  }


  def main (args: Array[String]) {
    LOG.info("Start")
    LOG.info(s"First = ${memo(2000)}")
    LOG.info(s"Second= ${memo(2000)}")
    LOG.info(s"Second= ${memo(2000)}")
    LOG.info(s"Second= ${memo(5000)}")
    LOG.info(s"Second= ${memo(5000)}")
    LOG.info(s"Second= ${memo(5000)}")
    LOG.info("End")
  }
}
