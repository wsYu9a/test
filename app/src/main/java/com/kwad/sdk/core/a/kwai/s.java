package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class s implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer("10").intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer("10").intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        String optString = jSONObject.optString("retainWindowText");
        adInsertScreenInfo.retainWindowText = optString;
        if (optString == JSONObject.NULL) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
        adInsertScreenInfo.guideShowStyle = jSONObject.optInt("guideShowStyle");
        adInsertScreenInfo.guideShowTime = jSONObject.optInt("guideShowTime", new Integer("5").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adInsertScreenInfo.cycleAggregateSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateSwitch", z);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i2 = adInsertScreenInfo.cycleAggregateStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateStyle", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i3 = adInsertScreenInfo.autoCloseTime;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoCloseTime", i3);
        }
        int i4 = adInsertScreenInfo.retainWindowStyle;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowStyle", i4);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i5 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowBasedAdShowCount", i5);
        }
        int i6 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowDailyShowCount", i6);
        }
        int i7 = adInsertScreenInfo.guideShowStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "guideShowStyle", i7);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "guideShowTime", adInsertScreenInfo.guideShowTime);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }
}
