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
    private b f23122a;

    /* renamed from: b */
    private FileWriter f23123b;

    /* renamed from: c */
    private File f23124c;

    /* renamed from: d */
    private char[] f23125d;

    /* renamed from: e */
    private volatile g f23126e;

    /* renamed from: f */
    private volatile g f23127f;

    /* renamed from: g */
    private volatile g f23128g;

    /* renamed from: h */
    private volatile g f23129h;

    /* renamed from: i */
    private volatile boolean f23130i;

    /* renamed from: j */
    private HandlerThread f23131j;

    /* renamed from: k */
    private Handler f23132k;

    public a(b bVar) {
        this(c.f23147b, true, h.f23170a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f23131j && !this.f23130i) {
            this.f23130i = true;
            i();
            try {
                this.f23129h.a(g(), this.f23125d);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.f23129h.b();
                throw th2;
            }
            this.f23129h.b();
            this.f23130i = false;
        }
    }

    private Writer g() {
        File a10 = c().a();
        if ((a10 != null && !a10.equals(this.f23124c)) || (this.f23123b == null && a10 != null)) {
            this.f23124c = a10;
            h();
            try {
                this.f23123b = new FileWriter(this.f23124c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f23123b;
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f23123b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f23123b.close();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            try {
                if (this.f23128g == this.f23126e) {
                    this.f23128g = this.f23127f;
                    this.f23129h = this.f23126e;
                } else {
                    this.f23128g = this.f23126e;
                    this.f23129h = this.f23127f;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a() {
        if (this.f23132k.hasMessages(1024)) {
            this.f23132k.removeMessages(1024);
        }
        this.f23132k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.f23131j.quit();
    }

    public b c() {
        return this.f23122a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i10, boolean z10, h hVar, b bVar) {
        super(i10, z10, hVar);
        this.f23130i = false;
        a(bVar);
        this.f23126e = new g();
        this.f23127f = new g();
        this.f23128g = this.f23126e;
        this.f23129h = this.f23127f;
        this.f23125d = new char[bVar.d()];
        g();
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f23131j = handlerThread;
        handlerThread.start();
        if (!this.f23131j.isAlive() || this.f23131j.getLooper() == null) {
            return;
        }
        this.f23132k = new Handler(this.f23131j.getLooper(), this);
    }

    @Override // com.tencent.open.a.i
    public void a(int i10, Thread thread, long j10, String str, String str2, Throwable th2) {
        a(e().a(i10, thread, j10, str, str2, th2));
    }

    public void a(String str) {
        this.f23128g.a(str);
        if (this.f23128g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f23122a = bVar;
    }
}
