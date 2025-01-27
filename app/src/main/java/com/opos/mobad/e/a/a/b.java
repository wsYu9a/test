package com.opos.mobad.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.e.a.a.b.a;
import com.opos.mobad.e.a.e;
import com.opos.mobad.e.a.f;
import com.opos.mobad.e.a.g;
import com.opos.mobad.e.a.i;
import com.opos.mobad.e.a.k;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class b implements f {

    /* renamed from: b */
    String f20492b;

    /* renamed from: c */
    String f20493c;

    /* renamed from: d */
    String f20494d;

    /* renamed from: e */
    Object f20495e;

    /* renamed from: f */
    Object f20496f;

    /* renamed from: g */
    int f20497g;

    /* renamed from: h */
    Map f20498h;

    /* renamed from: i */
    Map<String, String> f20499i;

    /* renamed from: j */
    HashMap<ZkViewSDK.KEY, Object> f20500j;
    com.opos.mobad.e.a.a k;
    e l;
    i m;
    com.opos.mobad.e.a.b n;
    com.opos.mobad.e.a.c o;
    com.opos.mobad.e.a.d p;
    k q;

    /* renamed from: a */
    boolean f20491a = true;
    private final com.opos.mobad.e.a.a.a.b r = new com.opos.mobad.e.a.a.a.a();
    private final com.opos.mobad.e.a.a.a.b s = new com.opos.mobad.e.a.a.a.c();

    private g a(Context context, String str, String str2, String str3, com.opos.mobad.e.a.a.a.b bVar) {
        String str4;
        com.opos.cmn.an.f.a.b("MatLoader", "Start load view!Loader:" + toString());
        if (context == null) {
            i iVar = this.m;
            if (iVar != null) {
                iVar.a(this.f20498h, "Context is null!");
            }
            str4 = "context is empty!";
        } else {
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                com.opos.cmn.an.f.a.d("MatLoader", "adId or matId is empty!");
            }
            Context applicationContext = context.getApplicationContext();
            String str5 = UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
            com.opos.mobad.e.a.a.b.a.a();
            a.C0441a a2 = com.opos.mobad.e.a.a.b.a.a(str5, str2, str3, this.f20499i);
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.opos.cmn.an.f.a.b("MatLoader", "load path:" + str + ",adId:" + str2 + ",matId:" + str3 + ",exist:" + new File(str).exists());
                    boolean z = this.f20491a;
                    if (this.f20500j == null) {
                        this.f20500j = new HashMap<>();
                    }
                    if (!TextUtils.isEmpty(this.f20492b)) {
                        this.f20500j.put(ZkViewSDK.KEY.KEY_AD_TITLE, this.f20492b);
                    }
                    if (!TextUtils.isEmpty(this.f20493c)) {
                        this.f20500j.put(ZkViewSDK.KEY.KEY_AD_DESC, this.f20493c);
                    }
                    if (!TextUtils.isEmpty(this.f20494d)) {
                        this.f20500j.put(ZkViewSDK.KEY.KEY_AD_ACTION, this.f20494d);
                    }
                    Object obj = this.f20495e;
                    if (obj != null) {
                        this.f20500j.put(ZkViewSDK.KEY.KEY_AD_IMAGE, obj);
                    }
                    Object obj2 = this.f20496f;
                    if (obj2 != null) {
                        this.f20500j.put(ZkViewSDK.KEY.KEY_AD_LOGO, obj2);
                    }
                    return new c(applicationContext, bVar.a(applicationContext, str, z, this.f20500j, this.f20498h, new a(applicationContext, this, a2, str)), a2);
                } catch (Exception e2) {
                    com.opos.mobad.e.a.a.b.a.a();
                    com.opos.mobad.e.a.a.b.a.d().a(a2).d("0").e("load view error!msg:" + e2.getMessage()).a(applicationContext);
                    com.opos.cmn.an.f.a.d("MatLoader", "Load view error!", e2);
                    return null;
                }
            }
            i iVar2 = this.m;
            if (iVar2 != null) {
                iVar2.a(this.f20498h, "Path is empty!");
            }
            com.opos.mobad.e.a.a.b.a.a();
            com.opos.mobad.e.a.a.b.a.d().a(a2).d("6").e("loadView path is empty!").a(applicationContext);
            str4 = "path is empty!";
        }
        com.opos.cmn.an.f.a.d("MatLoader", str4);
        return null;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(com.opos.mobad.e.a.a aVar) {
        this.k = aVar;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(i iVar) {
        this.m = iVar;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(Object obj) {
        this.f20495e = obj;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(String str) {
        this.f20492b = str;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(boolean z) {
        this.f20491a = z;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final g a(Context context, String str, String str2, String str3) {
        return a(context, str, str2, str3, this.s);
    }

    @Override // com.opos.mobad.e.a.f
    public final f b(Object obj) {
        this.f20496f = obj;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f b(String str) {
        this.f20493c = str;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f c(String str) {
        this.f20494d = str;
        return this;
    }

    public final String toString() {
        return "MatLoader{autoPlay=" + this.f20491a + ", matTitle='" + this.f20492b + "', matDesc='" + this.f20493c + "', matAction='" + this.f20494d + "', mMatImage=" + this.f20495e + ", mMatLogo=" + this.f20496f + ", skipTime=" + this.f20497g + ", mTansMap=" + this.f20498h + ", mReportMap=" + this.f20499i + ", mMatMap=" + this.f20500j + ", mClickListener=" + this.k + ", mExposeListener=" + this.l + ", mRenderListener=" + this.m + ", mExClickListener=" + this.n + ", mExExposeListener=" + this.o + ", mExRenderListener=" + this.p + ", mVideoListener=" + this.q + ", mFullLoader=" + this.r + ", mInsideLoader=" + this.s + '}';
    }
}
