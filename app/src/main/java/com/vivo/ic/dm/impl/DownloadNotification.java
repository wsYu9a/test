package com.vivo.ic.dm.impl;

import com.vivo.ic.dm.DownloadInfo;
import java.util.Collection;

/* loaded from: classes4.dex */
public interface DownloadNotification {
    void cancelAllNotification(int i2);

    void hideNetPauseNotification();

    void showNetPauseNotification();

    void updateWith(Collection<DownloadInfo> collection);
}
