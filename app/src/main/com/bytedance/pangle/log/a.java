package com.bytedance.pangle.log;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private String f7683a;

    /* renamed from: b */
    private String f7684b;

    /* renamed from: c */
    private String f7685c;

    /* renamed from: d */
    private long f7686d;

    /* renamed from: e */
    private long f7687e;

    private a(String str, String str2, String str3) {
        this.f7683a = str;
        this.f7684b = str2;
        this.f7685c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f7687e = currentTimeMillis;
        this.f7686d = currentTimeMillis;
        ZeusLogger.i(this.f7683a, this.f7684b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f7687e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f7686d;
        ZeusLogger.i(this.f7683a, this.f7684b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f7685c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f7686d;
    }
}
