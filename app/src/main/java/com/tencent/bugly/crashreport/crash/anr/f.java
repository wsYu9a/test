package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ea;

/* loaded from: classes4.dex */
class f extends FileObserver {

    /* renamed from: a */
    final /* synthetic */ h f24815a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(h hVar, String str, int i2) {
        super(str, i2);
        this.f24815a = hVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        boolean b2;
        ea eaVar;
        ea eaVar2;
        if (str == null) {
            return;
        }
        X.e("startWatchingPrivateAnrDir %s", str);
        b2 = this.f24815a.b(str);
        if (!b2) {
            X.a("trace file not caused by sigquit , ignore ", new Object[0]);
            return;
        }
        eaVar = this.f24815a.l;
        if (eaVar != null) {
            eaVar2 = this.f24815a.l;
            eaVar2.a(true);
        }
    }
}
