package com.aggmoread.sdk.z.a.g;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.a.d.a;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.o.a;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.c.e.a;

/* loaded from: classes.dex */
public class a implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.a.d.a f4270a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.c f4271b;

    /* renamed from: c */
    private a.C0052a.C0053a f4272c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f4273d;

    /* renamed from: e */
    private Activity f4274e;

    /* renamed from: f */
    private Context f4275f;

    /* renamed from: h */
    private String f4277h;

    /* renamed from: i */
    private com.aggmoread.sdk.z.c.e.a f4278i;

    /* renamed from: j */
    private boolean f4279j;

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.o.a f4281l;

    /* renamed from: g */
    private boolean f4276g = false;

    /* renamed from: k */
    private int f4280k = -1;

    /* renamed from: m */
    private a.b f4282m = new d();

    /* renamed from: com.aggmoread.sdk.z.a.g.a$a */
    public class C0057a implements a.d {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.c f4283a;

        public C0057a(com.aggmoread.sdk.z.b.s.c cVar, a.C0052a.C0053a c0053a) {
            this.f4283a = cVar;
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a() {
            a.this.g();
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(int i10, String str) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4283a, new e(i10, str));
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(Activity activity) {
            a.this.a(activity);
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(com.aggmoread.sdk.z.b.s.a aVar) {
            a.this.f4273d = aVar;
            a.this.i();
            a.this.h();
        }
    }

    public class b implements c.a {
        public b(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.u.c.a
        public void onShow() {
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "web show");
        }
    }

    public class c extends com.aggmoread.sdk.z.b.j.c {
        public c(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onDownloadFail  ");
        }
    }

    public class d implements a.b {

        /* renamed from: com.aggmoread.sdk.z.a.g.a$d$a */
        public class RunnableC0058a implements Runnable {
            public RunnableC0058a() {
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
            if (a.this.f4278i != null) {
                a.this.f4278i.a();
                a.this.f4278i = null;
            }
            n.a().postDelayed(new RunnableC0058a(), 1000L);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            a.this.f4279j = true;
        }
    }

    private void b(Activity activity) {
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "showAD enter ");
        if (activity == null) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4271b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败,Activity缺失!"));
            return;
        }
        try {
            com.aggmoread.sdk.z.b.u.a.a(this.f4281l);
            com.aggmoread.sdk.z.b.u.a.a(activity, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.a.h.a.a(this.f4271b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败!"));
        }
    }

    private com.aggmoread.sdk.z.b.g.c e() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f4273d;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    private void f() {
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onAdClick = " + e());
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4272c.f4169n, e(), String.valueOf(this.f4272c.f4157b)));
        this.f4271b.onAdClicked();
    }

    public void g() {
        this.f4271b.a();
    }

    public void h() {
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4272c.f4168m, e(), String.valueOf(this.f4272c.f4157b)));
        this.f4271b.d();
    }

    public void i() {
        this.f4271b.onAdShow();
    }

    private void j() {
        String str = this.f4277h;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4271b, e.f4497g);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.a.b.a(str, e(), String.valueOf(this.f4272c.f4157b));
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f4274e, this.f4272c.f4158c, a10, new b(this));
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        a.C0052a.C0053a c0053a = this.f4272c;
        if (c0053a == null) {
            return null;
        }
        a.C0052a.C0053a.C0054a c0054a = c0053a.f4171p;
        return (c0054a == null || TextUtils.isEmpty(c0054a.f4183b)) ? TextUtils.isEmpty(this.f4272c.f4158c) ? this.f4272c.f4159d : this.f4272c.f4158c : this.f4272c.f4171p.f4183b;
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return this.f4280k;
    }

    public void a() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f4272c.f4172q;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f4272c.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    private void b(String str) {
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "DL");
        a(str);
    }

    public void a(Activity activity) {
        String str;
        f();
        if (!TextUtils.isEmpty(this.f4272c.B)) {
            com.aggmoread.sdk.z.c.e.a aVar = new com.aggmoread.sdk.z.c.e.a(this.f4282m);
            this.f4278i = aVar;
            aVar.a(this.f4274e, this.f4272c.B);
        }
        if (com.aggmoread.sdk.z.b.m.a.a(this.f4274e)) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4271b, e.f4493c);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "metaGroupBean.deeplink = " + this.f4272c.f4162g);
        String str2 = this.f4272c.f4162g;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            try {
                intent.setData(Uri.parse(this.f4272c.f4162g));
                if (activity != null) {
                    activity.startActivity(intent);
                } else {
                    this.f4270a.d().k().startActivity(intent);
                }
                com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "onAppStartSuccess");
                com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4272c.a(14), e(), String.valueOf(this.f4272c.f4157b)));
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof ActivityNotFoundException) {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4272c.a(11), e(), String.valueOf(this.f4272c.f4157b)));
                    str = "onAppNotExist";
                } else {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4272c.a(12), e(), String.valueOf(this.f4272c.f4157b)));
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4272c.a(13), e(), String.valueOf(this.f4272c.f4157b)));
                    str = "onStartAppFailed";
                }
                com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", str);
            }
        }
        if (!this.f4272c.c()) {
            j();
            return;
        }
        if (TextUtils.isEmpty(this.f4272c.B)) {
            a();
            return;
        }
        if (this.f4278i == null) {
            com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "DL s");
            com.aggmoread.sdk.z.c.e.a aVar2 = new com.aggmoread.sdk.z.c.e.a(this.f4282m);
            this.f4278i = aVar2;
            aVar2.a(activity, this.f4272c.B);
        }
        this.f4278i.a(activity, (View) null);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        return a(this.f4274e, (ViewGroup) null);
    }

    public void a(com.aggmoread.sdk.z.a.d.a aVar, com.aggmoread.sdk.z.b.s.c cVar) {
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "handle   enter");
        this.f4270a = aVar;
        this.f4271b = cVar;
        this.f4274e = aVar.d().d();
        Context k10 = aVar.d().k();
        this.f4275f = k10;
        if (this.f4274e == null && (k10 instanceof Activity)) {
            this.f4274e = (Activity) k10;
        }
        a.C0052a.C0053a a10 = aVar.f4153e.a();
        if (a10 == null) {
            com.aggmoread.sdk.z.a.h.a.a(cVar, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
            return;
        }
        this.f4272c = a10;
        this.f4280k = (int) a10.f4157b;
        this.f4277h = a10.a();
        com.aggmoread.sdk.z.b.d.c("AgInterHandler_dsp", "clickUrl = " + this.f4277h);
        g gVar = new g();
        gVar.f4505a = a10.b();
        gVar.f4508d = a10.f4158c;
        gVar.f4509e = a10.f4159d;
        a.C0052a.C0053a.d dVar = this.f4272c.f4170o;
        if (dVar != null) {
            gVar.f4506b = dVar.f4204a;
            gVar.f4508d = TextUtils.isEmpty(dVar.f4222s) ? this.f4272c.f4158c : dVar.f4222s;
            gVar.f4509e = TextUtils.isEmpty(dVar.f4217n) ? this.f4272c.f4159d : dVar.f4217n;
            if (!TextUtils.isEmpty(dVar.f4218o)) {
                this.f4277h = dVar.f4218o;
            }
        }
        com.aggmoread.sdk.z.b.o.a aVar2 = new com.aggmoread.sdk.z.b.o.a();
        this.f4281l = aVar2;
        aVar2.a(gVar);
        this.f4276g = true;
        com.aggmoread.sdk.z.b.s.c cVar2 = this.f4271b;
        if (cVar2 != null) {
            cVar2.a(this);
        }
        this.f4281l.a(new C0057a(cVar, a10));
        if (aVar.d().t()) {
            return;
        }
        b(this.f4274e);
    }

    private void a(String str) {
        try {
            a.C0052a.C0053a c0053a = this.f4272c;
            new com.aggmoread.sdk.z.b.j.b(this.f4275f.getApplicationContext(), this.f4270a.d().j(), new c(this)).a(str, c0053a.f4172q, c0053a.f4158c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4270a.d().t() || !this.f4276g) {
            return false;
        }
        b(activity);
        return true;
    }
}
