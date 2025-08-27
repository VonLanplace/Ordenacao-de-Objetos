package view;

import controller.PessoaController;
import model.Pessoa;

public class PessoaView {
    public static void main(String[] args)
    {
        ordenaNome();
        ordenaSobrenome();
        ordenaIdade();
    }
    private static void ordenaNome()
    {
        try {
            System.out.println("\nOrdenado pelo Nome:");
            PessoaController obj = new PessoaController();
            Pessoa[] pessoas = obj.ordena_nome();
            for (int i = 0; i < pessoas.length; i++)
                System.out.println(pessoas[i].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ordenaSobrenome()
    {
        try {
            System.out.println("\nOrdenado pelo Sobrenome:");
            PessoaController obj = new PessoaController();
            Pessoa[] pessoas = obj.ordena_sobrenome();
            for (int i = 0; i < pessoas.length; i++)
                System.out.println(pessoas[i].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ordenaIdade()
    {
        try {
            System.out.println("\nOrdenado pela Idade:");
            PessoaController obj
                = new PessoaController();
            Pessoa[] pessoas = obj.ordena_idade();
            for (int i = 0; i < pessoas.length; i++)
                System.out.println(pessoas[i].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
