package com.opos.mobad.provider.strategy;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: classes4.dex */
public class StrategyModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.strategy.StrategyModel.1
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return StrategyModel.b(context);
        }
    };

    /* renamed from: b */
    private static volatile StrategyModel f23166b;

    /* renamed from: a */
    private Context f23167a;

    /* renamed from: c */
    private a f23168c;

    /* renamed from: com.opos.mobad.provider.strategy.StrategyModel$1 */
    static final class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return StrategyModel.b(context);
        }
    }

    private StrategyModel(Context context) {
        this.f23167a = context;
        this.f23168c = new a(context);
        b();
    }

    public static final StrategyModel b(Context context) {
        if (f23166b == null) {
            synchronized (StrategyModel.class) {
                if (f23166b == null) {
                    f23166b = new StrategyModel(context);
                }
            }
        }
        return f23166b;
    }

    private void b() {
        d("dispatch_strategy");
    }

    private void c(String str) {
        d("dispatch_strategy_" + str);
    }

    private void d(String str) {
        Context context = this.f23167a;
        if (context != null && Build.VERSION.SDK_INT >= 24) {
            context.deleteSharedPreferences(str);
        }
    }

    @BridgeMethod(a = 3)
    public Bundle a(String str) {
        return this.f23168c.b(str);
    }

    @BridgeMethod(a = 5)
    public AppInfo a() {
        return this.f23168c.a();
    }

    @BridgeMethod(a = 2)
    public void a(String str, StrategyInfo strategyInfo) {
        this.f23168c.a(str, strategyInfo.f23165b, strategyInfo.f23164a);
    }

    @BridgeMethod(a = 1)
    public void a(String str, String str2, AppInfo appInfo) {
        c(str);
        this.f23168c.a(str2, appInfo.f23161b, appInfo.f23160a);
    }

    @BridgeMethod(a = 4)
    public AppInfo b(String str) {
        return this.f23168c.a(str);
    }
}
