package com.opos.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class o {

    /* renamed from: a */
    private final AtomicInteger f23832a = new AtomicInteger(0);

    /* renamed from: b */
    private final String f23833b;

    /* renamed from: c */
    private volatile n f23834c;

    /* renamed from: d */
    private final List<b> f23835d;

    /* renamed from: e */
    private final b f23836e;

    /* renamed from: f */
    private final l f23837f;

    private static final class a extends Handler implements b {

        /* renamed from: a */
        private final String f23838a;

        /* renamed from: b */
        private final List<b> f23839b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f23838a = str;
            this.f23839b = list;
        }

        @Override // com.opos.videocache.b
        public void a(File file, String str, int i2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.f23839b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f23838a, message.arg1);
            }
        }
    }

    public o(String str, l lVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f23835d = copyOnWriteArrayList;
        this.f23833b = (String) f.a(str);
        this.f23837f = (l) f.a(lVar);
        this.f23836e = new a(str, copyOnWriteArrayList);
    }

    private void b() {
        synchronized (this) {
            this.f23834c = this.f23834c == null ? d() : this.f23834c;
        }
    }

    private void c() {
        synchronized (this) {
            if (this.f23832a.decrementAndGet() <= 0) {
                this.f23834c.a();
                this.f23834c = null;
            }
        }
    }

    private n d() {
        String str = this.f23833b;
        l lVar = this.f23837f;
        n nVar = new n(new d(str, lVar.f23822d, lVar.f23823e), new com.opos.videocache.a.b(this.f23837f.a(this.f23833b), this.f23837f.f23821c));
        nVar.a(this.f23836e);
        return nVar;
    }

    public int a() {
        return this.f23832a.get();
    }

    public void a(m mVar, Socket socket) {
        b();
        try {
            this.f23832a.incrementAndGet();
            this.f23834c.a(mVar, socket);
        } finally {
            c();
        }
    }
}
