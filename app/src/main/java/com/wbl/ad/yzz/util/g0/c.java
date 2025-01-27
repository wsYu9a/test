package com.wbl.ad.yzz.util.g0;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: f */
    public static String f34337f;

    /* renamed from: a */
    public final b f34338a;

    /* renamed from: b */
    public boolean f34339b;

    /* renamed from: c */
    public boolean f34340c;

    /* renamed from: d */
    public View f34341d;

    /* renamed from: e */
    public View f34342e;

    public static class b {

        /* renamed from: a */
        public final int f34343a;

        /* renamed from: b */
        public final boolean f34344b;

        /* renamed from: c */
        public final int f34345c;

        /* renamed from: d */
        public final int f34346d;

        /* renamed from: e */
        public final boolean f34347e;

        /* renamed from: f */
        public final float f34348f;

        public /* synthetic */ b(Activity activity, boolean z, boolean z2, a aVar) {
            this(activity, z, z2);
        }

        public final float a(Activity activity) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-8312, this, activity);
        }

        public int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8311, this, null);
        }

        public final int a(Context context) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8306, this, context);
        }

        public final int a(Resources resources, String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8305, this, resources, str);
        }

        public int b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8308, this, null);
        }

        public final int b(Context context) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8307, this, context);
        }

        public int c() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8270, this, null);
        }

        public final int c(Context context) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8269, this, context);
        }

        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8272, this, null);
        }

        public final boolean d(Context context) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8271, this, context);
        }

        public boolean e() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8266, this, null);
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f34347e = resources.getConfiguration().orientation == 1;
            this.f34348f = a(activity);
            this.f34343a = a(resources, "status_bar_height");
            a((Context) activity);
            int b2 = b(activity);
            this.f34345c = b2;
            this.f34346d = c(activity);
            this.f34344b = b2 > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
                declaredMethod.setAccessible(true);
                f34337f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f34337f = null;
            }
        }
    }

    @SuppressLint({"ResourceType"})
    @TargetApi(19)
    public c(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation});
            try {
                this.f34339b = obtainStyledAttributes.getBoolean(0, false);
                this.f34340c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                int i2 = window.getAttributes().flags;
                if ((67108864 & i2) != 0) {
                    this.f34339b = true;
                }
                if ((i2 & 134217728) != 0) {
                    this.f34340c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.f34339b, this.f34340c);
        this.f34338a = bVar;
        if (!bVar.d()) {
            this.f34340c = false;
        }
        if (this.f34339b) {
            b(activity, viewGroup);
        }
        if (this.f34340c) {
            a(activity, viewGroup);
        }
    }

    public static /* synthetic */ String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8265, null, null);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8268, this, Integer.valueOf(i2));
    }

    public final void a(Context context, ViewGroup viewGroup) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8267, this, context, viewGroup);
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8262, this, Boolean.valueOf(z));
    }

    public final void b(Context context, ViewGroup viewGroup) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8261, this, context, viewGroup);
    }
}
