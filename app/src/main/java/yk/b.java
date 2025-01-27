package yk;

import android.content.Context;
import com.sntech.ads.SNAdConfig;
import com.sntech.ads.impl.entity.InitConfig;
import p002continue.f;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public static boolean f33563a = false;

    /* renamed from: b */
    public static Context f33564b;

    /* renamed from: c */
    public static InitConfig f33565c;

    public static boolean a() {
        SNAdConfig sNAdConfig = f.b.f25213a.f25209d;
        if (sNAdConfig == null) {
            return false;
        }
        return sNAdConfig.isDebug();
    }

    public static boolean b() {
        return mj.j.a().getInt("START_UP_TIMES", 0) <= 1;
    }
}
