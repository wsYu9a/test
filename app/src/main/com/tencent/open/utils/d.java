package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static Context f23261a;

    public static final Context a() {
        Context context = f23261a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final void a(Context context) {
        f23261a = context;
    }
}
