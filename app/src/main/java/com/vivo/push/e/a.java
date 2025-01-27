package com.vivo.push.e;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static String[] f31007a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};

    /* renamed from: b */
    private ArrayList<String> f31008b;

    /* renamed from: com.vivo.push.e.a$a */
    private static class C0676a {

        /* renamed from: a */
        private static a f31014a = new a((byte) 0);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0676a.f31014a;
    }

    public final ArrayList<String> b() {
        return new ArrayList<>(this.f31008b);
    }

    public final boolean c() {
        ArrayList<String> arrayList = this.f31008b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.f31008b = null;
        this.f31008b = new ArrayList<>();
    }
}
