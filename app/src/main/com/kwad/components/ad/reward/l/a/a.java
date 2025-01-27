package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.l.a {

    /* renamed from: zi */
    private b f11724zi = new b();

    /* renamed from: zj */
    private final C0397a f11725zj = new C0397a(d.DG());

    /* renamed from: com.kwad.components.ad.reward.l.a.a$a */
    public static class C0397a extends com.kwad.components.ad.reward.l.b {
        public C0397a(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            this.f11727zg = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i10);
            this.f11728zh = String.format("进阶奖励：浏览详情页 %ss", sb3.toString());
        }
    }

    public static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.f11727zg = "基础奖励：观看视频";
            this.f11728zh = "基础奖励：需再观看%ss视频";
        }
    }

    private void jX() {
        if (this.f11725zj.isCompleted()) {
            jN();
        } else {
            jO();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.f11725zj.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<c> jL() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f11724zi);
        arrayList.add(this.f11725zj);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int jM() {
        Iterator<c> it = jL().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i10++;
            }
        }
        return i10;
    }

    public final void jV() {
        com.kwad.sdk.core.d.c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.f11724zi.jN();
        jX();
    }

    public final boolean jW() {
        return this.f11724zi.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.d.c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.f11725zj.jN();
        jX();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f11724zi.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f11725zj.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.a(jSONObject, "mWatchVideoTask", this.f11724zi);
        x.a(jSONObject, "mOpenNsTask", this.f11725zj);
        return jSONObject;
    }
}
