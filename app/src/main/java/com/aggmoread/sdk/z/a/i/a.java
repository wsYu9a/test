package com.aggmoread.sdk.z.a.i;

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
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.t.c;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.c.e.a;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.a.d.a f4314a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.s.d f4315b;

    /* renamed from: c */
    private a.C0052a.C0053a f4316c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f4317d;

    /* renamed from: e */
    private Activity f4318e;

    /* renamed from: f */
    private Context f4319f;

    /* renamed from: h */
    private String f4321h;

    /* renamed from: i */
    private com.aggmoread.sdk.z.c.e.a f4322i;

    /* renamed from: j */
    private boolean f4323j;

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.r.a f4325l;

    /* renamed from: g */
    private boolean f4320g = false;

    /* renamed from: k */
    private int f4324k = -1;

    /* renamed from: m */
    private a.b f4326m = new d();

    /* renamed from: com.aggmoread.sdk.z.a.i.a$a */
    public class C0062a implements c.b {

        /* renamed from: a */
        private boolean f4327a = false;

        /* renamed from: b */
        private boolean f4328b = false;

        /* renamed from: c */
        private boolean f4329c = false;

        /* renamed from: d */
        final /* synthetic */ a.C0052a.C0053a f4330d;

        /* renamed from: e */
        final /* synthetic */ com.aggmoread.sdk.z.b.s.d f4331e;

        public C0062a(a.C0052a.C0053a c0053a, com.aggmoread.sdk.z.b.s.d dVar) {
            this.f4330d = c0053a;
            this.f4331e = dVar;
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a() {
            a.this.g();
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void b() {
            com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4330d.b(8), a.this.e(), String.valueOf(this.f4330d.f4157b)));
            com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4330d.b(9), a.this.e(), String.valueOf(this.f4330d.f4157b)));
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void c() {
            com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4330d.b(9), a.this.e(), String.valueOf(this.f4330d.f4157b)));
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void d() {
            a.this.h();
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void onVideoCached() {
            com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4330d.b(10), a.this.e(), String.valueOf(this.f4330d.f4157b)));
            com.aggmoread.sdk.z.b.s.d dVar = this.f4331e;
            if (dVar != null) {
                dVar.onVideoCached();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void onVideoComplete() {
            a.this.j();
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(float f10) {
            a.C0052a.C0053a c0053a;
            int i10;
            double d10 = f10;
            if (d10 >= 0.25d && !this.f4327a) {
                this.f4327a = true;
                c0053a = this.f4330d;
                i10 = 2;
            } else if (d10 >= 0.5d && !this.f4328b) {
                this.f4328b = true;
                c0053a = this.f4330d;
                i10 = 3;
            } else {
                if (d10 < 0.75d || this.f4329c) {
                    return;
                }
                this.f4329c = true;
                c0053a = this.f4330d;
                i10 = 4;
            }
            com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(c0053a.b(i10), a.this.e(), String.valueOf(this.f4330d.f4157b)));
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(Activity activity) {
            a.this.a(activity);
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(com.aggmoread.sdk.z.b.s.a aVar) {
            a.this.f4317d = aVar;
            a.this.i();
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(String str) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4331e, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, str));
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(Map<String, Object> map) {
            a.this.a(map);
        }
    }

    public class b implements c.a {
        public b(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.u.c.a
        public void onShow() {
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "web show");
        }
    }

    public class c extends com.aggmoread.sdk.z.b.j.c {
        public c(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onDownloadFail  ");
        }
    }

    public class d implements a.b {

        /* renamed from: com.aggmoread.sdk.z.a.i.a$d$a */
        public class RunnableC0063a implements Runnable {
            public RunnableC0063a() {
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
            if (a.this.f4322i != null) {
                a.this.f4322i.a();
                a.this.f4322i = null;
            }
            n.a().postDelayed(new RunnableC0063a(), 1000L);
        }

        @Override // com.aggmoread.sdk.z.c.e.a.b
        public void onRenderSuccess() {
            a.this.f4323j = true;
        }
    }

    private void b(Activity activity) {
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "showAD enter ");
        if (activity == null) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4315b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败,Activity缺失!"));
            return;
        }
        try {
            com.aggmoread.sdk.z.b.u.b.a(this.f4325l);
            com.aggmoread.sdk.z.b.u.b.a(activity, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.a.h.a.a(this.f4315b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败!"));
        }
    }

    public com.aggmoread.sdk.z.b.g.c e() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f4317d;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    public void g() {
        this.f4315b.a();
    }

    public void h() {
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.f4168m, e(), String.valueOf(this.f4316c.f4157b)));
        this.f4315b.d();
    }

    public void i() {
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.b(1), e(), String.valueOf(this.f4316c.f4157b)));
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.b(6), e(), String.valueOf(this.f4316c.f4157b)));
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.b(7), e(), String.valueOf(this.f4316c.f4157b)));
        this.f4315b.onAdShow();
    }

    public void j() {
        this.f4315b.onVideoCompleted();
    }

    private void k() {
        String str = this.f4321h;
        if (TextUtils.isEmpty(str)) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4315b, e.f4497g);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "startWebActivity = " + str);
        String a10 = com.aggmoread.sdk.z.a.b.a(str, e(), String.valueOf(this.f4316c.f4157b));
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f4318e, this.f4316c.f4158c, a10, new b(this));
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        a.C0052a.C0053a c0053a = this.f4316c;
        if (c0053a == null) {
            return null;
        }
        a.C0052a.C0053a.C0054a c0054a = c0053a.f4171p;
        return (c0054a == null || TextUtils.isEmpty(c0054a.f4183b)) ? TextUtils.isEmpty(this.f4316c.f4158c) ? this.f4316c.f4159d : this.f4316c.f4158c : this.f4316c.f4171p.f4183b;
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return this.f4324k;
    }

    private void f() {
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onAdClick = " + e());
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.f4169n, e(), String.valueOf(this.f4316c.f4157b)));
        this.f4315b.onAdClicked();
    }

    private void b(String str) {
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "DL");
        a(str);
    }

    public void a() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f4316c.f4172q;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f4316c.a());
            return;
        }
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        return a(this.f4318e, (ViewGroup) null);
    }

    public void a(Activity activity) {
        String str;
        f();
        if (!TextUtils.isEmpty(this.f4316c.B)) {
            com.aggmoread.sdk.z.c.e.a aVar = new com.aggmoread.sdk.z.c.e.a(this.f4326m);
            this.f4322i = aVar;
            aVar.a(this.f4318e, this.f4316c.B);
        }
        if (com.aggmoread.sdk.z.b.m.a.a(this.f4318e)) {
            com.aggmoread.sdk.z.a.h.a.a(this.f4315b, e.f4493c);
            return;
        }
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "metaGroupBean.deeplink = " + this.f4316c.f4162g);
        String str2 = this.f4316c.f4162g;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            try {
                intent.setData(Uri.parse(this.f4316c.f4162g));
                if (activity != null) {
                    activity.startActivity(intent);
                } else {
                    this.f4314a.d().k().startActivity(intent);
                }
                com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "onAppStartSuccess");
                com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.a(14), e(), String.valueOf(this.f4316c.f4157b)));
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof ActivityNotFoundException) {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.a(11), e(), String.valueOf(this.f4316c.f4157b)));
                    str = "onAppNotExist";
                } else {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.a(12), e(), String.valueOf(this.f4316c.f4157b)));
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4316c.a(13), e(), String.valueOf(this.f4316c.f4157b)));
                    str = "onStartAppFailed";
                }
                com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", str);
            }
        }
        if (!this.f4316c.c()) {
            k();
            return;
        }
        if (TextUtils.isEmpty(this.f4316c.B)) {
            a();
            return;
        }
        if (this.f4322i == null) {
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "DL s");
            com.aggmoread.sdk.z.c.e.a aVar2 = new com.aggmoread.sdk.z.c.e.a(this.f4326m);
            this.f4322i = aVar2;
            aVar2.a(activity, this.f4316c.B);
        }
        this.f4322i.a(activity, (View) null);
    }

    public void a(com.aggmoread.sdk.z.a.d.a aVar, com.aggmoread.sdk.z.b.s.d dVar) {
        e eVar;
        com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "handle   enter");
        this.f4314a = aVar;
        this.f4315b = dVar;
        this.f4318e = aVar.d().d();
        Context k10 = aVar.d().k();
        this.f4319f = k10;
        if (this.f4318e == null && (k10 instanceof Activity)) {
            this.f4318e = (Activity) k10;
        }
        a.C0052a.C0053a a10 = aVar.f4153e.a();
        if (a10 != null) {
            this.f4316c = a10;
            this.f4324k = (int) a10.f4157b;
            this.f4321h = a10.a();
            com.aggmoread.sdk.z.b.d.c("AgRewardHandler_dsp", "clickUrl = " + this.f4321h);
            a.C0052a.C0053a.d dVar2 = this.f4316c.f4170o;
            if (dVar2 != null) {
                com.aggmoread.sdk.z.b.t.d dVar3 = new com.aggmoread.sdk.z.b.t.d();
                dVar3.f4944b = dVar2.f4204a;
                dVar3.f4947e = TextUtils.isEmpty(dVar2.f4221r) ? this.f4316c.f4160e : dVar2.f4221r;
                dVar3.f4945c = TextUtils.isEmpty(dVar2.f4222s) ? this.f4316c.f4158c : dVar2.f4222s;
                dVar3.f4946d = TextUtils.isEmpty(dVar2.f4217n) ? this.f4316c.f4159d : dVar2.f4217n;
                dVar3.f4952j = TextUtils.isEmpty(dVar2.f4215l) ? dVar2.f4205b : dVar2.f4215l;
                dVar3.f4948f = dVar2.f4212i;
                dVar3.f4949g = dVar2.f4213j;
                if (!TextUtils.isEmpty(dVar2.f4218o)) {
                    this.f4321h = dVar2.f4218o;
                }
                com.aggmoread.sdk.z.b.r.a aVar2 = new com.aggmoread.sdk.z.b.r.a();
                this.f4325l = aVar2;
                aVar2.a(dVar3);
                this.f4320g = true;
                com.aggmoread.sdk.z.b.s.d dVar4 = this.f4315b;
                if (dVar4 != null) {
                    dVar4.a(this);
                }
                this.f4325l.a(new C0062a(a10, dVar));
                if (aVar.d().t()) {
                    this.f4325l.a(this.f4318e, dVar3.f4944b);
                    return;
                } else {
                    b(this.f4318e);
                    return;
                }
            }
            eVar = new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "暂无视频广告素材，广告加载失败!");
        } else {
            eVar = new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常");
        }
        com.aggmoread.sdk.z.a.h.a.a(dVar, eVar);
    }

    private void a(String str) {
        try {
            a.C0052a.C0053a c0053a = this.f4316c;
            new com.aggmoread.sdk.z.b.j.b(this.f4319f.getApplicationContext(), this.f4314a.d().j(), new c(this)).a(str, c0053a.f4172q, c0053a.f4158c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(Map<String, Object> map) {
        this.f4315b.onReward(map);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4314a.d().t() || !this.f4320g) {
            return false;
        }
        b(activity);
        return true;
    }
}
