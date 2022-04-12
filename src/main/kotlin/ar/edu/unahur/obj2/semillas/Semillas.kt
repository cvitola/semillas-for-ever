package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {
    //la sobreescribe cada clase derivada
    open fun espacio(): Double = 0.0
    open fun toleranciaSol(): Int = 0
    open fun daSemillas(): Boolean = false
    open fun esFuerte(): Boolean =  this.toleranciaSol() > 7.0

}

open class Menta(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun espacio() = altura+1.0

    override fun daSemillas() =  altura>0.4

    override fun esFuerte() = this.toleranciaSol()>9.0

    override fun toleranciaSol() = 7
}

open class Soja(altura: Double, anioSemilla: Int): Planta(altura,anioSemilla) {
    override fun espacio() = altura/2.0

    override fun daSemillas() = ( (anioSemilla>=2007) && ((altura>=0.75) && (altura<=0.9)) )

    override fun esFuerte() = this.toleranciaSol()>9

    override fun toleranciaSol() =
        if (altura < 0.5){
            6
        }
        else if (altura < 1.0){
            8
        }
        else {
            12
        }
    }

class Quinoa(altura: Double, anioSemilla: Int, val espacio: Double) :Planta(altura, anioSemilla) {
    override fun espacio() = espacio

    override fun daSemillas() =  ((anioSemilla>=2001) && (anioSemilla<=2010))

    override fun esFuerte() = this.toleranciaSol()>9.0

    override fun toleranciaSol() =
        if (this.espacio()<0.3) {
            10
        }else {
            7
        }
    }

class Transgenica(altura: Double, anioSemilla: Int): Soja(altura,anioSemilla) {
    override fun daSemillas() = false
}

class Peperina(altura: Double, anioSemilla: Int): Menta(altura, anioSemilla) {
    override fun espacio() = super.espacio() * 2.0
}


