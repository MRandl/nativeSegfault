object App {
  import scalanative.unsafe._
  import scalanative.unsigned.given

  @main def main() = 
    val limit = 100
    Zone { implicit allocator =>
      val ptr = alloc[BigInt](limit.toULong)
      for i <- (0 until limit) do {
        ptr(i) = BigInt(2).pow(200+ i)
      }
      for i <- (0 until limit) do {
        println(s"2 to the ${i} : " + ptr(i))
      }
    }
    println("all good !")
} 
