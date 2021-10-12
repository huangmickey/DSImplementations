public class Main {
    public static void main(String[] args) {
        ArrayList arrList = new ArrayList(3);
        System.out.println(arrList.length());

        arrList.add(10);
        arrList.add(11);
        arrList.add(12);
        System.out.println(arrList.isFull());
        System.out.println(arrList);
        System.out.println(arrList.length());
        arrList.add(13);
        System.out.println(arrList.length());
        System.out.println(arrList);

        System.out.println(arrList.indexOf(13));




    }
}
