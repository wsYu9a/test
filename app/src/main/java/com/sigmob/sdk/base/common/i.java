package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.k0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.views.q;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {
    private static final long serialVersionUID = 2;

    /* renamed from: b */
    public Map<String, String> f17810b;

    /* renamed from: c */
    public String f17811c;

    /* renamed from: d */
    public String f17812d;

    /* renamed from: e */
    public String f17813e;

    /* renamed from: f */
    public String f17814f;

    /* renamed from: g */
    public String f17815g;

    /* renamed from: h */
    public String f17816h;

    /* renamed from: i */
    public String f17817i;

    /* renamed from: k */
    public boolean f17819k;

    /* renamed from: l */
    public boolean f17820l;

    /* renamed from: m */
    public String f17821m;

    /* renamed from: n */
    public boolean f17822n;

    /* renamed from: o */
    public z f17823o;

    /* renamed from: p */
    public com.sigmob.sdk.base.views.q f17824p;

    /* renamed from: q */
    public WeakReference<Activity> f17825q;

    /* renamed from: r */
    public q.g f17826r;

    /* renamed from: s */
    public WeakReference<BaseAdUnit> f17827s;

    /* renamed from: t */
    public boolean f17828t;

    /* renamed from: u */
    public int f17829u;

    /* renamed from: v */
    public boolean f17830v;

    /* renamed from: j */
    public int f17818j = 1;

    /* renamed from: a */
    public final List<com.sigmob.sdk.videoAd.f> f17809a = new ArrayList();

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f17831a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f17832b;

        static {
            int[] iArr = new int[j0.values().length];
            f17832b = iArr;
            try {
                iArr[j0.f17909e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17832b[j0.f17906b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17832b[j0.f17907c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17832b[j0.f17908d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17832b[j0.f17910f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17832b[j0.f17911g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17832b[j0.f17912h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17832b[j0.f17913i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.base.a.values().length];
            f17831a = iArr2;
            try {
                iArr2[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17831a[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public class b implements q.g {
        public b() {
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            if (i.this.b() == null) {
                return;
            }
            if (i.this.f17826r != null) {
                i.this.f17826r.a(str, str2);
            }
            i iVar = i.this;
            iVar.b(iVar.b().getClickCommon().clickUIType, str, str2, true);
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            if (i.this.b() == null) {
                return;
            }
            d0 sessionManager = i.this.b().getSessionManager();
            if (sessionManager != null) {
                sessionManager.a(com.sigmob.sdk.base.common.a.f17653f, 0);
            }
            if (i.this.f17826r == null || !i.this.f17819k) {
                return;
            }
            i.this.f17826r.b();
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            if (i.this.f17824p != null) {
                i.this.f17824p.dismiss();
                i.this.f17824p.b();
                i.this.f17824p = null;
                i.this.f17819k = false;
            }
            if (i.this.b() == null) {
                return;
            }
            d0 sessionManager = i.this.b().getSessionManager();
            if (sessionManager != null) {
                sessionManager.a(com.sigmob.sdk.base.common.a.f17654g, 0);
            }
            if (i.this.f17826r != null) {
                i.this.f17826r.a();
            }
        }
    }

    public class c implements JsonRequest.Listener {

        public class a implements b0.g {
            public a() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(i.this.f17821m);
                }
            }
        }

        public class b implements b0.g {
            public b() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    ((PointEntitySigmobError) obj).setFinal_url(i.this.f17821m);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.base.common.i$c$c */
        public class C0564c implements b0.g {
            public C0564c() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(i.this.f17821m);
                }
            }
        }

        public class d implements b0.g {
            public d() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    ((PointEntitySigmobError) obj).setFinal_url(i.this.f17821m);
                }
            }
        }

        public class e implements b0.g {
            public e() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(i.this.f17821m);
                }
            }
        }

        public class f implements b0.g {
            public f() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    ((PointEntitySigmobError) obj).setFinal_url(i.this.f17821m);
                }
            }
        }

        public c() {
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (i.this.b() == null) {
                return;
            }
            b0.a("download_start", "0", i.this.b(), new e());
            b0.a("download_start", 0, volleyError.getMessage(), i.this.b(), new f());
            SigmobLog.e(volleyError.getMessage());
        }

        @Override // com.czhj.sdk.common.network.JsonRequest.Listener
        public void onSuccess(JSONObject jSONObject) {
            try {
                if (i.this.b() == null) {
                    return;
                }
                SigmobLog.d("GDTConvertRequest response " + jSONObject);
                if (jSONObject.getInt("ret") == 0) {
                    String string = jSONObject.getJSONObject(h3.e.f26408m).getString("dstlink");
                    i.this.b().getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, jSONObject.getJSONObject(h3.e.f26408m).getString("clickid"));
                    i.this.f17821m = string;
                    p.a(string, i.this.b());
                } else {
                    b0.a("download_start", "0", i.this.b(), new a());
                    b0.a("download_start", 0, jSONObject.toString(), i.this.b(), new b());
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                b0.a("download_start", "0", i.this.b(), new C0564c());
                b0.a("download_start", 0, th2.getMessage(), i.this.b(), new d());
            }
        }
    }

    public class d implements b0.g {
        public d() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(i.this.f17821m);
            }
        }
    }

    public class e implements b0.g {
        public e() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(i.this.f17821m);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ BaseAdUnit f17843a;

        public f(BaseAdUnit baseAdUnit) {
            this.f17843a = baseAdUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.sigmob.sdk.base.common.h.m() != null) {
                com.sigmob.sdk.base.common.h.f((BaseAdUnit) null);
                b0.a("open_pkg", "0", this.f17843a);
            }
        }
    }

    public class g implements JsonRequest.Listener {

        /* renamed from: a */
        public final /* synthetic */ BaseAdUnit f17844a;

        /* renamed from: b */
        public final /* synthetic */ String f17845b;

        public class a implements b0.g {
            public a() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(g.this.f17845b);
                }
            }
        }

        public class b implements b0.g {
            public b() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    ((PointEntitySigmobError) obj).setFinal_url(g.this.f17845b);
                }
            }
        }

        public class c implements b0.g {
            public c() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(g.this.f17845b);
                }
            }
        }

        public class d implements b0.g {
            public d() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    ((PointEntitySigmobError) obj).setFinal_url(g.this.f17845b);
                }
            }
        }

        public class e implements b0.g {
            public e() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(g.this.f17845b);
                }
            }
        }

        public class f implements b0.g {
            public f() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    ((PointEntitySigmobError) obj).setFinal_url(g.this.f17845b);
                }
            }
        }

        public g(BaseAdUnit baseAdUnit, String str) {
            this.f17844a = baseAdUnit;
            this.f17845b = str;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            b0.a("download_start", "0", this.f17844a, new e());
            b0.a("download_start", 0, volleyError.getMessage(), this.f17844a, new f());
            SigmobLog.e(volleyError.getMessage());
        }

        @Override // com.czhj.sdk.common.network.JsonRequest.Listener
        public void onSuccess(JSONObject jSONObject) {
            try {
                SigmobLog.d("GDTConvertRequest response " + jSONObject);
                if (jSONObject.getInt("ret") == 0) {
                    String string = jSONObject.getJSONObject(h3.e.f26408m).getString("dstlink");
                    this.f17844a.getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, jSONObject.getJSONObject(h3.e.f26408m).getString("clickid"));
                    p.a(string, this.f17844a);
                } else {
                    b0.a("download_start", "0", this.f17844a, new a());
                    b0.a("download_start", 0, jSONObject.toString(), this.f17844a, new b());
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                b0.a("download_start", "0", this.f17844a, new c());
                b0.a("download_start", 0, th2.getMessage(), this.f17844a, new d());
            }
        }
    }

    public class h implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f17852a;

        public h(String str) {
            this.f17852a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(this.f17852a);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.i$i */
    public class C0565i implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f17853a;

        public C0565i(String str) {
            this.f17853a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(this.f17853a);
            }
        }
    }

    public class j implements k0.f {

        /* renamed from: a */
        public final /* synthetic */ boolean f17854a;

        /* renamed from: b */
        public final /* synthetic */ boolean f17855b;

        /* renamed from: c */
        public final /* synthetic */ com.sigmob.sdk.base.a f17856c;

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17858a;

            public a(String str) {
                this.f17858a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f17858a);
                    if (i.this.b().getInteractionType() == 8) {
                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.a.f());
                    }
                }
            }
        }

        public class b implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17860a;

            public b(String str) {
                this.f17860a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f17860a);
                    if (i.this.b().getAndroidMarket() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("app_package_name", i.this.b().getAndroidMarket().app_package_name);
                        hashMap.put("store_package_name", i.this.b().getAndroidMarket().appstore_package_name);
                        pointEntitySigmob.setOptions(hashMap);
                    }
                }
            }
        }

        public class c implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17862a;

            public c(String str) {
                this.f17862a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f17862a);
                    if (i.this.b().getInteractionType() == 8) {
                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.a.f());
                    }
                }
            }
        }

        public class d implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17864a;

            public d(String str) {
                this.f17864a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f17864a);
                    HashMap hashMap = new HashMap();
                    hashMap.put("app_package_name", i.this.b().getAndroidMarket().app_package_name);
                    hashMap.put("store_package_name", i.this.b().getAndroidMarket().appstore_package_name);
                    pointEntitySigmob.setOptions(hashMap);
                }
            }
        }

        public j(boolean z10, boolean z11, com.sigmob.sdk.base.a aVar) {
            this.f17854a = z10;
            this.f17855b = z11;
            this.f17856c = aVar;
        }

        @Override // com.sigmob.sdk.base.common.k0.f
        public void a(String str, j0 j0Var) {
            AndroidMarket androidMarket;
            SigmobLog.d("urlHandlingSucceeded: " + j0Var.name() + " url: " + str);
            i.this.b().getClickCommon().is_final_click = true;
            if (!i.this.b().getAd().forbiden_parse_landingpage.booleanValue()) {
                b0.a(i.this.b(), j0Var.name(), str);
            }
            i.this.b().getClickCommon().isDeeplink = "0";
            int i10 = a.f17832b[j0Var.ordinal()];
            if (i10 == 3 || i10 == 4) {
                if (this.f17854a) {
                    com.sigmob.sdk.base.network.f.a(i.this.b(), "open_deeplink");
                    b0.a("open_deeplink", (String) null, i.this.b(), new a(str));
                }
                i.this.b().getClickCommon().isDeeplink = "1";
            } else if (i10 != 5) {
                if (i10 == 6) {
                    if (this.f17855b && i.this.l()) {
                        i.this.b().getClickCommon().is_final_click = false;
                    } else {
                        i.this.a(str);
                    }
                }
            } else if (this.f17854a) {
                BaseAdUnit b10 = i.this.b();
                if (b10 != null && (androidMarket = b10.getAndroidMarket()) != null) {
                    b0.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? "market" : "mimarket", b10);
                    if (!TextUtils.isEmpty(androidMarket.app_package_name)) {
                        try {
                            FileUtil.writeToCache(b10, new File(com.sigmob.sdk.base.utils.d.f(), androidMarket.app_package_name + ".log").getAbsolutePath());
                        } catch (Throwable th2) {
                            SigmobLog.e("write ad info with package error " + th2.getMessage());
                        }
                    }
                }
                b0.a(PointCategory.OPEN_MARKET, (String) null, i.this.b(), new b(str));
            }
            i.this.b().setCustomDeeplink(null);
            i.this.b().setCustomAndroidMarket(null);
            i.this.b().setCustomLandPageUrl(null);
            if (i.this.f17823o != null) {
                i.this.f17823o.a(this.f17854a, this.f17856c);
            }
        }

        @Override // com.sigmob.sdk.base.common.k0.f
        public void b(String str, j0 j0Var) {
            SigmobLog.d("urlHandlingFailed: " + j0Var.name() + " url: " + str);
            i.this.b().getClickCommon().isDeeplink = "0";
            int i10 = a.f17832b[j0Var.ordinal()];
            if (i10 == 3 || i10 == 4) {
                Log.d("lance", "打开小程序失败:" + j0Var);
                if (this.f17854a) {
                    com.sigmob.sdk.base.network.f.a(i.this.b(), "open_deeplink_failed");
                    b0.a("open_deeplink_failed", (String) null, i.this.b(), new c(str));
                    return;
                }
                return;
            }
            if (i10 == 5) {
                if (this.f17854a) {
                    b0.a(PointCategory.OPEN_MARKET_FAILED, str, i.this.b(), new d(str));
                }
            } else {
                if (i10 != 8) {
                    return;
                }
                if (TextUtils.isEmpty(str) && !i.this.b().getAd().forbiden_parse_landingpage.booleanValue()) {
                    b0.a(i.this.b(), j0Var.name(), str);
                }
                i.this.b().setCustomDeeplink(null);
                i.this.b().setCustomAndroidMarket(null);
                i.this.b().setCustomLandPageUrl(null);
                if (i.this.f17823o != null) {
                    i.this.f17823o.a(this.f17854a, this.f17856c);
                }
            }
        }
    }

    public String g() {
        return this.f17817i;
    }

    public Map<String, String> h() {
        return this.f17810b;
    }

    public boolean i() {
        return this.f17820l;
    }

    public boolean j() {
        return this.f17828t;
    }

    public boolean k() {
        WeakReference<Activity> weakReference = this.f17825q;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (b() == null) {
            return false;
        }
        if (activity != null && b().getadPrivacy() != null && this.f17824p == null) {
            com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(activity, b());
            this.f17824p = qVar;
            qVar.a(new b());
        }
        com.sigmob.sdk.base.views.q qVar2 = this.f17824p;
        if (qVar2 == null || !qVar2.e() || this.f17819k) {
            return false;
        }
        if (activity != null) {
            boolean isFinishing = activity.isFinishing();
            boolean isDestroyed = activity.isDestroyed();
            if (!isFinishing && !isDestroyed) {
                this.f17824p.show();
                this.f17819k = true;
                return true;
            }
        }
        this.f17819k = false;
        this.f17824p.dismiss();
        this.f17824p.b();
        this.f17824p = null;
        return true;
    }

    public boolean l() {
        if (b() == null || !b().isDownloadDialog()) {
            return false;
        }
        return k();
    }

    public final BaseAdUnit b() {
        WeakReference<BaseAdUnit> weakReference = this.f17827s;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String c() {
        return this.f17811c;
    }

    public String d() {
        return this.f17816h;
    }

    public String e() {
        return this.f17814f;
    }

    public String f() {
        return this.f17815g;
    }

    public void b(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        b0.b("start", null, baseAdUnit);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "start");
    }

    public void c(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void d(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.f17670w);
    }

    public void e(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "full_video_click");
    }

    public void f(String str) {
        this.f17817i = str;
    }

    public void b(Context context, BaseAdUnit baseAdUnit) {
        b0.a(PointCategory.LANDING_PAGE_SHOW, (String) null, baseAdUnit);
    }

    public void c(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "click");
    }

    public void d(String str) {
        if (str != null) {
            this.f17814f = str;
        }
    }

    public void e(String str) {
        if (str != null) {
            this.f17815g = str;
        }
    }

    public void a(List<com.sigmob.sdk.videoAd.f> list) {
        Preconditions.NoThrow.checkNotNull(list, "fractionalTrackers cannot be null");
        this.f17809a.addAll(list);
        Collections.sort(this.f17809a);
    }

    public void b(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z10) {
        a(aVar, str, str2, z10, false);
    }

    public void c(String str) {
        if (str != null) {
            this.f17816h = str;
        }
    }

    public final void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z10) {
        d0 sessionManager;
        String str3;
        int i10 = a.f17831a[aVar.ordinal()];
        if (i10 == 1) {
            sessionManager = b().getSessionManager();
            str3 = com.sigmob.sdk.base.common.a.f17670w;
        } else if (i10 != 2) {
            sessionManager = b().getSessionManager();
            str3 = "click";
        } else {
            sessionManager = b().getSessionManager();
            str3 = "full_video_click";
        }
        sessionManager.a(str3, 0);
    }

    public void b(BaseAdUnit baseAdUnit) {
        this.f17827s = new WeakReference<>(baseAdUnit);
    }

    public void a() {
        this.f17826r = null;
        this.f17823o = null;
        com.sigmob.sdk.base.views.q qVar = this.f17824p;
        if (qVar != null) {
            qVar.dismiss();
            this.f17824p.b();
            this.f17824p = null;
            this.f17819k = false;
        }
    }

    public void b(String str) {
        this.f17811c = str;
    }

    public static i a(BaseAdUnit baseAdUnit) {
        i iVar = new i();
        iVar.b(baseAdUnit);
        return iVar;
    }

    public List<com.sigmob.sdk.videoAd.f> a(long j10, long j11) {
        if (j11 <= 0 || j10 < 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        com.sigmob.sdk.videoAd.f fVar = new com.sigmob.sdk.videoAd.f("play_quarter", j10 / j11);
        int size = this.f17809a.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.sigmob.sdk.videoAd.f fVar2 = this.f17809a.get(i10);
            if (fVar2.compareTo(fVar) > 0) {
                break;
            }
            if (!fVar2.isTracked()) {
                arrayList.add(fVar2);
            }
        }
        return arrayList;
    }

    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, int i10, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, String str, BaseAdUnit baseAdUnit, String str2, int i10) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        b0.a(str2, i10, str, baseAdUnit);
    }

    public void a(String str) {
        boolean a10 = p.a(this.f17821m);
        BaseAdUnit b10 = b();
        if (b10 == null) {
            return;
        }
        if (a10) {
            try {
                g0.makeText(com.sigmob.sdk.a.d(), "正在下载", 1).show();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String landing_page = b10.getLanding_page();
        if (!TextUtils.isEmpty(str)) {
            landing_page = str;
        }
        String macroProcess = b10.getMacroCommon().macroProcess(landing_page);
        if (b10.getsubInteractionType() != 1) {
            this.f17821m = str;
            p.a(str, b());
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(macroProcess, new c(), 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            b0.a("download_start", "0", b(), new d());
            b0.a("download_start", 0, "request queue is null", b(), new e());
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    public void a(Context context, BaseAdUnit baseAdUnit) {
        b0.a(PointCategory.LANDING_PAGE_CLOSE, (String) null, baseAdUnit);
    }

    public static void a(BaseAdUnit baseAdUnit, String str, boolean z10) {
        Intent launchIntentForPackage;
        String macroProcess = baseAdUnit.getMacroCommon().macroProcess(str);
        String apkPackageName = baseAdUnit.getApkPackageName();
        if (baseAdUnit.getsubInteractionType() == 2 || !TextUtils.isEmpty(apkPackageName)) {
            String productId = baseAdUnit.getProductId();
            if (TextUtils.isEmpty(apkPackageName)) {
                apkPackageName = productId;
            }
            if (!TextUtils.isEmpty(apkPackageName) && (launchIntentForPackage = com.sigmob.sdk.a.d().getPackageManager().getLaunchIntentForPackage(apkPackageName)) != null) {
                try {
                    com.sigmob.sdk.base.common.h.f(baseAdUnit);
                    new Handler().postDelayed(new f(baseAdUnit), 3000L);
                    u.b(com.sigmob.sdk.a.d(), launchIntentForPackage);
                    return;
                } catch (Throwable th2) {
                    SigmobLog.e("launch fail", th2);
                }
            }
        }
        if (baseAdUnit.getsubInteractionType() != 1 || z10) {
            p.a(macroProcess, baseAdUnit);
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(macroProcess, new g(baseAdUnit, macroProcess), 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            b0.a("download_start", "0", baseAdUnit, new h(macroProcess));
            b0.a("download_start", 0, "request queue is null", baseAdUnit, new C0565i(macroProcess));
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z10, boolean z11) {
        String str3 = this.f17811c;
        if (!TextUtils.isEmpty(str)) {
            str3 = str;
        }
        b().getClickCommon().clickUIType = aVar;
        b().getClickCommon().clickCoordinate = str2;
        b().getClickCommon().clickUrl = str3;
        new k0.e().a(j0.f17906b, j0.f17912h, j0.f17910f, j0.f17911g, j0.f17909e, j0.f17908d, j0.f17907c).b(new j(z10, z11, aVar)).a(b()).b(b().isSkipSigmobBrowser()).a(b().getAd().forbiden_parse_landingpage.booleanValue()).a().b(com.sigmob.sdk.a.d(), str);
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, boolean z10) {
        a(aVar, (String) null, str, z10, true);
    }

    public void a(Activity activity, BaseAdUnit baseAdUnit, q.g gVar) {
        if (baseAdUnit == null) {
            return;
        }
        if (activity != null) {
            this.f17825q = new WeakReference<>(activity);
        }
        this.f17826r = gVar;
    }

    public void a(int i10) {
        this.f17829u = i10;
    }

    public void a(z zVar) {
        this.f17823o = zVar;
    }
}
