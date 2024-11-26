public class SampleJava {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 6;
        int num3 = num1 + num2;

        System.out.println("The sum of num1 and num2 is " +num3);
        System.out.println("Array 1:");

        //arrays
        int[] arr = {1, 3, 5, 7};
       for (int i = 0; i < arr.length; i++)
       {
           System.out.println(arr[i]);
       }

        System.out.println("Array 2:");
       //array2 --check if array has multiple of 2
       int[] arr2 = {1,2,4,8,11,12,14,19,20};
       for (int i = 0; i<arr2.length; i++){
           if (arr2[i] % 2 == 0){
               System.out.println(arr2[i]);
           }
           else {
               System.out.println(arr2[i] + " is not a multiple of 2.");
           }
       }

    }
}
