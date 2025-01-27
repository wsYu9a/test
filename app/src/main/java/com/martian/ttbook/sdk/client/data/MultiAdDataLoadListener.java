package com.martian.ttbook.sdk.client.data;

import com.martian.ttbook.sdk.client.AdCommonListener;
import java.util.List;

/* loaded from: classes4.dex */
public interface MultiAdDataLoadListener extends AdCommonListener {
    void onAdLoaded(List<MultiAdData> list);
}
