package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val menta2 = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val quinoa = Quinoa(1.0,2010,0.2)
        val quinoa2 = Quinoa(1.0,2006, 0.9)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            menta2.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
            quinoa.daSemillas().shouldBeTrue()
            quinoa2.daSemillas().shouldBeTrue()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            menta2.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
            quinoa.espacio().shouldBe(0.2)
            quinoa2.espacio().shouldBe(0.9)
        }

        it("horas de sol toleradas"){
            soja.toleranciaSol().shouldBe(8.0)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                menta2.espacio()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }

    }
})