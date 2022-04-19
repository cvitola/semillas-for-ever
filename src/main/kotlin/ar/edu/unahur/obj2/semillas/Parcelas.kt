package ar.edu.unahur.obj2.semillas

open class Parcela(val ancho: Double, val largo: Double, val horasSol: Int) {

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
        }
    }

    fun cantidadPlantas() = plantas.size

    fun tieneComplicaciones(): Boolean = plantas.any({ p-> p.toleranciaSol() < horasSol })

    fun hayPlantasBajaAltura(): Boolean = plantas.all( { p -> p.altura < 1.5})

    open fun seAsociaBien(unaPlanta: Planta): Boolean = false

}

class ParcelaEcologica(ancho: Double, largo: Double, horasSol: Int) : Parcela(ancho,largo,horasSol) {

    override fun seAsociaBien(unaPlanta: Planta) = !this.tieneComplicaciones() && unaPlanta.parcelaIdeal(this)

}

class ParcelaIndustrial(ancho: Double, largo: Double, horasSol: Int) : Parcela(ancho,largo,horasSol) {

    override fun seAsociaBien(unaPlanta: Planta) = this.cantidadPlantas()<=2 && unaPlanta.esFuerte()

}

