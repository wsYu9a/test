package com.opos.mobad.provider.init;

import android.content.Context;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: classes4.dex */
public class InitModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.init.InitModel.1
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return InitModel.b(context.getApplicationContext());
        }
    };

    /* renamed from: a */
    private static volatile InitModel f23123a;

    /* renamed from: b */
    private Context f23124b;

    /* renamed from: com.opos.mobad.provider.init.InitModel$1 */
    static final class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return InitModel.b(context.getApplicationContext());
        }
    }

    public InitModel(Context context) {
        this.f23124b = context;
    }

    public static final InitModel b(Context context) {
        if (f23123a == null) {
            synchronized (InitModel.class) {
                if (f23123a == null) {
                    f23123a = new InitModel(context);
                }
            }
        }
        return f23123a;
    }

    @BridgeMethod(a = 1)
    public void a(boolean z, boolean z2) {
        com.opos.cmn.c.a.a(this.f23124b.getApplicationContext(), z, z2);
        com.opos.cmn.an.f.a.b("", "init ContentProvider Log " + z2);
    }
}
