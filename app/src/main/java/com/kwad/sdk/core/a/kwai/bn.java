package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.ad.reward.k;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bn implements com.kwad.sdk.core.d<k.c> {
    /* renamed from: a */
    private static void a2(k.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt(OapsKey.KEY_STYLE);
        String optString = jSONObject.optString("title");
        cVar.title = optString;
        if (optString == JSONObject.NULL) {
            cVar.title = "";
        }
        String optString2 = jSONObject.optString("closeBtnText");
        cVar.qd = optString2;
        if (optString2 == JSONObject.NULL) {
            cVar.qd = "";
        }
        String optString3 = jSONObject.optString("continueBtnText");
        cVar.qe = optString3;
        if (optString3 == JSONObject.NULL) {
            cVar.qe = "";
        }
        String optString4 = jSONObject.optString("viewDetailText");
        cVar.qf = optString4;
        if (optString4 == JSONObject.NULL) {
            cVar.qf = "";
        }
        String optString5 = jSONObject.optString("unWatchedVideoTime");
        cVar.qg = optString5;
        if (optString5 == JSONObject.NULL) {
            cVar.qg = "";
        }
        String optString6 = jSONObject.optString(DBDefinition.ICON_URL);
        cVar.qh = optString6;
        if (optString6 == JSONObject.NULL) {
            cVar.qh = "";
        }
        String optString7 = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        cVar.qi = optString7;
        if (optString7 == JSONObject.NULL) {
            cVar.qi = "";
        }
        String optString8 = jSONObject.optString("descTxt");
        cVar.qj = optString8;
        if (optString8 == JSONObject.NULL) {
            cVar.qj = "";
        }
        String optString9 = jSONObject.optString("currentPlayTime");
        cVar.qk = optString9;
        if (optString9 == JSONObject.NULL) {
            cVar.qk = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(k.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = cVar.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_STYLE, i2);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.qd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeBtnText", cVar.qd);
        }
        String str3 = cVar.qe;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "continueBtnText", cVar.qe);
        }
        String str4 = cVar.qf;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewDetailText", cVar.qf);
        }
        String str5 = cVar.qg;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "unWatchedVideoTime", cVar.qg);
        }
        String str6 = cVar.qh;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.ICON_URL, cVar.qh);
        }
        String str7 = cVar.qi;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, cVar.qi);
        }
        String str8 = cVar.qj;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "descTxt", cVar.qj);
        }
        String str9 = cVar.qk;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentPlayTime", cVar.qk);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
