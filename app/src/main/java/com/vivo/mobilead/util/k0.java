package com.vivo.mobilead.util;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.ad.model.AdError;
import com.vivo.ic.SystemUtils;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k0 {

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.vivo.mobilead.manager.f.j().c() == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "413");
            hashMap.put("applist", f0.a(com.vivo.mobilead.manager.f.j().c()));
            k0.b((String) null, (String) null, (String) null, (JSONObject) null, hashMap);
        }
    }

    static class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f30673a;

        /* renamed from: b */
        final /* synthetic */ int f30674b;

        /* renamed from: c */
        final /* synthetic */ int f30675c;

        /* renamed from: d */
        final /* synthetic */ int f30676d;

        /* renamed from: e */
        final /* synthetic */ int f30677e;

        /* renamed from: f */
        final /* synthetic */ int f30678f;

        /* renamed from: g */
        final /* synthetic */ int f30679g;

        /* renamed from: h */
        final /* synthetic */ String f30680h;

        /* renamed from: i */
        final /* synthetic */ String f30681i;

        b(String str, int i2, int i3, int i4, int i5, int i6, int i7, String str2, String str3) {
            this.f30673a = str;
            this.f30674b = i2;
            this.f30675c = i3;
            this.f30676d = i4;
            this.f30677e = i5;
            this.f30678f = i6;
            this.f30679g = i7;
            this.f30680h = str2;
            this.f30681i = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "213");
            hashMap.put("ptype", this.f30673a);
            hashMap.put("reqType", String.valueOf(this.f30674b));
            hashMap.put("renderType", String.valueOf(this.f30675c));
            hashMap.put("uiVersion", String.valueOf(this.f30676d));
            hashMap.put("ad_sdk", String.valueOf(this.f30677e));
            hashMap.put("permission", String.valueOf(h0.K().b()));
            hashMap.put("materialType", String.valueOf(this.f30678f));
            int i2 = this.f30679g;
            if (i2 != -1) {
                hashMap.put("orientation", String.valueOf(i2));
            }
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.b(this.f30680h);
            cVar.c(this.f30681i);
            k0.b(cVar);
        }
    }

    static class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f30682a;

        /* renamed from: b */
        final /* synthetic */ int f30683b;

        /* renamed from: c */
        final /* synthetic */ int f30684c;

        /* renamed from: d */
        final /* synthetic */ int f30685d;

        /* renamed from: e */
        final /* synthetic */ int f30686e;

        /* renamed from: f */
        final /* synthetic */ int f30687f;

        /* renamed from: g */
        final /* synthetic */ String f30688g;

        /* renamed from: h */
        final /* synthetic */ String f30689h;

        c(String str, int i2, int i3, int i4, int i5, int i6, String str2, String str3) {
            this.f30682a = str;
            this.f30683b = i2;
            this.f30684c = i3;
            this.f30685d = i4;
            this.f30686e = i5;
            this.f30687f = i6;
            this.f30688g = str2;
            this.f30689h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "213");
            hashMap.put("ptype", this.f30682a);
            hashMap.put("reqType", String.valueOf(this.f30683b));
            hashMap.put("renderType", String.valueOf(this.f30684c));
            hashMap.put("uiVersion", String.valueOf(this.f30685d));
            hashMap.put("ad_sdk", String.valueOf(this.f30686e));
            hashMap.put("permission", String.valueOf(h0.K().b()));
            hashMap.put("materialType", String.valueOf(this.f30687f));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.b(this.f30688g);
            cVar.c(this.f30689h);
            k0.b(cVar);
        }
    }

    static class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f30690a;

        /* renamed from: b */
        final /* synthetic */ int f30691b;

        /* renamed from: c */
        final /* synthetic */ int f30692c;

        /* renamed from: d */
        final /* synthetic */ int f30693d;

        /* renamed from: e */
        final /* synthetic */ int f30694e;

        /* renamed from: f */
        final /* synthetic */ int f30695f;

        /* renamed from: g */
        final /* synthetic */ int f30696g;

        /* renamed from: h */
        final /* synthetic */ int f30697h;

        /* renamed from: i */
        final /* synthetic */ int f30698i;

        /* renamed from: j */
        final /* synthetic */ String f30699j;
        final /* synthetic */ String k;
        final /* synthetic */ String l;

        d(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2, String str3, String str4) {
            this.f30690a = str;
            this.f30691b = i2;
            this.f30692c = i3;
            this.f30693d = i4;
            this.f30694e = i5;
            this.f30695f = i6;
            this.f30696g = i7;
            this.f30697h = i8;
            this.f30698i = i9;
            this.f30699j = str2;
            this.k = str3;
            this.l = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "213");
            hashMap.put("ptype", this.f30690a);
            hashMap.put("uiVersion", this.f30691b + "");
            hashMap.put("reqType", String.valueOf(this.f30692c));
            hashMap.put("materialType", String.valueOf(this.f30693d));
            hashMap.put("renderType", String.valueOf(this.f30694e));
            hashMap.put("permission", String.valueOf(h0.K().b()));
            hashMap.put("ad_sdk", String.valueOf(this.f30695f));
            hashMap.put("renderStyle", String.valueOf(this.f30696g));
            int i2 = this.f30697h;
            if (i2 != -1) {
                hashMap.put("a_mbFloor", String.valueOf(i2));
            }
            int i3 = this.f30698i;
            if (i3 != -1) {
                hashMap.put("orientation", String.valueOf(i3));
            }
            k0.b(this.f30699j, this.k, this.l, (JSONObject) null, hashMap);
        }
    }

    static class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30700a;

        /* renamed from: b */
        final /* synthetic */ String f30701b;

        /* renamed from: c */
        final /* synthetic */ int f30702c;

        /* renamed from: d */
        final /* synthetic */ int f30703d;

        /* renamed from: e */
        final /* synthetic */ int f30704e;

        /* renamed from: f */
        final /* synthetic */ String f30705f;

        /* renamed from: g */
        final /* synthetic */ int f30706g;

        /* renamed from: h */
        final /* synthetic */ String f30707h;

        e(com.vivo.ad.model.b bVar, String str, int i2, int i3, int i4, String str2, int i5, String str3) {
            this.f30700a = bVar;
            this.f30701b = str;
            this.f30702c = i2;
            this.f30703d = i3;
            this.f30704e = i4;
            this.f30705f = str2;
            this.f30706g = i5;
            this.f30707h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f30700a == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "215");
            hashMap.put("ptype", this.f30701b);
            hashMap.put("id", this.f30700a.d());
            hashMap.put(OapsKey.KEY_TOKEN, this.f30700a.P());
            hashMap.put("renderType", String.valueOf(this.f30700a.a() == null ? -1 : this.f30700a.a().a()));
            if (this.f30700a.Q() != null) {
                hashMap.put("materialids", this.f30700a.Q().f());
                hashMap.put("scene", String.valueOf(this.f30702c));
                hashMap.put("dfrom", String.valueOf(this.f30703d));
            } else if (this.f30700a.f() != null) {
                hashMap.put("materialids", this.f30700a.f().f());
            }
            if (!SystemUtils.isVivoPhone() && this.f30700a.y() != null && !TextUtils.isEmpty(this.f30700a.y().a())) {
                hashMap.put("install_status", String.valueOf(f0.a(com.vivo.mobilead.manager.f.j().c(), this.f30700a.y().a())));
            }
            hashMap.put("status", String.valueOf(this.f30704e));
            hashMap.put("dspid", String.valueOf(this.f30700a.q()));
            com.vivo.ad.model.r z = this.f30700a.z();
            if (1 == this.f30704e) {
                hashMap.put("deeplinkUrl", z != null ? z.b() : "");
                hashMap.put("reason", this.f30705f);
                hashMap.put("errCode", String.valueOf(this.f30706g));
            }
            k0.b(this.f30700a.G(), this.f30700a.C(), this.f30707h, (JSONObject) null, hashMap);
        }
    }

    static class f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30708a;

        /* renamed from: b */
        final /* synthetic */ String f30709b;

        /* renamed from: c */
        final /* synthetic */ int f30710c;

        /* renamed from: d */
        final /* synthetic */ int f30711d;

        /* renamed from: e */
        final /* synthetic */ int f30712e;

        /* renamed from: f */
        final /* synthetic */ String f30713f;

        /* renamed from: g */
        final /* synthetic */ int f30714g;

        /* renamed from: h */
        final /* synthetic */ String f30715h;

        f(com.vivo.ad.model.b bVar, String str, int i2, int i3, int i4, String str2, int i5, String str3) {
            this.f30708a = bVar;
            this.f30709b = str;
            this.f30710c = i2;
            this.f30711d = i3;
            this.f30712e = i4;
            this.f30713f = str2;
            this.f30714g = i5;
            this.f30715h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f30708a == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "426");
            hashMap.put("ptype", this.f30709b);
            hashMap.put("id", this.f30708a.d());
            hashMap.put(OapsKey.KEY_TOKEN, this.f30708a.P());
            hashMap.put("renderType", String.valueOf(this.f30708a.a() == null ? -1 : this.f30708a.a().a()));
            if (this.f30708a.Q() != null) {
                hashMap.put("materialids", this.f30708a.Q().f());
                hashMap.put("scene", String.valueOf(this.f30710c));
                hashMap.put("dfrom", String.valueOf(this.f30711d));
            } else if (this.f30708a.f() != null) {
                hashMap.put("materialids", this.f30708a.f().f());
            }
            if (!SystemUtils.isVivoPhone() && this.f30708a.y() != null && !TextUtils.isEmpty(this.f30708a.y().a())) {
                hashMap.put("install_status", String.valueOf(f0.a(com.vivo.mobilead.manager.f.j().c(), this.f30708a.y().a())));
            }
            hashMap.put("status", String.valueOf(this.f30712e));
            hashMap.put("dspid", String.valueOf(this.f30708a.q()));
            com.vivo.ad.model.r z = this.f30708a.z();
            if (1 == this.f30712e) {
                hashMap.put("deeplinkUrl", z != null ? z.b() : "");
                hashMap.put("reason", this.f30713f);
                hashMap.put("errCode", String.valueOf(this.f30714g));
            }
            k0.b(this.f30708a.G(), this.f30708a.C(), this.f30715h, (JSONObject) null, hashMap);
        }
    }

    static class g extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f30716a;

        /* renamed from: b */
        final /* synthetic */ String f30717b;

        /* renamed from: c */
        final /* synthetic */ String f30718c;

        g(com.vivo.ad.model.b bVar, String str, String str2) {
            this.f30716a = bVar;
            this.f30717b = str;
            this.f30718c = str2;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "425");
            hashMap.put("ptype", this.f30716a.i());
            hashMap.put(OapsKey.KEY_TOKEN, this.f30716a.P());
            hashMap.put("id", this.f30716a.d());
            hashMap.put("dspid", String.valueOf(this.f30716a.q()));
            hashMap.put("reason", this.f30717b);
            hashMap.put("renderType", String.valueOf(this.f30716a.a() == null ? -1 : this.f30716a.a().a()));
            if (this.f30716a.Q() != null) {
                hashMap.put("materialids", this.f30716a.Q() != null ? this.f30716a.Q().f() : "");
            } else {
                hashMap.put("materialids", this.f30716a.f() != null ? this.f30716a.f().f() : "");
            }
            k0.b(this.f30716a.G(), this.f30716a.C(), this.f30718c, (JSONObject) null, hashMap);
        }
    }

    public static void b(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "424");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        com.vivo.ad.model.f f2 = bVar.f();
        com.vivo.ad.model.a0 Q = bVar.Q();
        hashMap.put("materialids", Q != null ? Q.f() : f2 != null ? f2.f() : "");
        com.vivo.ad.model.q y = bVar.y();
        if (y != null) {
            if (!TextUtils.isEmpty(y.a())) {
                hashMap.put("pkg", y.a());
            }
            hashMap.put("appid", String.valueOf(y.c()));
        }
        b(bVar.G(), bVar.C(), (String) null, (JSONObject) null, hashMap);
    }

    public static void c(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "421");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        com.vivo.ad.model.f f2 = bVar.f();
        com.vivo.ad.model.a0 Q = bVar.Q();
        hashMap.put("materialids", Q != null ? Q.f() : f2 != null ? f2.f() : "");
        com.vivo.ad.model.q y = bVar.y();
        if (y != null) {
            if (!TextUtils.isEmpty(y.a())) {
                hashMap.put("pkg", y.a());
            }
            hashMap.put("appid", String.valueOf(y.c()));
        }
        b(bVar.G(), bVar.C(), (String) null, (JSONObject) null, hashMap);
    }

    public static void d(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "423");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        com.vivo.ad.model.f f2 = bVar.f();
        com.vivo.ad.model.a0 Q = bVar.Q();
        hashMap.put("materialids", Q != null ? Q.f() : f2 != null ? f2.f() : "");
        com.vivo.ad.model.q y = bVar.y();
        if (y != null) {
            if (!TextUtils.isEmpty(y.a())) {
                hashMap.put("pkg", y.a());
            }
            hashMap.put("appid", String.valueOf(y.c()));
        }
        b(bVar.G(), bVar.C(), (String) null, (JSONObject) null, hashMap);
    }

    public static void a() {
        if (!SystemUtils.isVivoPhone() && f0.c() && f0.b()) {
            f0.a(System.currentTimeMillis());
            a1.e(new a());
        }
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, String str) {
        String f2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "422");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        com.vivo.ad.model.f f3 = bVar.f();
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q != null) {
            f2 = Q.f();
        } else {
            f2 = f3 != null ? f3.f() : "";
        }
        hashMap.put("materialids", f2);
        com.vivo.ad.model.q y = bVar.y();
        if (y != null) {
            if (!TextUtils.isEmpty(y.a())) {
                hashMap.put("pkg", y.a());
            }
            hashMap.put("appid", String.valueOf(y.c()));
        }
        hashMap.put("dl_status", String.valueOf(i2));
        if (i2 == 0) {
            hashMap.put("errorCode", String.valueOf(i3));
            hashMap.put("reason", str);
        }
        b(bVar.G(), bVar.C(), (String) null, (JSONObject) null, hashMap);
    }

    public static void b(com.vivo.ad.model.b bVar, int i2, String str) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "412");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("reason", str);
        hashMap.put("status", String.valueOf(i2));
        b(bVar.G(), bVar.C(), (String) null, (JSONObject) null, hashMap);
    }

    public static void c(com.vivo.ad.model.b bVar, String str, String str2, String str3) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "217");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("materialids", bVar.Q() != null ? bVar.Q().f() : "");
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("ad_sdk", str3);
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/videoplay", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(str);
        b(cVar);
    }

    public static void d(com.vivo.ad.model.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "402");
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void d(String str, int i2) {
        d(str, i2, 1);
    }

    public static void d(String str, int i2, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "2140");
            hashMap.put("pstId", str);
            hashMap.put("appId", b.a.a.a.a.b().a(i3).getAppId());
            hashMap.put("adLoad", String.valueOf(i2));
            hashMap.put("appPkg", b.a.a.a.a.b().a(i3).getPackageName());
            hashMap.put("versionName", b.a.a.a.a.b().a(i3).getVersionName());
            hashMap.put("versionCode", b.a.a.a.a.b().a(i3).getVersionCode());
            hashMap.put("thirdSdkType", String.valueOf(i3));
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "416");
        hashMap.put("mediaId", str);
        hashMap.put("ac_adsdk", str2);
        b((String) null, (String) null, (String) null, (JSONObject) null, hashMap);
    }

    public static void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "411");
        hashMap.put("clientName", String.valueOf(n.a.d()));
        if (com.vivo.mobilead.manager.f.j().c() != null) {
            hashMap.put(com.heytap.mcssdk.n.d.p, com.vivo.mobilead.manager.f.j().c().getPackageName());
        }
        b((String) null, (String) null, (String) null, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, str4, 1);
    }

    public static void a(String str, String str2, String str3, String str4, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "100");
        hashMap.put("ptype", str);
        if ("3".equals(str)) {
            hashMap.put("orientation", String.valueOf(w0.c()));
        }
        hashMap.put("ad_sdk", str2);
        hashMap.put("get_config", com.vivo.mobilead.manager.f.j().b() + "");
        hashMap.put("reqCount", String.valueOf(i2));
        b(str3, str4, (String) null, (JSONObject) null, hashMap);
    }

    public static void c(com.vivo.ad.model.b bVar, String str, String str2) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.vivo.mobilead.util.f1.c.c(new g(bVar, str, str2));
    }

    public static void c(com.vivo.ad.model.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "418");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str);
        cVar.b(bVar.C());
        com.vivo.mobilead.b.b.c().b(cVar);
        com.vivo.mobilead.manager.c.d().a(cVar);
    }

    public static void b(com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, int i4, int i5, String str3) {
        a1.e(new f(bVar, str3, i4, i5, i2, str, i3, str2));
    }

    public static void b(String str, String str2, String str3, String str4, String str5, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "217");
        hashMap.put("ptype", str);
        hashMap.put(OapsKey.KEY_TOKEN, str3);
        hashMap.put("ad_sdk", str2);
        hashMap.put("renderType", String.valueOf(i2));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/videoplay", hashMap), "vivo");
        cVar.c(str4);
        cVar.b(str5);
        b(cVar);
    }

    public static void a(String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8) {
        a(str, str2, str3, i2, str4, str5, str6, str7, str8, -999, 1);
    }

    public static void a(String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "101");
        hashMap.put("ptype", str);
        hashMap.put("win_adsdk", str3);
        hashMap.put("result", str2);
        hashMap.put(OapsKey.KEY_TOKEN, str5);
        hashMap.put("id", str4);
        hashMap.put("linkErrCode", str8);
        hashMap.put("acwin_adsdk", String.valueOf(i2));
        if (-999 != i3) {
            hashMap.put("ac_adCount", String.valueOf(i3));
        }
        hashMap.put("adCount", String.valueOf(i4));
        b(str7, str6, (String) null, (JSONObject) null, hashMap);
    }

    public static void b(com.vivo.ad.model.b bVar, String str, String str2, String str3) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "406");
        hashMap.put("ptype", str);
        hashMap.put("ad_sdk", str2);
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        }
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", bVar.q() + "");
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/videoplay", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(str3);
        b(cVar);
    }

    public static void c(String str, int i2) {
        c(str, i2, 1);
    }

    public static void c(String str, int i2, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "2130");
            hashMap.put("pstId", str);
            hashMap.put("appId", b.a.a.a.a.b().a(i3).getAppId());
            hashMap.put("adLoad", String.valueOf(i2));
            hashMap.put("appPkg", b.a.a.a.a.b().a(i3).getPackageName());
            hashMap.put("versionName", b.a.a.a.a.b().a(i3).getVersionName());
            hashMap.put("versionCode", b.a.a.a.a.b().a(i3).getVersionCode());
            hashMap.put("thirdSdkType", String.valueOf(i3));
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
        } catch (Exception unused) {
        }
    }

    public static void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, int i5, String str, int i6, String str2, int i7, boolean z2) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", str);
        hashMap.put("id", bVar.d());
        hashMap.put("uiVersion", i7 + "");
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("realX", String.valueOf(i2));
        hashMap.put("realY", String.valueOf(i3));
        hashMap.put("x", String.valueOf(i4));
        hashMap.put("y", String.valueOf(i5));
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("dlCfg", z2 ? "2" : "1");
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("clickArea", z ? String.valueOf(2) : String.valueOf(1));
        hashMap.put("preturn", String.valueOf(i6));
        hashMap.put("ad_sdk", c.a.f28912a + "");
        hashMap.put("renderStyle", String.valueOf(bVar.F()));
        if (bVar.l() == 2) {
            hashMap.put("button", bVar.X() ? String.valueOf(2) : String.valueOf(1));
            if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
                hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
            }
        }
        b(bVar.G(), bVar.C(), str2, (JSONObject) null, hashMap);
    }

    public static void b(com.vivo.ad.model.b bVar, int i2, int i3, int i4, String str, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "118");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("materialids", bVar.Q().f());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("broadcasttime", String.valueOf(i2));
        if (i3 > 0) {
            hashMap.put("duration", String.valueOf(i3));
        }
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("status", String.valueOf(i4));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/videoplay", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(str);
        b(cVar);
    }

    public static void b(String str, com.vivo.ad.model.b bVar, int i2, int i3, String str2) {
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "108");
            hashMap.put("ptype", str);
            hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
            hashMap.put("id", bVar.d());
            hashMap.put("status", String.valueOf(i2));
            if (i2 == 0) {
                hashMap.put("reason", str2);
                hashMap.put("errorCode", String.valueOf(i3));
            }
            com.vivo.ad.model.y M = bVar.M();
            if (M != null) {
                hashMap.put("style_id", M.f());
                hashMap.put("template_id", M.g());
                hashMap.put("style_direction", "" + M.e());
            }
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.b(bVar.C());
            cVar.c(bVar.G());
            b(cVar);
        }
    }

    public static void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, int i5, String str, int i6, String str2, int i7, boolean z2, boolean z3) {
        a(bVar, z, i2, i3, i4, i5, str, i6, str2, i7, z2, false, z3);
    }

    public static void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, int i5, String str, int i6, String str2, int i7, boolean z2, boolean z3, boolean z4) {
        a(bVar, z, i2, i3, i4, i5, (com.vivo.ad.model.w) null, str, i6, str2, i7, z2, z3, "", -1, z4);
    }

    public static void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, int i5, com.vivo.ad.model.w wVar, String str, int i6, String str2, int i7, boolean z2, boolean z3) {
        a(bVar, z, i2, i3, i4, i5, (com.vivo.ad.model.w) null, str, i6, str2, i7, z2, false, "", -1, z3);
    }

    public static void a(com.vivo.ad.model.b bVar, boolean z, int i2, int i3, int i4, int i5, com.vivo.ad.model.w wVar, String str, int i6, String str2, int i7, boolean z2, boolean z3, String str3, int i8, boolean z4) {
        com.vivo.ad.model.d b2;
        com.vivo.ad.model.d b3;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", str);
        hashMap.put("id", bVar.d());
        hashMap.put("uiVersion", i7 + "");
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("realX", String.valueOf(i2));
        hashMap.put("realY", String.valueOf(i3));
        hashMap.put("x", String.valueOf(i4));
        hashMap.put("y", String.valueOf(i5));
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("dlCfg", z4 ? "2" : "1");
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("clickArea", z ? String.valueOf(2) : String.valueOf(1));
        if (bVar.l() == 5) {
            hashMap.put("clickType", z3 ? String.valueOf(2) : String.valueOf(1));
        }
        com.vivo.ad.model.y M = bVar.M();
        if (M != null && M.k()) {
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("clickArea", str3);
            }
            if (i8 != -1) {
                hashMap.put("dynamicMaterialType", "" + i8);
            }
            hashMap.put("style_id", M.f());
            hashMap.put("template_id", M.g());
            hashMap.put("style_direction", "" + M.e());
        } else {
            hashMap.put("clickArea", z ? String.valueOf(2) : String.valueOf(1));
        }
        hashMap.put("preturn", String.valueOf(i6));
        hashMap.put("ad_sdk", c.a.f28912a + "");
        if (i7 == 0 && bVar.l() == 2) {
            hashMap.put("compatibleType", String.valueOf(a(bVar)));
        }
        if (bVar.X() && (b3 = bVar.b()) != null && b3.l()) {
            hashMap.put("button_url", Base64.encodeToString(b3.h().getBytes(), 2));
        }
        if (q.a(bVar)) {
            hashMap.put("if_app_compliance_elements", z2 ? String.valueOf(1) : String.valueOf(0));
        }
        if (bVar.l() == 2) {
            hashMap.put("button", bVar.X() ? String.valueOf(2) : String.valueOf(1));
            if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
                hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
            }
        }
        b(bVar.G(), bVar.C(), str2, (JSONObject) null, hashMap);
    }

    public static void b(com.vivo.ad.model.b bVar, int i2, int i3, int i4, String str) {
        if (bVar == null || TextUtils.isEmpty(bVar.A())) {
            return;
        }
        String A = bVar.A();
        if (i2 != 1) {
            if (A.contains("__AUCTION_LOSS__")) {
                if (i4 < 1 || i4 > 3) {
                    i4 = 10001;
                }
                A = A.replace("__AUCTION_LOSS__", com.vivo.mobilead.i.g.c(String.valueOf(i4)));
            }
        } else if (bVar.m() == 2 && ((i3 <= 0 || i3 > bVar.D()) && A.contains("__AUCTION_LOSS__"))) {
            A = A.replace("__AUCTION_LOSS__", com.vivo.mobilead.i.g.c(String.valueOf(10001)));
        }
        if (A.contains("__WIN_PRICE__")) {
            A = A.replace("__WIN_PRICE__", com.vivo.mobilead.i.g.c(String.valueOf(i3)));
        }
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(A, "vivo");
        cVar.c(1);
        cVar.b(1);
        cVar.e(str);
        cVar.a(a.EnumC0603a.SHOW);
        b(cVar);
    }

    public static void b(com.vivo.mobilead.b.c cVar) {
        if (cVar != null) {
            com.vivo.mobilead.b.b.c().b(cVar);
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void b(String str, String str2, String str3, JSONObject jSONObject, Map<String, String> map) {
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", map), "vivo");
        cVar.c(str);
        cVar.e(str3);
        cVar.b(str2);
        if (jSONObject != null) {
            cVar.d(jSONObject.toString());
        }
        com.vivo.mobilead.b.b.c().b(cVar);
        com.vivo.mobilead.manager.c.d().a(cVar);
    }

    public static void b(com.vivo.ad.model.b bVar, String str, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "414");
        hashMap.put("id", bVar.d());
        hashMap.put(str, str2);
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        b(cVar);
    }

    public static void b(com.vivo.ad.model.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "419");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str);
        cVar.b(bVar.C());
        com.vivo.mobilead.b.b.c().b(cVar);
        com.vivo.mobilead.manager.c.d().a(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, long j2, int i2, String str, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "111");
        hashMap.put("ptype", String.valueOf(str));
        hashMap.put("id", bVar.d());
        if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("reqTime", String.valueOf(bVar.w()));
        hashMap.put("showTime", String.valueOf(j2));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("closetype", String.valueOf(i2));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str2);
        b(cVar);
    }

    public static void b(String str, int i2) {
        b(str, i2, 1);
    }

    public static void b(String str, int i2, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "2110");
            hashMap.put("pstId", str);
            hashMap.put("appId", b.a.a.a.a.b().a(i3).getAppId());
            hashMap.put("adLoad", String.valueOf(i2));
            hashMap.put("appPkg", b.a.a.a.a.b().a(i3).getPackageName());
            hashMap.put("versionName", b.a.a.a.a.b().a(i3).getVersionName());
            hashMap.put("versionCode", b.a.a.a.a.b().a(i3).getVersionCode());
            hashMap.put("thirdSdkType", String.valueOf(i3));
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
        } catch (Exception unused) {
        }
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, String str, String str2, int i6) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", str);
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
        hashMap.put("uiVersion", i6 + "");
        hashMap.put("ad_sdk", c.a.f28912a + "");
        if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        hashMap.put("renderStyle", String.valueOf(bVar.F()));
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        com.vivo.ad.model.y M = bVar.M();
        if (M != null && M.k()) {
            hashMap.put("style_id", M.f());
            hashMap.put("template_id", M.g());
            hashMap.put("style_direction", "" + M.e());
        }
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(str2);
        cVar.a(bVar.n());
        b(cVar);
    }

    public static void a(String str, String str2, int i2, int i3, int i4, int i5, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", str2);
        hashMap.put("uiVersion", String.valueOf(i2));
        hashMap.put("ad_sdk", String.valueOf(i3));
        hashMap.put("renderType", String.valueOf(i4));
        hashMap.put("renderStyle", String.valueOf(i5));
        hashMap.put("admsg", str);
        hashMap.put("duration", String.valueOf(j2));
        b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, String str3, String str4) {
        if (bVar == null) {
            return;
        }
        com.vivo.ad.model.r z = bVar.z();
        int i2 = 0;
        if (z != null && 1 == z.a()) {
            i2 = 1;
        }
        com.vivo.ad.model.f f2 = bVar.f();
        com.vivo.ad.model.a0 Q = bVar.Q();
        String f3 = f2 != null ? f2.f() : "";
        if (Q != null) {
            f3 = Q.f();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "410");
        hashMap.put("ptype", bVar.i());
        hashMap.put("renderType", str2);
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("materialids", f3);
        hashMap.put("adStyle", String.valueOf(bVar.j()));
        hashMap.put("isDeeplink", String.valueOf(i2));
        hashMap.put("openType", str3);
        hashMap.put("uiVersion", str4);
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7) {
        a1.b(new b(str3, i2, i4, i3, i5, i6, i7, str, str2));
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6) {
        a1.b(new c(str3, i2, i4, i3, i5, i6, str, str2));
    }

    public static void a(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a1.b(new d(str, i5, i4, i3, i6, i9, i7, i8, i2, str2, str3, str4));
    }

    public static void a(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, String str5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "214");
        hashMap.put("ptype", str3);
        hashMap.put(OapsKey.KEY_TOKEN, str4);
        hashMap.put("uiVersion", String.valueOf(i2));
        hashMap.put("materialType", String.valueOf(i3));
        hashMap.put("status", String.valueOf(i4));
        hashMap.put("linkErrCode", String.valueOf(i5));
        hashMap.put("reason", str5);
        hashMap.put("ad_sdk", String.valueOf(i6));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.b(str);
        cVar.c(str2);
        b(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, int i2, int i3, int i4, int i5, int i6) {
        if (bVar == null) {
            return;
        }
        String d2 = bVar.d();
        com.vivo.ad.model.f f2 = bVar.f();
        com.vivo.ad.model.a0 Q = bVar.Q();
        String f3 = f2 != null ? f2.f() : d2;
        if (Q != null) {
            f3 = Q.f();
        }
        int q = bVar.q();
        String G = bVar.G();
        String P = bVar.P();
        x0.a("ReportData", "The AdId:" + d2);
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "214");
        hashMap.put("uiVersion", i4 + "");
        hashMap.put("ptype", str);
        hashMap.put("status", String.valueOf(1));
        hashMap.put("id", d2);
        hashMap.put("materialids", f3);
        hashMap.put(OapsKey.KEY_TOKEN, P);
        hashMap.put("reqType", String.valueOf(i3));
        hashMap.put("renderStyle", String.valueOf(bVar.F()));
        hashMap.put("ad_sdk", String.valueOf(i5));
        hashMap.put("materialType", String.valueOf(i6));
        if (bVar.l() == 4) {
            hashMap.put("realMaterialType", String.valueOf(bVar.Q() != null ? 2 : 1));
        }
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if ("3".equals(str) || "1".equals(str)) {
            hashMap.put("orientation", String.valueOf(i2));
            hashMap.put("compatibleType", String.valueOf(a(bVar)));
        }
        hashMap.put("dspid", String.valueOf(q));
        if (9 == bVar.l()) {
            hashMap.put("file_flag", String.valueOf(bVar.x()));
        }
        com.vivo.ad.model.d b2 = bVar.b();
        if (b2 != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        com.vivo.mobilead.b.d dVar = new com.vivo.mobilead.b.d();
        dVar.c("vivo");
        dVar.a(String.valueOf(-99));
        dVar.d(String.valueOf(1));
        dVar.b("");
        b(G, bVar.C(), str2, dVar.a(), hashMap);
    }

    public static void a(List<com.vivo.ad.model.b> list, int i2, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6, int i7) {
        JSONArray jSONArray = new JSONArray();
        HashMap hashMap = new HashMap();
        Iterator<com.vivo.ad.model.b> it = list.iterator();
        int i8 = 0;
        while (true) {
            if (!it.hasNext()) {
                hashMap.put("cfrom", "214");
                hashMap.put("uiVersion", i3 + "");
                hashMap.put("ptype", str4);
                hashMap.put("status", String.valueOf(1));
                hashMap.put("reqType", String.valueOf(i2));
                hashMap.put("renderStyle", String.valueOf(i8));
                hashMap.put("ad_sdk", String.valueOf(i4));
                hashMap.put("materialType", String.valueOf(i5));
                hashMap.put("renderType", String.valueOf(i6));
                hashMap.put("admsg", jSONArray.toString());
                com.vivo.mobilead.b.d dVar = new com.vivo.mobilead.b.d();
                dVar.c("vivo");
                dVar.a(String.valueOf(-99));
                dVar.d(String.valueOf(i7));
                dVar.b("");
                b(str, str2, str3, dVar.a(), hashMap);
                return;
            }
            com.vivo.ad.model.b next = it.next();
            if (next != null) {
                i8 = next.F();
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(next.P())) {
                    t.a(jSONObject, OapsKey.KEY_TOKEN, next.P());
                }
                if (!TextUtils.isEmpty(next.d())) {
                    t.a(jSONObject, "id", next.d());
                }
                if (!TextUtils.isEmpty(next.q() + "")) {
                    t.a(jSONObject, "dspid", next.q() + "");
                }
                com.vivo.ad.model.f f2 = next.f();
                com.vivo.ad.model.a0 Q = next.Q();
                String f3 = f2 != null ? f2.f() : "";
                if (Q != null) {
                    f3 = Q.f();
                }
                if (!TextUtils.isEmpty(f3)) {
                    t.a(jSONObject, "materialids", f3);
                }
                t.a(jSONObject, "status", String.valueOf(i7));
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    public static void a(List<com.vivo.ad.model.b> list, int i2, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6) {
        JSONArray jSONArray = new JSONArray();
        HashMap hashMap = new HashMap();
        Iterator<com.vivo.ad.model.b> it = list.iterator();
        int i7 = 0;
        while (true) {
            if (!it.hasNext()) {
                hashMap.put("cfrom", "214");
                hashMap.put("uiVersion", i3 + "");
                hashMap.put("ptype", str4);
                hashMap.put("status", String.valueOf(1));
                hashMap.put("reqType", String.valueOf(i2));
                hashMap.put("renderStyle", String.valueOf(i7));
                hashMap.put("ad_sdk", String.valueOf(i4));
                hashMap.put("materialType", String.valueOf(i5));
                hashMap.put("renderType", String.valueOf(i6));
                hashMap.put("admsg", jSONArray.toString());
                com.vivo.mobilead.b.d dVar = new com.vivo.mobilead.b.d();
                dVar.c("vivo");
                dVar.a(String.valueOf(-99));
                dVar.d(String.valueOf(1));
                dVar.b("");
                b(str, str2, str3, dVar.a(), hashMap);
                return;
            }
            com.vivo.ad.model.b next = it.next();
            if (next != null) {
                i7 = next.F();
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(next.d())) {
                    t.a(jSONObject, "id", next.d());
                }
                if (!TextUtils.isEmpty(next.q() + "")) {
                    t.a(jSONObject, "dspid", next.q() + "");
                }
                com.vivo.ad.model.f f2 = next.f();
                com.vivo.ad.model.a0 Q = next.Q();
                String f3 = f2 != null ? f2.f() : "";
                if (Q != null) {
                    f3 = Q.f();
                }
                if (!TextUtils.isEmpty(f3)) {
                    t.a(jSONObject, "materialids", f3);
                }
                if (!TextUtils.isEmpty(next.P())) {
                    t.a(jSONObject, OapsKey.KEY_TOKEN, next.P());
                }
                t.a(jSONObject, "display_mode", String.valueOf(b0.a(next)));
                com.vivo.ad.model.d b2 = next.b();
                if (b2 != null && b2.l()) {
                    t.a(jSONObject, "button_url", Base64.encodeToString(b2.h().getBytes(), 2));
                }
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    public static int a(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.e c2;
        int v;
        if (bVar == null || (c2 = bVar.c()) == null || (v = c2.v()) == 0) {
            return 1;
        }
        if (v == 1) {
            return 2;
        }
        return v == 2 ? 3 : 1;
    }

    public static void a(AdError adError, String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "214");
        hashMap.put("ptype", str3);
        hashMap.put("uiVersion", i4 + "");
        hashMap.put("status", String.valueOf(2));
        hashMap.put("id", adError.getADID());
        hashMap.put(OapsKey.KEY_TOKEN, adError.getToken());
        hashMap.put("materialids", adError.getMaterialsIDs());
        hashMap.put("reqType", String.valueOf(i3));
        hashMap.put("linkErrCode", adError.getErrorCode() + "");
        hashMap.put("renderType", String.valueOf(i5));
        hashMap.put("ad_sdk", String.valueOf(i6));
        hashMap.put("materialType", String.valueOf(i7));
        if ("3".equals(str3) || "1".equals(str3)) {
            hashMap.put("orientation", String.valueOf(i2));
        }
        com.vivo.mobilead.b.d dVar = new com.vivo.mobilead.b.d();
        dVar.c("vivo");
        dVar.a(String.valueOf(-99));
        dVar.d("0");
        dVar.b(adError.getErrorMsg());
        b(adError.getRequestId(), str, str2, dVar.a(), hashMap);
    }

    public static void a(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "401");
        hashMap.put("saveauthorization", i2 + "");
        hashMap.put(com.heytap.mcssdk.n.d.p, n.h());
        b((String) null, (String) null, (String) null, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, int i4, int i5, String str3) {
        a1.e(new e(bVar, str3, i4, i5, i2, str, i3, str2));
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, String str, int i3, int i4, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "218");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
            hashMap.put("scene", String.valueOf(i3));
            hashMap.put("dfrom", String.valueOf(i4));
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("status", String.valueOf(i2));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, List<Long> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            long j2 = 0;
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                j2 += it.next().longValue();
            }
            hashMap.put("buffering_time", String.valueOf(j2));
            hashMap.put("buffering_nums", String.valueOf(list.size()));
        }
        hashMap.put("cfrom", "405");
        hashMap.put("url", str);
        hashMap.put("changeplayer", str2);
        hashMap.put("frameskip", str3);
        hashMap.put("disconnect", str4);
        hashMap.put("is_playover", "" + i2);
        hashMap.put(com.alipay.mobilesecuritysdk.deviceID.c.y, str5);
        b(str7, str6, (String) null, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", str);
        hashMap.put(OapsKey.KEY_TOKEN, str3);
        hashMap.put("uiVersion", i2 + "");
        hashMap.put("ad_sdk", str2);
        b(str4, str5, (String) null, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j2, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", str);
        hashMap.put(OapsKey.KEY_TOKEN, str3);
        hashMap.put("duration", String.valueOf(j2));
        hashMap.put("uiVersion", i2 + "");
        hashMap.put("ad_sdk", str2);
        b(str4, str5, (String) null, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, int i2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", str);
        hashMap.put(OapsKey.KEY_TOKEN, str3);
        hashMap.put("uiVersion", i2 + "");
        hashMap.put("ad_sdk", str2);
        hashMap.put("dlCfg", z ? "2" : "1");
        b(str4, str5, (String) null, (JSONObject) null, hashMap);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "217");
        hashMap.put("ptype", str);
        hashMap.put(OapsKey.KEY_TOKEN, str3);
        hashMap.put("ad_sdk", str2);
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/videoplay", hashMap), "vivo");
        cVar.c(str4);
        cVar.b(str5);
        b(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, String str, String str2, String str3, int i3, int i4) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("uiVersion", i3 + "");
        if (i4 != -999) {
            hashMap.put("material_style", String.valueOf(i4));
        }
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
            hashMap.put("status", String.valueOf(1));
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("ad_sdk", str3);
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("iconStatus", String.valueOf(i2));
        if (bVar.l() == 9) {
            hashMap.put("file_flag", String.valueOf(bVar.x()));
        }
        if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, AdParams adParams, int i2, int i3, String str, long j2, String str2, int i4) {
        if (adParams == null) {
            return;
        }
        a(bVar, i2, i3, adParams.getSourceAppend(), str, adParams.getSplashOrientation(), j2, str2, i4);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2, int i4, long j2, String str3, int i5) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "211");
        hashMap.put("ptype", String.valueOf(str2));
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("duration", String.valueOf(j2));
        hashMap.put("uiVersion", i5 + "");
        hashMap.put("ad_sdk", str3);
        hashMap.put("orientation", i4 + "");
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("status", String.valueOf(1));
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        if (bVar.l() == 2) {
            hashMap.put("launchtype", String.valueOf(i2));
            if (i2 == 2) {
                hashMap.put("is_repeat", String.valueOf(i3));
            }
            hashMap.put("button", bVar.X() ? String.valueOf(2) : String.valueOf(1));
        }
        if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("compatibleType", String.valueOf(a(bVar)));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(str);
        b(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, String str, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "112");
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("reason", String.valueOf(i2));
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, int i10, boolean z) {
        a(bVar, i2, i3, i4, i5, i6, i7, i8, i9, str, str2, str3, i10, false, "", z);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, int i10, boolean z, String str4, int i11, boolean z2) {
        com.vivo.ad.model.d b2;
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", str2);
        hashMap.put("uiVersion", i10 + "");
        hashMap.put("id", bVar.d());
        hashMap.put("material_style", String.valueOf(i11));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        }
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("realX", String.valueOf(i5));
        hashMap.put("realY", String.valueOf(i6));
        hashMap.put("x", String.valueOf(i7));
        hashMap.put("y", String.valueOf(i8));
        hashMap.put("scene", String.valueOf(i3));
        hashMap.put("ad_sdk", str3);
        hashMap.put("clickArea", String.valueOf(i4));
        hashMap.put("dlCfg", z2 ? "2" : "1");
        hashMap.put("preturn", String.valueOf(i9));
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (q.a(bVar)) {
            hashMap.put("if_app_compliance_elements", z ? String.valueOf(1) : String.valueOf(0));
        }
        if (i3 == 1 || i3 == 4) {
            hashMap.put("iconStatus", String.valueOf(i2));
        }
        if (bVar.l() == 9) {
            hashMap.put("file_flag", String.valueOf(bVar.x()));
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("display_page", str4);
        }
        if (bVar.X() && (b2 = bVar.b()) != null && b2.l()) {
            hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
        }
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, int i10, boolean z, String str4, boolean z2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "212");
        hashMap.put("ptype", str2);
        hashMap.put("uiVersion", i10 + "");
        hashMap.put("id", bVar.d());
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        }
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("realX", String.valueOf(i5));
        hashMap.put("realY", String.valueOf(i6));
        hashMap.put("x", String.valueOf(i7));
        hashMap.put("y", String.valueOf(i8));
        hashMap.put("scene", String.valueOf(i3));
        hashMap.put("ad_sdk", str3);
        hashMap.put("clickArea", String.valueOf(i4));
        hashMap.put("dlCfg", z2 ? "2" : "1");
        hashMap.put("preturn", String.valueOf(i9));
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (q.a(bVar)) {
            hashMap.put("if_app_compliance_elements", z ? String.valueOf(1) : String.valueOf(0));
        }
        if (i3 == 1 || i3 == 4) {
            hashMap.put("iconStatus", String.valueOf(i2));
        }
        if (bVar.l() == 9) {
            hashMap.put("file_flag", String.valueOf(bVar.x()));
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("display_page", str4);
        }
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, String str, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "115");
        hashMap.put("ptype", str);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (bVar.Q() != null) {
            if (i2 == 1) {
                hashMap.put("broadcasttime", String.valueOf(i3));
                hashMap.put("playsstatus", "1");
            } else {
                hashMap.put("playsstatus", "2");
            }
            hashMap.put("clickPosition", String.valueOf(i2));
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("closetype", String.valueOf(i4));
        new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        b(bVar.G(), bVar.C(), str2, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, int i2, int i3, int i4) {
        a(bVar, str, str2, i2, i3, i4, "");
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, int i2, int i3, int i4, String str3, int i5) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "115");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("material_style", String.valueOf(i5));
        if (bVar.Q() != null) {
            if (TextUtils.isEmpty(str3)) {
                if (i2 == 1) {
                    hashMap.put("broadcasttime", String.valueOf(i3));
                    hashMap.put("playsstatus", "1");
                } else {
                    hashMap.put("playsstatus", "2");
                }
            } else if ("1".equals(str3)) {
                hashMap.put("broadcasttime", String.valueOf(i3));
                hashMap.put("playsstatus", "1");
            } else {
                hashMap.put("playsstatus", "2");
            }
            hashMap.put("clickPosition", String.valueOf(i2));
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("closetype", String.valueOf(i4));
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, int i2, int i3, int i4, String str3) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "115");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        hashMap.put("renderStyle", String.valueOf(bVar.F()));
        if (bVar.Q() != null) {
            if (TextUtils.isEmpty(str3)) {
                if (i2 == 1) {
                    hashMap.put("broadcasttime", String.valueOf(i3));
                    hashMap.put("playsstatus", "1");
                } else {
                    hashMap.put("playsstatus", "2");
                }
            } else if ("1".equals(str3)) {
                hashMap.put("broadcasttime", String.valueOf(i3));
                hashMap.put("playsstatus", "1");
            } else {
                hashMap.put("playsstatus", "2");
            }
            hashMap.put("clickPosition", String.valueOf(i2));
            hashMap.put("materialids", bVar.Q().f());
            hashMap.put("file_flag", String.valueOf(bVar.x()));
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("closetype", String.valueOf(i4));
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(List<com.vivo.ad.model.b> list, String str, int i2, int i3, int i4) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.vivo.ad.model.b> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                HashMap hashMap = new HashMap();
                hashMap.put("cfrom", "115");
                hashMap.put("ptype", str);
                hashMap.put("renderType", String.valueOf(i3));
                hashMap.put("renderStyle", String.valueOf(i4));
                hashMap.put("closetype", String.valueOf(i2));
                hashMap.put("admsg", jSONArray.toString());
                b("", "", "", (JSONObject) null, hashMap);
                return;
            }
            com.vivo.ad.model.b next = it.next();
            if (next != null) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(next.P())) {
                    t.a(jSONObject, OapsKey.KEY_TOKEN, next.P());
                }
                if (!TextUtils.isEmpty(next.d())) {
                    t.a(jSONObject, "id", next.d());
                }
                if (!TextUtils.isEmpty(next.q() + "")) {
                    t.a(jSONObject, "dspid", next.q() + "");
                }
                com.vivo.ad.model.f f2 = next.f();
                String f3 = f2 != null ? f2.f() : "";
                if (!TextUtils.isEmpty(f3)) {
                    t.a(jSONObject, "materialids", f3);
                }
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, String str3, long j2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "219");
        hashMap.put("ptype", str2);
        hashMap.put("id", bVar.d());
        hashMap.put("prebroadcasting_time", String.valueOf(j2));
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("materialids", bVar.Q() != null ? bVar.Q().f() : "");
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("ad_sdk", str3);
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn/videoplay", hashMap), "vivo");
        cVar.b(bVar.C());
        cVar.c(bVar.G());
        cVar.e(str);
        b(cVar);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "105");
        hashMap.put("ptype", str);
        hashMap.put(OapsKey.KEY_TOKEN, str2);
        hashMap.put("admsg", str6);
        hashMap.put("ad_sdk", str3);
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.b(str4);
        cVar.c(str5);
        b(cVar);
    }

    public static void a(String str, com.vivo.ad.model.b bVar, int i2) {
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "106");
            hashMap.put("ptype", str);
            hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
            hashMap.put("id", bVar.d());
            hashMap.put("status", String.valueOf(i2));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.b(bVar.C());
            cVar.c(bVar.G());
            b(cVar);
        }
    }

    public static void a(String str, com.vivo.ad.model.b bVar, int i2, int i3, String str2) {
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "107");
            hashMap.put("ptype", str);
            hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
            hashMap.put("id", bVar.d());
            hashMap.put("status", String.valueOf(i2));
            if (i2 == 0) {
                hashMap.put("reason", str2);
                hashMap.put("errorCode", String.valueOf(i3));
            }
            com.vivo.ad.model.y M = bVar.M();
            if (M != null) {
                hashMap.put("style_id", M.f());
                hashMap.put("template_id", M.g());
                hashMap.put("style_direction", "" + M.e());
            }
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.b(bVar.C());
            cVar.c(bVar.G());
            b(cVar);
        }
    }

    public static void a(String str, List<com.vivo.mobilead.unified.exitFloat.c> list, int i2) {
        com.vivo.ad.model.b a2;
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.vivo.mobilead.unified.exitFloat.c cVar : list) {
            if (cVar != null && (a2 = cVar.a()) != null) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(a2.d())) {
                    t.a(jSONObject, "id", a2.d());
                }
                com.vivo.ad.model.f f2 = a2.f();
                if (f2 != null && !TextUtils.isEmpty(f2.e())) {
                    t.a(jSONObject, "title", f2.e());
                }
                if (!TextUtils.isEmpty(a2.P())) {
                    t.a(jSONObject, OapsKey.KEY_TOKEN, a2.P());
                }
                t.a(jSONObject, "status", String.valueOf(i2));
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "106");
        hashMap.put("ptype", str);
        hashMap.put("admsg", jSONArray.toString());
        b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, String str) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "400");
        hashMap.put("compreason", String.valueOf(i2));
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("ptype", bVar.i());
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.b(bVar.C());
        cVar.e(str);
        b(cVar);
    }

    public static void a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        com.vivo.mobilead.l.a.b().a("exceptionInfo", Log.getStackTraceString(th));
        if (TextUtils.isEmpty(stackTraceString) || !stackTraceString.contains("vivo")) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "300");
        hashMap.put("exceptionInfo", Log.getStackTraceString(th));
        hashMap.put("av", Uri.encode(String.valueOf(Build.VERSION.SDK_INT)));
        hashMap.put("make", Uri.encode(String.valueOf(Build.MANUFACTURER)));
        hashMap.put("androidId", Uri.encode(h0.K().j()));
        com.vivo.mobilead.manager.c.d().a(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
    }

    public static void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a, String str) {
        a(bVar, enumC0603a, -999, -999, -999, -999, -999, -999, -999, -999, str);
    }

    public static void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        a(bVar, enumC0603a, i2, i3, i4, i5, (com.vivo.ad.model.w) null, i6, i7, i8, i9, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (1 == r1.a()) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.vivo.ad.model.b r20, com.vivo.mobilead.model.a.EnumC0603a r21, int r22, int r23, int r24, int r25, com.vivo.ad.model.w r26, int r27, int r28, int r29, int r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.k0.a(com.vivo.ad.model.b, com.vivo.mobilead.model.a$a, int, int, int, int, com.vivo.ad.model.w, int, int, int, int, java.lang.String):void");
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, String str) {
        if (bVar == null || TextUtils.isEmpty(bVar.A())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "420");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        if (!TextUtils.isEmpty(bVar.o())) {
            hashMap.put("price_tag", String.valueOf(bVar.o()));
        }
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        if (i2 == 1) {
            hashMap.put("bidding_result", "1");
            if (bVar.m() == 2) {
                hashMap.put("bidding_price", String.valueOf(i3));
            } else {
                hashMap.put("bidding_price", String.valueOf(bVar.D()));
            }
            if (bVar.m() == 2 && (i3 <= 0 || i3 > bVar.D())) {
                hashMap.put("reason", String.valueOf(10001));
            }
        } else {
            hashMap.put("bidding_result", "0");
            if (i4 < 1 || i4 > 3) {
                i4 = 10001;
            }
            hashMap.put("reason", String.valueOf(i4));
            hashMap.put("cp_price", String.valueOf(i3));
        }
        hashMap.put(OapsKey.KEY_PRICE, String.valueOf(bVar.D()));
        b(bVar.G(), bVar.C(), str, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "407");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        hashMap.put("reason", str);
        hashMap.put("renderType", String.valueOf(bVar.a() == null ? -1 : bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        b(bVar.G(), bVar.C(), str2, (JSONObject) null, hashMap);
    }

    public static void a(com.vivo.ad.model.b bVar, int i2, int i3, String str, String str2) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "403");
        hashMap.put("ptype", bVar.i());
        hashMap.put("id", bVar.d());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("thirdApp", String.valueOf(i2));
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("openresult", String.valueOf(i3));
        hashMap.put("failreason", str);
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str2);
        cVar.b(bVar.C());
        com.vivo.mobilead.b.b.c().b(cVar);
        com.vivo.mobilead.manager.c.d().a(cVar);
    }

    public static void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "303");
        hashMap.put("exceptionInfo", "splash ad,the screen orientation is  no difference");
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.e(str);
        b(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, String str, double d2, double d3, double d4) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "415");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        hashMap.put("ad_sdk", c.a.f28912a + "");
        hashMap.put("button", bVar.X() ? String.valueOf(2) : String.valueOf(1));
        if (bVar.X()) {
            com.vivo.ad.model.d b2 = bVar.b();
            if (b2 != null && b2.l()) {
                hashMap.put("button_url", Base64.encodeToString(b2.h().getBytes(), 2));
            }
            hashMap.put("sliding_distance", "" + d4);
            hashMap.put("angle", "" + d2);
            hashMap.put("acceleration", "" + d3);
        }
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str);
        cVar.b(bVar.C());
        com.vivo.mobilead.b.b.c().b(cVar);
        com.vivo.mobilead.manager.c.d().a(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "417");
        hashMap.put("ptype", bVar.i());
        hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
        hashMap.put("id", bVar.d());
        hashMap.put("dspid", String.valueOf(bVar.q()));
        if (bVar.Q() != null) {
            hashMap.put("materialids", bVar.Q().f());
        } else if (bVar.f() != null) {
            hashMap.put("materialids", bVar.f().f());
        }
        hashMap.put("renderType", String.valueOf(bVar.a().a()));
        com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
        cVar.c(bVar.G());
        cVar.e(str);
        cVar.b(bVar.C());
        com.vivo.mobilead.b.b.c().b(cVar);
        com.vivo.mobilead.manager.c.d().a(cVar);
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2, String str3) {
        if (bVar == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "119");
            hashMap.put("display_page", str);
            hashMap.put("ptype", bVar.i());
            hashMap.put("id", bVar.d());
            hashMap.put(OapsKey.KEY_TOKEN, bVar.P());
            hashMap.put("renderType", String.valueOf(bVar.a().a()));
            if (bVar.Q() != null) {
                hashMap.put("materialids", bVar.Q().f());
            } else {
                hashMap.put("materialids", bVar.f().f());
            }
            hashMap.put("dspid", String.valueOf(bVar.q()));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(bVar.G());
            cVar.e(str2);
            cVar.a(str3);
            b(cVar);
        } catch (Exception unused) {
        }
    }

    public static void a(String str, int i2) {
        a(str, i2, 1);
    }

    public static void a(int i2, String str, String str2, String str3, String str4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "2001");
            hashMap.put("appPkg", str2);
            hashMap.put("versionName", str3);
            hashMap.put("versionCode", str4);
            hashMap.put("thirdSdkType", String.valueOf(i2));
            hashMap.put("appId", str);
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, int i2, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "2120");
            hashMap.put("pstId", str);
            hashMap.put("appId", b.a.a.a.a.b().a(i3).getAppId());
            hashMap.put("appPkg", b.a.a.a.a.b().a(i3).getPackageName());
            hashMap.put("versionName", b.a.a.a.a.b().a(i3).getVersionName());
            hashMap.put("versionCode", b.a.a.a.a.b().a(i3).getVersionCode());
            hashMap.put("thirdSdkType", String.valueOf(i3));
            hashMap.put("adLoad", String.valueOf(i2));
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, int... iArr) {
        if (iArr != null) {
            try {
                if (iArr.length == 0) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("cfrom", "2002");
                hashMap.put("mediaId", str);
                hashMap.put("appPkg", k.a(com.vivo.mobilead.manager.f.j().c()).a());
                hashMap.put("versionName", k.a(com.vivo.mobilead.manager.f.j().c()).c());
                hashMap.put("versionCode", String.valueOf(k.a(com.vivo.mobilead.manager.f.j().c()).b()));
                JSONArray jSONArray = new JSONArray();
                for (int i2 : iArr) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thirdSdkType", String.valueOf(i2));
                    jSONObject.put("isRep", "1");
                    jSONArray.put(jSONObject);
                }
                hashMap.put("exSdkInfo", jSONArray.toString());
                hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
                b(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
            } catch (Exception unused) {
            }
        }
    }
}
