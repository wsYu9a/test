package com.opos.mobad.provider.statistic;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: classes4.dex */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c */
    private static final String f23159c = StatisticModel.class.getName();

    public a(Context context, StatisticModelIdentify statisticModelIdentify) {
        this.f23782a = context;
        this.f23783b = statisticModelIdentify;
    }

    @Override // com.opos.process.bridge.provider.a
    protected Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final void a(String str) throws c, b {
        b(this.f23782a, f23159c, this.f23783b, 2, str);
    }

    public final void a(String str, String str2) throws c, b {
        b(this.f23782a, f23159c, this.f23783b, 1, str, str2);
    }
}
