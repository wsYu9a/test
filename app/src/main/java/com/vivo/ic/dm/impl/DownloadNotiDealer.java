package com.vivo.ic.dm.impl;

import android.content.Context;

/* loaded from: classes4.dex */
public interface DownloadNotiDealer {
    void onNotiCompleteClicked(Context context, long j2);

    void onNotiCompleteHidden(Context context, long j2);

    void onNotiDownloadClicked(Context context, long j2);

    void onNotiNetPauseClicked(Context context);
}
