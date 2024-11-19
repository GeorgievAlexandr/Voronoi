public class Main {
    public static void main(String[] args) {
        int[][] points = new int[][]{{100, 300}, {200, 400}, {50, 200}, {150, 150}, {300, 100}, {100,100}};
        float[][][] screen = new float[500][500][3];
        Display display = new Display(400, 400);
        for (int x = 0; x < 500; x++) {
            for (int y = 0; y < 500; y++) {
                float lastLength = 1000;
                int outputI = 0;
                for (int i = 0; i < points.length; i++) {
                    float length = (float) Math.sqrt(Math.pow((x - points[i][0]), 2) + Math.pow((y - points[i][1]), 2));
                    if (length < lastLength) {
                        outputI = i;
                        lastLength = length;
                    }
                }
                switch (outputI){
                    case 0 -> {
                        screen[x][y][0] = 0;
                        screen[x][y][1] = 1;
                        screen[x][y][2] = 0;
                    }
                    case 1 -> {
                        screen[x][y][0] = 1;
                        screen[x][y][1] = 0;
                        screen[x][y][2] = 1;
                    }
                    case 2 -> {
                        screen[x][y][0] = 1;
                        screen[x][y][1] = 1;
                        screen[x][y][2] = 0;
                    }
                    case 3 -> {
                        screen[x][y][0] = 0;
                        screen[x][y][1] = 0;
                        screen[x][y][2] = 1;
                    }
                    case 4 -> {
                        screen[x][y][0] = 1;
                        screen[x][y][1] = 0;
                        screen[x][y][2] = 0;
                    }
                    case 5 -> {
                        screen[x][y][0] = 0;
                        screen[x][y][1] = 0;
                        screen[x][y][2] = 0;
                    }
                }
            }
        }
        display.render(screen);
    }
}