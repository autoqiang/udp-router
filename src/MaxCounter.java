import java.io.*;

import static java.lang.Math.abs;

public class MaxCounter {

    private static int getMax(int[][] arr) {
        int max = 0;
        int temp_1 = 0;
        int temp_2 = 0;

        //横竖查
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //横查
                if (arr[i][j] == 1) {
                    temp_1++;
                } else {
                    if (temp_1 > max) {
                        max = temp_1;
                    }
                    temp_1 = 0;
                }
                //竖查
                if (arr[j][i] == 1) {
                    temp_2++;
                } else {
                    if (temp_2 > max) {
                        max = temp_2;
                    }
                    temp_2 = 0;
                }
            }
            //横
            if (temp_1 > max) {
                max = temp_1;
            }
            temp_1 = 0;
            //竖
            if (temp_2 > max) {
                max = temp_2;
            }
            temp_2 = 0;
        }



        //斜查
        for (int i = 1 - arr.length; i < arr.length; i++) {
            for (int j = 0; j < 8 - abs(i); j++) {

                if (i <= 0) {
                    //左上到右下
                    if (arr[j - i][j] == 1) {
                        temp_1++;
                    } else {
                        if (temp_1 > max) {
                            max = temp_1;
                        }
                        temp_1 = 0;
                    }
                    //右上到左下
                    if (arr[j - i][7 - j] == 1) {
                        temp_2++;
                    } else {
                        if (temp_2 >max) {
                            max = temp_2;
                        }
                        temp_2 = 0;
                    }
                } else {
                    //左上到右下
                    if (arr[j][i + j] == 1) {
                        temp_1++;
                    } else {
                        if (temp_1 > max) {
                            max = temp_1;
                        }
                        temp_1 = 0;
                    }
                    //右上到左下
                    if (arr[j][7 - i - j] == 1) {
                        temp_2++;
                    } else {
                        if (temp_2 >max) {
                            max = temp_2;
                        }
                        temp_2 = 0;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[8][8];
        InputStream f = new FileInputStream("./DATA/c.txt");

        int temp;
        int size = f.available();

        for (int i = 0; i < size; i++) {
            temp = f.read();
            //System.out.println(temp + " ");
            if (temp == 13 || temp == 10) {
                i--;
                size--;
            } else {
                if (temp == 48) {
                    arr[i / 8][i % 8] = 0;
                } else {
                    arr[i / 8][i % 8] = 1;
                }
            }
        }
        f.close();

        //检查是否数组中元素是否正确
//        System.out.print("\n");
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
        System.out.println(getMax(arr));
    }
}
