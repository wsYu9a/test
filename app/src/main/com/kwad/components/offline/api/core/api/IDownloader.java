package com.kwad.components.offline.api.core.api;

import androidx.annotation.WorkerThread;
import java.io.File;

/* loaded from: classes3.dex */
public interface IDownloader {
    @WorkerThread
    boolean downloadSync(File file, String str);
}
