package org.example;

public class Veiculo {

    private String placa;
    private boolean emOperacao;

    public Veiculo(String placa, boolean emOperacao) {
        this.placa = placa;
        this.emOperacao = emOperacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isEmOperacao() {
        return emOperacao;
    }

    public void setEmOperacao(boolean emOperacao) {
        this.emOperacao = emOperacao;
    }
}
