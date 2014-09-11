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

    LOG.info(s"First  2K = ${memo(2000)}")
    LOG.info(s"Second 2K= ${memo(2000)}")

    LOG.info("=========================")

    LOG.info(s"First  5K = ${memo(5000)}")
    LOG.info(s"Second 5K = ${memo(5000)}")
    LOG.info("End")
  }
}
