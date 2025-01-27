package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ce implements com.kwad.sdk.core.d<a.C0484a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0484a c0484a, JSONObject jSONObject) {
        a2(c0484a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0484a c0484a, JSONObject jSONObject) {
        return b2(c0484a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0484a c0484a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0484a.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0484a.templateId)) {
            c0484a.templateId = "";
        }
        c0484a.asB = jSONObject.optString("template_show_type");
        if (obj.toString().equals(c0484a.asB)) {
            c0484a.asB = "";
        }
        c0484a.asC = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0484a.asD = jSONObject.optInt("award_task_name");
        c0484a.asE = jSONObject.optInt("jumps_liveroom_type");
        c0484a.asF = jSONObject.optInt("universe_feature_freg");
        c0484a.asG = jSONObject.optInt("replace_url_succ");
        c0484a.asI = jSONObject.optInt("is_carousel");
        c0484a.asJ = jSONObject.optInt("is_special_preload");
        c0484a.asK = jSONObject.optInt("card_type");
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0484a c0484a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0484a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, c0484a.templateId);
        }
        String str2 = c0484a.asB;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "template_show_type", c0484a.asB);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "network_download_status", c0484a.asC);
        int i10 = c0484a.asD;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "award_task_name", i10);
        }
        int i11 = c0484a.asE;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jumps_liveroom_type", i11);
        }
        int i12 = c0484a.asF;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "universe_feature_freg", i12);
        }
        int i13 = c0484a.asG;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "replace_url_succ", i13);
        }
        int i14 = c0484a.asI;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "is_carousel", i14);
        }
        int i15 = c0484a.asJ;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "is_special_preload", i15);
        }
        int i16 = c0484a.asK;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "card_type", i16);
        }
        return jSONObject;
    }
}
