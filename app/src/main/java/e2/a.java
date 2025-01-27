package e2;

import android.content.Context;
import com.kuaishou.weapon.p0.bq;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static a f25587a = new a();

    public static a a() {
        return f25587a;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return bq.f10841e;
        }
    }
}
