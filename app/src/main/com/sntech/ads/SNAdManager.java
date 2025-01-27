package com.sntech.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import com.sntech.ads.api.callback.RiskUserCallback;

@Keep
/* loaded from: classes4.dex */
public interface SNAdManager {
    @Keep
    String did(Context context);

    @Keep
    String getSdkVersion();

    @Keep
    void isRiskUser(RiskUserCallback riskUserCallback);

    @Keep
    void onRequestPermissionResult(Activity activity, int i10, String[] strArr, int[] iArr);

    @Keep
    void requestPermissionsIfNeed(Activity activity, String... strArr);

    @Keep
    void setUserId(String str);
}
