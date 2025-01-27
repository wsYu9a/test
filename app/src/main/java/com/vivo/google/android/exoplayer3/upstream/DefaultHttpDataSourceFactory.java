package com.vivo.google.android.exoplayer3.upstream;

import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import com.vivo.google.android.exoplayer3.t5;
import com.vivo.google.android.exoplayer3.u5;
import com.vivo.google.android.exoplayer3.x5;

/* loaded from: classes4.dex */
public final class DefaultHttpDataSourceFactory extends u5.b {
    public final boolean allowCrossProtocolRedirects;
    public final int connectTimeoutMillis;
    public final x5<? super DataSource> listener;
    public final int readTimeoutMillis;
    public final String userAgent;

    public DefaultHttpDataSourceFactory(String str) {
        this(str, null);
    }

    public DefaultHttpDataSourceFactory(String str, x5<? super DataSource> x5Var) {
        this(str, x5Var, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, false);
    }

    public DefaultHttpDataSourceFactory(String str, x5<? super DataSource> x5Var, int i2, int i3, boolean z) {
        this.userAgent = str;
        this.listener = x5Var;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.allowCrossProtocolRedirects = z;
    }

    @Override // com.vivo.google.android.exoplayer3.u5.b
    public t5 createDataSourceInternal(u5.g gVar) {
        return new t5(this.userAgent, null, this.listener, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, gVar);
    }
}
