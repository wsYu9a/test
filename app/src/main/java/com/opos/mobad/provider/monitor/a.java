package com.opos.mobad.provider.monitor;

import android.content.Context;
import android.net.Uri;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: classes4.dex */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c */
    private static final String f23128c = MonitorModel.class.getName();

    public a(Context context) {
        this.f23782a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    protected Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final void a(String str, MonitorEvent monitorEvent) throws c, b {
        b(this.f23782a, f23128c, this.f23783b, 1, str, monitorEvent);
    }
}
