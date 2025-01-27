package com.shu.priory.listener;

import com.shu.priory.config.AdError;
import com.shu.priory.download.DialogListener;

/* loaded from: classes3.dex */
public interface IFLYBaseAdListener<T> extends DialogListener {
    void onAdFailed(AdError adError);

    void onAdLoaded(T t10);
}
