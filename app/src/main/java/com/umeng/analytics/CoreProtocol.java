package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a */
    private static Context f25576a;

    private static class a {

        /* renamed from: a */
        private static final CoreProtocol f25577a = new CoreProtocol();

        private a() {
        }
    }

    /* synthetic */ CoreProtocol(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static CoreProtocol getInstance(Context context) {
        if (f25576a == null && context != null) {
            f25576a = context.getApplicationContext();
        }
        return a.f25577a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        o.a(f25576a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        o.a(f25576a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        o.a(f25576a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return o.a(f25576a).a(j2);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        o.a(f25576a).a(obj, i2);
    }

    private CoreProtocol() {
    }
}
