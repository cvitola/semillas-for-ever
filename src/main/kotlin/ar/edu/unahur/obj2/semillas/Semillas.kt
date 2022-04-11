package ar.edu.unahur.obj2.semillas

class Menta(var altura: Double, val anioSemilla: Int) {
    fun espacio(): Double {
        return altura+1.0
    }

    fun daSemillas(): Boolean {
        return altura>0.4
    }

    fun esFuerte(): Boolean {
        return this.toleranciaSol()>9.0
    }
    fun toleranciaSol(): Double {
        return 7.0
    }
}

class Soja(var altura: Double, val anioSemilla: Int) {
    fun espacio(): Double {
        return altura/2.0
    }

    fun daSemillas(): Boolean {
        return ( (anioSemilla>=2007) && ((altura>=0.75) && (altura<=0.9)) )
    }

    fun esFuerte(): Boolean {
        return this.toleranciaSol()>9.0
    }

    fun toleranciaSol(): Double {
        if (altura<0.5){ return 6.0 }
        else if ((altura>=0.5) && (altura<=1.0)) { return 8.0 }
        else { return 12.0 }
    }
}
class Quinoa(var altura: Double, val anioSemilla: Int, val espacio: Double) {
    fun espacio(): Double {
        return espacio
    }

    fun daSemillas(): Boolean {
        return ((anioSemilla>=2001) && (anioSemilla<=2010))
    }

    fun esFuerte(): Boolean {
        return this.toleranciaSol()>9.0
    }
    fun toleranciaSol(): Double {
        if (this.espacio()<0.3) {return 10.0}
        else {return 7.0}
    }
}

/*
class Planta(var altura: Double, val anioSemilla: Int) {
    fun espacio() {
        TODO("Pasaron cosas")
    }

}
*/