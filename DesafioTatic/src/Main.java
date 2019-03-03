import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String comando;
        String nomeArquivoTxt = new String();

        Scanner scanIn = new Scanner(System.in);
        comando = scanIn.nextLine();

        while (!comando.equals("end")){
            String[] arrayValores = comando.split(" ");

            if (arrayValores[0].equals("armazenador")){

                nomeArquivoTxt = arrayValores[1];

                // ordena o arquivo txt antes de armazenar
                Ordenador.ordenador(arrayValores[1]);

                // cria arquivo .zip
                Armazenador.armazenador(arrayValores[1]);

                // delete arquivo .txt para economizar espaço em disco
                Armazenador.deletador(arrayValores[1]);
            }
            if (arrayValores[0].equals("buscador")){

                // descompactador e buscador
                Descompactador.descompactador(nomeArquivoTxt, arrayValores);

            }
            comando = scanIn.nextLine();
        }
    }
}