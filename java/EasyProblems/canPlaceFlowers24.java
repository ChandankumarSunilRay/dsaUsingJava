package EasyProblems;

public class canPlaceFlowers24 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {


            if (flowerbed[i] == 0) {

                boolean emptyLeft = (i == 0) || flowerbed[i - 1] == 0;
                boolean emptyRight = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;


                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    n--;

                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {

        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println(canPlaceFlowers(flowerbed1, n1));

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println(canPlaceFlowers(flowerbed2, n2));
    }
}





