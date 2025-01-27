package com.aggmoread.sdk.z.a.f;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.a.d.a;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.k.c;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.b.u.f;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.k.a f4264l;

    /* renamed from: m */
    private a.C0052a.C0053a f4265m;

    /* renamed from: n */
    private com.aggmoread.sdk.z.a.d.a f4266n;

    /* renamed from: o */
    private com.aggmoread.sdk.z.b.s.a f4267o;

    /* renamed from: com.aggmoread.sdk.z.a.f.a$a */
    public class C0056a implements c.k {

        /* renamed from: a */
        final /* synthetic */ a.C0052a.C0053a f4268a;

        public C0056a(a.C0052a.C0053a c0053a) {
            this.f4268a = c0053a;
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void a() {
            if (a.this.f4264l != null) {
                a.this.f4264l.b(a.this);
            }
            com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4268a.f4168m, a.this.j(), String.valueOf(this.f4268a.f4157b)));
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void b() {
            if (a.this.f4264l != null) {
                a.this.f4264l.d(a.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void c() {
            a.this.k();
            if (a.this.f4264l != null) {
                a.this.f4264l.c(a.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void onRenderSuccess() {
            if (a.this.f4264l != null) {
                a.this.f4264l.a(a.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void a(String str) {
            if (a.this.f4264l != null) {
                a.this.f4264l.a(a.this, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, str));
            }
        }
    }

    public class b extends com.aggmoread.sdk.z.b.j.c {
        public b(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            d.c("AGEXPRESSTAG", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            d.c("AGEXPRESSTAG", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            d.c("AGEXPRESSTAG", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            d.c("AGEXPRESSTAG", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            d.c("AGEXPRESSTAG", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            d.c("AGEXPRESSTAG", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            d.c("AGEXPRESSTAG", "onDownloadFail  ");
        }
    }

    public a(com.aggmoread.sdk.z.a.d.a aVar, a.C0052a.C0053a c0053a, com.aggmoread.sdk.z.b.k.a aVar2) {
        super(aVar.d().k());
        this.f4264l = aVar2;
        this.f4265m = c0053a;
        this.f4266n = aVar;
        a(c0053a);
    }

    private void i() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f4265m.f4172q;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f4265m.a());
            return;
        }
        d.c("AGEXPRESSTAG", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    public com.aggmoread.sdk.z.b.g.c j() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f4267o;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    public void k() {
        String str;
        com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4265m.f4169n, j(), String.valueOf(this.f4265m.f4157b)));
        String str2 = this.f4265m.f4162g;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.f4265m.f4162g));
                intent.addFlags(268435456);
                this.f4266n.d().k().startActivity(intent);
                com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4265m.a(14), j(), String.valueOf(this.f4265m.f4157b)));
                d.c("AGEXPRESSTAG", "onStartAppSuccess");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof ActivityNotFoundException) {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4265m.a(11), j(), String.valueOf(this.f4265m.f4157b)));
                    str = "onAppNotExist";
                } else {
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4265m.a(12), j(), String.valueOf(this.f4265m.f4157b)));
                    com.aggmoread.sdk.z.a.a.a(com.aggmoread.sdk.z.a.b.a(this.f4265m.a(13), j(), String.valueOf(this.f4265m.f4157b)));
                    str = "onStartAppFailed";
                }
                d.c("AGEXPRESSTAG", str);
            }
        }
        if (this.f4265m.c()) {
            if (TextUtils.isEmpty(this.f4265m.B)) {
                i();
            }
        } else {
            try {
                l();
            } catch (f e11) {
                e11.printStackTrace();
            }
        }
    }

    private void l() {
        String a10 = this.f4265m.a();
        if (TextUtils.isEmpty(a10)) {
            this.f4264l.a(new e(50008, "跳转地址异常"));
            return;
        }
        d.c("AGEXPRESSTAG", "startWebActivity = " + a10);
        com.aggmoread.sdk.z.a.b.a(a10, j(), String.valueOf(this.f4265m.f4157b));
        d.c("AGEXPRESSTAG", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f4266n.d().k(), this.f4265m.f4158c, a10, c.a.f5043a);
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public View a() {
        View a10 = super.a();
        this.f4267o = com.aggmoread.sdk.z.b.s.a.a(a10, null);
        return a10;
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public int b() {
        return (int) this.f4265m.f4157b;
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public String c() {
        return this.f4265m.f4158c;
    }

    private void a(a.C0052a.C0053a c0053a) {
        if (c0053a != null) {
            g gVar = new g();
            gVar.f4505a = c0053a.b();
            gVar.f4509e = c0053a.f4159d;
            gVar.f4508d = c0053a.f4158c;
            a(gVar);
        }
        a(new C0056a(c0053a));
    }

    private void b(String str) {
        try {
            a.C0052a.C0053a c0053a = this.f4265m;
            new com.aggmoread.sdk.z.b.j.b(this.f4266n.d().k(), this.f4266n.d().j(), new b(this)).a(str, c0053a.f4172q, c0053a.f4158c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
