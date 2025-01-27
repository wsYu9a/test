package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hg implements com.kwad.sdk.core.d<AdMatrixInfo.RotateInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("title");
        rotateInfo.title = optString;
        if (optString == JSONObject.NULL) {
            rotateInfo.title = "";
        }
        String optString2 = jSONObject.optString("subTitle");
        rotateInfo.subTitle = optString2;
        if (optString2 == JSONObject.NULL) {
            rotateInfo.subTitle = "";
        }
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        rotateInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.x = rotateDegreeInfo;
        rotateDegreeInfo.parseJson(jSONObject.optJSONObject("x"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.y = rotateDegreeInfo2;
        rotateDegreeInfo2.parseJson(jSONObject.optJSONObject("y"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.z = rotateDegreeInfo3;
        rotateDegreeInfo3.parseJson(jSONObject.optJSONObject(com.umeng.analytics.pro.am.aD));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rotateInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", rotateInfo.title);
        }
        String str2 = rotateInfo.subTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subTitle", rotateInfo.subTitle);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "downloadTexts", rotateInfo.downloadTexts);
        com.kwad.sdk.utils.t.a(jSONObject, "x", rotateInfo.x);
        com.kwad.sdk.utils.t.a(jSONObject, "y", rotateInfo.y);
        com.kwad.sdk.utils.t.a(jSONObject, com.umeng.analytics.pro.am.aD, rotateInfo.z);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        a2(rotateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        return b2(rotateInfo, jSONObject);
    }
}
