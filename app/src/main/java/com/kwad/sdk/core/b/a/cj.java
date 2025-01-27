package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cj implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.ru = jSONObject.optString("closeBtnText");
        if (obj.toString().equals(cVar.ru)) {
            cVar.ru = "";
        }
        cVar.rv = jSONObject.optString("continueBtnText");
        if (obj.toString().equals(cVar.rv)) {
            cVar.rv = "";
        }
        cVar.rw = jSONObject.optString("viewDetailText");
        if (obj.toString().equals(cVar.rw)) {
            cVar.rw = "";
        }
        cVar.f11716rx = jSONObject.optString("unWatchedVideoTime");
        if (obj.toString().equals(cVar.f11716rx)) {
            cVar.f11716rx = "";
        }
        cVar.ry = jSONObject.optString(DBDefinition.ICON_URL);
        if (obj.toString().equals(cVar.ry)) {
            cVar.ry = "";
        }
        cVar.rz = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        if (obj.toString().equals(cVar.rz)) {
            cVar.rz = "";
        }
        cVar.rA = jSONObject.optString("descTxt");
        if (obj.toString().equals(cVar.rA)) {
            cVar.rA = "";
        }
        cVar.rB = jSONObject.optString("currentPlayTime");
        if (obj.toString().equals(cVar.rB)) {
            cVar.rB = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = cVar.style;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "style", i10);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.ru;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "closeBtnText", cVar.ru);
        }
        String str3 = cVar.rv;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "continueBtnText", cVar.rv);
        }
        String str4 = cVar.rw;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "viewDetailText", cVar.rw);
        }
        String str5 = cVar.f11716rx;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "unWatchedVideoTime", cVar.f11716rx);
        }
        String str6 = cVar.ry;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, DBDefinition.ICON_URL, cVar.ry);
        }
        String str7 = cVar.rz;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, cVar.rz);
        }
        String str8 = cVar.rA;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "descTxt", cVar.rA);
        }
        String str9 = cVar.rB;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentPlayTime", cVar.rB);
        }
        return jSONObject;
    }
}
