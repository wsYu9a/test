package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ac implements com.kwad.sdk.core.d<WebCardRegisterLiveMessageListener.AdLiveMessageInfoList> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        a2(adLiveMessageInfoList, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        return b2(adLiveMessageInfoList, jSONObject);
    }

    /* renamed from: a */
    private static void a2(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adLiveMessageInfos");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                WebCardRegisterLiveMessageListener.AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new WebCardRegisterLiveMessageListener.AdLiveMessageInfoList.AdLiveMessageItemInfo();
                adLiveMessageItemInfo.parseJson(optJSONArray.optJSONObject(i10));
                adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(WebCardRegisterLiveMessageListener.AdLiveMessageInfoList adLiveMessageInfoList, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "adLiveMessageInfos", adLiveMessageInfoList.adLiveMessageInfos);
        return jSONObject;
    }
}
