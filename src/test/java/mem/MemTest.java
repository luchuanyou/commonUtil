package mem;

public class MemTest {
    public static void main(String[] args) {
        System.out.println("totalMemory:" + Runtime.getRuntime().totalMemory() / 1024L / 1024L + "M");
        System.out.println("freeMemory:" + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "M");
        System.out.println("maxMemory:" + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "M");
    }
}
