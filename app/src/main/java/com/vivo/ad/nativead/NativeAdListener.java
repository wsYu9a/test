package com.vivo.ad.nativead;

import com.vivo.ad.model.AdError;
import java.util.List;

/* loaded from: classes4.dex */
public interface NativeAdListener {
    void onADLoaded(List<NativeResponse> list);

    void onAdShow(NativeResponse nativeResponse);

    void onClick(NativeResponse nativeResponse);

    void onNoAD(AdError adError);
}
