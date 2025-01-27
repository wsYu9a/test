package com.bytedance.pangle.log;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private String f6176a;

    /* renamed from: b */
    private String f6177b;

    /* renamed from: c */
    private String f6178c;

    /* renamed from: d */
    private long f6179d;

    /* renamed from: e */
    private long f6180e;

    private a(String str, String str2, String str3) {
        this.f6176a = str;
        this.f6177b = str2;
        this.f6178c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f6180e = currentTimeMillis;
        this.f6179d = currentTimeMillis;
        ZeusLogger.i(this.f6176a, this.f6177b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f6180e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f6179d;
        ZeusLogger.i(this.f6176a, this.f6177b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f6178c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f6179d;
    }
}
