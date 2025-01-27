package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bu implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.posId = jSONObject.optLong("pos_Id");
        aVar.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.templateId)) {
            aVar.templateId = "";
        }
        aVar.templateVersion = jSONObject.optString("template_version");
        if (obj.toString().equals(aVar.templateVersion)) {
            aVar.templateVersion = "";
        }
        aVar.tkPublishType = jSONObject.optInt("tk_publish_type");
        aVar.errorCode = jSONObject.optInt("error_code");
        aVar.errorMsg = jSONObject.optString("error_msg");
        if (obj.toString().equals(aVar.errorMsg)) {
            aVar.errorMsg = "";
        }
        aVar.campaignType = jSONObject.optInt("campaign_type");
        aVar.ocpcActionType = jSONObject.optInt("ocpc_action_type");
        aVar.industryFirstLevelId = jSONObject.optInt("industry_first_level_id");
        aVar.adOperationType = jSONObject.optInt("ad_operation_type");
        aVar.webUriSourceType = jSONObject.optInt("web_uri_source_type");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.creativeId;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j10);
        }
        long j11 = aVar.llsid;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "llsid", j11);
        }
        long j12 = aVar.posId;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pos_Id", j12);
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, aVar.templateId);
        }
        String str2 = aVar.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "template_version", aVar.templateVersion);
        }
        int i10 = aVar.tkPublishType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "tk_publish_type", i10);
        }
        int i11 = aVar.errorCode;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "error_code", i11);
        }
        String str3 = aVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "error_msg", aVar.errorMsg);
        }
        int i12 = aVar.campaignType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "campaign_type", i12);
        }
        int i13 = aVar.ocpcActionType;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ocpc_action_type", i13);
        }
        int i14 = aVar.industryFirstLevelId;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "industry_first_level_id", i14);
        }
        int i15 = aVar.adOperationType;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_operation_type", i15);
        }
        int i16 = aVar.webUriSourceType;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "web_uri_source_type", i16);
        }
        return jSONObject;
    }
}
