import java.util.*

fun main(args: Array<String>) {

/*
    val name = "Bill Gates"
    val status="VIP"
*//*
    val name="Tom Smith"
    val status="Worker"
*/
    val name="Mr Anonimous"
    val status="Participant"
/*
    val name="John S"
    val status="Worker-coworker-superdupercoworker"
 */
    val nameAllCaps= name.toUpperCase()
    val nameLength = getPrintLength(nameAllCaps)
    var statusLength = status.length

    var printLength = 0
    var namePad = 2 
    var statusPad = 2
    if(nameLength > statusLength){
        printLength = nameLength
        statusPad = ((nameLength/2).toInt() - (statusLength/2).toInt())-1
    }else{
        printLength = statusLength
        namePad = ((statusLength/2).toInt() -  (nameLength/2).toInt())-1
    }

    var sacrificeLeftPad = printLength%2 != statusLength%2
    println("Should sacrificeLeft pad: $sacrificeLeftPad")
    println("Name length: $nameLength")
    println("Status Length: $statusLength")
    println("NamePad: $namePad")
    println("StatusPad: $statusPad")
    
    writeStarLine(printLength+ 6)
    printNameLine(namePad, nameAllCaps, 1)
    printNameLine(namePad, nameAllCaps, 2)
    printNameLine(namePad, nameAllCaps, 3)
    printStatus(statusPad, status, sacrificeLeftPad)
    writeStarLine(printLength+ 6)
}

fun getPadLength(name: String, status: String): Int{
    return 0
}

fun printNameLine(padding: Int, name: String, line: Int){
    print("*")
    addPadding(padding)
    for(char in name){
        when(line){
            1->writeCharLine1(char)
            2->writeCharLine2(char)
            3->writeCharLine3(char)
        }
        print(' ')
    }
    addPadding(padding-1)
    println("*")
}

fun addPadding(paddingLength: Int){
    for(i in 1..paddingLength){
        print(" ")
    }
}

fun printStatus(padding: Int, status: String, shouldSacrificeLeftPad: Boolean){
    print("*  ")
    addPadding(if(shouldSacrificeLeftPad)padding-1 else padding)
    print(status)
    addPadding(padding)
    println("  *")
}


fun writeStarLine(len: Int){
    for(i in 1..len){
        print('*')
    }
    println()
}

fun getPrintLength(name: String): Int{
    var length = 0
    for(char in name){
        length += getCharLength(char)
    }
    return length+name.length-1
}

fun getCharLength(character: Char):Int{
    return when(character){
        'T'-> 3
        in arrayOf('W','Y')-> 5
        'I'-> 1
        'J'-> 2
        ' '-> 4
        else -> 4
    }
}

fun writeCharLine1(char: Char){
    when(char){
        in arrayOf('B','D','P','Z')->print("___ ")
        in arrayOf('H','K','M','N','U','V','X')-> print("_  _")
        'I'-> print("_")
        'J'-> print(" _")
        'L'-> print("_   ")
        'T'-> print("___")
        'W'->print("_ _ _")
        'Y'->print("_   _")
        ' '-> print("    ")
        else -> print("____")
    }
}

fun writeCharLine2(char: Char){
    when(char){
        in arrayOf('A','H')->print("|__|")
        in arrayOf('B','P')->print("|__]")
        in arrayOf('C','L')->print("|   ")
        'D'->print("|  \\")
        in arrayOf('E','F','G')->print("|___")
        'I'->print("|")
        'J'->print(" |")
        'K'->print("|_/ ")
        'M'->print("|\\/|")
        'N'->print("|\\ |")
        in arrayOf('O','Q','U','V')->print("|  |")
        'R'->print("|__/")
        'S'->print("[__ ")
        'T'->print(" | ")
        'W'->print("| | |")
        'X'->print(" \\/ ")
        'Y'->print(" \\_/ ")
        ' '-> print("    ")
        else ->print("  / ")
    }
}

fun writeCharLine3(char: Char){
    when(char){
        in arrayOf('A','H')->print("|  |")
        in arrayOf('B','G')->print("|__]")
        in arrayOf('C','E')->print("|___")
        'D'->print("|__/")
        in arrayOf('F','P')->print("|   ")
        'I'->print("|")
        'J'->print("_|")
        'K'->print("| \\_")
        'L'->print("|___")
        'M'->print("|  |")
        'N'->print("| \\|")
        in arrayOf('O','U')->print("|__|")
        'Q'->print("|_\\|")
        'R'->print("|  \\")
        'S'->print("___]")
        'T'->print(" | ")
        'V'->print(" \\/ ")
        'W'->print("|_|_|")
        'X'->print("_/\\_")
        'Y'->print("  |  ")
        ' '-> print("    ")
        else ->print(" /__")
    }
}