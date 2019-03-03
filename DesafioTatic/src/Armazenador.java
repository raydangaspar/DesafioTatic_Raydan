import java.io.*;
import java.util.StringTokenizer;
import java.util.zip.*;

// compacta o arquivo txt no formato zip e deleta o antigo arquivo txt, para economizar espaço
public class Armazenador {

    public static void armazenador (String arquivo) throws IOException {
        String sourceFile = arquivo;

        // separa o .txt do restante da string
        StringTokenizer tokenizer = new StringTokenizer(arquivo, ".");

        FileOutputStream fos = new FileOutputStream(tokenizer.nextToken() + ".zip");

        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;

        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

    // deleta o arquivo txt para melhor utilização do espaço
    public static void deletador (String arquivo){
        File file = new File(arquivo);
        file.delete();
    }
}