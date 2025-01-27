package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fa implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveReservationPlayEndInfo.detailBtnTitle = jSONObject.optString("detailBtnTitle", new String("查看详情"));
        liveReservationPlayEndInfo.reservationBtnTitle = jSONObject.optString("reservationBtnTitle", new String("立即预约"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "detailBtnTitle", liveReservationPlayEndInfo.detailBtnTitle);
        com.kwad.sdk.utils.t.putValue(jSONObject, "reservationBtnTitle", liveReservationPlayEndInfo.reservationBtnTitle);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        a2(liveReservationPlayEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        return b2(liveReservationPlayEndInfo, jSONObject);
    }
}
