package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class g extends Thread {

    /* renamed from: a */
    final /* synthetic */ h f22461a;

    public g(h hVar) {
        this.f22461a = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        List<CrashDetailBean> list;
        context = this.f22461a.f22478q;
        if (!ca.a(context, "local_crash_lock", 10000L)) {
            X.a("Failed to lock file for uploading local crash.", new Object[0]);
            return;
        }
        List<CrashDetailBean> b10 = this.f22461a.f22479r.b();
        if (b10 == null || b10.size() <= 0) {
            X.a("no crash need to be uploaded at this start", new Object[0]);
        } else {
            X.a("Size of crash list: %s", Integer.valueOf(b10.size()));
            int size = b10.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList();
                Collections.sort(b10);
                for (int i10 = 0; i10 < 20; i10++) {
                    arrayList.add(b10.get((size - 1) - i10));
                }
                list = arrayList;
            } else {
                list = b10;
            }
            this.f22461a.f22479r.a(list, 0L, false, false, false);
        }
        context2 = this.f22461a.f22478q;
        ca.b(context2, "local_crash_lock");
    }
}
