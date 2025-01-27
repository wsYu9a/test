package com.aggmoread.sdk.client;

import android.content.Context;
import android.util.Log;
import com.aggmoread.sdk.b.a;
import com.aggmoread.sdk.client.AMAdLoader;
import com.aggmoread.sdk.t;
import com.aggmoread.sdk.z.d.a.a.c.k;
import com.aggmoread.sdk.z.d.a.a.e.c;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AMSdk {
    private static IAdSdkManager sdkManager;

    /* renamed from: com.aggmoread.sdk.client.AMSdk$1 */
    public static class AnonymousClass1 implements k.e {
        public AnonymousClass1() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.k.e
        public void callback(k.f fVar) {
            String str;
            String str2;
            if (fVar != null) {
                str = fVar.f5245a;
                str2 = fVar.f5246b;
            } else {
                str = null;
                str2 = null;
            }
            SDKBidInfoCallback.this.onResult(str, str2);
        }
    }

    public interface IAdSdkManager {
        void init(Context context, AMAdConfig aMAdConfig);

        void preLoad(Context context, List<AMChannelIdInfo> list);
    }

    public interface SDKBidInfoCallback {
        void onResult(String str, String str2);
    }

    public static void getSDKBidInfo(String str, Map<String, Object> map, SDKBidInfoCallback sDKBidInfoCallback) {
        if (sDKBidInfoCallback != null) {
            k.a(str, map, new k.e() { // from class: com.aggmoread.sdk.client.AMSdk.1
                public AnonymousClass1() {
                }

                @Override // com.aggmoread.sdk.z.d.a.a.c.k.e
                public void callback(k.f fVar) {
                    String str2;
                    String str22;
                    if (fVar != null) {
                        str2 = fVar.f5245a;
                        str22 = fVar.f5246b;
                    } else {
                        str2 = null;
                        str22 = null;
                    }
                    SDKBidInfoCallback.this.onResult(str2, str22);
                }
            });
        }
    }

    public static String getSDKVersion() {
        return c.q();
    }

    public static void init(Context context, AMAdConfig aMAdConfig) {
        if (sdkManager != null) {
            return;
        }
        synchronized (AMSdk.class) {
            try {
                if (sdkManager != null) {
                    return;
                }
                IAdSdkManager iAdSdkManager = (IAdSdkManager) a.a(new Class[]{IAdSdkManager.class, AMAdLoader.IAdLoader.class}, context);
                sdkManager = iAdSdkManager;
                iAdSdkManager.init(context, aMAdConfig);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static AMAdLoader makeAdLoader(AMAdLoadSlot aMAdLoadSlot) {
        String str;
        String str2;
        if (sdkManager == null) {
            str = t.SDK_TAG;
            str2 = "广告未初始化，请先对广告进行初始化操作!";
        } else {
            if (aMAdLoadSlot != null) {
                return new AMAdLoader(aMAdLoadSlot);
            }
            str = t.SDK_TAG;
            str2 = "广告请求参数为null，广告创建失败!";
        }
        Log.e(str, str2);
        return null;
    }

    public static void preLoad(Context context, List<AMChannelIdInfo> list) {
        if (sdkManager == null) {
            Log.e(t.SDK_TAG, "广告未初始化，请先对广告进行初始化操作!");
        } else {
            if (list == null || list.isEmpty()) {
                return;
            }
            sdkManager.preLoad(context, list);
        }
    }
}
