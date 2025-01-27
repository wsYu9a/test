package com.opos.mobad.provider.openId;

import android.content.Context;
import com.opos.cmn.g.a.b;
import com.opos.cmn.g.a.c;
import com.opos.mobad.provider.statistic.StatisticModel;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: classes4.dex */
public class IdModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.openId.IdModel.1
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public IdModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            IdModelIdentify idModelIdentify = (IdModelIdentify) iBridgeTargetIdentify;
            return IdModel.b(context.getApplicationContext(), idModelIdentify.f23133a, idModelIdentify.f23134b);
        }
    };

    /* renamed from: a */
    private static volatile IdModel f23129a;

    /* renamed from: b */
    private Context f23130b;

    /* renamed from: c */
    private boolean f23131c;

    /* renamed from: d */
    private String f23132d;

    /* renamed from: com.opos.mobad.provider.openId.IdModel$1 */
    static final class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public IdModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            IdModelIdentify idModelIdentify = (IdModelIdentify) iBridgeTargetIdentify;
            return IdModel.b(context.getApplicationContext(), idModelIdentify.f23133a, idModelIdentify.f23134b);
        }
    }

    private IdModel(Context context, boolean z, String str) {
        this.f23130b = context;
        this.f23131c = z;
        this.f23132d = str;
        StatisticModel.a(context, z, str);
    }

    public static final IdModel b(Context context, boolean z, String str) {
        if (f23129a == null) {
            synchronized (IdModel.class) {
                if (f23129a == null) {
                    f23129a = new IdModel(context, z, str);
                }
            }
        }
        return f23129a;
    }

    @BridgeMethod(a = 1)
    public OpenIdData a() {
        return new OpenIdData(b.a(this.f23130b), b.b(this.f23130b), !com.opos.cmn.an.f.a.b(this.f23130b) ? b.c(this.f23130b) : null);
    }

    @BridgeMethod(a = 2)
    public boolean b() {
        return b.h(this.f23130b);
    }

    @BridgeMethod(a = 3)
    public String c() {
        c.b(this.f23130b);
        return com.opos.cmn.an.f.a.b(this.f23130b) ? c.c(this.f23130b) : c.a(this.f23130b);
    }
}
