package exercises.concurrency

import java.util.concurrent.atomic.AtomicLong

import ExecUtils.exec

object AtomicIncrement extends App {
  // Bad: read and write are not atomic
  //var k = 0
  //def incAndReturn = { k+=1; k }
  // Good: use atomic variable
  val k = new AtomicLong(0L)
  def incAndReturn = { k.incrementAndGet() }

  for(i <- 1 to 10000) exec {
    println(s"Task $i got ${incAndReturn}")
  }
  Thread.sleep(10000)
}