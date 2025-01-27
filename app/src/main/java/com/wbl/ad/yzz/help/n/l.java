package com.wbl.ad.yzz.help.n;

import android.app.Activity;
import com.baidu.mobads.sdk.api.AppActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.qq.e.ads.ADActivity;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class l {

    /* renamed from: a */
    public static Field f32742a;

    /* renamed from: b */
    public static Field f32743b;

    /* renamed from: c */
    public static Field f32744c;

    static {
        try {
            Field declaredField = AppActivity.class.getDeclaredField("mProxyActivity");
            f32742a = declaredField;
            declaredField.setAccessible(true);
            com.wbl.ad.yzz.network.f.f.d("baidu activity setup: " + f32742a);
        } catch (Throwable th) {
            th.printStackTrace();
            com.wbl.ad.yzz.network.f.f.c("error bd activity");
            com.wbl.ad.yzz.network.f.f.a(th);
        }
        try {
            Field declaredField2 = ADActivity.class.getDeclaredField("a");
            f32743b = declaredField2;
            declaredField2.setAccessible(true);
            com.wbl.ad.yzz.network.f.f.d("mGdtField activity setup: " + f32743b);
        } catch (Throwable th2) {
            th2.printStackTrace();
            com.wbl.ad.yzz.network.f.f.c("error mGdtField activity");
            com.wbl.ad.yzz.network.f.f.a(th2);
        }
        try {
            Field declaredField3 = GenerateProxyActivity.class.getDeclaredField("mTargetActivity");
            f32744c = declaredField3;
            declaredField3.setAccessible(true);
            com.wbl.ad.yzz.network.f.f.d("mCsjField activity setup: " + f32743b);
        } catch (Throwable th3) {
            th3.printStackTrace();
            com.wbl.ad.yzz.network.f.f.c("error mCsjField activity");
            com.wbl.ad.yzz.network.f.f.a(th3);
        }
    }

    public static void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12889, null, activity);
    }

    public static boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12892, null, null);
    }

    public static void b(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12891, null, activity);
    }

    public static boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12886, null, null);
    }

    public static void c(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12885, null, activity);
    }

    public static void d(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12888, null, activity);
    }
}
