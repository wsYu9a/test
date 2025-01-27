package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class e {
    private static final Map<String, List<String>> aSt;

    /* renamed from: com.kwad.sdk.utils.e$1 */
    public class AnonymousClass1 extends b.C0491b {
        final /* synthetic */ String aSu;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.core.download.a.b.C0491b, com.kwad.sdk.core.download.a.b.a
        public final void onError(Throwable th2) {
            super.onError(th2);
            com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bt.t(th2));
        }

        @Override // com.kwad.sdk.core.download.a.b.C0491b, com.kwad.sdk.core.download.a.b.a
        public final void onStart() {
            super.onStart();
            com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
        }

        @Override // com.kwad.sdk.core.download.a.b.C0491b, com.kwad.sdk.core.download.a.b.a
        public final void onSuccess() {
            super.onSuccess();
            AdTemplate adTemplate = AdTemplate.this;
            adTemplate.mXiaomiAppStoreDetailViewOpen = true;
            adTemplate.mClickOpenAppStore = true;
            com.kwad.sdk.commercial.b.a.b(adTemplate, str, "com.xiaomi.market", 0, 1);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        aSt = hashMap;
        hashMap.put("huawei", Arrays.asList("com.huawei.appmarket"));
        hashMap.put("oppo", Arrays.asList("com.oppo.market", "com.heytap.market"));
        hashMap.put(ke.e.f27807e, Arrays.asList("com.bbk.appstore"));
        hashMap.put("xiaomi", Arrays.asList("com.xiaomi.market"));
        hashMap.put("oneplus", Arrays.asList("com.oppo.market"));
        hashMap.put("meizu", Arrays.asList("com.meizu.mstore"));
        hashMap.put("samsung", Arrays.asList("com.sec.android.app.samsungapps"));
        hashMap.put("smartisan", Arrays.asList("com.smartisanos.appstore"));
        hashMap.put(ke.e.f27809g, Arrays.asList("com.oppo.market"));
        hashMap.put("honor", Arrays.asList("com.hihonor.appmarket", "com.huawei.appmarket"));
    }

    public static boolean a(Context context, String str, AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (ay.NY() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, "com.xiaomi.market", 0, 1);
                return false;
            }
            if (com.kwad.sdk.core.download.a.b.a(context, str, new b.C0491b() { // from class: com.kwad.sdk.utils.e.1
                final /* synthetic */ String aSu;

                public AnonymousClass1(String str2) {
                    str = str2;
                }

                @Override // com.kwad.sdk.core.download.a.b.C0491b, com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th2) {
                    super.onError(th2);
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bt.t(th2));
                }

                @Override // com.kwad.sdk.core.download.a.b.C0491b, com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    super.onStart();
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C0491b, com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    super.onSuccess();
                    AdTemplate adTemplate2 = AdTemplate.this;
                    adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                    adTemplate2.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
                }
            }) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(Context context, AdTemplate adTemplate) {
        String str;
        String str2;
        int i10;
        Intent intent;
        String str3;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        String cX = com.kwad.sdk.core.response.b.a.cX(eb2);
        String ay = com.kwad.sdk.core.response.b.a.ay(eb2);
        Map<String, List<String>> map = aSt;
        String str4 = Build.BRAND;
        List<String> list = map.get(str4.toLowerCase());
        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
            str = "";
        } else {
            str = list.get(0);
        }
        String str5 = str;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(cX)) {
            com.kwad.sdk.commercial.b.a.a(adTemplate, str5, 1, 0);
            return false;
        }
        try {
            if ("samsung".equals(str4)) {
                cX = "http://apps.samsung.com/appquery/appDetail.as?appId=" + ay;
            }
            com.kwad.sdk.commercial.b.a.a(adTemplate, cX, str5, 1, 0);
            intent = new Intent("android.intent.action.VIEW", Uri.parse(cX));
            intent.addFlags(268435456);
            for (String str6 : list) {
                PackageInfo packageInfo = ao.getPackageInfo(context, str6, 1);
                if (packageInfo != null && (str3 = packageInfo.packageName) != null && str3.equals(str6)) {
                    intent.setPackage(str3);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, cX, str6, 1, 0);
                    return true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = cX;
            i10 = 1;
        }
        try {
            context.startActivity(intent);
            adTemplate.mClickOpenAppStore = true;
            com.kwad.sdk.commercial.b.a.b(adTemplate, cX, str5, 0, 0);
            return true;
        } catch (Throwable th3) {
            th = th3;
            str2 = cX;
            i10 = 0;
            com.kwad.sdk.commercial.b.a.a(adTemplate, str2, str5, i10, 0, bt.t(th));
            return false;
        }
    }
}
