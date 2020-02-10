/*
1. The signum of a number is 1 if the number is positive, -1 if it is negative, and 0 if it is zero. Write a function
that computes this value.
 */
println("1.")
def signum(number: Int): Int = {
  val sig = if (number > 0) 1 else -1
  if (number == 0) 0 else sig
}

signum(2)
signum(-2)
signum(0)

/*
2.What is the value of an empty block expression {}? What is its type?

Its value is () and its type is unit
 */

/*
3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
 */

println("2.")
var x: Unit = ()
var y: Int = 1
x = y = 1

/*
4. Write a Scala equivalent for the Java loop. for (int i = 10; i <= 10; i--) System.out.println(i);
 */

println("3.")
for(i <- 10.to(0 , -1)) println(i)

/*
5. Write a procedure countdown(n: int) that prints the numbers from n to 0
 */

def countdown(n: Int): Unit = {
  for(i <- n.to(0 , -1)) println(i)
}

countdown(20)

/*
6. Write a for loop for computing the product of the Unicode codes of all the letters in a string. For example, the
product of the characters in "Hello is 825152896L.
 */

def productOfUnicodes(word: String): Int = {
  var result = 1
  for(letter <- word) result *= letter.toInt
  result
}

productOfUnicodes("Hello")

/*
7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc)
 */

def productOfUnicodesNoLoop(word: String): Int = {
  word.map(_.toInt).product
}

productOfUnicodesNoLoop("Hello")

/*
8. Write a function product(s: String) that computes the product, as described in the preceding exercises
 */

def product(s: String): Int = productOfUnicodes(s)

product("Hello")

/*
9. Make the function of the preceding exercise a recursive function.
 */

def productR(s: String): Int = {
  if (s.isEmpty) 1
  else s.head * productR(s.tail)
}

productR("Hello")

/*
10. Write a function that computes x^n, where n is an integer. Use the following recursive definition:
x^n = y * y if n is even and positive, where y = x^(n/2)
x^n = x * x^(n-1) if n is odd and positive
x^0 = 1
x^n = 1/(x^-n) if n is negative
Don't use a return statement
 */

import scala.math.pow
def fun10(x: Int, n: Int): Double = {
  if (n > 0 && n % 2 == 0) (pow(x, n/2) * pow(x, n/2))
  else if (n > 0 && n % 2 != 0) x * (pow(x, n - 1))
  else if (n == 0) 1
  else 1 / (pow(x, -n))
}

fun10(2, 2)
fun10(2, 3)
fun10(2, 0)
fun10(2, -1)

/*
11. Define a string interpolator date so that you can define a java.time.LocalDate as date"$year-$month-$day". You need to
define an "implicit" class with a date method like this:
implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = ...
}
args(i) is the value of the ith expression. Convert each to a string and then to an integer, and pass them to the
LocalDate.of method. If you already know some Scala, add error handling. Throw an exception if there aren't three
arguments, or if they aren't integers, or if they aren't separated by dashes.
(You get the strings in between the expressions as sc.parts)
 */
import java.time.LocalDate
implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
    if (args.length != 3) throw new IllegalArgumentException("There must be 3 arguments")
    for (s <- sc.parts) if (s.length > 0 && !s.equals("-")) throw new IllegalArgumentException("Separators must be '-'")
    try {
      val (year, month, day) = (args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
      LocalDate.of(year, month, day)
    } catch {
      case ex: NumberFormatException => throw new NumberFormatException("Date arguments must be strings")
    }
  }
}

//date"2"


val year = 2020
val month = 2
val day = 9

val yearString = "^&*"

//date"$year=$month=$day"

//date"$yearString-$month-$day"

date"$year-$month-$day"