package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.downloadnew.q;

/* loaded from: classes.dex */
public class DownloadBridgeFactory {
    public static final TTAdBridge getDownloadBridge(Context context) {
        return q.j(context);
    }
}
