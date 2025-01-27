package b.d.a;

import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a */
    protected static TTAdManager f4360a;

    public static TTAdManager a() {
        if (f4360a == null) {
            f4360a = TTAdSdk.getAdManager();
        }
        return f4360a;
    }
}
