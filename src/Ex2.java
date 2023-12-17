import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
    Ex2_1 - ให้เขียนใหม่โดยใช้แนวคิดของ Single Responsibility Principle จากข้อตกลงที่ตกลงกันไว้คือสร้าง 5 methods(ไม่รวม main)

    # 1.รับเลข (inputNumbers)
    # 2.การตรวจสอบ type (isValidType): ตรวจสอบว่าสตริงที่ให้มาสามารถแปลงเป็นตัวเลข integer ได้หรือไม่
    # 3.การตรวจสอบ range (isValidRange): ตรวจสอบว่าตัวเลข integer อยู่ในช่วงที่กำหนด (0 ถึง 10)
    # 4.จัดเรียง (sortNumbers): จัดเรียงจากมากไปน้อย ASC(ascending) *เพิ่ม method นี้เพื่อใช้ในข้อ Ex2_2
    # 5.แสดงผล (printNumbers)
*/
public class Ex2 {
    public static final int MAX = 5;
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 10;

    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");
        List<Integer> nums = inputNumbers();
        sortNumbers(nums);
        printNumbers(nums);
    }

    private static List<Integer> inputNumbers() {
        Scanner inp = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter 5 valid integers in the range [" + MIN_RANGE + ", " + MAX_RANGE + "]");
        while (nums.size() < MAX) {
            String s = inp.nextLine();
            if (isValidType(s) && isValidRange(Integer.parseInt(s))) {
                nums.add(Integer.parseInt(s));
            }
        }
        inp.close();
        return nums;
    }

    private static boolean isValidType(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid! Try again!");
            return false;
        }
    }

    private static boolean isValidRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            System.out.println("Invalid range! Try again!");
            return false;
        }
        return true;
    }

    private static void sortNumbers(List<Integer> nums) {
        Collections.sort(nums);
    }

    private static void printNumbers(List<Integer> nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
