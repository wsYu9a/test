package com.opos.mobad.provider.ad;

import android.content.Context;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: classes4.dex */
public class AdCacheModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.ad.AdCacheModel.1
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return AdCacheModel.b(context.getApplicationContext());
        }
    };

    /* renamed from: a */
    private static volatile AdCacheModel f23117a;

    /* renamed from: b */
    private b f23118b;

    /* renamed from: com.opos.mobad.provider.ad.AdCacheModel$1 */
    static final class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return AdCacheModel.b(context.getApplicationContext());
        }
    }

    private AdCacheModel(Context context) {
        this.f23118b = new b(context);
    }

    public static final AdCacheModel b(Context context) {
        if (f23117a == null) {
            synchronized (AdCacheModel.class) {
                if (f23117a == null) {
                    f23117a = new AdCacheModel(context);
                }
            }
        }
        return f23117a;
    }

    @BridgeMethod(a = 2)
    public AdEntity a(String str) {
        return this.f23118b.a(str);
    }

    @BridgeMethod(a = 1)
    public void a(String str, AdEntity adEntity) {
        this.f23118b.a(str, adEntity);
    }
}
