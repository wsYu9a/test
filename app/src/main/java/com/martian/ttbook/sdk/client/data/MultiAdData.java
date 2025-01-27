package com.martian.ttbook.sdk.client.data;

import android.view.View;

/* loaded from: classes4.dex */
public interface MultiAdData extends AdData, AdDataBinder<View> {
    public static final int TYPE_NATIVE = 0;
    public static final int TYPE_VIEW = 1;

    <T extends AdData> T getAdData();

    int getAdDataType();

    void resume();
}
