package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ea;

/* loaded from: classes4.dex */
public class f extends FileObserver {

    /* renamed from: a */
    final /* synthetic */ h f22418a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, String str, int i10) {
        super(str, i10);
        this.f22418a = hVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i10, String str) {
        boolean b10;
        ea eaVar;
        ea eaVar2;
        if (str == null) {
            return;
        }
        X.e("startWatchingPrivateAnrDir %s", str);
        b10 = this.f22418a.b(str);
        if (!b10) {
            X.a("trace file not caused by sigquit , ignore ", new Object[0]);
            return;
        }
        eaVar = this.f22418a.f22431l;
        if (eaVar != null) {
            eaVar2 = this.f22418a.f22431l;
            eaVar2.a(true);
        }
    }
}
