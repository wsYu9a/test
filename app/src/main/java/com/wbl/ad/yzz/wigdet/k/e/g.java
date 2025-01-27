package com.wbl.ad.yzz.wigdet.k.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a */
    public com.wbl.ad.yzz.wigdet.k.e.s.b f34588a;

    /* renamed from: c */
    public boolean f34590c;

    /* renamed from: e */
    public final String f34592e;

    /* renamed from: f */
    public volatile e f34593f;

    /* renamed from: g */
    public final List<b> f34594g;

    /* renamed from: h */
    public final b f34595h;

    /* renamed from: i */
    public final c f34596i;

    /* renamed from: b */
    public String f34589b = null;

    /* renamed from: d */
    public final AtomicInteger f34591d = new AtomicInteger(0);

    public static final class a extends Handler implements b {

        /* renamed from: a */
        public final String f34597a;

        /* renamed from: b */
        public final List<b> f34598b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34597a = str;
            this.f34598b = list;
        }

        @Override // com.wbl.ad.yzz.wigdet.k.e.b
        public void a(ProxyCacheException proxyCacheException) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7685, this, proxyCacheException);
        }

        @Override // com.wbl.ad.yzz.wigdet.k.e.b
        public void a(File file, String str, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7688, this, file, str, Integer.valueOf(i2));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7687, this, message);
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f34594g = copyOnWriteArrayList;
        this.f34592e = (String) m.a(str);
        this.f34596i = (c) m.a(cVar);
        this.f34595h = new a(str, copyOnWriteArrayList);
    }

    public final synchronized void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7682, this, null);
    }

    public void a(d dVar, Socket socket) throws ProxyCacheException, IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7681, this, dVar, socket);
    }

    public final void a(String str) throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7684, this, str);
    }

    public final e b() throws ProxyCacheException {
        return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7683, this, null);
    }

    public synchronized e c() throws ProxyCacheException {
        return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7710, this, null);
    }
}
