// busca os dados no arquivo na memória ram
public class Buscador {

    public static void buscador (long[] v, int fim, String[] t, String[] u, String[] arrayValores){

        String menor = arrayValores[1];
        String maior = arrayValores[2];

        long numMenor = Long.parseLong(menor);
        long numMaior = Long.parseLong(maior);

        int tamanhoArray = arrayValores.length;

        // busca os eventos no intervalo de datas desejado
        for (int i = 0; i < fim; i++){
            if (v[i] >= numMenor && v[i] <= numMaior){
                if (tamanhoArray > 3) {
                    for (int j = 3; j < tamanhoArray; j++){
                        // se houver identificação de evento, filtra por aqui
                        if (arrayValores[j].equals(t[i])){
                            System.out.println(v[i] + ";" + t[i] + ";" + u[i]);
                        }
                    }
                }
                else {
                    System.out.println(v[i] + ";" + t[i] + ";" + u[i]);
                }
            }
            // como o arquivo está ordenado, se passar da maior data, não é necessário continuar a busca
            if (v[i] > numMaior){
                break;
            }
        }
    }
}