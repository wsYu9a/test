package com.tencent.open.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes4.dex */
public class a extends i implements Handler.Callback {

    /* renamed from: a */
    private b f25394a;

    /* renamed from: b */
    private FileWriter f25395b;

    /* renamed from: c */
    private File f25396c;

    /* renamed from: d */
    private char[] f25397d;

    /* renamed from: e */
    private volatile g f25398e;

    /* renamed from: f */
    private volatile g f25399f;

    /* renamed from: g */
    private volatile g f25400g;

    /* renamed from: h */
    private volatile g f25401h;

    /* renamed from: i */
    private volatile boolean f25402i;

    /* renamed from: j */
    private HandlerThread f25403j;
    private Handler k;

    public a(b bVar) {
        this(c.f25418b, true, h.f25437a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f25403j && !this.f25402i) {
            this.f25402i = true;
            i();
            try {
                this.f25401h.a(g(), this.f25397d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f25401h.b();
                throw th;
            }
            this.f25401h.b();
            this.f25402i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f25396c)) || (this.f25395b == null && a2 != null)) {
            this.f25396c = a2;
            h();
            try {
                this.f25395b = new FileWriter(this.f25396c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f25395b;
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f25395b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f25395b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f25400g == this.f25398e) {
                this.f25400g = this.f25399f;
                this.f25401h = this.f25398e;
            } else {
                this.f25400g = this.f25398e;
                this.f25401h = this.f25399f;
            }
        }
    }

    public void a() {
        if (this.k.hasMessages(1024)) {
            this.k.removeMessages(1024);
        }
        this.k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.f25403j.quit();
    }

    public b c() {
        return this.f25394a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i2, boolean z, h hVar, b bVar) {
        super(i2, z, hVar);
        this.f25402i = false;
        a(bVar);
        this.f25398e = new g();
        this.f25399f = new g();
        this.f25400g = this.f25398e;
        this.f25401h = this.f25399f;
        this.f25397d = new char[bVar.d()];
        g();
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f25403j = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.f25403j.isAlive() || this.f25403j.getLooper() == null) {
            return;
        }
        this.k = new Handler(this.f25403j.getLooper(), this);
    }

    @Override // com.tencent.open.a.i
    protected void a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j2, str, str2, th));
    }

    protected void a(String str) {
        this.f25400g.a(str);
        if (this.f25400g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f25394a = bVar;
    }
}
