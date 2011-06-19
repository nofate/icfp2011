package name.nofate.icfp2011

import scala.Predef

class Card(val card: String) {
  def <-:(slot: Int) {
	println("1")
	println(card)
	println(slot)
	BotApp.opponentTurn()
	BotApp.incCnt()
  }
  
  def ->:(slot: Int) {
	println("2")
	println(slot)
	println(card)
	BotApp.opponentTurn()
	BotApp.incCnt()
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
  var cnt = 0;
  
  def incCnt() {
	cnt = cnt + 1
	//if (cnt == 659) { System.exit(0) } 
  }
  
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
	0 <-: Cards.Put
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
	for (i <- 1 to 7000) {
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
	
	
	
	while (1==1) {
	  store(1, 171)
	  run10000()
	  store(1, 86)
	  run10000()
	  store(1, 1)
	  run10000()
	}
  }
  
  def kill0_255() {
	1 ->: Cards.Zero
	2 ->: Cards.Zero
	2 <-: Cards.Succ
	
	2 <-: Cards.Attack
	1 <-: Cards.Attack
	
	0 ->: Cards.Zero
	0 <-: Cards.Succ
	0 <-: Cards.Succ
	0 <-: Cards.Succ
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl //48
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl
	0 <-: Cards.Dbl //6144
	
	2 <-: Cards.S
	2 ->: Cards.Get
	1 <-: Cards.S
	1 ->: Cards.Get
	
	2 ->: Cards.Zero
	1 ->: Cards.Zero
	
	2 ->: Cards.Zombie
	2 ->: Cards.Zero
	
	1 ->: Cards.Help
	1 ->: Cards.Zero
	1 ->: Cards.Zero
	
	1 <-: Cards.K
	1 <-: Cards.S
	1 <-: Cards.K
	1 <-: Cards.S
	1 ->: Cards.K
	1 <-: Cards.K
	1 <-: Cards.S
	1 ->: Cards.Get
	1 ->: Cards.Zero
	
	2 <-: Cards.K
	2 <-: Cards.S
	2 ->: Cards.Get
	2 <-: Cards.K
	2 <-: Cards.S
	2 ->: Cards.Succ
	2 ->: Cards.Zero
  }
  
  def zombieRaid() {
	1 <-: Cards.Put
	1 ->: Cards.Get
	1 ->: Cards.Zero
	
	0 <-: Cards.Put
	0 ->: Cards.Zero
	
	2 ->: Cards.Zombie
	2 ->: Cards.Zero
	
	2 <-: Cards.K
	2 <-: Cards.S
	2 ->: Cards.Get
	2 <-: Cards.K
	2 <-: Cards.S
	2 ->: Cards.Succ
	2 <-: Cards.K
	2 <-: Cards.S
	2 ->: Cards.Succ
	2 <-: Cards.K
	2 <-: Cards.S
	2 ->: Cards.Succ
	
	//loop
	for (i <- 1 to 254) {
	  0 <-: Cards.Succ
	  
	  3 <-: Cards.Put
	  3 ->: Cards.Help
	  3 <-: Cards.K
	  3 <-: Cards.S
	  3 ->: Cards.Get
	  3 <-: Cards.S
	  3 ->: Cards.Get
	  3 ->: Cards.Zero
	  3 <-: Cards.K
	  3 <-: Cards.S
	  3 <-: Cards.K
	  3 <-: Cards.S
	  3 ->: Cards.K
	  3 <-: Cards.K
	  3 <-: Cards.S
	  3 ->: Cards.Get
	  3 <-: Cards.K
	  3 <-: Cards.S
	  3 ->: Cards.Succ
	  3 ->: Cards.Zero
	  
	  5 ->: Cards.Zero
	  5 <-: Cards.Succ
	  5 <-: Cards.Succ
	  5 <-: Cards.Get
	  
	  6 ->: Cards.Dec
	  6 ->: Cards.Zero
	  5 ->: Cards.Zero
	  
	}
  }
  
  def main(args:Array[String]) {

	val player = { 
	  if (args(0) == "1") { 1 }   
	  else { 0 }
	} 
	
	if (player == 1) {
	  opponentTurn();
	}
	
	kill0_255()
	zombieRaid()
	goodStrategy()
	
	56 ->: Cards.I
	
  }
}


