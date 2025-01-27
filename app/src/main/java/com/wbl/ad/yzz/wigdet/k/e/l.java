package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public class l {

    /* renamed from: a */
    public final ExecutorService f34617a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    public final String f34618b;

    /* renamed from: c */
    public final int f34619c;

    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            return (Boolean) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7787, this, null);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7782, this, null);
        }

        public /* synthetic */ b(l lVar, a aVar) {
            this();
        }
    }

    public l(String str, int i2) {
        this.f34618b = (String) m.a(str);
        this.f34619c = i2;
    }

    public final List<Proxy> a() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7784, this, null);
    }

    public void a(Socket socket) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7783, this, socket);
    }

    public boolean a(int i2, int i3) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7778, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public boolean a(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7777, this, str);
    }

    public final String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7780, this, null);
    }

    public final boolean c() throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7779, this, null);
    }
}
