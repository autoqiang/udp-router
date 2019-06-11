import java.io.*;

public class Prime {
    public static void main(String[] args) throws IOException {
        OutputStream fs = new FileOutputStream("./DATA/b.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fs);
        int flag;
        for (int i = 2; i < 10000; i++) {
            flag = 1;
            for (int j = 2; j < i; j++) {
                if ( i % j == 0 ) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                osw.write(Integer.toString(i));
                osw.write("\r\n");
            }
        }
        osw.close();
        fs.close();
    }
}
