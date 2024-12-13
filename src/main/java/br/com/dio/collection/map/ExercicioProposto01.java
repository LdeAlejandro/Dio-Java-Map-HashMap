package br.com.dio.collection.map;

import java.util.*;

/*

Dada a população estimada de alguns estados do NE brasileiro, faça:

Estado = PE - População = 9.616.621

Estado = AL - População = 3.351.543

Estado = CE - População = 9.187.103

Estado = RN - População = 3.534.265

Crie um dicionário e relacione os estados e suas populações;

Substitua a população do estado do RN por 3.534.165;

Confira se o estado PB está no dicionário, caso não adicione: PB -
4.039.277;

Exiba a população PE;

Exiba todos os estados e suas populações na ordem que foi
informado;

Exiba os estados e suas populações em ordem alfabética;

Exiba o estado com o menor população e sua quantidade;

Exiba o estado com a maior população e sua quantidade;

Exiba a soma da população desses estados;

Exiba a média da população deste dicionário de estados;

Remova os estados com a população menor que 4.000.000;

Apague o dicionário de estados;

Confira se o dicionário está vazio.
 */
public class ExercicioProposto01 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");

        Map<String, Integer> populacoesEstados = new HashMap<>(){{

            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);

        }};

        System.out.println(populacoesEstados);

        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populacoesEstados.put("RN", 3534165);

        System.out.println(populacoesEstados);

        System.out.println("Confira se o estado da Paraíba (PB) tucson está no dicionário, caso não, adicione " +
                "PB - 4.039.277: ");

        if(!populacoesEstados.containsKey("PB")){
            populacoesEstados.put("PB", 4039277);
        }

        System.out.println(populacoesEstados);

        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");

        Map<String, Integer> linkedPopulacoesEstados = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534165);
            put("PB", 4039277);
        }};

        System.out.println(linkedPopulacoesEstados);

        System.out.println("Exiba todos os estados e suas populações na ordem alfabética (ordem natural): ");
        Map<String, Integer> treeMapPopulacoesEstados = new TreeMap<>(linkedPopulacoesEstados);
        System.out.println(treeMapPopulacoesEstados);

        Collection<Integer> populacao = linkedPopulacoesEstados.values();
        String estadoComMaiorPopulacao = "";
        String estadoComMenorPopulacao = "";

        //O entrySet() retorna um conjunto (Set) de objetos do tipo Map.Entry, exemplo: Map.Entry("PE", 9616621)
        for(Map.Entry<String, Integer> entry: populacoesEstados.entrySet()){

            if(entry.getValue().equals(Collections.max(populacao))){
                estadoComMaiorPopulacao = entry.getKey();
            }

            if(entry.getValue().equals(Collections.min(populacao))){
                estadoComMenorPopulacao = entry.getKey();
            }
        }

        System.out.println("Exiba o estado com o menor população e seu respectivo valor");
        System.out.println(estadoComMenorPopulacao +" "+ Collections.min(populacao));
        System.out.println("Exiba o estado com a maior população e seu respectivo valor");
        System.out.println(estadoComMaiorPopulacao +" "+ Collections.max(populacao));

        System.out.println("Exiba a soma da população desses estados: ");

        int somaPopulacao = 0;

        // obter todos valores e fazer eles iterables
        Iterator<Integer> iterator = populacoesEstados.values().iterator();
        while(iterator.hasNext()){
            somaPopulacao+= iterator.next(); //.next() avança e retornar o proxima elemento
        };

        System.out.println(somaPopulacao);

        int populacaoMedia = somaPopulacao / populacoesEstados.size() ;

        System.out.println("Exiba a média da população deste dicionário de estados: " + populacaoMedia );

        Iterator<Integer> iteratorToRemove = populacoesEstados.values().iterator();

        while(iteratorToRemove.hasNext()){
            if(iteratorToRemove.next() <= 4000000){
                iteratorToRemove.remove();
            }
        }
        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        System.out.println(populacoesEstados);

        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        populacoesEstados.clear();
        System.out.println(populacoesEstados);

        System.out.println("Confira se a lista está vazia: " + populacoesEstados.isEmpty());
    }
}

