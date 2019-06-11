import java.io.*;
import java.util.*;

public class Word {
    private HashMap<String, String> wordList;
    //构造函数，新建一个哈希表
    private Word() {
        wordList = new HashMap<>();
    }

    //每次使用时，对哈希表进行一次初始化，这个初始化是对于文件进行读写或者创建
    private void initList() throws IOException {
        //文件路径
        String wordPath = "./DATA/word.txt";
        //文件类
        File f = new File(wordPath);
        //文件不存在时，创建文件
        if (f.createNewFile()) {
            return;
        }

        //读取文件
        FileInputStream fis = new FileInputStream("./DATA/word.txt");
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        //一个一个添加
        while ((s = br.readLine()) != null) {
            if (s.length() == 0) continue;
            StringTokenizer st = new StringTokenizer(s, "=");
            String word = st.nextToken().trim();
            String explain = st.nextToken().trim();
            wordList.put(word, explain);
        }

    }

    //添加单词
    private void addWord() throws IOException{
        String word;
        String explain;
        int flag;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input word
        System.out.println("Please input the word:");
        word = br.readLine();
        if (wordList.containsKey(word)) {
            System.out.println("The word has been exist, can we replace it?");
            System.out.println("\t1.Yes  2.No");
            flag = Integer.parseInt(br.readLine());
            if (flag == 0) {
                return;
            } else if (flag == 1) {
                removeWord(word);
            }
        }
        System.out.println("Please input the explain of this word");
        explain = br.readLine();
        wordList.put(word, explain);


        FileOutputStream fos = new FileOutputStream("./DATA/word.txt", true);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos, "GBK"));
        pw.println(word + "=" + explain);

        pw.close();
        fos.close();
    }

    //查找单词
    private void findWord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word;
        String explain;

        System.out.println("Please input the word that you want to find:");
        word = br.readLine();
        if (!wordList.containsKey(word)) {
            System.out.println("This word is not exist.");
        } else {
            explain = wordList.get(word);
            System.out.println(word + "'s explain is " + explain);
        }
    }

    //删除单词
    private void removeWord(String str) throws IOException {
        //在文件中删除
        RandomAccessFile raf = new RandomAccessFile("./DATA/word.txt", "rw");

        String s = "";
        long lastPoint = 0;
        while ((s = raf.readLine()) != null) {
            final long point = raf.getFilePointer();
            if (s.contentEquals(str)) {
                raf.seek(lastPoint);
                raf.writeBytes("");
            }
            lastPoint = point;
        }
        raf.close();

        //在HashMap中删除
        wordList.remove(str);
    }


    public static void main(String[] args) throws IOException {
        Word w1 = new Word();
        w1.initList();
        int choose;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please choose the function:");
            System.out.println("\t1.Add word  2.Find word  3.Exit");
            choose = Integer.parseInt(br.readLine());
            if (choose == 1) {
                w1.addWord();
            } else if (choose == 2) {
                w1.findWord();
            } else {
                break;
            }
        }
    }
}
