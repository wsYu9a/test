package com.sn.catpie.service;

import android.view.View;
import androidx.annotation.Keep;
import com.sntech.ads.api.callback.RiskUserCallback;
import com.sntech.ads.api.event.SNEvent;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public interface CCService {
    @Keep
    void isRiskUser(RiskUserCallback riskUserCallback);

    @Keep
    void onAdClick(SNEvent.AdPlatform adPlatform, String str, String str2);

    @Keep
    void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d10, String str2);

    @Keep
    void onEvent(String str, JSONObject jSONObject);

    @Keep
    void onUserEvent(SNEvent.UserEvent userEvent);

    @Keep
    void onWithdraw(String str, float f10, SNEvent.WithdrawChannel withdrawChannel, String str2);

    @Keep
    void setABTest(String str, int i10, String... strArr);

    @Keep
    void setUserId(String str);
}
