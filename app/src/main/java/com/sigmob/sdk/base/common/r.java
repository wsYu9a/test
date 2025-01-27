package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.network.Networking;
import com.czhj.volley.toolbox.FileDownloader;

/* loaded from: classes4.dex */
public class r {

    /* renamed from: a */
    public static FileDownloader f18019a;

    /* renamed from: b */
    public static FileDownloader f18020b;

    public static FileDownloader a() {
        if (f18019a == null) {
            synchronized (r.class) {
                try {
                    if (f18019a == null && Networking.getDownloadRequestQueue() != null) {
                        f18019a = new FileDownloader(Networking.getDownloadRequestQueue(), 3);
                    }
                } finally {
                }
            }
        }
        return f18019a;
    }
}
