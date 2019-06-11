import java.io.*;

public class FileSearch {

    private SingleLinkedList list = new SingleLinkedList();

    private void fileErgodic(String str) {
        File f1 = new File(str);

        if (f1.isDirectory()) {
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                fileErgodic(str + "/" + s[i]);
            }
        } else {
            list.countPlus(f1.getName(), f1.length());
        }
    }

    private void show() {
        list.printElements(2);
    }

    public static void main(String[] args) {
        FileSearch fs = new FileSearch();
        fs.fileErgodic(args[0]);
        fs.show();
    }
}
