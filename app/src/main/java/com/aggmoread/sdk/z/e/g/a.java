package com.aggmoread.sdk.z.e.g;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.k.c;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.b.u.f;
import com.aggmoread.sdk.z.e.e.a;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.k.a f6221l;

    /* renamed from: m */
    private a.C0192a.C0193a f6222m;

    /* renamed from: n */
    private com.aggmoread.sdk.z.e.e.a f6223n;

    /* renamed from: com.aggmoread.sdk.z.e.g.a$a */
    public class C0196a implements c.k {

        /* renamed from: a */
        final /* synthetic */ a.C0192a.C0193a f6224a;

        public C0196a(a.C0192a.C0193a c0193a) {
            this.f6224a = c0193a;
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void a() {
            if (a.this.f6221l != null) {
                a.this.f6221l.b(a.this);
            }
            com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6224a.f6177m, new BigDecimal(this.f6224a.f6166b)));
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void b() {
            if (a.this.f6221l != null) {
                a.this.f6221l.d(a.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void c() {
            a.this.j();
            if (a.this.f6221l != null) {
                a.this.f6221l.c(a.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void onRenderSuccess() {
            if (a.this.f6221l != null) {
                a.this.f6221l.a(a.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void a(String str) {
            if (a.this.f6221l != null) {
                a.this.f6221l.a(a.this, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, str));
            }
        }
    }

    public class b extends com.aggmoread.sdk.z.b.j.c {
        public b(a aVar) {
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a() {
            super.a();
            d.c("RSEXPRESSTAG", "apkIsDownLoading  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b() {
            super.b();
            d.c("RSEXPRESSTAG", "onStartDownload  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void c(long j10) {
            super.c(j10);
            d.c("RSEXPRESSTAG", "onStartApkInstaller  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10) {
            super.a(j10);
            d.c("RSEXPRESSTAG", "onApkInstalled  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10) {
            super.b(j10);
            d.c("RSEXPRESSTAG", "onDownloadSuccess  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void a(long j10, int i10, String str) {
            super.a(j10, i10, str);
            d.c("RSEXPRESSTAG", "onApkInstalledError  ");
        }

        @Override // com.aggmoread.sdk.z.b.j.c
        public void b(long j10, int i10, String str) {
            super.b(j10, i10, str);
            d.c("RSEXPRESSTAG", "onDownloadFail  ");
        }
    }

    public a(com.aggmoread.sdk.z.e.e.a aVar, a.C0192a.C0193a c0193a, com.aggmoread.sdk.z.b.k.a aVar2) {
        super(aVar.d().k());
        this.f6221l = aVar2;
        this.f6222m = c0193a;
        this.f6223n = aVar;
        a(c0193a);
    }

    private void i() {
        Intent a10;
        Context a11 = com.aggmoread.sdk.z.b.h.a.d().a();
        String str = this.f6222m.f6180p;
        if (!com.aggmoread.sdk.z.b.m.d.c(a11, str) || (a10 = com.aggmoread.sdk.z.b.m.d.a(a11, str)) == null) {
            b(this.f6222m.a());
            return;
        }
        d.c("RSEXPRESSTAG", "intent = " + a10);
        a10.addFlags(268435456);
        a11.startActivity(a10);
    }

    public void j() {
        com.aggmoread.sdk.z.e.c.a(com.aggmoread.sdk.z.e.b.a(this.f6222m.f6178n, new BigDecimal(this.f6222m.f6166b)));
        String str = this.f6222m.f6171g;
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                String str2 = this.f6222m.f6180p;
                boolean c10 = !TextUtils.isEmpty(str2) ? com.aggmoread.sdk.z.b.m.d.c(this.f6223n.d().k(), str2) : true;
                d.c("RSEXPRESSTAG", "isInstalled " + c10 + ", packageName = " + str2);
                if (c10) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(this.f6222m.f6171g));
                    intent.addFlags(268435456);
                    this.f6223n.d().k().startActivity(intent);
                    d.c("RSEXPRESSTAG", "onStartAppSuccess");
                    return;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                d.c("RSEXPRESSTAG", e10 instanceof ActivityNotFoundException ? "onAppNotExist" : "onStartAppFailed");
            }
        }
        if (this.f6222m.c()) {
            if (TextUtils.isEmpty(this.f6222m.f6181q)) {
                i();
            }
        } else {
            try {
                k();
            } catch (f e11) {
                e11.printStackTrace();
            }
        }
    }

    private void k() {
        String a10 = this.f6222m.a();
        if (TextUtils.isEmpty(a10)) {
            this.f6221l.a(new e(50008, "跳转地址异常"));
            return;
        }
        d.c("RSEXPRESSTAG", "startWebActivity final = " + a10);
        com.aggmoread.sdk.z.b.u.c.a(this.f6223n.d().k(), this.f6222m.f6167c, a10, c.a.f5043a);
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public int b() {
        return this.f6222m.f6166b;
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public String c() {
        return this.f6222m.f6167c;
    }

    private void a(a.C0192a.C0193a c0193a) {
        if (c0193a != null) {
            g gVar = new g();
            gVar.f4505a = c0193a.b();
            gVar.f4509e = c0193a.f6168d;
            gVar.f4508d = c0193a.f6167c;
            a(gVar);
        }
        a(new C0196a(c0193a));
    }

    private void b(String str) {
        try {
            a.C0192a.C0193a c0193a = this.f6222m;
            new com.aggmoread.sdk.z.b.j.b(this.f6223n.d().k(), this.f6223n.d().j(), new b(this)).a(str, c0193a.f6180p, c0193a.f6167c);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
