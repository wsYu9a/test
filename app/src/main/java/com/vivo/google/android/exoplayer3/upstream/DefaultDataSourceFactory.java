package com.vivo.google.android.exoplayer3.upstream;

import android.content.Context;
import com.vivo.google.android.exoplayer3.s5;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.x5;

/* loaded from: classes4.dex */
public final class DefaultDataSourceFactory implements DataSource.Factory {
    public final DataSource.Factory baseDataSourceFactory;
    public final Context context;
    public final x5<? super DataSource> listener;

    public DefaultDataSourceFactory(Context context, x5<? super DataSource> x5Var, DataSource.Factory factory) {
        this.context = context.getApplicationContext();
        this.listener = x5Var;
        this.baseDataSourceFactory = factory;
    }

    public DefaultDataSourceFactory(Context context, String str) {
        this(context, str, (x5<? super DataSource>) null);
    }

    public DefaultDataSourceFactory(Context context, String str, x5<? super DataSource> x5Var) {
        this(context, x5Var, new DefaultHttpDataSourceFactory(str, x5Var));
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource.Factory
    public s5 createDataSource() {
        return new s5(this.context, this.listener, this.baseDataSourceFactory.createDataSource());
    }
}
