package com.aggmoread.sdk.z.d.a.a.d.a.d.q.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.d.a.a.d.a.d.j;
import com.aggmoread.sdk.z.d.a.a.d.a.d.q.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends j {

    /* renamed from: x */
    private SplashAd f5516x;

    /* renamed from: y */
    private AtomicBoolean f5517y;

    /* renamed from: z */
    private AtomicBoolean f5518z;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.i.a$a */
    public class C0139a implements c.k {
        public C0139a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void a() {
            e.b("AMSTAGBD", "onAdDismissed");
            a.this.r();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void b() {
            e.b("AMSTAGBD", "onAdCacheFailed");
            a.this.b(new i(-1000, "广告素材加载失败！"));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void c() {
            e.b("AMSTAGBD", "onLpClosed");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void d() {
            e.b("AMSTAGBD", "onAdCacheSuccess");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void e() {
            e.b("AMSTAGBD", "onAdSkip");
            a.this.t();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void f() {
            e.b("AMSTAGBD", "onADLoaded");
            int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) a.this.f5516x);
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a.this.f5843h, a10)) {
                a.this.a(a10, 0);
                return;
            }
            a.this.b(a10);
            a aVar = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(aVar.f5841f, a10, aVar.f5843h);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            a.this.e(arrayList);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void g() {
            e.b("AMSTAGBD", "onAdPresent");
            if (a.this.f5518z.compareAndSet(false, true)) {
                a.this.s();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void onAdClick() {
            e.b("AMSTAGBD", IAdInterListener.AdCommandType.AD_CLICK);
            a.this.q();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void onAdExposed() {
            e.b("AMSTAGBD", "onAdExposed");
            if (a.this.f5518z.compareAndSet(false, true)) {
                a.this.s();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.k
        public void onAdFailed(String str) {
            a.this.b(new i(-1000, str));
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5517y = new AtomicBoolean();
        this.f5518z = new AtomicBoolean();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5516x, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        e.c("win " + i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5516x, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a().a(this.f5516x);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(View view) {
        this.f5378r = false;
        String a10 = this.f5843h.f5907c.a(e.c.X, "");
        Context a11 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5842g, this.f5843h, this.f5846k);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a11.getApplicationContext(), a10);
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.f5842g.f5868n));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "false");
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(builder, this.f5842g, this.f5843h);
        SplashAd splashAd = new SplashAd(a11.getApplicationContext(), this.f5843h.f5907c.c(e.c.T), builder.build(), c.a().a(new C0139a()));
        this.f5516x = splashAd;
        splashAd.setAppSid(a10);
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5516x.load();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void b(ViewGroup viewGroup) {
        if (viewGroup == null || this.f5516x == null || !this.f5517y.compareAndSet(false, true)) {
            return;
        }
        a(viewGroup, this.f5516x);
    }

    private void a(ViewGroup viewGroup, SplashAd splashAd) {
        if (splashAd != null) {
            splashAd.show(viewGroup);
        }
    }
}
