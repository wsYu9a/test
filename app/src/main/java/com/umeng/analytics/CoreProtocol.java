package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a */
    private static Context f23310a;

    public static class a {

        /* renamed from: a */
        private static final CoreProtocol f23311a = new CoreProtocol();

        private a() {
        }
    }

    public /* synthetic */ CoreProtocol(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static CoreProtocol getInstance(Context context) {
        if (f23310a == null && context != null) {
            f23310a = context.getApplicationContext();
        }
        return a.f23311a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        q.a(f23310a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        q.a(f23310a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        q.a(f23310a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j10) {
        return q.a(f23310a).a(j10);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i10) {
        q.a(f23310a).a(obj, i10);
    }

    private CoreProtocol() {
    }
}
