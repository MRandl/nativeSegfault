object App {
  import scalanative.unsafe._
  import scalanative.unsigned.given

  @main def main() = 
    val limit = 1000
    Zone { implicit allocator =>
      val ptr = alloc[BigInt](limit.toULong)
      for i <- (0 until limit) do {
        ptr(i) = BigInt(2).pow(i)
      }
      for i <- (0 until limit) do {
        println(s"2 to the ${i} : " + ptr(i))
      }
    }
    println("all good !")
} 
