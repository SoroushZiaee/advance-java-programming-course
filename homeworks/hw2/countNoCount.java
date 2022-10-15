import java.util.*;

public class countNoCount {

    static int convertTimeToNumber(String str) {
        return Integer.parseInt(str.replaceAll(":", ""));
    }

    static void sortTime(String[] arrStr){
        Arrays.sort(arrStr, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String time1 = str1.split(" ")[2];
                String time2 = str2.split(" ")[2];
                return time1.compareTo(time2);
            }
        });
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] trans = new String[n];

        in.nextLine();
        for (int i = 0; i < n; i++) {
            trans[i] = in.nextLine();
        }
        sortTime(trans);
        // System.out.println(Arrays.toString(trans));

        int currentMoney = 0, min = 0;

        // String[] trans = {"WIT 100 08:57 OK", "WIT 250 18:00 OK", "WIT 150 13:23
        // FAIL", "DEP 1000 18:01", "WIT 600 20:07 OK"};

        for (String str : trans) {
            // System.out.println("The Transaction is : " + str);
            String[] arrStr = str.split(" ");
            int r;
            if (arrStr[0].equals("DEP"))
                currentMoney += Integer.parseInt(arrStr[1]);

            else if (arrStr[0].equals("WIT")) {
                if (arrStr[3].equals("OK")) {
                    r = currentMoney - Integer.parseInt(arrStr[1]);
                    if (r >= 0) {
                        currentMoney = r;
                    }

                    else {
                        min += r;
                        currentMoney = 0;
                    }
                }
            }
        }

        System.out.println(-1 * min);
        in.close();

    }

}
