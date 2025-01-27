package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    private static final String f21489a = "l";

    public class a implements Runnable {

        /* renamed from: b */
        private final com.ss.android.downloadad.api.a.b f21491b;

        public a(com.ss.android.downloadad.api.a.b bVar) {
            this.f21491b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f21491b.j(true);
                    l.this.b(this.f21491b);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } finally {
                this.f21491b.j(false);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        private static l f21492a = new l();
    }

    public /* synthetic */ l(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(com.ss.android.downloadad.api.a.b bVar) {
        JSONObject jSONObject = new JSONObject();
        int a10 = com.ss.android.downloadlib.g.e.a(bVar);
        int b10 = com.ss.android.downloadlib.g.e.b(bVar);
        if (com.ss.android.downloadlib.g.e.e(bVar) && com.ss.android.downloadlib.g.e.d(bVar)) {
            com.ss.android.downloadlib.g.l.a().a(f21489a, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            a(bVar, a10, b10, jSONObject);
        } else {
            com.ss.android.downloadlib.g.l.a().a(f21489a, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            b(bVar, 15, 20000, jSONObject);
        }
    }

    private l() {
    }

    public static l a() {
        return b.f21492a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        com.ss.android.downloadlib.g.l.a().a(f21489a, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.d.a().c(new a(bVar));
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, int i10, int i11, JSONObject jSONObject) {
        int f10;
        if (bVar.K() == 4) {
            f10 = k.j().optInt("market_install_finish_check_time", 600);
        } else {
            f10 = com.ss.android.downloadlib.g.e.f(bVar);
        }
        int i12 = ((f10 * 1000) / 20000) + 1;
        com.ss.android.downloadlib.g.l a10 = com.ss.android.downloadlib.g.l.a();
        String str = f21489a;
        a10.a(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:" + i12);
        if (b(bVar, i12, 20000, jSONObject)) {
            return;
        }
        if (f10 * 1000 < com.ss.android.downloadlib.g.e.g(bVar)) {
            com.ss.android.downloadlib.g.l.a().a(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (b(bVar, i10, i11, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.g.l.a().a(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.g.l.a().a(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean b(com.ss.android.downloadad.api.a.b bVar, int i10, int i11, JSONObject jSONObject) {
        com.ss.android.downloadlib.g.l.a().a(f21489a, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i11 + ",轮询次数为" + i10);
        long j10 = (long) i11;
        SystemClock.sleep(j10);
        while (i10 > 0) {
            if (com.ss.android.downloadlib.g.m.b(bVar)) {
                com.ss.android.downloadlib.a.a().a(bVar.e());
                com.ss.android.downloadlib.g.l.a().a(f21489a, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为" + i10);
                return true;
            }
            i10--;
            if (i10 == 0) {
                return false;
            }
            SystemClock.sleep(j10);
        }
        return false;
    }
}
