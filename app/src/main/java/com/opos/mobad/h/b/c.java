package com.opos.mobad.h.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.i;
import com.opos.mobad.ad.c.k;
import com.opos.mobad.ad.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends g.a implements h {

    /* renamed from: a */
    private AdItemData f20885a;

    /* renamed from: b */
    private MaterialData f20886b;

    /* renamed from: c */
    private List<com.opos.mobad.ad.c.e> f20887c = null;

    /* renamed from: d */
    private List<com.opos.mobad.ad.c.e> f20888d = null;

    /* renamed from: e */
    private final long f20889e = SystemClock.elapsedRealtime();

    /* renamed from: f */
    private Context f20890f;

    /* renamed from: g */
    private d f20891g;

    /* renamed from: h */
    private com.opos.mobad.ad.c.b f20892h;

    private static class a implements com.opos.mobad.ad.c.b {

        /* renamed from: a */
        private AppPrivacyData f20893a;

        public a(AppPrivacyData appPrivacyData) {
            this.f20893a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.c.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f20893a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f21708d;
        }

        @Override // com.opos.mobad.ad.c.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f20893a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f21707c;
        }
    }

    public c(com.opos.mobad.cmn.a.a aVar, AdItemData adItemData, Context context, String str, com.opos.mobad.ad.privacy.b bVar) {
        this.f20885a = adItemData;
        this.f20890f = context.getApplicationContext();
        this.f20886b = adItemData.i().get(0);
        this.f20891g = new d(context, aVar, adItemData, str, bVar);
        if (this.f20885a.O() != null) {
            this.f20892h = new a(this.f20885a.O());
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public String a() {
        return this.f20886b.h();
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(Context context, FrameLayout frameLayout, k kVar) {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        d dVar = this.f20891g;
        if (dVar != null) {
            dVar.a(frameLayout, kVar);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(Context context, FrameLayout frameLayout, List<View> list) {
        d dVar = this.f20891g;
        if (dVar != null) {
            dVar.a(context, frameLayout, list);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        d dVar = this.f20891g;
        if (dVar == null) {
            return;
        }
        dVar.a(context, list, aVar, list2, aVar2);
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(i iVar) {
        d dVar = this.f20891g;
        if (dVar != null) {
            dVar.a(iVar);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public String b() {
        return this.f20886b.i();
    }

    @Override // com.opos.mobad.ad.c.h
    public List<com.opos.mobad.ad.c.e> c() {
        List<MaterialData> i2;
        List<MaterialFileData> j2;
        if (this.f20887c == null && (i2 = this.f20885a.i()) != null && i2.size() > 0) {
            for (MaterialData materialData : i2) {
                if (materialData != null && (j2 = materialData.j()) != null && j2.size() > 0) {
                    this.f20887c = new ArrayList();
                    for (MaterialFileData materialFileData : j2) {
                        if (materialFileData != null) {
                            this.f20887c.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getIconFiles =");
        List<com.opos.mobad.ad.c.e> list = this.f20887c;
        sb.append(list != null ? Integer.valueOf(list.size()) : "null");
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.f20887c;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        d dVar = this.f20891g;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public List<com.opos.mobad.ad.c.e> d() {
        List<MaterialData> i2;
        List<MaterialFileData> f2;
        if (this.f20888d == null && (i2 = this.f20885a.i()) != null && i2.size() > 0) {
            for (MaterialData materialData : i2) {
                if (materialData != null && materialData.d() != 13 && (f2 = materialData.f()) != null && f2.size() > 0) {
                    this.f20888d = new ArrayList();
                    for (MaterialFileData materialFileData : f2) {
                        if (materialFileData != null) {
                            this.f20888d.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getImgFiles =");
        List<com.opos.mobad.ad.c.e> list = this.f20888d;
        sb.append(list != null ? Integer.valueOf(list.size()) : "null");
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.f20888d;
    }

    @Override // com.opos.mobad.ad.c.h
    public int e() {
        return this.f20886b.d();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        return this.f20885a.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        return this.f20885a.Y();
    }

    @Override // com.opos.mobad.ad.c.h
    public int h() {
        return (int) this.f20886b.u();
    }

    @Override // com.opos.mobad.ad.c.h
    public com.opos.mobad.ad.c.e i() {
        MaterialFileData l = this.f20885a.l();
        b bVar = l != null ? new b(l) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoFile=");
        sb.append(bVar != null ? bVar : "null");
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return bVar;
    }

    @Override // com.opos.mobad.ad.c.h
    public boolean j() {
        return SystemClock.elapsedRealtime() - this.f20889e <= ((long) ((this.f20885a.p() * 60) * 1000));
    }

    @Override // com.opos.mobad.ad.c.h
    public String k() {
        return this.f20885a.n();
    }

    @Override // com.opos.mobad.ad.c.h
    public String l() {
        String a2 = com.opos.mobad.cmn.a.b.g.a(this.f20890f, this.f20885a, false);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "getClickBnText=" + a2);
        return a2;
    }

    @Override // com.opos.mobad.ad.c.h
    public void m() {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "release");
        d dVar = this.f20891g;
        if (dVar != null) {
            dVar.a();
            this.f20891g = null;
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public com.opos.mobad.ad.c.b n() {
        return this.f20892h;
    }
}
