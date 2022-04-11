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

        val transgenica1 = Transgenica(1.2, 2019)
        val peperina1 = Peperina(1.5, 2015)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
            menta2.altura.shouldBe(0.3)
            menta2.anioSemilla.shouldBe(2021)
            soja.altura.shouldBe(0.6)
            soja.anioSemilla.shouldBe(2009)
            quinoa.altura.shouldBe(1.0)
            quinoa.anioSemilla.shouldBe(2010)
            quinoa.espacio.shouldBe(0.2)
            quinoa2.altura.shouldBe(1.0)
            quinoa2.anioSemilla.shouldBe(2006)
            quinoa2.espacio.shouldBe(0.9)
            transgenica1.altura.shouldBe(1.2)
            transgenica1.anioSemilla.shouldBe(2019)
            peperina1.altura.shouldBe(1.5)
            peperina1.anioSemilla.shouldBe(2015)

        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            menta2.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
            quinoa.daSemillas().shouldBeTrue()
            quinoa2.daSemillas().shouldBeTrue()
            transgenica1.daSemillas().shouldBeFalse()
            peperina1.daSemillas().shouldBeTrue()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            menta2.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
            quinoa.esFuerte().shouldBeTrue()
            quinoa2.esFuerte().shouldBeFalse()
            transgenica1.esFuerte().shouldBeTrue()
            peperina1.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            menta2.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
            quinoa.espacio().shouldBe(0.2)
            quinoa2.espacio().shouldBe(0.9)
            transgenica1.espacio().shouldBe(0.6)
            peperina1.espacio().shouldBe(5.0)
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