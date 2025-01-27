package com.sntech.ads;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public interface SNCodeManager {
    @NonNull
    @Keep
    JSONArray getFilteredAdCodeArray(@NonNull String str);

    @NonNull
    @Keep
    List<AdCode> getFilteredAdCodeList(@NonNull String str);

    @Keep
    void onAdClicked(@NonNull String str, @NonNull AdCode adCode, boolean z10);

    @Keep
    void onAdClicked(@NonNull String str, @NonNull String str2, @NonNull String str3);

    @Keep
    void onAdFilled(@NonNull String str, @NonNull AdCode adCode, boolean z10, boolean z11, @Nullable AdError adError);

    @Keep
    void onAdFilled(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull boolean z10, @Nullable AdError adError);

    @Keep
    void setAdCodes(@NonNull String str, @NonNull Map<String, List<AdCode>> map);

    @Keep
    void setAdCodes(@NonNull String str, @NonNull JSONObject jSONObject);
}
