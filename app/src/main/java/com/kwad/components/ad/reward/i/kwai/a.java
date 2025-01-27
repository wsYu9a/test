package com.kwad.components.ad.reward.i.kwai;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.reward.i.a {
    private b xq = new b();
    private final C0146a xr = new C0146a(d.uA());

    /* renamed from: com.kwad.components.ad.reward.i.kwai.a$a */
    static class C0146a extends com.kwad.components.ad.reward.i.b {
        public C0146a(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            this.xo = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            this.xp = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    static class b extends com.kwad.components.ad.reward.i.b {
        public b() {
            this.xo = "基础奖励：观看视频";
            this.xp = "基础奖励：需再观看%ss视频";
        }
    }

    private void jw() {
        if (this.xr.isCompleted()) {
            jm();
        } else {
            jn();
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.xr.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<c> jk() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xq);
        arrayList.add(this.xr);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int jl() {
        Iterator<c> it = jk().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i2++;
            }
        }
        return i2;
    }

    public final void ju() {
        com.kwad.sdk.core.d.b.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xq.jm();
        jw();
    }

    public final boolean jv() {
        return this.xq.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.d.b.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xr.jm();
        jw();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xq.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xr.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xq);
        t.a(jSONObject, "mOpenNsTask", this.xr);
        return jSONObject;
    }
}
