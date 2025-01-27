package com.sigmob.sdk.videoAd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.LandscapeAdActivity;
import com.sigmob.sdk.base.common.LandscapeTransparentAdActivity;
import com.sigmob.sdk.base.common.PortraitAdActivity;
import com.sigmob.sdk.base.common.PortraitTransparentAdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class BaseAdActivity extends Activity {

    /* renamed from: a */
    public static final String f20394a = "LandPage";

    /* renamed from: b */
    public static final String f20395b = "reward";

    /* renamed from: c */
    public static final String f20396c = "mraid";

    /* renamed from: d */
    public static final String f20397d = "mraid_two";

    /* renamed from: e */
    public static final String f20398e = "LandNative";

    /* renamed from: f */
    public static final String f20399f = "DisLike";

    /* renamed from: g */
    public static final String f20400g = "ad_view_class_name";

    /* renamed from: h */
    public static final String f20401h = "adUnit_requestId_key";

    /* renamed from: i */
    public static final String f20402i = "land_page_url";

    /* renamed from: j */
    public static final String f20403j = "new_interstitial";

    public static Intent a(Context context, Class<? extends BaseAdActivity> cls, String str, String str2) {
        Intent intent = new Intent(context, cls);
        intent.setFlags(268435456);
        intent.putExtra(f20400g, str2);
        intent.putExtra(f20401h, str);
        int requestedOrientation = context instanceof Activity ? ((Activity) context).getRequestedOrientation() : 3;
        if (requestedOrientation != 7 && requestedOrientation != 6) {
            requestedOrientation = context.getResources().getDisplayMetrics().widthPixels > context.getResources().getDisplayMetrics().heightPixels ? 6 : 7;
        }
        intent.putExtra(com.sigmob.sdk.base.k.f18191w, requestedOrientation);
        intent.putExtra(Constants.BROADCAST_IDENTIFIER_KEY, str);
        return intent;
    }

    public static void b(Context context, Class<? extends BaseAdActivity> cls, String str) {
        a(context, cls, str, null, f20394a);
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String str) {
        try {
            Intent intent = new Intent(context, cls);
            intent.setFlags(268435456);
            intent.putExtra(f20400g, f20399f);
            intent.putExtra(f20401h, str);
            intent.putExtra(Constants.BROADCAST_IDENTIFIER_KEY, "dislike_broadcastIdentifier");
            context.startActivity(intent);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, BaseAdUnit baseAdUnit) {
        Intent a10 = a(context, cls, baseAdUnit.getUuid(), f20394a);
        try {
            Bundle bundle = new Bundle();
            bundle.putSerializable(f20402i, baseAdUnit);
            a10.putExtras(bundle);
            context.startActivity(a10);
        } catch (Throwable th2) {
            new HashMap().put("error", th2.getMessage());
        }
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String str, Bundle bundle, String str2) {
        try {
            int display_orientation = com.sigmob.sdk.base.common.h.f(str).getDisplay_orientation();
            if (display_orientation == 0) {
                display_orientation = ClientMetadata.getInstance().getOrientationInt().intValue();
            }
            Class cls2 = TransparentAdActivity.class;
            if (cls != cls2) {
                cls2 = display_orientation != 1 ? display_orientation != 2 ? AdActivity.class : LandscapeAdActivity.class : PortraitAdActivity.class;
            } else if (display_orientation == 1) {
                cls2 = PortraitTransparentAdActivity.class;
            } else if (display_orientation == 2) {
                cls2 = LandscapeTransparentAdActivity.class;
            }
            Intent a10 = a(context, cls2, str, str2);
            if (bundle != null) {
                a10.putExtras(bundle);
            }
            context.startActivity(a10);
        } catch (Throwable th2) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", th2.getMessage());
            BaseBroadcastReceiver.a(context, str, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
        }
    }
}
