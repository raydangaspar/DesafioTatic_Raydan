import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String nomeArquivo;
        int quantidadeLinhas;
        Scanner scanIn = new Scanner(System.in);

        System.out.println("Entre aqui a quantidade de linhas do arquivo txt: ");

        quantidadeLinhas = scanIn.nextInt();

        System.out.println("Qual o nome desejado do arquivo txt a ser gerado? (Nao inclua o .txt)");

        nomeArquivo = scanIn.next();

        GeradorArquivoTxt.geradorArquivoTxt(nomeArquivo, quantidadeLinhas);
        System.out.println("Arquivo teste de nome " + nomeArquivo + " contendo " + quantidadeLinhas + " linhas foi criado.");
    }
}
