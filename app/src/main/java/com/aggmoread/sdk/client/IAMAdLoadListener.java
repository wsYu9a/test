package com.aggmoread.sdk.client;

import java.util.List;

/* loaded from: classes.dex */
public interface IAMAdLoadListener<T> {
    void onAdLoadFail(AMError aMError);

    void onAdLoaded(List<T> list);
}
