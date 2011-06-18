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
  
  def store(slot: Int, v: Int) {
	reset(slot)
	slot -> Cards.Zero
	
	val div = (a: Int) => Unit = {
	  div
	}
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
	val cmdSlot = 0
	
	powerSlot ->: Cards.Zero
	powerSlot <-: Cards.Succ
	
	for (i <- 0 until 13) {
	  powerSlot <-: Cards.Dbl
	}
	
	cmdSlot ->: Cards.Attack
	//первый аргумент
	cmdSlot <-: Cards.K
	cmdSlot <-: Cards.S
	cmdSlot ->: Cards.I
	cmdSlot ->: Cards.Zero
	//второй аргумент
	cmdSlot <-: Cards.K
	cmdSlot <-: Cards.S
	cmdSlot ->: Cards.Succ
	cmdSlot ->: Cards.Zero
	//третий аргумент
	cmdSlot <-: Cards.K
	cmdSlot <-: Cards.S
	cmdSlot ->: Cards.Get
	  cmdSlot <-: Cards.K
	  cmdSlot <-: Cards.S
	  cmdSlot ->: Cards.Succ
	  cmdSlot ->: Cards.Zero
	
	  
  }
  
  def strategy2() {
	
	2 ->: Cards.Zero
	2 <-: Cards.Succ
	
	for (i <- 0 until 13) {
	  2 <-: Cards.Dbl
	}
	
	func(1, Cards.Attack)	
	push_0(1)
	push_0(1)
	push_field(1, 2)
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
	
	strategy2()
  }
}


