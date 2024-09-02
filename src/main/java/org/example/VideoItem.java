package org.example;

public class VideoItem {
	public String nome;
	public double preco;
	
	public VideoItem(String nome, double d){
		this.nome = nome;
		this.preco = d;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
