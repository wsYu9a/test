package com.sigmob.sdk.base.common;

import android.text.TextUtils;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: classes4.dex */
public class h0 {

    /* renamed from: a */
    public String f17800a;

    /* renamed from: b */
    public String f17801b;

    /* renamed from: c */
    public String f17802c;

    /* renamed from: d */
    public String f17803d;

    /* renamed from: e */
    public String f17804e = "5";

    /* renamed from: f */
    public WindAdRequest f17805f;

    /* renamed from: g */
    public LoadAdRequest f17806g;

    /* renamed from: h */
    public b0.g f17807h;

    /* renamed from: i */
    public BaseAdUnit f17808i;

    public static h0 a(String str) {
        h0 h0Var = new h0();
        h0Var.f17800a = str;
        return h0Var;
    }

    public h0 b(String str) {
        this.f17802c = this.f17802c;
        return this;
    }

    public h0 c(String str) {
        this.f17802c = str;
        return this;
    }

    public h0 d(String str) {
        this.f17803d = str;
        return this;
    }

    public h0 e(String str) {
        this.f17801b = str;
        return this;
    }

    public void a() {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(this.f17804e);
        pointEntitySigmob.setCategory(this.f17800a);
        pointEntitySigmob.setSub_category(this.f17801b);
        if (!TextUtils.isEmpty(this.f17802c)) {
            pointEntitySigmob.setAdtype(this.f17802c);
        }
        b0.a(this.f17800a, this.f17801b, pointEntitySigmob, this.f17805f);
        b0.a(this.f17800a, this.f17801b, pointEntitySigmob, this.f17806g);
        b0.a(this.f17800a, this.f17801b, this.f17808i, pointEntitySigmob);
        b0.g gVar = this.f17807h;
        if (gVar != null) {
            gVar.a(pointEntitySigmob);
        }
        b0.a(pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public h0 a(BaseAdUnit baseAdUnit) {
        this.f17808i = baseAdUnit;
        return this;
    }

    public h0 a(LoadAdRequest loadAdRequest) {
        this.f17806g = loadAdRequest;
        return this;
    }

    public h0 a(b0.g gVar) {
        this.f17807h = gVar;
        return this;
    }

    public h0 a(WindAdRequest windAdRequest) {
        this.f17805f = windAdRequest;
        return this;
    }
}
