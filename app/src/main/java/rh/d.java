package rh;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public static boolean f30427a = false;

    /* renamed from: b */
    public static boolean f30428b = false;

    /* renamed from: c */
    public static Context f30429c = null;

    /* renamed from: d */
    public static boolean f30430d = false;

    /* renamed from: e */
    public static final String[] f30431e;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(20L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).build();
        f30431e = new String[]{g.f11102c, g.f11103d, g.f11100a};
    }

    public static void a(Activity activity, String... strArr) {
        String[] strArr2;
        if (Build.VERSION.SDK_INT >= 23) {
            if (strArr != null) {
                HashSet hashSet = new HashSet(Arrays.asList(f30431e));
                hashSet.addAll(Arrays.asList(strArr));
                strArr2 = (String[]) hashSet.toArray(new String[hashSet.size()]);
            } else {
                strArr2 = f30431e;
            }
            activity.requestPermissions(strArr2, 74565);
        }
    }

    public static /* synthetic */ void b(Context context) {
        if (d()) {
            Log.d("SNC_LOG", "post on delayed");
        }
        if (f30427a) {
            return;
        }
        f30427a = true;
    }

    public static synchronized void c(Context context, boolean z10) {
        synchronized (d.class) {
            if (f30427a && f30428b) {
                return;
            }
            if (z10) {
                if (d()) {
                    Log.d("SNC_LOG", "check on granted");
                }
                if (!f30428b || !f30427a) {
                    if (d()) {
                        Log.d("SNC_LOG", "post on granted");
                    }
                    f30428b = true;
                    f30427a = true;
                }
            } else {
                new Handler().postDelayed(new Runnable() { // from class: rh.c

                    /* renamed from: b */
                    public final /* synthetic */ Context f30426b;

                    public /* synthetic */ c(Context context2) {
                        context = context2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.b(context);
                    }
                }, 30000L);
            }
        }
    }

    public static boolean d() {
        return f30430d;
    }
}
