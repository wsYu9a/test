package com.bytedance.sdk.openadsdk;

import android.content.Context;

/* loaded from: classes2.dex */
public interface TTDislikeController {
    @Deprecated
    void onDislikeEvent(Context context, boolean z10);

    void onDislikeSelected(FilterWord filterWord);

    @Deprecated
    void openWebPage(Context context, boolean z10);
}
