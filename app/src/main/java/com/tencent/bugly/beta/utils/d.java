package com.tencent.bugly.beta.utils;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private String f24699a;

    /* renamed from: b */
    private long f24700b;

    /* renamed from: c */
    private long f24701c;

    /* renamed from: d */
    a f24702d = null;

    public d(String str, long j2, long j3) {
        this.f24699a = null;
        this.f24700b = 0L;
        this.f24701c = 0L;
        this.f24699a = str;
        this.f24700b = j2;
        this.f24701c = j3;
    }

    private boolean b() {
        return (this.f24700b == 0 || this.f24701c == 0) ? false : true;
    }

    private synchronized boolean c() {
        if (!b()) {
            return false;
        }
        if (this.f24702d == null) {
            try {
                this.f24702d = new a(this.f24699a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public synchronized void a() {
        a aVar = this.f24702d;
        if (aVar == null) {
            return;
        }
        aVar.a();
        this.f24702d = null;
    }

    private synchronized String b(long j2) {
        if (this.f24702d == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.f24702d.b(this.f24700b);
            this.f24702d.b(j2);
            while (true) {
                byte b2 = this.f24702d.b();
                if (b2 == 0) {
                    break;
                }
                stringBuffer.append((char) b2);
            }
            this.f24702d.a();
            this.f24702d = new a(this.f24699a);
        } catch (Exception e2) {
            this.f24702d = null;
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public synchronized String a(long j2) {
        if (j2 >= 0) {
            if (j2 < this.f24701c) {
                if (this.f24702d == null && !c()) {
                    return null;
                }
                return b(j2);
            }
        }
        return null;
    }
}
