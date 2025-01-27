package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class KSAdLiveShopInfo extends BaseOfflineCompoJsonParse<KSAdLiveShopInfo> implements Serializable {
    private static final long serialVersionUID = -7139399767269744574L;
    public int changeType;
    public KSAdLiveRoomItemInfo itemInfo;
    public int shopCardType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveShopInfo.shopCardType = jSONObject.optInt("shopCardType");
        kSAdLiveShopInfo.changeType = jSONObject.optInt("changeType");
        KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo = new KSAdLiveRoomItemInfo();
        kSAdLiveShopInfo.itemInfo = kSAdLiveRoomItemInfo;
        kSAdLiveRoomItemInfo.parseJson(jSONObject.optJSONObject("itemInfo"));
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo) {
        return toJson(kSAdLiveShopInfo, (JSONObject) null);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "itemInfo", kSAdLiveShopInfo.itemInfo);
        int i2 = kSAdLiveShopInfo.shopCardType;
        if (i2 != 0) {
            t.putValue(jSONObject, "shopCardType", i2);
        }
        int i3 = kSAdLiveShopInfo.changeType;
        if (i3 != 0) {
            t.putValue(jSONObject, "changeType", i3);
        }
        return jSONObject;
    }
}
