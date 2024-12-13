package br.com.dio.collection.map;

import java.util.*;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */
public class ExercicioProposto02 {
    public static void main(String[] args) {

        List<Integer> diceValues = new ArrayList<>();

        int lancamentos = 100;

        Random randomValue = new Random();

        for (int i = 0; i < lancamentos; i++){
            int diceValue = randomValue.nextInt(6) + 1; // gerar un valor random entre 1 e 6
            diceValues.add(diceValue);
        }

        System.out.println(diceValues);

        Map<Integer, Integer> diceValuesCounter = new HashMap<>();

        for ( Integer value: diceValues){
            if(diceValuesCounter.containsKey(value)){ // se a chave ja existir no hash map
                diceValuesCounter.put(value, diceValuesCounter.get(value) + 1); //Atualizar o valor do contador da chave
            }

            else{// se a chave não existir criar a chave com o value com valor por defeito 0
                diceValuesCounter.put(value, 0);
            }

        }

        System.out.println(diceValuesCounter);

    }
}

