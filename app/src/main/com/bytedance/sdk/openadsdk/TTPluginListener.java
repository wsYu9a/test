package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* loaded from: classes2.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i10, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}
