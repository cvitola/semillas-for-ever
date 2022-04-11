package ar.edu.unahur.obj2.semillas

class Menta(var altura: Double, val anioSemilla: Int) {
    fun espacio(): Double {
        TODO("Te la debo, amigue...")
    }

    fun daSemillas(): Boolean {
        TODO("Colgue, che...")
    }

    fun esFuerte(): Boolean {
        TODO("Estas seguro que lo queres implementar así?")
    }

}

class Soja(var altura: Double, val anioSemilla: Int) {
    fun espacio(): Double {
        TODO("Lee un poco más el enunciado...")
    }

    fun daSemillas(): Boolean {
        TODO("Dalee")
    }

    fun esFuerte(): Boolean {
        TODO("Así me implementas mejor")
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
        TODO("Dalee")
    }

    fun esFuerte(): Boolean {
        TODO("Así me implementas mejor")
    }
}

class Planta(var altura: Double, val anioSemilla: Int) {
    fun espacio() {
        TODO("Pasaron cosas")
    }

}