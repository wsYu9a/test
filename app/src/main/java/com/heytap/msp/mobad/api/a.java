package com.heytap.msp.mobad.api;

import com.opos.mobad.f.e;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static volatile e f8970a;

    private a() {
    }

    public static e a() {
        if (f8970a == null) {
            synchronized (a.class) {
                if (f8970a == null) {
                    f8970a = new e();
                }
            }
        }
        return f8970a;
    }
}
