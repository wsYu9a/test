package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ic implements com.kwad.sdk.core.d<SplashSkipViewModel> {
    /* renamed from: a */
    private static void a2(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSkipViewModel.skipSecond = jSONObject.optInt("skipSecond");
    }

    /* renamed from: b */
    private static JSONObject b2(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = splashSkipViewModel.skipSecond;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipSecond", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        a2(splashSkipViewModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        return b2(splashSkipViewModel, jSONObject);
    }
}
