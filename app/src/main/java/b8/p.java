package b8;

import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: classes3.dex */
public abstract class p {

    /* renamed from: a */
    public static TTAdManager f1450a;

    public static TTAdManager a() {
        if (f1450a == null) {
            f1450a = TTAdSdk.getAdManager();
        }
        return f1450a;
    }
}
