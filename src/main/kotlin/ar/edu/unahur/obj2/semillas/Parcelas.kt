package ar.edu.unahur.obj2.semillas

class Parcela(val ancho: Double, val largo: Double, val horasSol: Int) {

    val plantas = mutableListOf<Planta>()

    fun superficie(): Double = ancho * largo

    fun cantidadMaximaPlantas(): Int =
        if (ancho > largo) {
            this.superficie().toInt() / 5
        } else {
            this.superficie().toInt() / 3 + largo.toInt() //problema de redondeo.
        }

    fun plantarPlanta(unaPlanta: Planta)  {
        if(this.cantidadPlantas() < this.cantidadMaximaPlantas() && horasSol <= unaPlanta.toleranciaSol() + 2){
            plantas.add(unaPlanta)
        }else{
            println("Error no se puede agregar")
        }
    }

    fun cantidadPlantas() = plantas.size



}