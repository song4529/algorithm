package com.study.algorithm.Question;

/* 문제 해결 순서
1. 각각의 입력값을 List에 넣어준 뒤 중복을 제외하기 위해 set을 사용해서 중복된 결과의 개수를 제외한 뒤에 size의 값의 차이를 통해 결과를 얻어낼 수 있다.
2. 중복 확인을 위해서 인텔리제이의 equals() and hashCode()기능을 사용했다.
*/

import java.util.*;

public class DuplicatedProducts {

    public int countDuplicates(List<String> names, List<Integer> prices, List<Integer> weights) {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            Item item = new Item(names.get(i), prices.get(i), weights.get(i));
            items.add(item);
        }

        int totalItems = items.size();

        Set<Item> uniqueItems = new HashSet<>(items);

        int uniqueItemCount = uniqueItems.size();

        return totalItems - uniqueItemCount;
    }

    class Item {
        String name;
        int price;
        int weight;

        Item(String name, int price, int weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return price == item.price && weight == item.weight && Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameCount = scanner.nextInt();

        scanner.nextLine();

        List<String> names = new ArrayList<>();

        for (int i = 0; i < nameCount; i++) {
            String itemName = scanner.nextLine();
            names.add(itemName);
        }

        int priceCount = scanner.nextInt();

        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < priceCount; i++) {
            int itemPrice = scanner.nextInt();
            prices.add(itemPrice);
        }

        int weightCount = scanner.nextInt();

        List<Integer> weights = new ArrayList<>();

        for (int i = 0; i < weightCount; i++) {
            int itemWeight = scanner.nextInt();
            weights.add(itemWeight);
        }

        DuplicatedProducts duplicatedProducts = new DuplicatedProducts();

        int result = duplicatedProducts.countDuplicates(names, prices, weights);

        System.out.println(result);

        scanner.close();
    }
}