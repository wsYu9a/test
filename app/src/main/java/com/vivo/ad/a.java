package com.vivo.ad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.cdo.oaps.ad.OapsKey;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.q;
import com.vivo.ad.model.r;
import com.vivo.ad.model.v;
import com.vivo.ic.SystemUtils;
import com.vivo.mobilead.BaseAdParams;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.util.a;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.c0;
import com.vivo.mobilead.util.f0;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.w0;
import com.vivo.mobilead.util.x;
import com.vivo.mobilead.util.x0;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    protected String f26534a;

    /* renamed from: b */
    protected Context f26535b;

    /* renamed from: c */
    protected String f26536c;

    /* renamed from: d */
    protected String f26537d;

    /* renamed from: e */
    protected String f26538e;

    /* renamed from: f */
    protected int f26539f = 1;

    /* renamed from: g */
    private volatile boolean f26540g = true;

    /* renamed from: h */
    protected BackUrlInfo f26541h;

    /* renamed from: i */
    protected int f26542i;

    /* renamed from: j */
    protected com.vivo.mobilead.g.b f26543j;
    protected String k;
    protected int l;
    private int m;

    class f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f26563a;

        /* renamed from: b */
        final /* synthetic */ int f26564b;

        /* renamed from: c */
        final /* synthetic */ int f26565c;

        /* renamed from: d */
        final /* synthetic */ int f26566d;

        /* renamed from: e */
        final /* synthetic */ String f26567e;

        /* renamed from: f */
        final /* synthetic */ int f26568f;

        /* renamed from: g */
        final /* synthetic */ String f26569g;

        f(com.vivo.ad.model.b bVar, int i2, int i3, int i4, String str, int i5, String str2) {
            this.f26563a = bVar;
            this.f26564b = i2;
            this.f26565c = i3;
            this.f26566d = i4;
            this.f26567e = str;
            this.f26568f = i5;
            this.f26569g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f26563a == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "215");
            hashMap.put("ptype", String.valueOf(a.this.c()));
            hashMap.put("id", this.f26563a.d());
            hashMap.put(OapsKey.KEY_TOKEN, this.f26563a.P());
            hashMap.put("renderType", String.valueOf(this.f26563a.a().a()));
            if (this.f26563a.Q() != null) {
                hashMap.put("materialids", this.f26563a.Q().f());
                hashMap.put("scene", String.valueOf(this.f26564b));
                hashMap.put("dfrom", String.valueOf(this.f26565c));
            } else {
                com.vivo.ad.model.f f2 = this.f26563a.f();
                if (f2 != null) {
                    hashMap.put("materialids", f2.f());
                }
            }
            hashMap.put("status", String.valueOf(this.f26566d));
            hashMap.put("dspid", String.valueOf(this.f26563a.q()));
            if (!SystemUtils.isVivoPhone() && this.f26563a.y() != null && !TextUtils.isEmpty(this.f26563a.y().a())) {
                hashMap.put("install_status", String.valueOf(f0.a(a.this.f26535b, this.f26563a.y().a())));
            }
            if (1 == this.f26566d) {
                hashMap.put("reason", this.f26567e);
                hashMap.put("errCode", String.valueOf(this.f26568f));
                r z = this.f26563a.z();
                hashMap.put("deeplinkUrl", z != null ? z.b() : "");
            }
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(this.f26563a.G());
            cVar.e(this.f26569g);
            a.this.a(cVar);
        }
    }

    public interface g {
        void a();

        void a(int i2, String str);
    }

    public a(Context context, BaseAdParams baseAdParams) {
        this.f26535b = context;
        this.f26536c = baseAdParams.getPositionId();
        this.f26534a = baseAdParams.getWxAppId();
        this.f26537d = baseAdParams.getSourceAppend();
        x0.e("BaseAd", "mSourceAppend:" + this.f26537d);
        this.f26541h = baseAdParams.getBackUrlInfo();
        this.l = baseAdParams.getAdCount();
        this.m = baseAdParams.getFloorPrice();
        f();
    }

    public int b(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        return i2 == 4 ? 3 : -1;
    }

    public void b(com.vivo.ad.model.b bVar, int i2, int i3) {
        String str;
        v I = bVar.I();
        if (I == null || 1 != I.a()) {
            x0.c("BaseAd", "deeplink or  rpkDeeplink  not available !!!");
            str = "3006000";
        } else {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.setData(Uri.parse(I.b()));
                j.a(intent, bVar);
                this.f26535b.startActivity(intent);
                a(bVar, 0, this.f26537d, i2, i3);
                this.f26542i = 1;
                str = "";
            } catch (Exception e2) {
                a(bVar, 1, this.f26537d, i2, i3);
                x0.b("BaseAd", "deepRpkDeeplink error : ", e2);
                str = "3006001";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w.f(bVar, str, String.valueOf(0));
    }

    private void c(com.vivo.ad.model.b bVar, int i2, int i3) {
        r z = bVar.z();
        if (z != null && 1 == z.a()) {
            j.a(this.f26535b, bVar, this.f26541h, new c(bVar, i2, i3), 0);
        } else {
            j.a(this.f26535b, bVar, false, this.f26541h, this.f26537d, b(i2), 0, b());
            this.f26542i = 0;
        }
    }

    private int e() {
        return w0.a(this.f26535b, "com.vivo.browser");
    }

    private String f() {
        String b2 = x.b();
        this.f26538e = b2;
        return b2;
    }

    protected long a() {
        return -1L;
    }

    protected abstract void a(AdError adError);

    protected abstract void a(List<com.vivo.ad.model.b> list);

    protected abstract int b();

    protected abstract String c();

    protected int d() {
        return 1;
    }

    /* renamed from: com.vivo.ad.a$a */
    class C0551a implements a.b {
        C0551a() {
        }

        @Override // com.vivo.mobilead.util.a.b
        public void a(List<com.vivo.ad.model.b> list) {
            a.this.f26538e = list.get(0).G();
            a.this.a(list);
        }

        @Override // com.vivo.mobilead.util.a.b
        public void a(AdError adError) {
            if (!TextUtils.isEmpty(adError.getRequestId())) {
                a.this.f26538e = adError.getRequestId();
            }
            a.this.a(adError);
        }
    }

    class b implements g {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f26545a;

        /* renamed from: b */
        final /* synthetic */ int f26546b;

        /* renamed from: c */
        final /* synthetic */ int f26547c;

        b(com.vivo.ad.model.b bVar, int i2, int i3) {
            this.f26545a = bVar;
            this.f26546b = i2;
            this.f26547c = i3;
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            a aVar = a.this;
            aVar.a(this.f26545a, 0, 0, "", aVar.f26537d, this.f26546b, this.f26547c);
            a.this.f26542i = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            a aVar = a.this;
            aVar.a(this.f26545a, 1, i2, str, aVar.f26537d, this.f26546b, this.f26547c);
            a.this.b(this.f26545a, this.f26546b, this.f26547c);
        }
    }

    class c implements g {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f26549a;

        /* renamed from: b */
        final /* synthetic */ int f26550b;

        /* renamed from: c */
        final /* synthetic */ int f26551c;

        c(com.vivo.ad.model.b bVar, int i2, int i3) {
            this.f26549a = bVar;
            this.f26550b = i2;
            this.f26551c = i3;
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            a aVar = a.this;
            aVar.a(this.f26549a, 0, 0, "", aVar.f26537d, this.f26550b, this.f26551c);
            a.this.f26542i = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            a aVar = a.this;
            aVar.a(this.f26549a, 1, i2, str, aVar.f26537d, this.f26550b, this.f26551c);
            a aVar2 = a.this;
            j.a(aVar2.f26535b, this.f26549a, false, aVar2.f26541h, aVar2.f26537d, aVar2.b(this.f26550b), 0, a.this.b());
            a.this.f26542i = 0;
        }
    }

    class d implements g {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f26553a;

        /* renamed from: b */
        final /* synthetic */ int f26554b;

        /* renamed from: c */
        final /* synthetic */ int f26555c;

        /* renamed from: d */
        final /* synthetic */ boolean f26556d;

        d(com.vivo.ad.model.b bVar, int i2, int i3, boolean z) {
            this.f26553a = bVar;
            this.f26554b = i2;
            this.f26555c = i3;
            this.f26556d = z;
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            a aVar = a.this;
            aVar.a(this.f26553a, 0, 0, "", aVar.f26537d, this.f26554b, this.f26555c);
            a.this.f26542i = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            a aVar = a.this;
            aVar.a(this.f26553a, 1, i2, str, aVar.f26537d, this.f26554b, this.f26555c);
            a aVar2 = a.this;
            aVar2.a(this.f26553a, this.f26556d, aVar2.b(this.f26554b));
        }
    }

    class e implements g {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f26558a;

        /* renamed from: b */
        final /* synthetic */ int f26559b;

        /* renamed from: c */
        final /* synthetic */ int f26560c;

        /* renamed from: d */
        final /* synthetic */ boolean f26561d;

        e(com.vivo.ad.model.b bVar, int i2, int i3, boolean z) {
            this.f26558a = bVar;
            this.f26559b = i2;
            this.f26560c = i3;
            this.f26561d = z;
        }

        @Override // com.vivo.ad.a.g
        public void a() {
            a aVar = a.this;
            aVar.a(this.f26558a, 0, 0, "", aVar.f26537d, this.f26559b, this.f26560c);
            a.this.f26542i = 1;
        }

        @Override // com.vivo.ad.a.g
        public void a(int i2, String str) {
            a aVar = a.this;
            aVar.a(this.f26558a, 1, i2, str, aVar.f26537d, this.f26559b, this.f26560c);
            a aVar2 = a.this;
            aVar2.f26542i = u.a(aVar2.f26535b, this.f26558a, aVar2.f26537d, aVar2.b(), 0, a.this.b(this.f26559b), 1, a.this.f26541h, this.f26561d);
        }
    }

    public void a(com.vivo.mobilead.g.b bVar) {
        this.f26543j = bVar;
    }

    public void a(String str) {
        this.f26538e = str;
        this.f26540g = true;
        this.f26539f = 1;
    }

    protected void a(int i2) {
        k0.a();
        com.vivo.mobilead.unified.exitFloat.e.c().b();
        h0.K().a(true);
        com.vivo.mobilead.util.a f2 = com.vivo.mobilead.util.a.a().a(a()).c(c()).b(i2).e(d()).f(b()).b(this.f26536c).e(this.f26537d).f(this.k);
        Context context = this.f26535b;
        com.vivo.mobilead.util.a a2 = f2.a(context == null ? "" : context.getPackageName()).d(this.m).g(this.f26534a).c(e()).a(Math.max(1, this.l));
        a2.a(com.vivo.mobilead.manager.g.a(this.f26535b).a(this.f26534a));
        if (this.f26540g) {
            this.f26540g = false;
            a2.d(this.f26538e);
            this.f26539f = 1;
            a2.g(1);
        } else {
            a2.d(f());
            this.f26539f = 2;
            a2.g(2);
        }
        a2.a(new C0551a());
        com.vivo.mobilead.splash.a.b.a().a(this.k, "dataload:stage2");
        a1.c(a2);
    }

    private void b(com.vivo.ad.model.b bVar, boolean z, boolean z2, int i2, int i3) {
        r z3 = bVar.z();
        if (SystemUtils.isVivoPhone()) {
            if (z3 != null && 1 == z3.a()) {
                j.a(this.f26535b, bVar, this.f26541h, new d(bVar, i2, i3, z), 0);
                return;
            } else {
                a(bVar, z, b(i2));
                return;
            }
        }
        if (z3 != null && 1 == z3.a()) {
            j.a(this.f26535b, bVar, this.f26541h, new e(bVar, i2, i3, z2), 0);
        } else {
            this.f26542i = u.a(this.f26535b, bVar, this.f26537d, b(), 0, b(i2), 1, this.f26541h, z2);
        }
    }

    public void a(com.vivo.ad.model.b bVar, boolean z, boolean z2) {
        x0.a("BaseAd", "start dealClick " + z);
        a(bVar, z, z2, -1, -1);
    }

    protected void a(com.vivo.ad.model.b bVar, boolean z, boolean z2, int i2, int i3) {
        x0.a("BaseAd", "start dealClick " + z);
        this.f26542i = -1;
        if (bVar != null) {
            int j2 = bVar.j();
            if (j2 != 1) {
                if (j2 != 2 && j2 != 5 && j2 != 6) {
                    switch (j2) {
                        case 8:
                            a(bVar, i2, i3);
                            break;
                        case 9:
                            this.f26542i = u.a(this.f26535b, bVar, i2, this.f26537d, 0, b());
                            break;
                        case 10:
                            a(bVar, z, 0, b(), i2);
                            break;
                        case 11:
                            u.a(this.f26535b, bVar, z, z2, i2, i3, this.f26537d, c(), this.f26541h, 0, b(), null);
                            break;
                    }
                }
                b(bVar, z, z2, i2, i3);
                return;
            }
            c(bVar, i2, i3);
        }
    }

    private void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4) {
        l a2 = j.a(this.f26535b, bVar, this.f26541h, 0);
        if (a2.f30720b) {
            k0.a(bVar, 3, 1, "", this.f26537d);
        } else {
            k0.a(bVar, 3, 2, a2.f30719a, this.f26537d);
            j.a(this.f26535b, bVar, z, this.f26541h, this.f26537d, b(i4), i2, i3);
        }
    }

    private void a(com.vivo.ad.model.b bVar, int i2, int i3) {
        x0.e("BaseAd", "dealRpkAdClick");
        r z = bVar.z();
        bVar.I();
        if (z != null && 1 == z.a()) {
            j.a(this.f26535b, bVar, this.f26541h, new b(bVar, i2, i3), 0);
        } else {
            b(bVar, i2, i3);
        }
    }

    public void a(com.vivo.ad.model.b bVar, boolean z, int i2) {
        int j2 = bVar.j();
        q y = bVar.y();
        if (j.b(this.f26535b, y == null ? "" : y.a())) {
            if (y != null) {
                j.a(this.f26535b, y.a(), bVar, this.f26537d, String.valueOf(b()), String.valueOf(0));
                w.b(bVar, "3005002", String.valueOf(0));
                this.f26542i = 1;
                return;
            }
            return;
        }
        if (j2 != 2 && !z) {
            j.a(this.f26535b, bVar, false, this.f26541h, this.f26537d, i2, 0, b());
            this.f26542i = 0;
            return;
        }
        boolean z2 = j2 == 5 || j2 == 6;
        if (bVar.y() != null && bVar.y().m() == 1 && z2) {
            j.a(this.f26535b, bVar, false, this.f26541h, this.f26537d, i2, 0, b());
            this.f26542i = 0;
        } else {
            j.a(this.f26535b, bVar, z, this.f26537d, 0);
            this.f26542i = 2;
        }
    }

    protected void a(com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, int i4, int i5) {
        a1.e(new f(bVar, i4, i5, i2, str, i3, str2));
    }

    protected void a(com.vivo.ad.model.b bVar, int i2, String str, int i3, int i4) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "218");
        hashMap.put("ptype", String.valueOf(c()));
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
            hashMap.put("scene", String.valueOf(i3));
            hashMap.put("dfrom", String.valueOf(i4));
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("status", String.valueOf(i2));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str);
        a(cVar);
    }

    public void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(bVar, enumC0603a, i2, i3, i4, i5, null, i6, i7, i8, i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (1 == r2.a()) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.ad.model.b r21, com.vivo.mobilead.model.a.EnumC0603a r22, int r23, int r24, int r25, int r26, com.vivo.ad.model.w r27, int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ad.a.a(com.vivo.ad.model.b, com.vivo.mobilead.model.a$a, int, int, int, int, com.vivo.ad.model.w, int, int, int, int):void");
    }

    protected void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a) {
        x0.b("BaseAd", "reportAdThirdPartyEvent");
        a(bVar, enumC0603a, -999, -999, -999, -999, -999, -999, -999, -999);
    }

    protected void a(AdError adError, int i2, int i3) {
        if (c0.b(this.f26535b)) {
            return;
        }
        k0.a(adError, this.f26536c, this.f26537d, c(), -1, i2, 0, i3, c.a.f28912a.intValue(), d());
    }

    public void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", String.valueOf(c()));
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
            hashMap.put("status", String.valueOf(1));
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("adLeftTopX", String.valueOf(i2));
        hashMap.put("adLeftTopY", String.valueOf(i3));
        hashMap.put("adRightBottomX", String.valueOf(i4));
        hashMap.put("adRightBottomY", String.valueOf(i5));
        hashMap.put("ad_sdk", c.a.f28912a + "");
        hashMap.put("uiVersion", "0");
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(this.f26537d);
        a(cVar);
    }

    public void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", String.valueOf(c()));
        hashMap.put("id", bVar.d());
        hashMap.put("uiVersion", "0");
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("realX", String.valueOf(i3));
        hashMap.put("realY", String.valueOf(i4));
        hashMap.put("x", String.valueOf(i5));
        hashMap.put("y", String.valueOf(i6));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("clickArea", String.valueOf(i2));
        hashMap.put("dlCfg", z2 ? "2" : "1");
        hashMap.put("preturn", String.valueOf(this.f26542i));
        hashMap.put("ad_sdk", c.a.f28912a + "");
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(this.f26537d);
        a(cVar);
    }

    protected void a(com.vivo.mobilead.b.c cVar) {
        if (cVar != null) {
            cVar.b(this.f26536c);
            com.vivo.mobilead.b.b.c().b(cVar);
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public AdError a(com.vivo.ad.model.b bVar, AdError adError) {
        if (adError == null) {
            adError = new AdError(40215, "未知情况下导致的错误，请联系广告SDK对接人员处理", null, null);
        }
        adError.setRequestId(this.f26538e);
        if (bVar != null) {
            adError.setRequestId(bVar.G());
            adError.setErrorMsg(adError.getErrorMsg());
            if (bVar.f() != null) {
                adError.setMaterialsIDs(bVar.f().f());
            }
            adError.setADID(bVar.d());
            adError.setToken(bVar.P());
            adError.setShowPriority(bVar.J());
        }
        return adError;
    }
}
