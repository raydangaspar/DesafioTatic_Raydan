import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// ordena o arquivo txt antes de comprimir, para assim tornar a busca no arquivo mais rápida
public class Ordenador {

    public static void ordenador (String arquivo) throws IOException {

        // listas para guardar as informações separadamete
        ArrayList<Long> datas = new ArrayList<Long>();  // datas do eventos
        ArrayList<String> identificadorEvento = new ArrayList<String>();    // identificador do evento
        ArrayList<String> identificadorUsuario = new ArrayList<String>();   // identificador do usuário

        File file = new File(arquivo);
        Scanner linha = new Scanner(file);
        while (linha.hasNextLine()){
            StringTokenizer tokenizer = new StringTokenizer(linha.nextLine(), ";");
            datas.add(Long.parseLong(tokenizer.nextToken()));
            identificadorEvento.add(tokenizer.nextToken());
            identificadorUsuario.add(tokenizer.nextToken());
        }
        // quicksort utiliza vetor para ordenar
        long[] v = new long[datas.size()];
        String[] t = new String[datas.size()];    // vetor de strings identificador evento
        String[] u = new String[datas.size()];    // vetor de strings identificador usuário
        for(int i=0; i<datas.size(); i++){
            v[i] = datas.get(i).longValue();
            t[i] = identificadorEvento.get(i);
            u[i] = identificadorUsuario.get(i);
        }

        //Vetores carregados passar para o quicksort
        quick_sort(v, 0, datas.size(), t, u);

        // os vetores "t" e "u", são ordenados seguindo a ordenação de "v"
        try (FileWriter fileWriter = new FileWriter(arquivo)) {
            for(int i=0; i<datas.size(); i++) {
                fileWriter.write(v[i] + ";" + t[i] + ";" + u[i] + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quick_sort(long[] v, int ini, int fim, String[] t, String[] u) {
        int meio;
        if (ini < fim) {
            meio = partition(v, ini, fim, t, u);
            quick_sort(v, ini, meio, t, u);
            quick_sort(v, meio + 1, fim, t, u);
        }
    }

    public static int partition(long[] v, int ini, int fim, String[] t, String[] u) {
        long pivo;
        int topo;
        int i;
        String pivoS;
        String pivoU;
        pivo = v[ini];
        pivoS = t[ini];
        pivoU = u[ini];
        topo = ini;
        for (i = ini + 1; i < fim; i++) {
            if (v[i] < pivo) {
                v[topo] = v[i];
                t[topo] = t[i];
                u[topo] = u[i];
                v[i] = v[topo + 1];
                t[i] = t[topo + 1];
                u[i] = u[topo + 1];
                topo++;
            }
        }
        v[topo] = pivo;
        t[topo] = pivoS;
        u[topo] = pivoU;
        return topo;
    }
}