package androidx.multidex;

import android.content.Context;
import bin.mt.signature.KillerApplication;

/* loaded from: classes.dex */
public class MultiDexApplication extends KillerApplication {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
