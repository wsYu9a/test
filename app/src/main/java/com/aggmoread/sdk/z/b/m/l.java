package com.aggmoread.sdk.z.b.m;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.s.h;
import com.aggmoread.sdk.z.b.u.c;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    public static class a extends h.c {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.c f4717a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4718b;

        /* renamed from: c */
        final /* synthetic */ b.a.C0072a f4719c;

        /* renamed from: d */
        final /* synthetic */ c f4720d;

        public a(com.aggmoread.sdk.z.b.g.c cVar, com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, c cVar2) {
            this.f4717a = cVar;
            this.f4718b = bVar;
            this.f4719c = c0072a;
            this.f4720d = cVar2;
        }

        @Override // com.aggmoread.sdk.z.b.s.h.c
        public void a(h.b bVar) {
            if (bVar.a()) {
                com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "ClickUrlRequestJuHeApi onResult enter, empty");
                return;
            }
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "ClickUrlRequestJuHeApi onResult enter, clickUrlResponse = " + bVar);
            com.aggmoread.sdk.z.b.g.c cVar = this.f4717a;
            cVar.f4477i = bVar.f4901a;
            l.b(bVar.f4902b, this.f4718b, this.f4719c, cVar);
            c cVar2 = this.f4720d;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    public static class b extends com.aggmoread.sdk.z.b.j.c {

        /* renamed from: b */
        final /* synthetic */ b.a.C0072a f4721b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.c f4722c;

        public b(b.a.C0072a c0072a, com.aggmoread.sdk.z.b.g.c cVar) {
            this.f4721b = c0072a;
            this.f4722c = cVar;
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onStartDownload  ");
            com.aggmoread.sdk.z.b.q.a.a("onStartDownload", this.f4721b.f4456l, this.f4722c);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onStartApkInstaller  ");
            com.aggmoread.sdk.z.b.q.a.a("onStartApkInstaller", this.f4721b.c(), this.f4722c);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onApkInstalled  ");
            com.aggmoread.sdk.z.b.q.a.a("onApkInstalled", this.f4721b.d(), this.f4722c);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onDownloadSuccess  ");
            com.aggmoread.sdk.z.b.q.a.a("onDownloadCompleted", this.f4721b.b(), this.f4722c);
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onDownloadFail  ");
        }
    }

    public interface c {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public static void a(com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, com.aggmoread.sdk.z.b.g.c cVar, com.aggmoread.sdk.z.b.i.b bVar2) {
        a(bVar, c0072a, cVar, bVar2, null, null);
    }

    public static void b(String str, com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, com.aggmoread.sdk.z.b.g.c cVar) {
        try {
            new com.aggmoread.sdk.z.b.j.b(bVar.d().j().getApplicationContext(), bVar.d().i(), new b(c0072a, cVar)).a(str, c0072a.f4445a, c0072a.f4447c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static void a(com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, com.aggmoread.sdk.z.b.g.c cVar, com.aggmoread.sdk.z.b.i.b bVar2, c.a aVar) {
        String str = c0072a.f4446b;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.b.s.b.a(bVar2, new com.aggmoread.sdk.z.b.g.e(50008, "跳转地址异常"));
            return;
        }
        com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.b.q.a.a(str, cVar);
        com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "startWebActivity final = " + a10);
        Context j10 = bVar.d().j();
        String str2 = c0072a.f4447c;
        if (aVar == null) {
            aVar = c.a.f5043a;
        }
        com.aggmoread.sdk.z.b.u.c.a(j10, str2, a10, aVar);
    }

    public static void a(com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, com.aggmoread.sdk.z.b.g.c cVar, com.aggmoread.sdk.z.b.i.b bVar2, c.a aVar, c cVar2) {
        Intent a10;
        List<String> a11;
        String str;
        com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "metaGroupBean.deeplink = " + c0072a.f4448d);
        String str2 = c0072a.f4448d;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(c0072a.f4448d));
                intent.addFlags(268435456);
                if (bVar.d().e() != null) {
                    bVar.d().e().startActivity(intent);
                } else {
                    bVar.d().j().startActivity(intent);
                }
                com.aggmoread.sdk.z.b.q.a.a("onStartAppSuccess", c0072a.a(3), cVar);
                com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "onStartAppSuccess");
                if (cVar2 != null) {
                    cVar2.b();
                    return;
                }
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                com.aggmoread.sdk.z.b.d.a("JHAPIHTAG", "e %s", e10);
                if (e10 instanceof ActivityNotFoundException) {
                    a11 = c0072a.a(0);
                    str = "onAppNotExist";
                } else {
                    a11 = c0072a.a(2);
                    str = "onStartAppFailed";
                }
                com.aggmoread.sdk.z.b.q.a.a(str, a11, cVar);
                com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", str);
            }
        }
        if (!c0072a.r()) {
            try {
                a(bVar, c0072a, cVar, bVar2, aVar);
                if (cVar2 != null) {
                    cVar2.d();
                    return;
                }
                return;
            } catch (com.aggmoread.sdk.z.b.u.f e11) {
                e11.printStackTrace();
                return;
            }
        }
        Context applicationContext = bVar.d().j().getApplicationContext();
        String m10 = c0072a.m();
        if (d.c(applicationContext, m10) && (a10 = d.a(applicationContext, m10)) != null) {
            com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "intent = " + a10);
            a10.addFlags(268435456);
            applicationContext.startActivity(a10);
            if (cVar2 != null) {
                cVar2.e();
                return;
            }
            return;
        }
        if (c0072a.h() != 2) {
            b(c0072a.i(), bVar, c0072a, cVar);
            if (cVar2 != null) {
                cVar2.c();
                return;
            }
            return;
        }
        String a12 = com.aggmoread.sdk.z.b.q.a.a(c0072a.e(), cVar);
        com.aggmoread.sdk.z.b.d.c("JHAPIHTAG", "rClickUrl = " + a12);
        com.aggmoread.sdk.z.b.s.h.a(a12, new a(cVar, bVar, c0072a, cVar2));
    }
}
