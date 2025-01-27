package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
class c extends FileObserver {

    /* renamed from: a */
    final /* synthetic */ h f24812a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(h hVar, String str, int i2) {
        super(str, i2);
        this.f24812a = hVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        W w;
        if (str == null) {
            return;
        }
        String str2 = "/data/anr/" + str;
        X.e("watching file %s", str2);
        if (!str2.contains("trace")) {
            X.e("not anr file %s", str2);
        } else {
            w = this.f24812a.f24822f;
            w.a(new b(this, str2));
        }
    }
}
