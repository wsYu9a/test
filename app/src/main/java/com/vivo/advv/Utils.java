package com.vivo.advv;

/* loaded from: classes4.dex */
public class Utils {
    private static final String TAG = "Utils_TMTEST";
    private static int UED_SCREEN = 750;
    private static final LruCache<String, Integer> colorCache = new LruCache<>(100);
    private static float sDensity;
    private static int sScreenWidth;

    public static int dp2px(double d2) {
        float f2 = sDensity;
        if (f2 < 0.0f) {
            f2 = 1.0f;
        }
        if (d2 >= 0.0d) {
            double d3 = f2;
            Double.isNaN(d3);
            return (int) ((d2 * d3) + 0.5d);
        }
        double d4 = f2;
        Double.isNaN(d4);
        return -((int) (((-d2) * d4) + 0.5d));
    }

    public static void init(float f2, int i2) {
        sDensity = f2;
        sScreenWidth = i2;
    }

    public static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isEL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        return (str.charAt(0) == '$' && str.charAt(1) == '{' && str.charAt(length + (-1)) == '}') || (str.charAt(0) == '@' && str.charAt(1) == '{' && str.charAt(length - 1) == '}');
    }

    public static boolean isHex(char c2) {
        return (c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'f') || (c2 >= 'A' && c2 <= 'F');
    }

    public static boolean isSpace(char c2) {
        return ' ' == c2 || '\t' == c2 || '\n' == c2;
    }

    public static boolean isThreeUnknown(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.charAt(0) == '@' && str.charAt(1) == '{' && str.charAt(str.length() - 1) == '}';
    }

    public static int parseColor(String str) {
        try {
            LruCache<String, Integer> lruCache = colorCache;
            Integer num = lruCache.get(str);
            if (num != null) {
                return num.intValue();
            }
            Integer valueOf = Integer.valueOf(Color.parseColor(str));
            lruCache.put(str, valueOf);
            return valueOf.intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int px2dp(float f2) {
        float f3 = sDensity;
        if (f3 < 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static void setUedScreenWidth(int i2) {
        UED_SCREEN = i2;
    }

    public static Boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Double toDouble(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float toFloat(Object obj) {
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof Double) {
            return Float.valueOf(((Double) obj).floatValue());
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Float.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Integer toInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf((int) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Long toLong(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Long.valueOf((long) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }
}
