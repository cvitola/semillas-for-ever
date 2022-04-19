package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class AsociacionPlantaTest : DescribeSpec ({
    describe("Asociación de plantas y creacion de parcelas ecologicas e industriales") {

        val sojaChica = Soja(0.4, 2009)      // soporta 6hs de sol
        val sojaGrande = Soja(0.6, 2009)     // soporta 8hs de sol
        val sojaGrabde2 = Soja(0.7,2009)     // soporta 8hs de sol
        val menta = Menta(1.0, 2021)         // soporta 7hs de sol
        val quinoaChica = Quinoa(0.5, 2001, 0.2)
        val quinoaChica2 = Quinoa(0.6, 2001, 0.2)


        val parcelaEcoChica = ParcelaEcologica(1.0, 4.0, 8)  // 24mts cuadrados
        val parcelaEcoGrande = ParcelaEcologica(4.0, 6.0, 8)  // 24mts cuadrados

        val parcelaIndu = ParcelaIndustrial(1.0,4.0,8)

        it("Asociar plantas a una parcela industrial") {
            // soja chica y menta no son fuerte por lo tanto no se pueden asociar con la parcela industrial
            parcelaIndu.seAsociaBien(sojaChica).shouldBeFalse()
            parcelaIndu.seAsociaBien(menta).shouldBeFalse()
            // soja grande es fuerte, por la tanto si se asocia bien.
            parcelaIndu.seAsociaBien(sojaGrande).shouldBeFalse()

        }

        it ("Plantar dos plantas fuertes y ver si se puede asociar otra planta") {
            parcelaIndu.plantarPlanta(sojaGrande)
            parcelaIndu.plantarPlanta(quinoaChica)
            parcelaIndu.seAsociaBien(quinoaChica2).shouldBeTrue()
            parcelaIndu.plantarPlanta(quinoaChica2)
            parcelaIndu.seAsociaBien(sojaGrabde2).shouldBeFalse()

        }


        it("Parcela Ecologia es o no ideal para las plantas") {
            // Soja chica da falso porque la cantidad de horas que tolera es diferente
            // que las horas de sol de la parcela.
            sojaChica.parcelaIdeal(parcelaEcoChica).shouldBeFalse()
            // Soja grande da verdadero porque la cantidad de horas que tolera es igual
            // a la horas de sol de la parcela.
            sojaGrande.parcelaIdeal(parcelaEcoChica).shouldBeTrue()
            // Menta le resulta falso, para que sea ideal la parcela deberia tener mas de 6mts cuadrados de superficie.
            menta.parcelaIdeal(parcelaEcoChica).shouldBeFalse()
        }

        it("Complicaciones al plantar las distintas plantas") {
            parcelaEcoChica.plantarPlanta(sojaGrande)
            parcelaEcoChica.tieneComplicaciones().shouldBeFalse()
            // Si tiene complicaciones, la menta soporta 7hs y la parcela recibe 8hs de sol.
            parcelaEcoChica.plantarPlanta(menta)
            parcelaEcoChica.tieneComplicaciones().shouldBeTrue()
            // Si tiene complicaciones, la soja chica soporta 6hs y la parcela recibe 8hs de sol.
            parcelaEcoChica.plantarPlanta(sojaChica)
            parcelaEcoChica.tieneComplicaciones().shouldBeTrue()
        }

        it("Plantas se asocian bien o no con la parcela") {
            // Probamos sin tener plantas en la parcela.
            parcelaEcoGrande.seAsociaBien(menta).shouldBeTrue()
            parcelaEcoGrande.seAsociaBien(sojaChica).shouldBeFalse()
            parcelaEcoGrande.seAsociaBien(sojaGrande).shouldBeTrue()
            // Probamos al plantar la menta la parcela si tiene complicaciones,
            // y por eso la sojaGrande ahora no se asocia bien.
            parcelaEcoGrande.plantarPlanta(menta)
            parcelaEcoGrande.seAsociaBien(sojaGrande).shouldBeFalse()

        }



    }

})