package com.vivo.push.e;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static String[] f25043a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};

    /* renamed from: b */
    private ArrayList<String> f25044b;

    /* renamed from: com.vivo.push.e.a$a */
    public static class C0681a {

        /* renamed from: a */
        private static a f25050a = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a a() {
        return C0681a.f25050a;
    }

    public final ArrayList<String> b() {
        return new ArrayList<>(this.f25044b);
    }

    public final boolean c() {
        ArrayList<String> arrayList = this.f25044b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.f25044b = null;
        this.f25044b = new ArrayList<>();
    }
}
