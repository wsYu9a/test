package com.opos.mobad.h.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.c.l;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.ad.c.d {

    /* renamed from: a */
    protected Context f20873a;

    /* renamed from: b */
    private com.opos.mobad.h.c f20874b;

    /* renamed from: c */
    private AdItemData f20875c;

    /* renamed from: d */
    private MaterialData f20876d;

    /* renamed from: e */
    private List<com.opos.mobad.ad.c.e> f20877e = null;

    /* renamed from: f */
    private List<com.opos.mobad.ad.c.e> f20878f = null;

    /* renamed from: g */
    private long f20879g = SystemClock.elapsedRealtime();

    /* renamed from: h */
    private boolean f20880h = false;

    /* renamed from: i */
    private boolean f20881i = false;

    /* renamed from: j */
    private boolean f20882j = false;
    private l k;

    /* renamed from: com.opos.mobad.h.b.a$a */
    private static class C0447a implements l {

        /* renamed from: a */
        private AppPrivacyData f20883a;

        public C0447a(AppPrivacyData appPrivacyData) {
            this.f20883a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.c.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f20883a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f21708d;
        }

        @Override // com.opos.mobad.ad.c.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f20883a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f21707c;
        }

        @Override // com.opos.mobad.ad.c.l
        public String c() {
            AppPrivacyData appPrivacyData = this.f20883a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f21706b;
        }

        @Override // com.opos.mobad.ad.c.l
        public String d() {
            AppPrivacyData appPrivacyData = this.f20883a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f21705a;
        }
    }

    public a(Context context, com.opos.mobad.h.c cVar, AdItemData adItemData) {
        this.f20873a = context;
        this.f20874b = cVar;
        this.f20875c = adItemData;
        this.f20876d = adItemData.i().get(0);
        if (this.f20875c.O() != null) {
            this.k = new C0447a(this.f20875c.O());
        }
    }

    private String a(int i2) {
        switch (i2) {
            case 10200:
                return "ad repeat exposure.";
            case 10201:
                return "ad exposure expired.";
            case 10202:
                return "ad hasn't exposed.";
            case 10203:
                return "ad repeat click.";
            case 10204:
                return "ad click expired.";
            default:
                return "";
        }
    }

    private int m() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.f20879g + ",mHasAdShow=" + this.f20880h + ",nowTime=" + elapsedRealtime + ",getShowInterval=" + this.f20875c.p());
        int i2 = this.f20880h ? 10200 : elapsedRealtime - this.f20879g > ((long) ((this.f20875c.p() * 60) * 1000)) ? 10201 : 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdShowStatus =" + i2);
        return i2;
    }

    private int n() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.f20879g + ",mHasAdShow=" + this.f20880h + ",mHasAdClick=" + this.f20881i + ",nowTime=" + elapsedRealtime + ",getClickInterval=" + this.f20875c.q());
        int i2 = !this.f20880h ? 10202 : this.f20881i ? 10203 : elapsedRealtime - this.f20879g > ((long) ((this.f20875c.q() * 60) * 1000)) ? 10204 : 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdClickStatus =" + i2);
        return i2;
    }

    @Override // com.opos.mobad.ad.c.d
    public String a() {
        return this.f20876d.h();
    }

    @Override // com.opos.mobad.ad.c.d
    public void a(View view) {
        synchronized (this) {
            if (!this.f20874b.d()) {
                this.f20875c.k(com.opos.mobad.service.f.a.a().x());
                int m = m();
                if (m == 0) {
                    this.f20874b.b(this.f20875c);
                    this.f20874b.a(this.f20875c, true, null);
                    this.f20880h = true;
                } else {
                    this.f20874b.a(this.f20875c, false, null);
                    this.f20874b.b().a(new q(m, a(m)), this);
                }
                this.f20874b.a(this.f20875c);
            }
        }
    }

    @Override // com.opos.mobad.ad.c.d
    public boolean a(String str) {
        MaterialData materialData;
        boolean z = false;
        if (!this.f20874b.d()) {
            try {
                if (!com.opos.cmn.an.c.a.a(str) && this.f20875c != null && (materialData = this.f20876d) != null) {
                    z = str.equals(materialData.k());
                    com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isCurrentApp downloadPkgName=" + this.f20876d.k());
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isCurrentApp pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return z;
    }

    @Override // com.opos.mobad.ad.c.d
    public String b() {
        return this.f20876d.i();
    }

    @Override // com.opos.mobad.ad.c.d
    public void b(View view) {
        String str;
        String str2;
        synchronized (this) {
            if (!this.f20874b.d()) {
                HashMap hashMap = new HashMap();
                if (this.f20882j) {
                    str = "clickState";
                    str2 = "2";
                } else {
                    this.f20882j = true;
                    str = "clickState";
                    str2 = "1";
                }
                hashMap.put(str, str2);
                int n = n();
                if (n == 0) {
                    this.f20881i = true;
                    this.f20874b.a(this.f20875c, true, null, hashMap, com.opos.mobad.cmn.a.b.a.ClickBt, view);
                } else {
                    this.f20874b.a(this.f20875c, false, null, hashMap, com.opos.mobad.cmn.a.b.a.ClickBt, view);
                    this.f20874b.b().a(new q(n, a(n)), this);
                }
            }
        }
    }

    @Override // com.opos.mobad.ad.c.d
    public List<com.opos.mobad.ad.c.e> c() {
        List<MaterialData> i2;
        List<MaterialFileData> j2;
        if (this.f20877e == null && (i2 = this.f20875c.i()) != null && i2.size() > 0) {
            for (MaterialData materialData : i2) {
                if (materialData != null && (j2 = materialData.j()) != null && j2.size() > 0) {
                    this.f20877e = new ArrayList();
                    for (MaterialFileData materialFileData : j2) {
                        if (materialFileData != null) {
                            this.f20877e.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getIconFiles =");
        List<com.opos.mobad.ad.c.e> list = this.f20877e;
        sb.append(list != null ? Integer.valueOf(list.size()) : "null");
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return this.f20877e;
    }

    @Override // com.opos.mobad.ad.c.d
    public List<com.opos.mobad.ad.c.e> d() {
        List<MaterialData> i2;
        List<MaterialFileData> f2;
        if (this.f20878f == null && (i2 = this.f20875c.i()) != null && i2.size() > 0) {
            for (MaterialData materialData : i2) {
                if (materialData != null && (f2 = materialData.f()) != null && f2.size() > 0) {
                    this.f20878f = new ArrayList();
                    for (MaterialFileData materialFileData : f2) {
                        if (materialFileData != null) {
                            this.f20878f.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getImgFiles =");
        List<com.opos.mobad.ad.c.e> list = this.f20878f;
        sb.append(list != null ? Integer.valueOf(list.size()) : "null");
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return this.f20878f;
    }

    @Override // com.opos.mobad.ad.c.d
    public int e() {
        return this.f20876d.d();
    }

    @Override // com.opos.mobad.ad.c.d
    public int f() {
        return this.f20876d.e();
    }

    @Override // com.opos.mobad.ad.c.d
    public com.opos.mobad.ad.c.e g() {
        MaterialFileData l = this.f20875c.l();
        b bVar = l != null ? new b(l) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoFile=");
        sb.append(bVar != null ? bVar : "null");
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return bVar;
    }

    @Override // com.opos.mobad.ad.c.d
    public boolean h() {
        boolean z = m() == 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isAdValid=" + z);
        return z;
    }

    @Override // com.opos.mobad.ad.c.d
    public String i() {
        return this.f20875c.n();
    }

    @Override // com.opos.mobad.ad.c.d
    public String j() {
        String a2 = g.a(this.f20873a, this.f20875c, false);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getClickBnText=" + a2);
        return a2;
    }

    @Override // com.opos.mobad.ad.c.d
    public boolean k() {
        AdItemData adItemData;
        MaterialData materialData;
        boolean a2;
        if (!this.f20874b.d()) {
            try {
                adItemData = this.f20875c;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e2);
            }
            if (adItemData != null && (materialData = this.f20876d) != null) {
                a2 = this.f20874b.a(adItemData, materialData);
                com.opos.cmn.an.f.a.b("NativeAdDataImpl", "launchApp=" + a2);
                return a2;
            }
        }
        a2 = false;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "launchApp=" + a2);
        return a2;
    }

    @Override // com.opos.mobad.ad.c.d
    public l l() {
        return this.k;
    }
}
