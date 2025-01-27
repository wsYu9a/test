package com.shu.priory;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.shu.priory.config.AdKeys;
import com.shu.priory.download.c;
import com.shu.priory.param.UploadData;
import com.shu.priory.request.a;
import com.shu.priory.utils.b;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class IFLYAdSDK {

    /* renamed from: a */
    private static String f16780a = null;

    /* renamed from: b */
    private static Context f16781b = null;

    /* renamed from: c */
    private static int f16782c = 1;

    /* renamed from: com.shu.priory.IFLYAdSDK$1 */
    public static class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UploadData.initParam(IFLYAdSDK.f16781b);
            UploadData.getDevice(null);
            UploadData.getExtraInfo();
            UploadData.getAppInfo(null);
            UploadData.getAdStatis();
            a.a(IFLYAdSDK.f16781b).b();
            OnStartListener onStartListener = OnStartListener.this;
            if (onStartListener != null) {
                onStartListener.onStartSuccess();
            }
        }
    }

    public interface OnStartListener {
        void onStartFailed(int i10, String str);

        void onStartSuccess();
    }

    public static int getPersonalizedState() {
        return f16782c;
    }

    public static synchronized void initWithoutStart(Context context) {
        synchronized (IFLYAdSDK.class) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (TextUtils.isEmpty(f16780a)) {
                        f16780a = context.getPackageName();
                    }
                    String d10 = b.d(context);
                    if (!f16780a.equals(d10)) {
                        WebView.setDataDirectorySuffix(d10);
                    }
                }
                f16781b = context.getApplicationContext();
            } finally {
            }
        }
    }

    public static void setParameter(String str, Object obj) {
        if (AdKeys.DEBUG_MODE.equals(str) && (obj instanceof Boolean)) {
            h.a(((Boolean) obj).booleanValue());
            return;
        }
        if (AdKeys.DOWNLOAD_CONTROL.equals(str) && (obj instanceof Boolean)) {
            c.b(((Boolean) obj).booleanValue());
        } else if (AdKeys.MAIN_PROCESS_NAME.equals(str) && (obj instanceof String)) {
            f16780a = (String) obj;
        }
    }

    public static void setPersonalizedState(int i10) {
        f16782c = i10;
    }

    public static synchronized void start(OnStartListener onStartListener) {
        synchronized (IFLYAdSDK.class) {
            if (f16781b != null) {
                new Thread(new Runnable() { // from class: com.shu.priory.IFLYAdSDK.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        UploadData.initParam(IFLYAdSDK.f16781b);
                        UploadData.getDevice(null);
                        UploadData.getExtraInfo();
                        UploadData.getAppInfo(null);
                        UploadData.getAdStatis();
                        a.a(IFLYAdSDK.f16781b).b();
                        OnStartListener onStartListener2 = OnStartListener.this;
                        if (onStartListener2 != null) {
                            onStartListener2.onStartSuccess();
                        }
                    }
                }).start();
            } else {
                if (onStartListener != null) {
                    onStartListener.onStartFailed(-1, "context is null");
                }
            }
        }
    }
}
