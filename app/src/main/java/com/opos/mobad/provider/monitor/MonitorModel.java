package com.opos.mobad.provider.monitor;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: classes4.dex */
public class MonitorModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.monitor.MonitorModel.1
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return MonitorModel.b(context.getApplicationContext());
        }
    };

    /* renamed from: a */
    private static volatile MonitorModel f23126a;

    /* renamed from: b */
    private Context f23127b;

    /* renamed from: com.opos.mobad.provider.monitor.MonitorModel$1 */
    static final class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return MonitorModel.b(context.getApplicationContext());
        }
    }

    private MonitorModel(Context context) {
        this.f23127b = context;
        com.opos.cmn.biz.monitor.a.a().a(this.f23127b);
    }

    public static final MonitorModel b(Context context) {
        if (f23126a == null) {
            synchronized (MonitorModel.class) {
                if (f23126a == null) {
                    f23126a = new MonitorModel(context);
                }
            }
        }
        return f23126a;
    }

    @BridgeMethod(a = 1)
    public void a(String str, MonitorEvent monitorEvent) {
        com.opos.cmn.biz.monitor.a.a().a(this.f23127b, str, monitorEvent);
    }
}
