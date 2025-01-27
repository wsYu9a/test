package oh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import okhttp3.MediaType;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static Context f29195a;

    /* renamed from: b */
    public static String f29196b;

    /* renamed from: c */
    public static String f29197c;

    /* renamed from: d */
    public static String f29198d;

    /* renamed from: e */
    public static final MediaType f29199e = MediaType.parse("application/json; charset=utf-8");

    @SuppressLint({"HardwareIds"})
    public static String a() {
        if (f29198d == null) {
            f29198d = Settings.Secure.getString(f29195a.getContentResolver(), "android_id");
        }
        if (f29198d == null) {
            f29198d = "";
        }
        return f29198d;
    }
}
