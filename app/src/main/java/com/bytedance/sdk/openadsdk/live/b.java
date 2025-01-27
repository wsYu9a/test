package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.live.b$1 */
    public static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                LivePluginHelper.initLiveCommerce();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static boolean a(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z10) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z10);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean a() {
        try {
            com.bytedance.sdk.openadsdk.e.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.initLiveCommerce();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey("room_id")) {
            long j10 = bundle.getLong("room_id");
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService == null) {
                    return false;
                }
                liveRoomService.enterLiveRoom(context, j10, bundle);
                return true;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }
}
