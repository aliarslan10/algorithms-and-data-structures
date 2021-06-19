package algorithms;

public class NestedLoops {

    public static void main(String[] args) {
        basic();
        optimized();
    }

    private static void basic() {

        long started = System.currentTimeMillis();
        System.out.println("Started : " + started);

        int x = 30;

        for (int i = 0; i < x; i+=2) {

            for (int j = 0; j < (x-i); j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println("*");
        }

        long finished = System.currentTimeMillis();
        System.out.println("Finished : " + finished);

        long duration = finished - started;
        System.out.println("Duration : " + duration + "\n");
    }


    private static void optimized() {

        long started = System.currentTimeMillis();
        System.out.println("Started : " + started);

        int x = 30;

        for (int i = 0; i < x; i+=2) {

            for (int j = 0; j < ((x/2)-i/2); j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println("*");
        }

        long finished = System.currentTimeMillis();
        System.out.println("Finished : " + finished);

        long duration = finished - started;
        System.out.println("Duration : " + duration + "\n");
    }
}
