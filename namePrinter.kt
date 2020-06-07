object CharacterPrinter{

    fun getCharLine1(char: Char):String{
        return when(char){
            in arrayOf('B','D','P','Z')->"___ "
            in arrayOf('H','K','M','N','U','V','X')-> "_  _"
            'I'-> "_"
            'J'-> " _"
            'L'-> "_   "
            'T'-> "___"
            'W'->"_ _ _"
            'Y'->"_   _"
            ' '-> "    "
            else -> "____"
        }
    }

    fun getCharLine2(char: Char): String{
        return when(char){
            in arrayOf('A','H')->"|__|"
            in arrayOf('B','P')->"|__]"
            in arrayOf('C','L')->"|   "
            'D'->"|  \\"
            in arrayOf('E','F','G')->"|___"
            'I'->"|"
            'J'->" |"
            'K'->"|_/ "
            'M'->"|\\/|"
            'N'->"|\\ |"
            in arrayOf('O','Q','U','V')->"|  |"
            'R'->"|__/"
            'S'->"[__ "
            'T'->" | "
            'W'->"| | |"
            'X'->" \\/ "
            'Y'->" \\_/ "
            ' '-> "    "
            else ->"  / "
        }
    }

    fun getCharLine3(char: Char): String{
        return when(char){
            in arrayOf('A','H')->"|  |"
            in arrayOf('B','G')->"|__]"
            in arrayOf('C','E')->"|___"
            'D'->"|__/"
            in arrayOf('F','P')->"|   "
            'I'->"|"
            'J'->"_|"
            'K'->"| \\_"
            'L'->"|___"
            'M'->"|  |"
            'N'->"| \\|"
            in arrayOf('O','U')->"|__|"
            'Q'->"|_\\|"
            'R'->"|  \\"
            'S'->"___]"
            'T'->" | "
            'V'->" \\/ "
            'W'->"|_|_|"
            'X'->"_/\\_"
            'Y'->"  |  "
            ' '-> "    "
            else ->" /__"
        }
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

    fun getNameTagLength(string: String): Int{
        var length: Int =0
        for(char in string){
            length+= this.getCharLength(char)
        }
        return length+string.length-1
    }
}

class Tag(val name: String, val status: String){

    private var tagLength: Int = 0
    private var nameLength: Int = 0

    init{
        this.nameLength = CharacterPrinter.getNameTagLength(this.name)
        tagLength = if (this.nameLength>this.status.length) this.nameLength else this.status.length
    }

    public fun print(){
        this.printHorizontalBorder()
        this.printLineWithHorizontalBorder(this.getNameLine(1))
        this.printLineWithHorizontalBorder(this.getNameLine(2))
        this.printLineWithHorizontalBorder(this.getNameLine(3))
        this.printLineWithHorizontalBorder(this.getPaddedStringForStatus())
        this.printHorizontalBorder()
    }

    private fun printLineWithHorizontalBorder(line: String){
        println("*  $line  *")
    }

    private fun getNameLine(lineNum: Int): String{
        var lineToPrint = ArrayList<String>()
        for(char in this.name){
            lineToPrint.add(when(lineNum){
                1->CharacterPrinter.getCharLine1(char)
                2->CharacterPrinter.getCharLine2(char)
                3->CharacterPrinter.getCharLine3(char)
                else -> ""
            })
        }
        var unpaddedString = lineToPrint.joinToString(" ")

        return this.getPaddedStringForName(unpaddedString)
    }

    private fun isEven(string: String):Boolean{
        return string.length%2==0
    }
    private fun getPaddedStringForName(string: String):String{
        var midLength = this.tagLength/2 + this.nameLength/2
        //if(!isEven(string)) midLength+=1

        return string.padStart(midLength,' ').padEnd(this.tagLength, ' ')
    }

    private fun getPaddedStringForStatus(): String{
        var midLength = this.tagLength/2 + this.status.length/2
        if(!isEven(this.status)) midLength+=1
        return this.status.padStart(midLength, ' ').padEnd(this.tagLength,' ')
    }

    private fun printHorizontalBorder(){
        println("".padStart(this.tagLength+6,'*'))
    }
}

fun main(){
    var tag = Tag("Bill Gates".toUpperCase(), "VIP")
    tag.print()

    var tag2 = Tag("Tom Smith".toUpperCase(), "Worker")
    tag2.print()

    var tag3=Tag("Mr Anonimous".toUpperCase(),"Participant")
    tag3.print()

    var tag4= Tag("John S".toUpperCase(),"Worker-coworker-superdupercoworker")
    tag4.print()
}