package com.sn.catpie.service;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public interface DeviceStatService {
    @Keep
    String did(Context context);

    @Keep
    void onRequestPermissionResult(Activity activity, int i10, String[] strArr, int[] iArr);

    @Keep
    void requestPermissionsIfNeed(Activity activity, String... strArr);
}
