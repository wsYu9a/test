package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public interface UILifecycleListener<T> {
    void onCreate(Context context, View view, T t10);

    void onDestroy(Context context, View view, T t10);

    void onPause(Context context, View view, T t10);

    void onResume(Context context, View view, T t10);

    void onStart(Context context, View view, T t10);

    void onStop(Context context, View view, T t10);
}
