package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dc implements com.kwad.sdk.core.d<FeedPageInfo> {
    /* renamed from: a */
    private static void a2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt("status");
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt("ad_num");
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        String optString = jSONObject.optString("material_url");
        feedPageInfo.materialUrl = optString;
        if (optString == JSONObject.NULL) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.errorCode = jSONObject.optInt("error_code");
        String optString2 = jSONObject.optString("error_msg");
        feedPageInfo.errorMsg = optString2;
        if (optString2 == JSONObject.NULL) {
            feedPageInfo.errorMsg = "";
        }
        String optString3 = jSONObject.optString("ext_msg");
        feedPageInfo.extMsg = optString3;
        if (optString3 == JSONObject.NULL) {
            feedPageInfo.extMsg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = feedPageInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        int i3 = feedPageInfo.loadStatus;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", i3);
        }
        int i4 = feedPageInfo.adNum;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_num", i4);
        }
        int i5 = feedPageInfo.type;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i5);
        }
        long j2 = feedPageInfo.loadDataDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j2);
        }
        long j3 = feedPageInfo.resourceLoadDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "resource_load_duration_ms", j3);
        }
        int i6 = feedPageInfo.materialType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i6);
        }
        String str = feedPageInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", feedPageInfo.materialUrl);
        }
        long j4 = feedPageInfo.renderDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_duration_ms", j4);
        }
        int i7 = feedPageInfo.renderType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_type", i7);
        }
        int i8 = feedPageInfo.expectedRenderType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "expected_render_type", i8);
        }
        long j5 = feedPageInfo.convertDuration;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convert_duartion_ms", j5);
        }
        int i9 = feedPageInfo.errorCode;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_code", i9);
        }
        String str2 = feedPageInfo.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", feedPageInfo.errorMsg);
        }
        String str3 = feedPageInfo.extMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ext_msg", feedPageInfo.extMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        a2(feedPageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        return b2(feedPageInfo, jSONObject);
    }
}
