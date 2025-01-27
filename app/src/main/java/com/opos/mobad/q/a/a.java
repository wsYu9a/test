package com.opos.mobad.q.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.i;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Context f23171a;

    /* renamed from: b */
    private String f23172b;

    /* renamed from: c */
    private com.opos.mobad.cmn.a.a f23173c;

    /* renamed from: d */
    private b.InterfaceC0437b f23174d;

    /* renamed from: e */
    private InterfaceC0474a f23175e;

    /* renamed from: f */
    private boolean f23176f;

    /* renamed from: g */
    private AdItemData f23177g;

    /* renamed from: h */
    private MaterialData f23178h;

    /* renamed from: i */
    private boolean f23179i;

    /* renamed from: j */
    private long f23180j;
    private int k;
    private boolean l;
    private int m;
    private int n = 0;

    /* renamed from: com.opos.mobad.q.a.a$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23175e != null) {
                a.this.f23175e.j_();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23182a;

        AnonymousClass2(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23175e != null) {
                a.this.f23175e.a(-1, "render fail code:" + i2);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.a$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23175e != null) {
                a.this.f23175e.a(a.this.f23177g.J());
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.a$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f23185a;

        AnonymousClass4(long j2) {
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23175e != null) {
                a.this.f23175e.a(j2);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.a$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23176f || a.this.f23175e == null) {
                return;
            }
            a.this.f23175e.d();
        }
    }

    /* renamed from: com.opos.mobad.q.a.a$a */
    public interface InterfaceC0474a extends i.b, a.b {
        void j_();
    }

    public a(Context context, String str, com.opos.mobad.cmn.a.a aVar, b.InterfaceC0437b interfaceC0437b, InterfaceC0474a interfaceC0474a) {
        this.f23171a = context;
        this.f23172b = str;
        this.f23173c = aVar;
        this.f23174d = interfaceC0437b;
        this.f23175e = interfaceC0474a;
    }

    private void a(boolean z, int i2, Map<String, String> map) {
        com.opos.mobad.cmn.a.b.d.a(this.f23171a, this.f23172b, this.f23177g, this.f23178h, z, i2, map);
    }

    private boolean a(int i2, long j2) {
        boolean z;
        long j3;
        try {
            j3 = this.f23180j;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdPresenter", "", (Throwable) e2);
        }
        if (j3 < j2 && j2 - j3 <= i2 * 60 * 1000) {
            z = true;
            com.opos.cmn.an.f.a.b("AdPresenter", "isValidClick=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("AdPresenter", "isValidClick=" + z);
        return z;
    }

    private boolean a(long j2, int i2) {
        long j3 = this.f23180j;
        boolean z = j2 < j3 && j3 - j2 <= ((long) ((i2 * 60) * 1000));
        com.opos.cmn.an.f.a.b("AdPresenter", "isValidExpose=" + z);
        return z;
    }

    private void c() {
        MaterialData materialData = this.f23178h;
        if (materialData != null) {
            com.opos.mobad.service.g.b.a(this.f23171a, materialData.o());
        } else {
            com.opos.cmn.an.f.a.c("AdPresenter", "close with null data");
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f23176f || a.this.f23175e == null) {
                    return;
                }
                a.this.f23175e.d();
            }
        });
    }

    public void a() {
        if (this.f23176f) {
            return;
        }
        if (this.f23177g != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientTemplateId", String.valueOf(this.k));
            com.opos.mobad.cmn.a.b.d.a(this.f23171a, this.f23177g.b(), this.f23177g.g(), "3", this.f23177g.c(), "", hashMap);
        }
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.q.a.a.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f23175e != null) {
                    a.this.f23175e.j_();
                }
            }
        });
    }

    public void a(int i2) {
        String b2;
        String str;
        String c2;
        String a2;
        String str2;
        if (this.f23176f) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i2);
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        AdItemData adItemData = this.f23177g;
        Context context = this.f23171a;
        if (adItemData == null) {
            str = this.f23172b;
            b2 = "";
            str2 = "4";
            c2 = "";
            a2 = "";
        } else {
            b2 = adItemData.b();
            str = this.f23172b;
            c2 = this.f23177g.c();
            a2 = this.f23177g.a();
            str2 = "4";
        }
        com.opos.mobad.cmn.a.b.d.a(context, b2, str, str2, c2, a2, hashMap);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.2

            /* renamed from: a */
            final /* synthetic */ int f23182a;

            AnonymousClass2(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f23175e != null) {
                    a.this.f23175e.a(-1, "render fail code:" + i2);
                }
            }
        });
    }

    public void a(View view) {
        if (this.f23176f || this.f23179i) {
            return;
        }
        this.f23179i = true;
        this.f23177g.k(com.opos.mobad.service.f.a.a().x());
        this.f23180j = SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        if (view != null) {
            com.opos.mobad.cmn.a.b.d.a(view, hashMap);
        }
        boolean a2 = a(this.f23177g.N(), this.f23177g.p());
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        a(a2, this.n, hashMap);
        com.opos.mobad.service.g.b.a(this.f23171a, this.f23178h.n());
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f23175e != null) {
                    a.this.f23175e.a(a.this.f23177g.J());
                }
            }
        });
    }

    public void a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar, long j2, Map<String, String> map, a.c cVar) {
        String str;
        if (this.f23176f) {
            return;
        }
        Map<String, String> hashMap = map == null ? new HashMap() : map;
        if (aVar == com.opos.mobad.cmn.a.b.a.FloatLayerClickBt || aVar == com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt) {
            hashMap.put("endTmType", "" + this.m);
        }
        boolean a2 = a(this.f23177g.q(), SystemClock.elapsedRealtime());
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        if (this.l) {
            str = "2";
        } else {
            this.l = true;
            str = "1";
        }
        hashMap.put("clickState", str);
        com.opos.mobad.cmn.a.a aVar2 = this.f23173c;
        if (aVar2 != null) {
            aVar2.a(this.f23177g, a2, iArr, hashMap, aVar, view, this.f23174d, (com.opos.mobad.cmn.a.b) null, cVar);
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.4

            /* renamed from: a */
            final /* synthetic */ long f23185a;

            AnonymousClass4(long j22) {
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f23175e != null) {
                    a.this.f23175e.a(j2);
                }
            }
        });
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i2, int i3) {
        this.n = 0;
        this.f23177g = adItemData;
        this.f23178h = materialData;
        this.f23179i = false;
        this.k = i2;
        this.m = i3;
        com.opos.mobad.cmn.a.a aVar = this.f23173c;
        if (aVar != null) {
            aVar.b(adItemData);
            this.f23173c.a(this.f23177g);
        }
        this.l = false;
    }

    public void a(boolean z, int[] iArr) {
        if (this.f23176f) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f23171a, this.f23172b, z, this.f23177g, this.f23178h, (Map<String, String>) null, iArr);
        c();
    }

    public void b() {
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f23171a).a(this.f23174d);
        this.f23176f = true;
        com.opos.mobad.cmn.a.a aVar = this.f23173c;
        if (aVar != null) {
            aVar.a();
        }
        this.f23173c = null;
    }

    public void b(int i2) {
        this.n = i2;
    }

    public void b(boolean z, int[] iArr) {
        if (this.f23176f) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f23171a, this.f23172b, this.f23177g, this.f23178h, iArr, z);
        c();
    }

    public void c(int i2) {
        if (this.f23176f) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f23171a, this.f23172b, this.f23177g, this.f23178h, i2);
    }

    public void d(int i2) {
        String b2;
        String str;
        String c2;
        String a2;
        String str2;
        if (this.f23176f) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i2);
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        AdItemData adItemData = this.f23177g;
        Context context = this.f23171a;
        if (adItemData == null) {
            str = this.f23172b;
            b2 = "";
            str2 = "5";
            c2 = "";
            a2 = "";
        } else {
            b2 = adItemData.b();
            str = this.f23172b;
            c2 = this.f23177g.c();
            a2 = this.f23177g.a();
            str2 = "5";
        }
        com.opos.mobad.cmn.a.b.d.a(context, b2, str, str2, c2, a2, hashMap);
    }
}
