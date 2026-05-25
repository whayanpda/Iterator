package org.example;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControleFrotaTest {

    @Test
    void deveContarVeiculosEmOperacao() {
        Frota frota = new Frota(
                new Veiculo("ABC-1234", true),
                new Veiculo("DEF-5678", false),
                new Veiculo("GHI-9012", true)
        );

        assertEquals(2, ControleFrota.contarVeiculosEmOperacao(frota));
    }

    @Test
    void deveContarTotalVeiculos() {
        Frota frota = new Frota(
                new Veiculo("ABC-1234", true),
                new Veiculo("DEF-5678", false),
                new Veiculo("GHI-9012", true)
        );

        assertEquals(3, ControleFrota.contarTotalVeiculos(frota));
    }

    @Test
    void deveRetornarZeroParaFrotaVazia() {
        Frota frota = new Frota();

        assertEquals(0, ControleFrota.contarTotalVeiculos(frota));
        assertEquals(0, ControleFrota.contarVeiculosEmOperacao(frota));
    }

    @Test
    void devePermitirIterarPelosVeiculosDaFrota() {
        Veiculo primeiro = new Veiculo("ABC-1234", true);
        Veiculo segundo = new Veiculo("DEF-5678", false);
        Frota frota = new Frota(primeiro, segundo);

        Iterator<Veiculo> iterator = frota.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(primeiro, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(segundo, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void deveLerEAlterarDadosDoVeiculo() {
        Veiculo veiculo = new Veiculo("ABC-1234", true);

        veiculo.setPlaca("XYZ-9876");
        veiculo.setEmOperacao(false);

        assertEquals("XYZ-9876", veiculo.getPlaca());
        assertFalse(veiculo.isEmOperacao());
    }
}
