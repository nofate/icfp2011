package name.nofate.icfp2011;

import scala.Predef

object Cardz {
  val Zero = "zero"
  val Succ = "succ"
  val Dbl = "dbl"
  
  val I = "I"
  val K = "K"
  val S = "S"
  val Get ="get"
  
  val Inc = "inc"
  val Dec = "dec"
  val Attack = "attack"
  val Help = "help"
  
  val Zombie = "zombie"
  val Revive = "revive"
  val Put = "put"
  val Copy = "copy" 
}

object DummyBotApp {
  def left(card: String, slot: Int) {
	println("1")
	println(card)
	println(slot)
	opponentTurn()
  }

  def right(slot: Int, card: String) {
	println("2")
	println(slot)
	println(card)
	opponentTurn()
  }

  def initialize(a: Array[(Any, Int)]) {
	for (i <- 0.until(a.length)) {
	  //a.update(i, (Cards.I, 10000))
	}
  }
  
  def opponentTurn() {
	var slot = ""
	var card = ""
	
	if (readLine() == "1") {
	  card = readLine()
	  slot = readLine()
	} else {
	  slot = readLine()
	  card = readLine()
	}
  }

  def strategy1() {
	val powerSlot = 1
	
	while (1 == 1) {
	  right(0, Cardz.I)	  
	}
	  
  }
  
  def main(args:Array[String]) {
	val mySlots = new Array[(Any, Int)](256)
	val opSlots = new Array[(Any, Int)](256)
	
	
	initialize(mySlots)
	initialize(opSlots) 

	val player = { 
	  if (args(0) == "1") { 1 }   
	  else { 0 }
	} 
	
	if (player == 1) {
	  opponentTurn();
	}
	
	strategy1()
  }
}


