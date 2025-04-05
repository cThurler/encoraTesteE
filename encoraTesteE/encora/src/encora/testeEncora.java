package encora;

import java.util.*;

public class testeEncora {
    public static Set<Set<Integer>> getSubsets(Set<Integer> A) {
        Set<Set<Integer>> result = new LinkedHashSet<>();
        Integer[] elementos = A.toArray(new Integer[0]);
        int totalSubsets = 1 << elementos.length;

        List<Set<Integer>> temp = new ArrayList<>();

        for (int i = 0; i < totalSubsets; i++) {
            Set<Integer> subset = new LinkedHashSet<>();
            for (int j = 0; j < elementos.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(elementos[j]);
                }
            }
            temp.add(subset);
        }

        temp.sort((a, b) -> Integer.compare(b.size(), a.size()));

        result.addAll(temp);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> A = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Set<Integer>> sets = getSubsets(A);
        System.out.println(sets);
    }
}


//utilizado linked hash set para preservar a ordem, sorteados a partir dos tamanhos.