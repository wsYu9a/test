package jh;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static Context f27577a;

    public static Context a() {
        Context context;
        synchronized (b.class) {
            if (f27577a == null) {
                Context context2 = null;
                try {
                    context2 = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
                } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e10) {
                    e10.printStackTrace();
                }
                f27577a = context2;
            }
            context = f27577a;
        }
        return context;
    }
}
