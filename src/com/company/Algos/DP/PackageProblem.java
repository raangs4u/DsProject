package com.company.Algos.DP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rmandada
 */
public class PackageProblem {

    static class Item implements Comparable<Item>{
        private Integer index;
        private Double weight;
        private Integer cost;

        public Item(Integer index, Double weight, Integer cost) {
            this.index = index;
            this.weight = weight;
            this.cost = cost;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public Integer getCost() {
            return cost;
        }

        public void setCost(Integer cost) {
            this.cost = cost;
        }

        @Override
        public int compareTo(Item o) {
            if(this.cost.equals(o.cost)) {
                return this.weight.compareTo(o.weight);
            }
            return o.cost.compareTo(this.cost);
        }
    }

    public static void main(String[] args) {
        String fileName = args[0];
        String currentLine;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((currentLine = bufferedReader.readLine()) != null) {
                List<Item> items = new ArrayList<>();
                String[] line = currentLine.split(":");
                int weightCapacity = Integer.parseInt(line[0].replaceAll(" ", ""));
                String[] itemStrings = line[1].substring(1).split(" ");
                for (String str: itemStrings) {
                    str = str.replaceAll("[()]", "");
                    String[] details = str.split(",");
                    Integer index = Integer.parseInt(details[0]);
                    Double weight = Double.parseDouble(details[1]);
                    Integer cost = Integer.parseInt(details[2].substring(1));
                    Item item = new Item(index, weight, cost);
                    items.add(item);
                }

                Collections.sort(items);
                List<Integer> packageList = new ArrayList<>();
                items = items.stream()
                        .filter(item1 -> item1.getWeight() <= weightCapacity)
                        .collect(Collectors.toList());
                double weightAvailable = weightCapacity;

                for (int i = 0; i <items.size() ; i++) {
                    weightAvailable -= items.get(i).getWeight();
                    if (weightAvailable < 0) {
                        weightAvailable += items.get(i).getWeight();
                    } else {
                        packageList.add(items.get(i).getIndex());
                    }
                }

                if (packageList.isEmpty()) {
                    System.out.println("-");
                } else {
                    Collections.sort(packageList);
                    int i;
                    for (i = 0; i <packageList.size()-1 ; i++) {
                        System.out.print(packageList.get(i) + ",");
                    }
                    System.out.println(packageList.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
