package com.vivo.advv;

import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes4.dex */
public class Color {
    public static final int BLACK = -16777216;
    public static final int BLUE = -16776961;
    public static final int CYAN = -16711681;
    public static final int DKGRAY = -12303292;
    public static final int GRAY = -7829368;
    public static final int GREEN = -16711936;
    public static final int LTGRAY = -3355444;
    public static final int MAGENTA = -65281;
    public static final int RED = -65536;
    public static final int TRANSPARENT = 0;
    public static final int WHITE = -1;
    public static final int YELLOW = -256;
    private static final HashMap<String, Integer> sColorNameMap;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        sColorNameMap = hashMap;
        hashMap.put("black", -16777216);
        Integer valueOf = Integer.valueOf(DKGRAY);
        hashMap.put("darkgray", valueOf);
        Integer valueOf2 = Integer.valueOf(GRAY);
        hashMap.put("gray", valueOf2);
        Integer valueOf3 = Integer.valueOf(LTGRAY);
        hashMap.put("lightgray", valueOf3);
        hashMap.put("white", -1);
        hashMap.put("red", -65536);
        Integer valueOf4 = Integer.valueOf(GREEN);
        hashMap.put("green", valueOf4);
        hashMap.put("blue", Integer.valueOf(BLUE));
        hashMap.put("yellow", -256);
        Integer valueOf5 = Integer.valueOf(CYAN);
        hashMap.put("cyan", valueOf5);
        Integer valueOf6 = Integer.valueOf(MAGENTA);
        hashMap.put("magenta", valueOf6);
        hashMap.put("aqua", valueOf5);
        hashMap.put("fuchsia", valueOf6);
        hashMap.put("darkgrey", valueOf);
        hashMap.put("grey", valueOf2);
        hashMap.put("lightgrey", valueOf3);
        hashMap.put("lime", valueOf4);
        hashMap.put("maroon", -8388608);
        hashMap.put("navy", -16777088);
        hashMap.put("olive", -8355840);
        hashMap.put("purple", -8388480);
        hashMap.put("silver", -4144960);
        hashMap.put("teal", -16744320);
    }

    public static int parseColor(String str) {
        if (str.charAt(0) != '#') {
            Integer num = sColorNameMap.get(str.toLowerCase(Locale.ROOT));
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("Unknown color");
        }
        long parseLong = Long.parseLong(str.substring(1), 16);
        if (str.length() == 7) {
            parseLong |= -16777216;
        } else if (str.length() != 9) {
            throw new IllegalArgumentException("Unknown color");
        }
        return (int) parseLong;
    }
}
