package com.shu.priory.h;

import java.util.Locale;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private static Locale f17116a = Locale.US;

    public static String a(int i10) {
        String[] strArr = b.f17117a;
        if (f17116a.equals(Locale.US)) {
            strArr = c.f17119a;
        }
        return (i10 <= 0 || i10 >= strArr.length) ? strArr[7] : strArr[i10];
    }
}
