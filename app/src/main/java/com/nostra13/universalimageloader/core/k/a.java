package com.nostra13.universalimageloader.core.k;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

/* loaded from: classes4.dex */
public interface a {
    void a(String str, View view, FailReason failReason);

    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingStarted(String str, View view);
}
