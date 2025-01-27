package com.baidu.mobads.sdk.api;

import android.view.View;

/* loaded from: classes.dex */
public interface PrerollVideoResponse {
    public static final String GIF = "gif";
    public static final String NORMAL = "normal";
    public static final String VIDEO = "video";

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getDesc();

    String getIconUrl();

    String getImageUrl();

    String getMaterialType();

    String getTitle();

    String getVideoUrl();

    void handleClick(View view);

    void handleClick(View view, int i2);

    void recordImpression(View view);
}
