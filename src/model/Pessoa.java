package model;

import java.io.IOException;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;

    public int getIdade() { return this.idade; }
    public String getNome() { return this.nome; }
    public String getSobrenome() { return this.sobrenome; }

    public void setIdade(int idade) { this.idade = idade; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public String toString()
    {
        return this.nome + "\t" + this.sobrenome + "\t" + idade;
    }

    public static Pessoa[] carregar() throws IOException
    {
        Arquivo arquivo = new Arquivo("data/pessoas.csv");
        String[] valores;
        String[] linhas = arquivo.linhas();
        Pessoa[] pessoas = new Pessoa[linhas.length];

        for (int i = 0; i < linhas.length; i++) {
            valores = linhas[i].split(";");
            pessoas[i] = new Pessoa();
            pessoas[i].setNome(valores[0]);
            pessoas[i].setSobrenome(valores[1]);
            pessoas[i].setIdade(Integer.parseInt(valores[2]));
        }
        return pessoas;
    }
}
