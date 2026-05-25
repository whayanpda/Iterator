package org.example;

import java.util.Iterator;

public class ControleFrota {

    public static Integer contarVeiculosEmOperacao(Frota frota) {
        int quantidade = 0;
        for (Veiculo veiculo : frota) {
            if (veiculo.isEmOperacao()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static Integer contarTotalVeiculos(Frota frota) {
        int quantidade = 0;
        for (Iterator<Veiculo> v = frota.iterator(); v.hasNext(); ) {
            quantidade++;
            v.next();
        }
        return quantidade;
    }
}