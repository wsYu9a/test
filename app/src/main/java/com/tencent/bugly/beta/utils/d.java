package com.tencent.bugly.beta.utils;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private String f22220a;

    /* renamed from: b */
    private long f22221b;

    /* renamed from: c */
    private long f22222c;

    /* renamed from: d */
    a f22223d = null;

    public d(String str, long j10, long j11) {
        this.f22220a = str;
        this.f22221b = j10;
        this.f22222c = j11;
    }

    private boolean b() {
        return (this.f22221b == 0 || this.f22222c == 0) ? false : true;
    }

    private synchronized boolean c() {
        if (!b()) {
            return false;
        }
        if (this.f22223d == null) {
            try {
                this.f22223d = new a(this.f22220a);
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public synchronized void a() {
        a aVar = this.f22223d;
        if (aVar == null) {
            return;
        }
        aVar.a();
        this.f22223d = null;
    }

    private synchronized String b(long j10) {
        try {
            if (this.f22223d == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            try {
                this.f22223d.b(this.f22221b);
                this.f22223d.b(j10);
                while (true) {
                    byte b10 = this.f22223d.b();
                    if (b10 == 0) {
                        break;
                    }
                    stringBuffer.append((char) b10);
                }
                this.f22223d.a();
                this.f22223d = new a(this.f22220a);
            } catch (Exception e10) {
                this.f22223d = null;
                e10.printStackTrace();
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized String a(long j10) {
        if (j10 >= 0) {
            if (j10 < this.f22222c) {
                if (this.f22223d == null && !c()) {
                    return null;
                }
                return b(j10);
            }
        }
        return null;
    }
}
