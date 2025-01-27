package com.aggmoread.sdk.z.e.h;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.o.a;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.c.e.a;
import com.aggmoread.sdk.z.e.e.a;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class a implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.e.e.a f6226a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.c f6227b;

    /* renamed from: c */
    private a.C0192a.C0193a f6228c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f6229d;

    /* renamed from: e */
    private Activity f6230e;

    /* renamed from: f */
    private Context f6231f;

    /* renamed from: h */
    private String f6233h;

    /* renamed from: i */
    private com.aggmoread.sdk.z.c.e.a f6234i;

    /* renamed from: j */
    private boolean f6235j;

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.o.a f6237l;

    /* renamed from: g */
    private boolean f6232g = false;

    /* renamed from: k */
    private int f6236k = -1;

    /* renamed from: m */
    private a.b f6238m = new d();

    /* renamed from: com.aggmoread.sdk.z.e.h.a$a */
    public class C0197a implements a.d {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.c f6239a;

        public C0197a(com.aggmoread.sdk.z.b.s.c cVar) {
            this.f6239a = cVar;
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a() {
            a.this.g();
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(int i10, String str) {
            com.aggmoread.sdk.z.e.i.a.a(this.f6239a, new e(i10, str));
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(Activity activity) {
            a.this.a(activity);
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(com.aggmoread.sdk.z.b.s.a aVar) {
            a.this.f6229d = aVar;
            a.this.i();
            a.this.h();
        }
    }

    public class b implements c.a {
        public b(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.u.c.a
        public void onShow() {
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "web show");
        }
    }

    public class c extends com.aggmoread.sdk.z.b.j.c {
        public c(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onDownloadFail  ");
        }
    }

    public class d implements a.b {

        /* renamed from: com.aggmoread.sdk.z.e.h.a$d$a */
        public class RunnableC0198a implements Runnable {
            public RunnableC0198a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.g();
            }
        }

        public d() {
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void a() {
            a.this.a();
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void b() {
            if (a.this.f6234i != null) {
                a.this.f6234i.a();
                a.this.f6234i = null;
            }
            n.a().postDelayed(new RunnableC0198a(), 1000L);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            a.this.f6235j = true;
        }
    }

    private void b(Activity activity) {
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "showAD enter ");
        if (activity == null) {
            com.aggmoread.sdk.z.e.i.a.a(this.f6227b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败,Activity缺失!"));
            return;
        }
        try {
            com.aggmoread.sdk.z.b.u.a.a(this.f6237l);
            com.aggmoread.sdk.z.b.u.a.a(activity, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.e.i.a.a(this.f6227b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败!"));
        }
    }

    private com.aggmoread.sdk.z.b.g.c e() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f6229d;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    private void f() {
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onAdClick = " + e());
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6228c.f6178n, new BigDecimal(this.f6228c.f6166b)));
        this.f6227b.onAdClicked();
    }

    public void g() {
        this.f6227b.a();
    }

    public void h() {
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6228c.f6177m, new BigDecimal(this.f6228c.f6166b)));
        this.f6227b.d();
    }

    public void i() {
        this.f6227b.onAdShow();
    }

    private void j() {
        String str = this.f6233h;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.e.i.a.a(this.f6227b, e.f4497g);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.b.q.a.a(str, e());
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "startWebActivity final = " + a10);
        Context context = this.f6230e;
        if (context == null) {
            context = this.f6226a.d().k();
        }
        com.aggmoread.sdk.z.b.u.c.a(context, this.f6228c.f6167c, a10, new b(this));
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        a.C0192a.C0193a c0193a = this.f6228c;
        if (c0193a != null) {
            return TextUtils.isEmpty(c0193a.f6167c) ? this.f6228c.f6168d : this.f6228c.f6167c;
        }
        return null;
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return this.f6236k;
    }

    public void a() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f6228c.f6180p;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f6228c.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    private void b(String str) {
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "DL");
        a(str);
    }

    public void a(Activity activity) {
        f();
        if (!TextUtils.isEmpty(this.f6228c.f6181q)) {
            com.aggmoread.sdk.z.c.e.a aVar = new com.aggmoread.sdk.z.c.e.a(this.f6238m);
            this.f6234i = aVar;
            aVar.a(this.f6230e, this.f6228c.f6181q);
        }
        if (com.aggmoread.sdk.z.b.m.a.a(this.f6230e)) {
            com.aggmoread.sdk.z.e.i.a.a(this.f6227b, e.f4493c);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "metaGroupBean.deeplink = " + this.f6228c.f6171g);
        String str = this.f6228c.f6171g;
        if (str != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            try {
                String str2 = this.f6228c.f6180p;
                boolean c10 = !TextUtils.isEmpty(str2) ? com.aggmoread.sdk.z.b.m.d.c(this.f6226a.d().k(), str2) : true;
                com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "isInstalled " + c10 + ", packageName = " + str2);
                if (c10) {
                    intent.setData(Uri.parse(this.f6228c.f6171g));
                    if (activity != null) {
                        activity.startActivity(intent);
                    } else {
                        this.f6226a.d().k().startActivity(intent);
                    }
                    com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "onAppStartSuccess");
                    return;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", e10 instanceof ActivityNotFoundException ? "onAppNotExist" : "onStartAppFailed");
            }
        }
        if (!this.f6228c.c()) {
            j();
            return;
        }
        if (TextUtils.isEmpty(this.f6228c.f6181q)) {
            a();
            return;
        }
        if (this.f6234i == null) {
            com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "DL s");
            com.aggmoread.sdk.z.c.e.a aVar2 = new com.aggmoread.sdk.z.c.e.a(this.f6238m);
            this.f6234i = aVar2;
            aVar2.a(activity, this.f6228c.f6181q);
        }
        this.f6234i.a(activity, (View) null);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        return a(this.f6230e, (ViewGroup) null);
    }

    public void a(com.aggmoread.sdk.z.e.e.a aVar, com.aggmoread.sdk.z.b.s.c cVar) {
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "handle   enter");
        this.f6226a = aVar;
        this.f6227b = cVar;
        this.f6230e = aVar.d().d();
        Context k10 = aVar.d().k();
        this.f6231f = k10;
        if (this.f6230e == null && (k10 instanceof Activity)) {
            this.f6230e = (Activity) k10;
        }
        a.C0192a.C0193a a10 = aVar.f6163g.a();
        if (a10 == null) {
            com.aggmoread.sdk.z.e.i.a.a(cVar, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
            return;
        }
        this.f6228c = a10;
        this.f6236k = a10.f6166b;
        this.f6233h = a10.a();
        com.aggmoread.sdk.z.b.d.c("RsInterHandler_dsp", "clickUrl = " + this.f6233h);
        g gVar = new g();
        gVar.f4505a = a10.b();
        gVar.f4508d = a10.f6167c;
        gVar.f4509e = a10.f6168d;
        com.aggmoread.sdk.z.b.o.a aVar2 = new com.aggmoread.sdk.z.b.o.a();
        this.f6237l = aVar2;
        aVar2.a(gVar);
        this.f6232g = true;
        com.aggmoread.sdk.z.b.s.c cVar2 = this.f6227b;
        if (cVar2 != null) {
            cVar2.a(this);
        }
        this.f6237l.a(new C0197a(cVar));
        if (aVar.d().r()) {
            return;
        }
        b(this.f6230e);
    }

    private void a(String str) {
        try {
            a.C0192a.C0193a c0193a = this.f6228c;
            new com.aggmoread.sdk.z.b.j.b(this.f6231f.getApplicationContext(), this.f6226a.d().j(), new c(this)).a(str, c0193a.f6180p, c0193a.f6167c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f6226a.d().r() || !this.f6232g) {
            return false;
        }
        b(activity);
        return true;
    }
}
