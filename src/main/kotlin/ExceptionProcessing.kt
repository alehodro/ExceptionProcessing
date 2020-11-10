/*
Иногда в программе могут возникать некоторые события, которые нарушают ее работу.
Такие события называются исключениями.
Для того, чтобы корректно обрабатывать такие исключения существует конструкция:

try {
  // здесь находится код при выполнении которого, может произойти исключение
  } catch (e:Exception) {
  // здесь находится код в котором исключение обрабатывается, при этом в свойстве 'e' передается инстанс класса Exception
     или его наследника, внутри которого есть строка с текстом ошибки
     } finally {
  // здесь находится код, который выполняется в любом случае, было исключение или нет
      }

     При выполнении некоторых операций Kotlin сам генерирует исключение (например деление на 0).
     Можно создать собственный тип исключения создав класс наследник от класса Exception, тогда в коде можно
     использовать оператор throw после которого необходимо указать конструктор своего типа исключения

 */

class AnotherException(override val message: String) : Exception()
//Создал класс наследник со своим типом исключения

fun checkArg(arg: Int) {
    try {
        if (arg > 5) throw AnotherException("Argument is more than 5")
        else println("Argument is $arg")
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("Check is over")
    }
}
/*
Функция принимает аргумент, если агрумент больше 5 - выбрасывает собственный тип исключения, которое обрабатывается в блоке
catch и выводится в консоль, если меньше в консоль выводится сам агрумент. Далее выполняется блок finally, где в консоль выводится
сообщения о завершении проверки.
Блок finally не обязательный.
 */


/*
Если в ходе выполнения кода могут возникнуть несколько типов исключения, и каждый тип требуется обрабатывать по своему
то для каждого типа необходимо разместить свой блок catch
 */

data class BlueException(override val message: String = "Blue exception") : Exception()

data class GreenException(override val message: String = "Green exception") : Exception()

enum class Colors {
    BLUE, RED, GREEN
}

fun checkRed(color: Colors) {
    try {
        when (color) {
            Colors.BLUE -> throw BlueException()
            Colors.GREEN -> throw GreenException()
            Colors.RED -> println("Color is valid")
        }
    } catch (e: BlueException) {
        println(e.message)
        println("Blue is not red")
    } catch (e: GreenException) {
        println(e.message)
        println("Green is not red")
    }
}

/*
Также с помощью конструкции try-catch, можно инициализировать переменную
 */

fun devideArgs(a: Int, b: Int): Int {
    var result: Int? = null
    try {
        result = a / b
    } catch (e: Exception) {
        println(e.message)
    }
    return result!!
}