package kj;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class c {
    public static final boolean a() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
            method.setAccessible(true);
            context = (Context) method.invoke(null, null);
        } catch (Exception e10) {
            StringBuilder a10 = nh.b.a("ActivityThread:currentApplication --> ");
            a10.append(e10.toString());
            Log.e(u2.b.f30924a, a10.toString());
        }
        if (context == null) {
            return false;
        }
        return b.b().e(context, false);
    }
}
