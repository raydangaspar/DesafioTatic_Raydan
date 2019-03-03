import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// descompacta o arquivo mas não o escreve no HD, apenas o utiliza para busca na memória ram
public class Descompactador {

    public static InputStream descompactador(final String filename, String[] arrayValores) throws IOException {

        // separa o .txt do restante da string
        StringTokenizer nomeTxt = new StringTokenizer(filename, ".");

        final ZipFile zipFile = new ZipFile(new File(nomeTxt.nextToken() + ".zip"));
        final ZipEntry zipEntry = zipFile.getEntry(filename);
        final InputStream file = zipFile.getInputStream(zipEntry);

        ArrayList<Long> datas = new ArrayList<Long>();
        ArrayList<String> identificadorEvento = new ArrayList<String>();
        ArrayList<String> identificadorUsuario = new ArrayList<String>();

        Scanner linha = new Scanner(file);
        while (linha.hasNextLine()){
            StringTokenizer tokenizer = new StringTokenizer(linha.nextLine(), ";");
            datas.add(Long.parseLong(tokenizer.nextToken()));
            identificadorEvento.add(tokenizer.nextToken());
            identificadorUsuario.add(tokenizer.nextToken());
        }

        long[] v = new long[datas.size()];
        String[] t = new String[datas.size()];    // vetor de strings identificador evento
        String[] u = new String[datas.size()];    // vetor de strings identificador usuário
        for(int i=0; i<datas.size(); i++){
            v[i] = datas.get(i).longValue();
            t[i] = identificadorEvento.get(i);
            u[i] = identificadorUsuario.get(i);
        }

        // chama o buscador para encontrar os dados desejados
        Buscador.buscador(v, datas.size(), t, u, arrayValores);

        zipFile.close();
        return file;
    }
}