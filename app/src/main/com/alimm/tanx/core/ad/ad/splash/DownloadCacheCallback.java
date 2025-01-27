package com.alimm.tanx.core.ad.ad.splash;

import java.io.File;

/* loaded from: classes.dex */
public interface DownloadCacheCallback {
    void onFail(int i10, String str);

    void onSuccess(File file);
}
