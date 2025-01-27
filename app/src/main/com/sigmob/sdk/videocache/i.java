package com.sigmob.sdk.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: g */
    public static final int f20626g = 1;

    /* renamed from: h */
    public static final int f20627h = 2;

    /* renamed from: a */
    public final AtomicInteger f20628a = new AtomicInteger(0);

    /* renamed from: b */
    public final String f20629b;

    /* renamed from: c */
    public volatile g f20630c;

    /* renamed from: d */
    public final List<d> f20631d;

    /* renamed from: e */
    public final d f20632e;

    /* renamed from: f */
    public final e f20633f;

    public static final class a extends Handler implements d {

        /* renamed from: a */
        public final String f20634a;

        /* renamed from: b */
        public final List<d> f20635b;

        public a(String str, List<d> list) {
            super(Looper.getMainLooper());
            this.f20634a = str;
            this.f20635b = list;
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(File file, String str, int i10) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i10;
            obtainMessage.obj = file;
            obtainMessage.what = 1;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (d dVar : this.f20635b) {
                int i10 = message.what;
                if (i10 == 1) {
                    dVar.a((File) message.obj, this.f20634a, message.arg1);
                } else if (i10 == 2) {
                    dVar.a(this.f20634a, (Throwable) message.obj);
                }
            }
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(String str, Throwable th2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.obj = th2;
            obtainMessage.what = 2;
            sendMessage(obtainMessage);
        }
    }

    public i(String str, e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f20631d = copyOnWriteArrayList;
        this.f20629b = (String) o.a(str);
        this.f20633f = (e) o.a(eVar);
        this.f20632e = new a(str, copyOnWriteArrayList);
    }

    public final synchronized void a() {
        if (this.f20628a.decrementAndGet() <= 0) {
            this.f20630c.g();
            this.f20630c = null;
        }
    }

    public int b() {
        return this.f20628a.get();
    }

    public final g c() throws q {
        String str = this.f20629b;
        e eVar = this.f20633f;
        g gVar = new g(t.a(str, eVar.f20585d, eVar.f20586e), new com.sigmob.sdk.videocache.file.b(this.f20633f.a(this.f20629b), this.f20633f.f20584c));
        gVar.a(this.f20632e);
        return gVar;
    }

    public void d() {
        this.f20631d.clear();
        if (this.f20630c != null) {
            this.f20630c.a((d) null);
            this.f20630c.g();
            this.f20630c = null;
        }
        this.f20628a.set(0);
    }

    public final synchronized void e() throws q {
        try {
            this.f20630c = this.f20630c == null ? c() : this.f20630c;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(f fVar, Socket socket) throws q, IOException {
        e();
        try {
            this.f20628a.incrementAndGet();
            this.f20630c.a(fVar, socket);
        } finally {
            try {
            } finally {
            }
        }
    }

    public void b(d dVar) {
        this.f20631d.remove(dVar);
    }

    public void a(d dVar) {
        this.f20631d.add(dVar);
    }
}
