package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Frota implements Iterable<Veiculo> {

    private List<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Frota(Veiculo... veiculos) {
        this.veiculos = Arrays.asList(veiculos);
    }

    @Override
    public Iterator<Veiculo> iterator() {
        return veiculos.iterator();
    }
}
