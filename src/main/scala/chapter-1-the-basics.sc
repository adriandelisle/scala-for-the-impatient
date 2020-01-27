/*
1. In the Scala REPEL, type 3. followed by the tab key. What methods can be applied?
 */

/*

scala> 3.
!=   <    >>>         doubleValue   isInfinity      isValidLong    self             toChar        toOctalString   |
%    <<   ^           floatValue    isNaN           isValidShort   shortValue       toDegrees     toRadians
&    <=   abs         floor         isNegInfinity   isWhole        sign             toDouble      toShort
*    ==   byteValue   getClass      isPosInfinity   longValue      signum           toFloat       unary_+
+    >    ceil        intValue      isValidByte     max            to               toHexString   unary_-
-    >=   compare     isFinite      isValidChar     min            toBinaryString   toInt         unary_~
/    >>   compareTo   isInfinite    isValidInt      round          toByte           toLong        until

 */

/*
2. In the Scala REPEL, compute the square root of 3, and then square that value.
By how much does the result differ from 3? (Hint the res variables are your friend)
 */

/*
scala> math.sqrt(3)
res17: Double = 1.7320508075688772

scala> math.pow(res17, 2)
res18: Double = 2.9999999999999996

scala> 3 - res17
res19: Double = 1.2679491924311228
 */

/*
3.  */

/*
They're val
 */

/*
4. Scala lets you multiply a string with a number--try out "crazy" * 3 in the REPEL.
What does this operation do? Where can you find it in the Scaladoc?
 */

/*
scala> "crazy" * 3
res20: String = crazycrazycrazy

https://www.scala-lang.org/api/current/scala/collection/StringOps.html#*(n:Int):String
Returns the string repeated x times
 */

/*
5. What does 10 max 2 mean? In which class is max method defined?
 */

/*
scala> 10 max 2
res21: Int = 10

https://www.scala-lang.org/api/current/scala/Int.html#max(that:Int):Int
Takes the largest of two numbers
 */

/*
6. Using BigInt, compute 2^1024
 */

/*
scala> BigInt(2) pow 1024
res32: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
 */

/*
7. What do you need to import so that you can get a random prime as probablePrime(100, Random),
without and qualifiers before probablePrime and Random?
 */

/*
scala> import scala.BigInt.probablePrime
import scala.BigInt.probablePrime

scala> import scala.util.Random
import scala.util.Random

scala> probablePrime(100, Random)
res33: scala.math.BigInt = 654428265210377151462477452921
 */

/*
8. One way to create random file or directory names is to produce a random BigInt and convert it to base 36, yielding a
string such as a "qsnvbevtomcj38o06kul". Poke around Scaladoc to find a way of doing this in Scala
 */

/*
scala> scala.math.BigInt(100, scala.util.Random)
res0: scala.math.BigInt = 57346852233880651446533180720

scala> res0.toString(36)
res1: String = 5k5l96ji9aemwj5rdbk
 */

/*
9. How do you get the first character of a string in Scala? The last character?
 */

/*
scala> val s = "Hello"
s: String = Hello

scala> s(0)
res8: Char = H

scala> s(s.length -1)
res9: Char = o
 */

/*
10. What do the take, drop, takeRight, and dropRight string functions do? What advantage or disadvantage do they have over
using substring?
 */

/*
 def take(n: Int): String

A string containing the first n chars of this string.

def drop(n: Int): String

The rest of the string without its n first chars.

def takeRight(n: Int): String

A string containing the last n chars of this string.

def dropRight(n: Int): String

The rest of the string without its n last chars.

----- compared to ----
def substring(start: Int, end: Int): String

Returns a new String made up of a subsequence of this sequence, beginning at the start index (inclusive) and extending to the end index (exclusive).

target.substring(start, end) is equivalent to target.slice(start, end).mkString

start

    The beginning index, inclusive.
end

    The ending index, exclusive.
returns

    The new String.

Exceptions thrown

    StringIndexOutOfBoundsException If either index is out of bounds, or if start > end.

They don't throw an exception
 */
