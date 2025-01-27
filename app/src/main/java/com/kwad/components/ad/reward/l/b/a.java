package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.l.a {

    /* renamed from: zk */
    private c f11729zk = new c();
    private C0398a zl = new C0398a();
    private final b zm = new b(com.kwad.components.ad.reward.a.b.gM());

    /* renamed from: com.kwad.components.ad.reward.l.b.a$a */
    public static class C0398a extends com.kwad.components.ad.reward.l.b {
        public C0398a() {
            this.f11727zg = "安装应用";
        }
    }

    public static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            this.f11727zg = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i10);
            this.f11728zh = String.format("进阶奖励：安装并激活APP %ss", sb3.toString());
        }
    }

    public static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.f11727zg = "基础奖励：观看视频";
            this.f11728zh = "基础奖励：需再观看%ss视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ap.ao(context, com.kwad.sdk.core.response.b.a.ay(e.eb(adTemplate)))) {
            aVar.jY();
        } else {
            aVar.jZ();
        }
    }

    private void jX() {
        if (this.f11729zk.isCompleted() && this.zl.isCompleted() && this.zm.isCompleted()) {
            jN();
        } else {
            jO();
        }
    }

    private void jZ() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallUncompleted");
        this.zl.jO();
        jX();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.zl.isCompleted() && this.zm.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jL() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f11729zk);
        arrayList.add(this.zm);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int jM() {
        Iterator<com.kwad.components.ad.reward.l.c> it = jL().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i10++;
            }
        }
        return i10;
    }

    public final void jV() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.f11729zk.jN();
        jX();
    }

    public final boolean jW() {
        return this.f11729zk.isCompleted();
    }

    public final void jY() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallCompleted");
        this.zl.jN();
        jX();
    }

    public final void ka() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markUseAppCompleted");
        this.zm.jN();
        jX();
    }

    public final boolean kb() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "isInstallCompleted");
        return this.zl.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f11729zk.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.zm.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.a(jSONObject, "mWatchVideoTask", this.f11729zk);
        x.a(jSONObject, "mInstallAppTask", this.zl);
        x.a(jSONObject, "mUseAppTask", this.zm);
        return jSONObject;
    }
}
