fun main() {
    /*
    Тестирую простой кейс обработки исключения
     */

    checkArg(10)
    checkArg(2)

    /*
    Тестирую кейс с индивидуальной обработкой разных типов исключений
     */

    val blue = Colors.BLUE
    val green = Colors.GREEN
    val red = Colors.RED

    checkRed(blue)
    checkRed(green)
    checkRed(red)

    /*
    Тестирую кейс с инициализацией переменной через конструкцию try-catch
     */

    val result1 = try{
        devideArgs(4,2)
    } catch (e:Exception){
        null
    }

    println("result1: $result1")

    val result2 = try{
        devideArgs(4,0)
    } catch (e:Exception){
        null
    }

    println("result2: $result2")


}