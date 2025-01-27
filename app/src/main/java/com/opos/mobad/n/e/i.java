package com.opos.mobad.n.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class i implements c {

    /* renamed from: a */
    String f22124a;

    /* renamed from: b */
    String f22125b;

    /* renamed from: c */
    String f22126c;

    /* renamed from: d */
    Object f22127d;

    /* renamed from: e */
    Object f22128e;

    /* renamed from: f */
    Object f22129f;

    /* renamed from: g */
    Object f22130g;

    /* renamed from: h */
    Object f22131h;

    /* renamed from: i */
    int f22132i;

    /* renamed from: j */
    String f22133j;
    String k;
    Map l;
    Map<String, String> m;
    HashMap<ZkViewSDK.KEY, Object> n;
    b o;
    e p;
    f q;
    g r;
    View s;

    private HashMap<ZkViewSDK.KEY, Object> a() {
        if (this.n == null) {
            this.n = new HashMap<>();
        }
        if (!TextUtils.isEmpty(this.f22124a)) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_TITLE, this.f22124a);
        }
        if (!TextUtils.isEmpty(this.f22125b)) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_DESC, this.f22125b);
        }
        if (!TextUtils.isEmpty(this.f22126c)) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_ACTION, this.f22126c);
        }
        Object obj = this.f22127d;
        if (obj != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_IMAGE, obj);
        }
        Object obj2 = this.f22128e;
        if (obj2 != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_IMAGE_LIST, obj2);
        }
        Object obj3 = this.f22130g;
        if (obj3 != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_LOGO, obj3);
        }
        Object obj4 = this.f22129f;
        if (obj4 != null) {
            this.n.put(ZkViewSDK.KEY.KEY_VIDEO_EXTERNAL, obj4);
        }
        if (!TextUtils.isEmpty(this.f22133j) && !TextUtils.isEmpty(this.k)) {
            this.n.put(ZkViewSDK.KEY.KEY_APP_DEVELOPER, this.f22133j);
            this.n.put(ZkViewSDK.KEY.KEY_APP_VERSION, this.k);
        }
        Object obj5 = this.f22131h;
        if (obj5 != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_ICON, obj5);
        }
        this.n.put(ZkViewSDK.KEY.KEY_VIDEO_PROGRESS_STEP, 1000);
        return this.n;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(b bVar) {
        this.o = bVar;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(f fVar) {
        this.q = fVar;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(g gVar) {
        this.r = gVar;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(Object obj) {
        this.f22127d = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(String str) {
        this.f22124a = str;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(String str, String str2) {
        this.f22133j = str;
        this.k = str2;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public d a(Context context, String str) {
        String str2;
        com.opos.cmn.an.f.a.b("ZKDynamicLoader", "Start load view!Loader:" + toString());
        if (context == null) {
            f fVar = this.q;
            if (fVar != null) {
                fVar.a("Context is null!");
            }
            str2 = "context is empty!";
        } else {
            Context applicationContext = context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.opos.cmn.an.f.a.b("ZKDynamicLoader", "load path:" + str + ",exist:" + new File(str).exists());
                    View a2 = ZkViewSDK.b().a(applicationContext, str, false, a(), this.l, new k(this, str));
                    this.s = a2;
                    return new j(applicationContext, a2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.d("ZKDynamicLoader", "Load view error!", e2);
                    return null;
                }
            }
            f fVar2 = this.q;
            if (fVar2 != null) {
                fVar2.a("Path is empty!");
            }
            str2 = "path is empty!";
        }
        com.opos.cmn.an.f.a.d("ZKDynamicLoader", str2);
        return null;
    }

    @Override // com.opos.mobad.n.e.c
    public c b(Object obj) {
        this.f22128e = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c b(String str) {
        this.f22125b = str;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c c(Object obj) {
        this.f22129f = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c c(String str) {
        this.f22126c = str;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c d(Object obj) {
        this.f22130g = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c e(Object obj) {
        this.f22131h = obj;
        return this;
    }

    public String toString() {
        return "MatLoader{matTitle='" + this.f22124a + "', matDesc='" + this.f22125b + "', matAction='" + this.f22126c + "', appDeveloper='" + this.f22133j + "', appVersion=" + this.k + ", mMatLogo=" + this.f22130g + ", skipTime=" + this.f22132i + ", mTansMap=" + this.l + ", mReportMap=" + this.m + ", mMatMap=" + this.n + ", mClickListener=" + this.o + ", mExposeListener=" + this.p + ", mRenderListener=" + this.q + ", mVideoListener=" + this.r + '}';
    }
}
