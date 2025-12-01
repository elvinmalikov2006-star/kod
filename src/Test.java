public class Test {
    static void main(String[] argstring) {
        example1();
    }

    public static void example1() {
        String str1 = "Elvin";
        System.out.println(str1);
    }

    public static void example2() {
        long Str = 12345678;
        var Str1 = String.valueOf(Str);
        System.out.println(Str1);
    }

    public static void example3() {
        String Str = "Malikov";
        var Str1 = Str.charAt(3);
        System.out.println(Str1);
    }

    public static void example4() {
        String firstname = "Elvin";
        String lastname = "Malikov";
        String age = "19";
        String fullname = firstname.concat(" " + lastname + " " + age);
        System.out.println(fullname);
    }

    public static void example5() {
        String text = "Azerbaijan State Oil and Industry University";
        System.out.println(text.startsWith("Azer"));
        System.out.println(text.endsWith("ty"));
    }

    public static void example6() {
        String name = "     Java programming      ";
        System.out.println(name.trim());
        System.out.println(name);
    }

    public static void example7() {
        String text = "Hello, my name is Elvin";
        System.out.println(text.indexOf("m"));
        System.out.println(text.lastIndexOf("m"));
    }

    public static void example8() {
        String text = "Hello, my name is Elvin";
        System.out.println(text.substring(1,9));
    }
    public static void example9(){
        String text = "Hello my dear friend";
        System.out.println(text.replace("l", "m"));
    }
    public static void example10(){
        StringBuffer tm = new StringBuffer("IdTech Academy");
        tm.append("group");
        System.out.println(tm);
    }
    public static void example11(){
        StringBuffer tm = new StringBuffer("IdTech Academy");
        tm.delete(5,8);
        System.out.println(tm);
    }
}
