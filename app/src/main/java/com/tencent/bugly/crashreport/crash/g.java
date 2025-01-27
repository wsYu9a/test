package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
class g extends Thread {

    /* renamed from: a */
    final /* synthetic */ h f24854a;

    g(h hVar) {
        this.f24854a = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        List<CrashDetailBean> list;
        context = this.f24854a.q;
        if (!ca.a(context, "local_crash_lock", 10000L)) {
            X.a("Failed to lock file for uploading local crash.", new Object[0]);
            return;
        }
        List<CrashDetailBean> b2 = this.f24854a.r.b();
        if (b2 == null || b2.size() <= 0) {
            X.a("no crash need to be uploaded at this start", new Object[0]);
        } else {
            X.a("Size of crash list: %s", Integer.valueOf(b2.size()));
            int size = b2.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList();
                Collections.sort(b2);
                for (int i2 = 0; i2 < 20; i2++) {
                    arrayList.add(b2.get((size - 1) - i2));
                }
                list = arrayList;
            } else {
                list = b2;
            }
            this.f24854a.r.a(list, 0L, false, false, false);
        }
        context2 = this.f24854a.q;
        ca.b(context2, "local_crash_lock");
    }
}
