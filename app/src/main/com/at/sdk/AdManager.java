package com.at.sdk;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public interface AdManager {
    @Keep
    String did(Context context);

    @Keep
    String getSdkVersion();
}
