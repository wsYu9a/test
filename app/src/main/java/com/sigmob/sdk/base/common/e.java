package com.sigmob.sdk.base.common;

import android.text.TextUtils;
import android.util.Log;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements h.f {

    /* renamed from: b */
    public final List<BaseAdUnit> f17737b;

    /* renamed from: c */
    public final h.f f17738c;

    /* renamed from: d */
    public LoadAdRequest f17739d;

    /* renamed from: a */
    public String f17736a = "AdListCacheManger";

    /* renamed from: e */
    public List<BaseAdUnit> f17740e = new ArrayList();

    public e(List<BaseAdUnit> list, h.f fVar, LoadAdRequest loadAdRequest) {
        this.f17737b = list;
        this.f17738c = fVar;
        this.f17739d = loadAdRequest;
    }

    public boolean a(boolean z10) {
        List<BaseAdUnit> list = this.f17737b;
        if (list != null) {
            if (z10) {
                BaseAdUnit baseAdUnit = list.get(0);
                if (baseAdUnit.getPlayMode() == 2) {
                    this.f17740e.add(baseAdUnit);
                    h.s().a(baseAdUnit, this);
                }
            } else {
                for (int i10 = 0; i10 < this.f17737b.size(); i10++) {
                    BaseAdUnit baseAdUnit2 = this.f17737b.get(i10);
                    if (baseAdUnit2.getPlayMode() != 2) {
                        this.f17740e.add(baseAdUnit2);
                        baseAdUnit2.setCatchVideo(true);
                        h.s().a(baseAdUnit2, this);
                    }
                }
            }
            Log.d(this.f17736a, "--------cache--------" + this.f17740e.size());
        }
        return this.f17740e.size() > 0;
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void d(BaseAdUnit baseAdUnit, String str) {
        if (baseAdUnit != this.f17737b.get(0)) {
            com.sigmob.sdk.base.network.f.a(baseAdUnit, TextUtils.isEmpty(str) ? a.B : a.C);
            b0.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, this.f17739d, (b0.g) null);
            return;
        }
        h.f fVar = this.f17738c;
        if (fVar != null) {
            fVar.d(this.f17737b.get(0), str);
        }
        Log.d(this.f17736a, "--------loadEnd--------" + this.f17740e.size());
    }

    @Override // com.sigmob.sdk.base.common.h.f
    public void i(BaseAdUnit baseAdUnit) {
        h.f fVar = this.f17738c;
        if (fVar != null) {
            fVar.i(baseAdUnit);
        }
    }
}
