package org.example._1807;

import java.util.HashMap;
import java.util.List;

public class Solve {
    public static void main(String[] args) {
        String result = evaluate("(name)is(age)yearsold(a)", List.of(List.of("name", "bob"), List.of("age", "two")));
        System.out.println(result);
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> si : knowledge) {
            map.put(si.get(0), si.get(1));
        }

        char[] schar = s.toCharArray();

        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (schar[i]== '(') {
                StringBuilder tmp = new StringBuilder();
                i++;
                while (schar[i] != ')') {
                    tmp.append(schar[i]);
                    i++;
                }
                st.append(map.getOrDefault(tmp.toString(), "?"));
            } else {
                st.append(schar[i]);
            }
        }
        return st.toString();
    }

}
