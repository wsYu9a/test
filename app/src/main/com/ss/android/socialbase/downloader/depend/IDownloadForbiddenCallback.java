package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* loaded from: classes4.dex */
public interface IDownloadForbiddenCallback {
    boolean hasCallback();

    void onCallback(List<String> list);
}
