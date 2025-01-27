package com.bytedance.pangle;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.ZeusPluginStateListener$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f5984a;

        /* renamed from: b */
        final /* synthetic */ int f5985b;

        /* renamed from: c */
        final /* synthetic */ Object[] f5986c;

        AnonymousClass1(String str, int i2, Object[] objArr) {
            str = str;
            i2 = i2;
            objArr = objArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<ZeusPluginStateListener> list = h.a().f6163b;
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<ZeusPluginStateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPluginStateChange(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i2, objArr);
            }
        }
    }

    public static void postStateChange(@Nullable String str, int i2, Object... objArr) {
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1

            /* renamed from: a */
            final /* synthetic */ String f5984a;

            /* renamed from: b */
            final /* synthetic */ int f5985b;

            /* renamed from: c */
            final /* synthetic */ Object[] f5986c;

            AnonymousClass1(String str2, int i22, Object[] objArr2) {
                str = str2;
                i2 = i22;
                objArr = objArr2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<ZeusPluginStateListener> list = h.a().f6163b;
                if (list == null || list.size() <= 0) {
                    return;
                }
                Iterator<ZeusPluginStateListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onPluginStateChange(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i2, objArr);
                }
            }
        });
        List<ZeusPluginStateListener> list = h.a().f6163b;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<ZeusPluginStateListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onStateChangeOnCurThread(TextUtils.isEmpty(str2) ? "UNKNOWN" : str2, i22, objArr2);
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i2, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i2, Object... objArr) {
    }
}
