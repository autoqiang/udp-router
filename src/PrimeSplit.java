public class PrimeSplit {

    public static void main(String[] args) {
        int flag;
        int count = 0;
        for (int i = 2; i < 10000; i++) {
            flag = 1;
            for (int j = 2; j < i; j++) {
                if ( i % j == 0 ) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                if (checkPrimeSplit(Integer.toString(i))) {
                    System.out.println(i);
                    count++;
                }
            }
        }
        System.out.println("Total : " + count);
    }



    private static boolean isPrim(int n) {
        boolean flag = true;
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }


    private static boolean checkPrimeSplit(String data) {  //判断是否为可拼接
        boolean flag = false;
        switch (data.length()) {
            case 1:
                flag = false;
                break;
            case 2:
                String[] s = new String[2];
                s[0] = data.substring(0, 1);
                s[1] = data.substring(1, 2);
                flag = isPrim(Integer.parseInt(s[0])) && isPrim(Integer.parseInt(s[1])); //若长度为二 分别判断是否为素数
                break;
            case 3:
                String[] s1 = new String[3];
                for (int i = 1; i < data.length(); i++)
                    for (int j = i + 1; j <= data.length(); j++) {
                        s1[0] = data.substring(0, i);
                        s1[1] = data.substring(i, j);
                        if (s1[1].charAt(0) == '0')
                            continue;
                        if (j < data.length()) {
                            s1[2] = data.substring(j, data.length());
                            flag = isPrim(Integer.parseInt(s1[0])) && isPrim(Integer.parseInt(s1[1]))
                                    && isPrim(Integer.parseInt(s1[2]));
                        } else {
                            flag = isPrim(Integer.parseInt(s1[0])) && isPrim(Integer.parseInt(s1[1]));
                        }
                        if (flag)
                            return true;
                    }
                break;
            case 4:
                String[] s2 = new String[4];
                for (int i = 1; i < data.length(); i++)
                    for (int j = i + 1; j <= data.length(); j++) {
                        s2[0] = data.substring(0, i);
                        s2[1] = data.substring(i, j);
                        if (s2[1].charAt(0) == '0')
                            continue; // 9833 9973
                        if (j < data.length()) {
                            for (int k = j + 1; k <= data.length(); k++) {
                                s2[2] = data.substring(j, k);
                                if (s2[2].charAt(0) == '0')
                                    continue;
                                if (k < data.length()) {
                                    s2[3] = data.substring(k, data.length());
                                    flag = isPrim(Integer.parseInt(s2[0])) && isPrim(Integer.parseInt(s2[1]))
                                            && isPrim(Integer.parseInt(s2[2])) && isPrim(Integer.parseInt(s2[3]));
                                    if (flag)
                                        return flag;
                                } else {
                                    flag = isPrim(Integer.parseInt(s2[0])) && isPrim(Integer.parseInt(s2[1]))
                                            && isPrim(Integer.parseInt(s2[2]));
                                    if (flag)
                                        return flag;
                                }
                            }
                        } else {
                            flag = isPrim(Integer.parseInt(s2[0])) && isPrim(Integer.parseInt(s2[1]));
                            if (flag)
                                return flag;
                        }
                    }
                break;
        }
        return flag;
    }
}
