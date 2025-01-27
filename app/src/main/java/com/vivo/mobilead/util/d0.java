package com.vivo.mobilead.util;

/* loaded from: classes4.dex */
public class d0 {
    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
