// ArrayDeclarationDemo.java
// 範例：Java 陣列宣告與使用
public class ArrayDeclarationDemo {
    public static void main(String[] args) {
        // 宣告一個可以存放 5 個整數的陣列
        int[] numbers = new int[5];

        // 賦值給陣列元素
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // 用 for 迴圈印出所有陣列元素
        System.out.println("陣列內容：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + " 的值是 " + numbers[i]);
        }
    }
}
