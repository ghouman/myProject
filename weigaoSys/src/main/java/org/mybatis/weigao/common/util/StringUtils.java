package org.mybatis.weigao.common.util;

import java.util.Calendar;
import java.util.Random;

public abstract class StringUtils {
    public static int getPassGrade(Integer passGrade, Integer grade) {
        if (passGrade == null) {
            return (int) (grade.intValue() * 0.8D);
        }

        return passGrade.intValue();
    }

    public static String getRate(int a, int b) {
        if (a == 0) return "0";
        if (b == 0) return "0";
        if (a == b) {
            return "100";
        }
        Double t = Double.valueOf(a / b * 100.0D);
        String s = t.toString();
        int index = s.indexOf(".");
        String prefix = s.substring(0, index);
        String ext = s.substring(index + 1);

        if (ext.length() == 1) ext = ext.substring(0, 1) + "0";
        if (ext.length() >= 3) {
            ext = ext.substring(0, 3);
            String s2 = ext.substring(0, 2);
            String s3 = ext.substring(2, 3);

            int i2 = Integer.parseInt(s2);
            int i3 = Integer.parseInt(s3);
            if (i3 >= 5) {
                ext = String.valueOf(i2 + 1);
            } else {
                ext = String.valueOf(i2);
            }
        }

        s = prefix + "." + ext;
        return s;
    }

    public static String getAvg(int a, int b) {
        if (a == 0) return "0";
        if (b == 0) return "0";
        if (a == b) {
            return "100";
        }
        Double t = Double.valueOf(a / b);
        String s = t.toString();
        int index = s.indexOf(".");
        String prefix = s.substring(0, index);
        String ext = s.substring(index + 1);

        if (ext.length() == 1) ext = ext.substring(0, 1) + "0";
        if (ext.length() >= 3) {
            ext = ext.substring(0, 3);
            String s2 = ext.substring(0, 2);
            String s3 = ext.substring(2, 3);

            int i2 = Integer.parseInt(s2);
            int i3 = Integer.parseInt(s3);
            if (i3 >= 5) {
                ext = String.valueOf(i2 + 1);
            } else {
                ext = String.valueOf(i2);
            }
        }

        s = prefix + "." + ext;
        return s;
    }

    public static String getIdentifierString() {
        Calendar calendar = Calendar.getInstance();

        String identifier = calendar.get(1) +
                addZero(calendar.get(2) + 1) +
                addZero(calendar.get(5)) +
                addZero(calendar.get(11)) +
                addZero(calendar.get(12)) +
                addZero(calendar.get(13));

        return identifier;
    }

    public static String addZero(int i) {
        String s = String.valueOf(i);

        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }

    public static String formatNumber(int c, int len) {
        String s = String.valueOf(c);
        if (s.length() >= len) {
            return s.substring(0, len);
        }

        String rtn = "";
        int i = 0;
        for (int cc = len - s.length(); i < cc; i++) {
            rtn = rtn + "0";
        }
        rtn = rtn + c;
        return rtn;
    }

    public static int getNRandom(int n) {
        Random r = new Random();
        return r.nextInt(n);
    }

    public static boolean isWhiteSpace(String s) {
        return (s == null) || (s.trim().length() == 0);
    }

    public static boolean isWhiteSpace(String[] array) {
        if (array == null) return true;
        String[] arrayOfString = array;
        int j = array.length;
        for (int i = 0; i < j; i++) {
            String item = arrayOfString[i];
            if (isWhiteSpace(item)) {
                return true;
            }
        }
        return false;
    }

    public static String killNull(String s) {
        if (isWhiteSpace(s)) return "";
        return s.trim();
    }

    public static String killNull(String s, String def) {
        if (isWhiteSpace(s)) return def;
        return s.trim();
    }

    public static String killNullObject(Object obj) {
        if (obj == null) return "";
        return obj.toString();
    }

    public static String parse2HTML(String s) {
        if (isWhiteSpace(s)) return s;
        s = s.replace("\r\n", "<br/>");
        s = s.replace("\r", "<br/>");
        s = s.replace("\n", "<br/>");
        return s;
    }

    public static String killNewLine(String s) {
        String rtn = null;

        if (s == null) return null;
        s = s.replace("\r\n", "");
        s = s.replace("\r", "");
        s = s.replace("\n", "");
        rtn = s;

        return rtn;
    }

    public static String formatString(String s, String delimiter, int index) {
        String rtn = null;

        String[] arr = s.split(delimiter);
        if ((arr == null) || (arr.length == 1)) return s;
        rtn = arr[(index - 1)].trim();

        return rtn;
    }

    public static String subString(String s, int len, String extend) {
        if (isWhiteSpace(s)) return null;
        if (s.length() < len) return s;
        return s.substring(0, len) + extend;
    }

    public static String decRand(int len) {
        Random random = new Random();
        String rtn = String.valueOf(random.nextInt(10));
        for (int i = 0; i < len - 1; i++) {
            rtn = rtn + String.valueOf(random.nextInt(10));
        }
        return rtn;
    }

    public static String maskMobile(String mobile) {
        if (isWhiteSpace(mobile)) return mobile;
        if (mobile.length() != 11) return mobile;
        return mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
    }

    public static String parseString(Integer i) {
        if (i == null) return "";
        return i.toString();
    }

    public static String subSomeString(String str, char rep, String starstr) {
        int s = 0;
        StringBuffer ss = new StringBuffer("");
        if (str.contains("page")) {
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == rep) {
                    s = i;
                    break;
                }
            }
            for (int j = s; j < str.length(); j++) {
                ss.append(str.charAt(j));
            }
            return str.replace(ss, starstr);
        }
        return str;
    }
}
