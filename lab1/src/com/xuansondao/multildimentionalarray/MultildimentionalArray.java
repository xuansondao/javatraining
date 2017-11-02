package com.xuansondao.multildimentionalarray;

public class MultildimentionalArray {
    public static void main(String[] args) {
        String[][] values = {
                {"Dao" ,"Xuan", "Son "},
                {"Le", "Cong", "Vu "}
        };
        for (int i = 0; i < values.length; i++) {
            System.out.print("|");

            for (int j = 0; j < values[i].length; j++) {
                System.out.print(i + "," + j + "|");
                System.out.print(values[i][j] + "|" );

            }
            System.out.println();
        }
    }
}
