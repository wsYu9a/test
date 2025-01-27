package yk;

import bh.b;
import com.sntech.ads.SNInitializer;
import com.sntech.ads.impl.entity.InitConfig;
import java.util.Set;

/* loaded from: classes5.dex */
public final class a implements SNInitializer.InitCallback {
    @Override // com.sntech.ads.SNInitializer.InitCallback
    public final void success() {
        InitConfig initConfig = b.f33565c;
        boolean c10 = mj.f.c();
        if (initConfig != null) {
            boolean z10 = initConfig.handleCrash == 1;
            bh.j jVar = b.a.f1608a;
            String str = c.f33566b;
            jVar.f(str, "handle crash = " + z10);
            mj.j.e("crash_handler_enabled", z10);
            boolean z11 = initConfig.handleSelfCrash == 1;
            jVar.f(str, "handle self crash = " + z11);
            mj.j.e("handle_self_crash", z11);
            Set<String> set = initConfig.selfCrashKeywords;
            jVar.f(str, "SelfCrashKeywords = " + set);
            mj.j.g(set);
        }
        if (c10 || !mj.f.c()) {
            return;
        }
        c.f33567c.postDelayed(new e(), 3000L);
    }

    @Override // com.sntech.ads.SNInitializer.InitCallback
    public final void fail(Exception exc) {
    }
}
