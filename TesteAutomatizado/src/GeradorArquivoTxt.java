import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

// gera arquivo txt com a quantidade de linhas e com o nome desejado
public class GeradorArquivoTxt {

    public static void geradorArquivoTxt (String nome, int linhas){

        String data, dataInicial, eventoId, eventoIdInicial, usuarioId;

        FileWriter arquivo;

        try {
            arquivo = new FileWriter(new File(nome + ".txt"));
            for (int i = 0; i < linhas; i++) {
                dataInicial = nomeAleatorio(1, numerosIniciais);
                data = nomeAleatorio(16, numeros);
                eventoIdInicial = nomeAleatorio(1, letrasNumerosIniciais);
                eventoId = nomeAleatorio(7, letrasNumeros);
                usuarioId = nomeAleatorio(11, numeros);
                arquivo.write(dataInicial + data + ";" + eventoIdInicial + eventoId + ";" + dataInicial + usuarioId);
                arquivo.write("\n");
            }
            arquivo.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Random rand = new Random();

    // caracteres utilizados para a data e identificador de usuário
    private static char[] numeros = "0123456789".toCharArray();
    // para não iniciar com 0
    private static char[] numerosIniciais = "123456789".toCharArray();
    // caracteres contendo números e letras utilizados para gerar o identificador de evento
    private static char[] letrasNumeros = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
    // para nao iniciar com 0
    private static char[] letrasNumerosIniciais = "123456789QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

    // os dados contidos as linhas dos arquivos são randômicos, para deixar o teste o mais variado possível
    public static String nomeAleatorio (int nCaracteres, char[] dados) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nCaracteres; i++) {
            int ch = rand.nextInt (dados.length);
            sb.append (dados [ch]);
        }
        return sb.toString();
    }
}