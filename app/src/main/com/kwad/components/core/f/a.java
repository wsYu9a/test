package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.e;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.g;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bo;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends e implements h {
    private long NB;
    private String NC;
    private String Nz;
    private Context mContext;

    /* renamed from: com.kwad.components.core.f.a$1 */
    public class AnonymousClass1 implements ResponseDfpCallback {
        public AnonymousClass1() {
        }

        @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
        public final void onFailed(int i10, String str) {
            c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i10 + "errorMessage :" + str);
        }

        @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
        public final void onSuccess(String str, String str2) {
            c.d("initGId onSuccess", "deviceInfo：" + str2);
            a.this.pk();
            a.this.al(str2);
        }
    }

    private void al(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (d.a(com.kwad.sdk.core.config.c.awG)) {
                jSONObject.put("64_level", 1);
            }
            KWEGIDDFP.handlePolicy(jSONObject);
        } catch (Throwable th2) {
            c.printStackTrace(th2);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.f.a.1
            public AnonymousClass1() {
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i10, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i10 + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                c.d("initGId onSuccess", "deviceInfo：" + str2);
                a.this.pk();
                a.this.al(str2);
            }
        });
    }

    public void pk() {
        String ct = ad.ct(this.mContext);
        String OV = bo.OV();
        if (TextUtils.isEmpty(ct)) {
            ad.Y(this.mContext, OV);
            return;
        }
        if (TextUtils.equals(ct, OV)) {
            return;
        }
        this.Nz = "";
        this.NB = 0L;
        this.NC = "";
        ad.X(this.mContext, "");
        ad.d(this.mContext, this.NB);
        ad.ag(this.mContext, this.NC);
        ad.Y(this.mContext, OV);
    }

    private String pn() {
        if (TextUtils.isEmpty(this.Nz)) {
            this.Nz = ad.cq(this.mContext);
        }
        return this.Nz;
    }

    private long po() {
        if (this.NB == 0) {
            this.NB = ad.cr(this.mContext);
        }
        return this.NB;
    }

    private String pp() {
        if (TextUtils.isEmpty(this.NC)) {
            this.NC = ad.cw(this.mContext);
        }
        return this.NC;
    }

    @Override // com.kwad.sdk.components.h
    public final void am(String str) {
        if (this.mContext == null || bm.isNullString(str) || bm.isEquals(pn(), str)) {
            return;
        }
        try {
            this.Nz = str;
            ad.X(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th2) {
            c.e("EncryptComponentsImpl", "setEGid error : " + th2);
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        try {
            this.mContext = context;
            al(context);
        } catch (Throwable th2) {
            c.e("EncryptComponentsImpl", "initGId error : " + th2);
        }
    }

    @Override // com.kwad.sdk.components.h
    public final String pl() {
        return (d.Dw() || System.currentTimeMillis() >= po() || TextUtils.isEmpty(pn())) ? pp() : "";
    }

    @Override // com.kwad.sdk.components.h
    public final g pm() {
        return new com.kwad.sdk.core.a.a();
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.components.h
    public final void x(long j10) {
        if (this.mContext == null || j10 <= 0 || j10 == po()) {
            return;
        }
        this.NB = j10;
        ad.d(this.mContext, j10);
    }

    public void al(String str) {
        if (this.mContext == null || bm.isNullString(str) || bm.isEquals(pp(), str)) {
            return;
        }
        this.NC = str;
        ad.ag(this.mContext, str);
    }
}
