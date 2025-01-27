package com.martian.ttbook.sdk.client;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.martian.ttbook.sdk.client.data.AdData;
import com.martian.ttbook.sdk.client.data.AdDataBinder;
import java.util.List;

/* loaded from: classes4.dex */
public interface NativeAdData extends AdData, AdDataBinder<View>, NativeMediaAdData, NativeAdDataComm, NativeAdLoader {
    void attach(Activity activity);

    View bindView(View view, ViewGroup.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, List<View> list, View view2, NativeAdListener nativeAdListener);

    View bindView(View view, ViewGroup.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, List<View> list, View view2, Object obj, NativeAdListener nativeAdListener);

    View bindView(View view, ViewGroup.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, List<View> list, NativeAdListener nativeAdListener);

    boolean isAppAd();

    void resume();
}
