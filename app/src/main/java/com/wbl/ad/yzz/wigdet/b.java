package com.wbl.ad.yzz.wigdet;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: d */
    public static Field f34411d;

    /* renamed from: e */
    public static Field f34412e;

    /* renamed from: f */
    public static b f34413f;

    /* renamed from: a */
    public Context f34414a;

    /* renamed from: b */
    public float f34415b = 17.5f;

    /* renamed from: c */
    public Handler f34416c = null;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f34417a;

        /* renamed from: b */
        public final /* synthetic */ View f34418b;

        public a(b bVar, Activity activity, View view) {
            this.f34417a = activity;
            this.f34418b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8464, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.wigdet.b$b */
    public static class HandlerC0796b extends Handler {

        /* renamed from: a */
        public Handler f34419a;

        public HandlerC0796b(Handler handler) {
            this.f34419a = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8463, this, message);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f34411d = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f34411d.getType().getDeclaredField("mHandler");
                f34412e = declaredField2;
                declaredField2.setAccessible(true);
            } catch (Throwable th) {
                com.wbl.ad.yzz.network.f.f.a(th);
            }
        }
        f34413f = null;
    }

    public b(Context context) {
        this.f34414a = context.getApplicationContext();
    }

    public static b a(Context context) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8458, null, context);
    }

    public static void a(Toast toast) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8457, null, toast);
    }

    public static void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8460, null, str);
    }

    public final Toast a(String str, int i2, int i3, boolean z) {
        return (Toast) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8459, this, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
    }

    public void a(Activity activity, FrameLayout frameLayout, CharSequence charSequence, int i2, long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8454, this, activity, frameLayout, charSequence, Integer.valueOf(i2), Long.valueOf(j2));
    }

    public void a(Activity activity, FrameLayout frameLayout, CharSequence charSequence, long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8453, this, activity, frameLayout, charSequence, Long.valueOf(j2));
    }

    public void a(Context context, CharSequence charSequence) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8456, this, context, charSequence);
    }

    public void a(Context context, CharSequence charSequence, int i2, int i3, int i4) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8455, this, context, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void a(Context context, CharSequence charSequence, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8450, this, context, charSequence, Boolean.valueOf(z));
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8449, this, charSequence, charSequence2);
    }

    public void a(CharSequence charSequence, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8452, this, charSequence, Boolean.valueOf(z));
    }

    public void a(String str, int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8451, this, str, Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public void a(String str, Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8478, this, str, context);
    }

    public void b(Context context, CharSequence charSequence, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8477, this, context, charSequence, Boolean.valueOf(z));
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8480, this, str);
    }

    public void b(String str, int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8479, this, str, Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8474, this, str);
    }

    public void c(String str, int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8473, this, str, Integer.valueOf(i2), Boolean.valueOf(z));
    }
}
