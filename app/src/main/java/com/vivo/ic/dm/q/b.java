package com.vivo.ic.dm.q;

import android.os.HandlerThread;
import com.vivo.ic.VLog;

/* loaded from: classes4.dex */
public class b extends HandlerThread {

    /* renamed from: a */
    private static final String f28611a = "BackgroundHandlerThread";

    public b(String str) {
        super(str, a(str) ? 10 : 0);
    }

    private static boolean a(String str) {
        boolean z = c.f28613b;
        VLog.d(f28611a, "useBackgroundPriority:" + z + ",name=" + str);
        return z;
    }

    public b(String str, int i2) {
        super(str, i2);
    }
}
