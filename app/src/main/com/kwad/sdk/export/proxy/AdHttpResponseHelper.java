package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public class AdHttpResponseHelper {

    /* renamed from: com.kwad.sdk.export.proxy.AdHttpResponseHelper$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdHttpResponseListener.this.onResponseStart();
        }
    }

    /* renamed from: com.kwad.sdk.export.proxy.AdHttpResponseHelper$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdHttpResponseListener.this.onResponseEnd();
        }
    }

    public static void notifyResponseEnd(@Nullable AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bt.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AdHttpResponseListener.this.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(@Nullable AdHttpResponseListener adHttpResponseListener, long j10, long j11) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j10, j11);
    }

    public static void notifyResponseStart(@Nullable AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bt.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AdHttpResponseListener.this.onResponseStart();
            }
        });
    }
}
