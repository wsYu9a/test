package com.kwad.components.core.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean Ol = true;
    com.kwad.components.core.n.kwai.b JW;
    private int Ok;

    public a(com.kwad.components.core.n.kwai.a aVar) {
        this(aVar.JW, aVar.Os, aVar.Ot, aVar.Ov);
        this.Ok = aVar.Ou ? 1 : 0;
    }

    public a(com.kwad.components.core.n.kwai.b bVar) {
        this(bVar, null);
    }

    private a(com.kwad.components.core.n.kwai.b bVar, com.kwad.components.core.n.kwai.d dVar) {
        this(bVar, null, false, null);
    }

    public a(com.kwad.components.core.n.kwai.b bVar, @Nullable List<String> list, boolean z, com.kwad.components.core.n.kwai.d dVar) {
        super(c(bVar), bVar.Ow);
        putBody("timestamp", System.currentTimeMillis());
        this.JW = bVar;
        com.kwad.sdk.internal.api.a pk = bVar.pk();
        if (pk != null && !pk.AB()) {
            a(com.kwad.sdk.core.request.model.a.xo(), pk);
        }
        JSONArray jSONArray = new JSONArray();
        t.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", dVar);
        int i2 = this.Ok;
        if (i2 > 0) {
            putBody("calledUnionType", i2);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String tO = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)).tO() : "";
        if (!TextUtils.isEmpty(tO)) {
            putBody("universeDebugParam", tO);
        }
        String d2 = d(bVar);
        if (!TextUtils.isEmpty(d2)) {
            putBody("sdkDebugReqInfo", d2);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", y.Dv());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String az = this.JW.az("thirdUserId");
        com.kwad.sdk.core.request.model.g xv = com.kwad.sdk.core.request.model.g.xv();
        if (az != null) {
            xv.cH(az);
        }
        if (pk != null && !pk.AA()) {
            a(xv, pk);
        }
        putBody("userInfo", xv);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, com.kwad.sdk.internal.api.a aVar) {
        int i2 = aVar.aaM;
        if (i2 != 0) {
            gVar.aaM = i2;
        }
        int i3 = aVar.aaN;
        if (i3 != 0) {
            gVar.aaN = i3;
        }
        if (TextUtils.isEmpty(aVar.aaO)) {
            return;
        }
        gVar.aaO = aVar.aaO;
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(aVar.aaP)) {
            t.putValue(jSONObject2, "prevTitle", aVar.aaP);
        }
        if (!TextUtils.isEmpty(aVar.aaQ)) {
            t.putValue(jSONObject2, "postTitle", aVar.aaQ);
        }
        if (!TextUtils.isEmpty(aVar.aaR)) {
            t.putValue(jSONObject2, "historyTitle", aVar.aaR);
        }
        if (!TextUtils.isEmpty(aVar.aaS)) {
            t.putValue(jSONObject2, "channel", aVar.aaS);
        }
        t.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }

    private static int c(com.kwad.components.core.n.kwai.b bVar) {
        try {
            return bVar.Ow.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(com.kwad.components.core.n.kwai.b bVar) {
        com.kwad.sdk.service.kwai.e eVar;
        if (Ol && (eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)) != null) {
            try {
                return (String) s.c(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(bVar.Ow.getPosId()), eVar.getContext());
            } catch (Exception unused) {
                Ol = false;
            }
        }
        return "";
    }

    public final void aD(int i2) {
        this.Ok = i2;
    }

    public final int getAdNum() {
        return this.JW.Ow.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl getScene() {
        com.kwad.components.core.n.kwai.b bVar = this.JW;
        if (bVar != null) {
            return bVar.Ow;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        return com.kwad.sdk.c.sc();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        o.bw(true);
        super.onCreate();
    }
}
