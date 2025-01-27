package com.sn.catpie.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sntech.ads.AdCode;
import com.sntech.ads.AdError;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: classes4.dex */
public interface CodeService {
    @NonNull
    @Keep
    List<AdCode> getFilteredAdCodeList(@NonNull String str);

    @Keep
    boolean isAdCodesSet();

    @Keep
    void onAdClicked(String str, @NonNull AdCode adCode, boolean z10);

    @Keep
    void onAdFilled(String str, @NonNull AdCode adCode, boolean z10, boolean z11, @Nullable AdError adError);

    @Keep
    void setAdCodes(boolean z10, @NonNull String str, @NonNull Map<String, List<AdCode>> map);
}
