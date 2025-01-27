package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class c extends FileObserver {

    /* renamed from: a */
    final /* synthetic */ h f22415a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar, String str, int i10) {
        super(str, i10);
        this.f22415a = hVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i10, String str) {
        W w10;
        if (str == null) {
            return;
        }
        String str2 = "/data/anr/" + str;
        X.e("watching file %s", str2);
        if (!str2.contains("trace")) {
            X.e("not anr file %s", str2);
        } else {
            w10 = this.f22415a.f22425f;
            w10.a(new b(this, str2));
        }
    }
}
