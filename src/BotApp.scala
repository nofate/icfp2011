package name.nofate.icfp2011

import scala.Predef

class Card(val card: String) {
  def <-:(slot: Int) {
	println("1")
	println(card)
	println(slot)
	BotApp.opponentTurn()
  }
  
  def ->:(slot: Int) {
	println("2")
	println(slot)
	println(card)
	BotApp.opponentTurn()
  }
}

object Cards {
  val Zero = new Card("zero")
  val Succ = new Card("succ")
  val Dbl = new Card ("dbl")
  
  val I = new Card("I")
  val K = new Card("K")
  val S = new Card("S")
  val Get = new Card("get")
  
  val Inc = new Card("inc")
  val Dec = new Card("dec")
  val Attack = new Card("attack")
  val Help = new Card("help")
  
  val Zombie = new Card("zombie")
  val Revive = new Card("revive")
  val Put = new Card("put")
  val Copy = new Card("copy")
}

object BotApp {
  
  def reset(slot: Int) {
	slot <-: Cards.Put
  }
  
  def func(slot: Int, f: Card) {
	slot ->: f
  }
  
  def push_0(slot: Int) {
	slot ->: Cards.Zero
  }
  
  def push_1(slot: Int) {
	slot <-: Cards.K
	slot <-: Cards.S
	slot ->: Cards.Succ
	slot ->: Cards.Zero
  }
  
  def push_field(slot: Int, src: Int) {
	0 <-: Cards.Put
	0 ->: Cards.Zero
	for (i <- 1 to src) {
	  0 <-: Cards.Succ
	}
	
	slot <-: Cards.K
	slot <-: Cards.S
	slot ->: Cards.Get
	
	slot <-: Cards.K
	slot <-: Cards.S
	slot ->: Cards.Get
	slot ->: Cards.Zero
  }
    
  def store(slot: Int, a: Int) {
	reset(slot)
	
	if (a != 0) {
	  var a1 = { if (a % 2 == 1) { a - 1 }	else { a / 2} }
	  store(slot, a1)
	  
	  if (a % 2 == 1) {
		slot <-: Cards.Succ
	  } else {
		slot <-: Cards.Dbl
	  }
	} else {
	  slot ->: Cards.Zero
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
  
  def reviveZero() {
	117 ->: Cards.Revive
	117 ->: Cards.Zero
  }
  
  def prepareGoodStrategy() {
	0 ->: Cards.S
	0 ->: Cards.Revive
	0 ->: Cards.Dec
	
	for (i <- 1 to 84) {
	  0 <-: Cards.K
	  0 <-: Cards.S
	  0 ->: Cards.Succ
	  0 <-: Cards.S
	  0 ->: Cards.Revive
	  0 <-: Cards.S
	  0 ->: Cards.Dec
	}
  }
  
  def run10000() {
	for (i <- 1 to 1) {
	  111 ->: Cards.Get
	  111 ->: Cards.Zero
	  111 ->: Cards.Zero
	  
	  if (i % 500 == 0) {reviveZero()}
	}
  }
  
  def modifyStrategy() {
	0 <-: Cards.K
	0 <-: Cards.S
	0 ->: Cards.Get
	0 <-: Cards.K
	0 <-: Cards.S
	0 ->: Cards.Succ
  }
  
  def store128() {
	1 ->: Cards.Zero
	1 <-: Cards.Succ
	1 <-: Cards.Dbl
	1 <-: Cards.Succ
	1 <-: Cards.Dbl
	1 <-: Cards.Succ
	1 <-: Cards.Dbl
	1 <-: Cards.Dbl
	1 <-: Cards.Dbl
	1 <-: Cards.Succ
	1 <-: Cards.Dbl
  }
  
  def goodStrategy() {

	prepareGoodStrategy()
	modifyStrategy()
	
	store(1, 171)
	run10000()
	store(1, 86)
	run10000()
	store(1, 1)
	run10000()
	
	
	
	/*while (1==1) {
	  45 ->: Cards.I
	}*/
  }
  
  def main(args:Array[String]) {

	val player = { 
	  if (args(0) == "1") { 1 }   
	  else { 0 }
	} 
	
	if (player == 1) {
	  opponentTurn();
	}
	
	goodStrategy()
	
  }
}


