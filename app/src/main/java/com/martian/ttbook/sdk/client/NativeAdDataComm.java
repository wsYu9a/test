package com.martian.ttbook.sdk.client;

import java.util.List;

/* loaded from: classes4.dex */
public interface NativeAdDataComm {
    NativeAdAppMiitInfo getAdAppMiitInfo();

    AdExtras getAdExtras();

    int getAdPatternType();

    int getDataSource();

    String getDesc();

    String getIconUrl();

    List<String> getImageList();

    String getImageUrl();

    String getTitle();

    String getVideoCoverImage();
}
