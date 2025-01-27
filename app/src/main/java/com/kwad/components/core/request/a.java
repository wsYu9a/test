package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.x;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean TV = true;
    ImpInfo Oy;
    private int TU;

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        int i10 = adLabelImpl.thirdAge;
        if (i10 != 0) {
            gVar.thirdAge = i10;
        }
        int i11 = adLabelImpl.thirdGender;
        if (i11 != 0) {
            gVar.thirdGender = i11;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (TV && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) w.f(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                TV = false;
            }
        }
        return "";
    }

    public final void aG(int i10) {
        this.TU = i10;
    }

    public final int getAdNum() {
        return this.Oy.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.Oy;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        if (com.kwad.components.ad.f.a.nr.booleanValue()) {
            try {
                if (((com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class)) != null) {
                    return com.kwad.sdk.h.zt();
                }
            } catch (Throwable unused) {
            }
        }
        return com.kwad.sdk.h.zf();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        q.bU(true);
        b.rn().ro();
        super.onCreate();
    }

    private a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.Oy, aVar.Ud, aVar.Ue, aVar.Ug);
        this.TU = aVar.Uf ? 1 : 0;
    }

    public a(ImpInfo impInfo, @Nullable List<String> list, boolean z10, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.Oy = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.GF(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        x.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i10 = this.TU;
        if (i10 > 0) {
            putBody("calledUnionType", i10);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String Cw = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)).Cw() : "";
        if (!TextUtils.isEmpty(Cw)) {
            putBody("universeDebugParam", Cw);
        }
        String d10 = d(impInfo);
        if (!TextUtils.isEmpty(d10)) {
            putBody("sdkDebugReqInfo", d10);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z10);
        }
        putBody("appTag", ad.Nz());
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.Oy.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g GM = com.kwad.sdk.core.request.model.g.GM();
        if (rewardCallbackExtraByKey != null) {
            GM.eA(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(GM, adLabelFromAdScene);
        }
        putBody("userInfo", GM);
        if (com.kwad.components.ad.f.a.nr.booleanValue()) {
            try {
                com.kwad.sdk.components.a aVar = (com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
                if (aVar != null) {
                    putBody("adBrowseParam", aVar.Cv());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            x.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            x.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            x.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            x.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        x.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }
}
