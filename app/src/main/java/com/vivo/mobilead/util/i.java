package com.vivo.mobilead.util;

import android.graphics.Color;

/* loaded from: classes4.dex */
public class i {
    public static int a(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return -1;
        }
    }
}
