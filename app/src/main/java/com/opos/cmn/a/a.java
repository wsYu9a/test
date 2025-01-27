package com.opos.cmn.a;

import android.text.TextUtils;
import com.opos.acs.st.STManager;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static AtomicBoolean f16353a = new AtomicBoolean(false);

    /* renamed from: b */
    private static volatile boolean f16354b = false;

    /* renamed from: c */
    private static AtomicReference<String> f16355c = new AtomicReference<>(null);

    /* renamed from: d */
    private static AtomicBoolean f16356d = new AtomicBoolean(false);

    public static void a(boolean z, String str) {
        if (f16353a.compareAndSet(false, true)) {
            f16354b = z;
        }
        f16355c.compareAndSet(null, str);
    }

    public static boolean a() {
        a(false, STManager.REGION_OF_CN);
        return f16354b;
    }

    public static String b() {
        String str = f16355c.get();
        return TextUtils.isEmpty(str) ? STManager.REGION_OF_CN : str;
    }

    public static boolean c() {
        return f16356d.get();
    }
}
