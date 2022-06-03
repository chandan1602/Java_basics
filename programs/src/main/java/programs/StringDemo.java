package programs;

public class StringDemo {
    public static void main(String[] args) {
        String a = "Chandan";
        String b = "Chandan";
        System.out.println(a==b + " because of string pool");

        String c = new String("Chandan");
        String d = new String("Chandan");
        System.out.println(c==d + " because of heap memory allocation");
//        int arr1[] = {1};
//        int arr2[] = {1};
//        System.out.println(arr1==arr2);

        StringBuilder builder =  new StringBuilder(); //allows mutability and prevents new object creation
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            builder.append(ch);
        }
        System.out.println(builder.toString());

    }
}
