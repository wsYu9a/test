package kk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import bh.b;
import com.at.api.service.CService;
import com.at.api.service.DService;
import com.at.sdk.callback.RUCallback;
import com.sntech.ads.SNAdConfig;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.api.event.SNEvent;
import nk.l;
import org.json.JSONObject;
import p002continue.f;
import ph.e;
import ph.g;

/* loaded from: classes5.dex */
public final class c {

    public class a implements rh.a {
    }

    public class b implements CService {
        @Override // com.at.api.service.CService
        public final void isRiskUser(RUCallback rUCallback) {
            b.a.f1608a.f("Fallback", "isRiskUser(Fallback)");
            g.a(new g.a() { // from class: kk.d
                public /* synthetic */ d() {
                }

                @Override // ph.g.a
                public final void a(Object obj) {
                    RUCallback.this.callback(((Boolean) obj).booleanValue());
                }
            });
        }

        @Override // com.at.api.service.CService
        public final void onAdClick(SNEvent.AdPlatform adPlatform, String str, String str2) {
            b.a.f1608a.f("Fallback", "onAdClick(Fallback)");
            l.c().g(adPlatform, str, SNEvent.AdType.NATIVE, SNEvent.AdEvent.CLICK, str2);
        }

        @Override // com.at.api.service.CService
        public final void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d10, String str2) {
            b.a.f1608a.f("Fallback", "onAdShow(Fallback)");
            l.c().e(view, adPlatform, str, SNEvent.AdType.NATIVE, SNEvent.AdEvent.SHOW, d10, str2);
        }

        @Override // com.at.api.service.CService
        public final void onEvent(String str, JSONObject jSONObject) {
            b.a.f1608a.f("Fallback", "onrEvent(Fallback)");
            l.c().u(str, jSONObject);
        }

        @Override // com.at.api.service.CService
        public final void onUserEvent(SNEvent.UserEvent userEvent) {
            b.a.f1608a.f("Fallback", "onUserEvent(Fallback)");
            l.c().q(userEvent);
        }

        @Override // com.at.api.service.CService
        public final void onWithdraw(String str, float f10, SNEvent.WithdrawChannel withdrawChannel, String str2) {
            b.a.f1608a.f("Fallback", "onWithdraw(Fallback)");
            l.c().s(str, f10, withdrawChannel, str2);
        }

        @Override // com.at.api.service.CService
        public final void setABTest(String str, int i10, String... strArr) {
            b.a.f1608a.f("Fallback", "setABTest(Fallback)");
            l.c().t(str, i10, strArr);
        }

        @Override // com.at.api.service.CService
        public final void setUserId(String str) {
            b.a.f1608a.f("Fallback", "setUserId(Fallback)");
            l.c().r(str);
        }
    }

    /* renamed from: kk.c$c */
    public class C0727c implements DService {
        @Override // com.at.api.service.DService
        public final String did(Context context) {
            b.a.f1608a.f("Fallback", "did(Fallback)");
            boolean z10 = rh.d.f30427a;
            return sk.b.a(context);
        }

        @Override // com.at.api.service.DService
        public final void onRequestPermissionResult(Activity activity, int i10, String[] strArr, int[] iArr) {
            b.a.f1608a.f("Fallback", "onRequestPermissionResult(Fallback)");
            if (rh.d.d()) {
                Log.d("SNC_LOG", "onRequestPermissionResult");
            }
            rh.d.c(rh.d.f30429c, true);
        }

        @Override // com.at.api.service.DService
        public final void requestPermissionsIfNeed(Activity activity, String... strArr) {
            b.a.f1608a.f("Fallback", "requestPermissionsIfNeed(Fallback)");
            rh.d.a(activity, strArr);
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.HashSet, java.util.Set<java.lang.Object>] */
    public static void a(Context context, SNAdConfig sNAdConfig) {
        g.f29902f = sNAdConfig.isDebug();
        b.a.f1608a.f("Fallback", "CC.init(Fallback)");
        String sdkVersion = SNAdSdk.getAdManager().getSdkVersion();
        String did = SNAdSdk.getAdManager().did(context);
        String appId = sNAdConfig.getAppId();
        kk.a aVar = new e() { // from class: kk.a
            @Override // ph.e
            public final String j() {
                return oh.a.a();
            }
        };
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        g.f29897a = context;
        g.f29898b = sdkVersion;
        g.f29899c = did;
        g.f29900d = appId;
        g.f29901e = aVar;
        l.c().f28972a = g.f29897a;
        f fVar = f.b.f25213a;
        b bVar = new b();
        fVar.getClass();
        fVar.f25208c.add(bVar);
    }

    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.HashSet, java.util.Set<java.lang.Object>] */
    public static void b(Context context, SNAdConfig sNAdConfig) {
        b.a.f1608a.f("Fallback", "SNC.init(Fallback)");
        String sdkVersion = SNAdSdk.getAdManager().getSdkVersion();
        StringBuilder a10 = nh.b.a("AN_A4_");
        a10.append(sNAdConfig.getAppId());
        String sb2 = a10.toString();
        boolean isDebug = sNAdConfig.isDebug();
        a aVar = new a();
        kk.b bVar = new rh.b() { // from class: kk.b
            @Override // rh.b
            public final String j() {
                return oh.a.a();
            }
        };
        rh.e eVar = new rh.e();
        eVar.f30432a = sdkVersion;
        eVar.f30433b = sb2;
        eVar.f30434c = isDebug;
        eVar.f30435d = aVar;
        eVar.f30436e = bVar;
        boolean z10 = rh.d.f30427a;
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        rh.d.f30429c = context;
        rh.d.f30430d = eVar.f30434c;
        sk.b.f30677a = eVar.f30432a;
        sk.b.f30678b = eVar.f30433b;
        sk.b.f30679c = eVar.f30435d;
        sk.b.f30680d = eVar.f30436e;
        f fVar = f.b.f25213a;
        C0727c c0727c = new C0727c();
        fVar.getClass();
        fVar.f25208c.add(c0727c);
    }
}
