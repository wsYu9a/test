package com.wbl.ad.yzz.config;

import java.util.List;

/* loaded from: classes.dex */
public interface IAdEventListener {
    void onAdClicked(List<IEventAd> list);

    void onAdExposure(List<IEventAd> list);

    void onAdLoaded(List<IEventAd> list);
}
