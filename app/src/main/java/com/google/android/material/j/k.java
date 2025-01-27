package com.google.android.material.j;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.u;

/* loaded from: classes.dex */
public class k {
    private k() {
    }

    @NonNull
    static e a(int i2) {
        return i2 != 0 ? i2 != 1 ? b() : new f() : new n();
    }

    @NonNull
    static e b() {
        return new n();
    }

    @NonNull
    static g c() {
        return new g();
    }

    public static void d(@NonNull View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            ((j) background).m0(f2);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            f(view, (j) background);
        }
    }

    public static void f(@NonNull View view, @NonNull j jVar) {
        if (jVar.a0()) {
            jVar.r0(u.h(view));
        }
    }
}
