package controller;

import java.io.IOException;
import model.Pessoa;

public class PessoaController {
    public PessoaController()
    {
        super();
    }
    public Pessoa[] ordena_idade() throws IOException
    {
        Pessoa[] pessoas = Pessoa.carregar();
        int size = pessoas.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size; j++) {
                if (pessoas[j].getIdade() < pessoas[i].getIdade()) {
                    Pessoa aux = pessoas[j];
                    pessoas[j] = pessoas[i];
                    pessoas[i] = aux;
                }
            }
        }

        return pessoas;
    }

    public Pessoa[] ordena_nome() throws IOException
    {
        Pessoa[] pessoas = Pessoa.carregar();
        mergeSort(pessoas);

        return pessoas;
    }

    private void mergeSort(Pessoa[] pessoas)
    {
        mergeSort(pessoas, 0, pessoas.length - 1);
    }

    private void mergeSort(Pessoa[] pessoas, int menor, int maior)
    {
        if (menor >= maior)
            return;
        int meio = ((maior - menor) / 2) + menor;
        mergeSort(pessoas, menor, meio);
        mergeSort(pessoas, meio + 1, maior);

        mergeUnite(pessoas, menor, meio, maior);
    }

    private void mergeUnite(Pessoa[] pessoas, int menor, int meio, int maior)
    {
        Pessoa[] aux = new Pessoa[maior - menor + 1];
        {
            int i = menor, j = meio + 1, k = 0;
            while (i <= meio && j <= maior) {
                if (pessoas[i].getNome().compareTo(pessoas[j].getNome()) < 0) {
                    aux[k++] = pessoas[i++];
                } else {
                    aux[k++] = pessoas[j++];
                }
            }

            while (i <= meio) {
                aux[k++] = pessoas[i++];
            }

            while (j <= maior) {
                aux[k++] = pessoas[j++];
            }
        }

        int k = 0;
        for (int i = menor; i <= maior; i++)
            pessoas[i] = aux[k++];
    }

    public Pessoa[] ordena_sobrenome() throws IOException
    {
        Pessoa[] pessoas = Pessoa.carregar();

        quickSort(pessoas);

        return pessoas;
    }

    private void quickSort(Pessoa[] pessoas)
    {
        quickSort(pessoas, 0, pessoas.length - 1);
    }

    private void quickSort(Pessoa[] pessoas, int menor, int maior)
    {
        int i = menor, j = maior;
        String pivo = pessoas[((maior - menor) / 2) + menor].getSobrenome();

        while (i <= j) {

            while (pessoas[i].getSobrenome().compareTo(pivo) < 0)
                i++;

            while (pessoas[j].getSobrenome().compareTo(pivo) > 0)
                j--;

            if (i <= j) {
                Pessoa aux = pessoas[j];
                pessoas[j] = pessoas[i];
                pessoas[i] = aux;
                i++;
                j--;
            }
        }

        if (i <= maior)
            quickSort(pessoas, i, maior);
        if (j >= menor)
            quickSort(pessoas, menor, j);
    }
}
