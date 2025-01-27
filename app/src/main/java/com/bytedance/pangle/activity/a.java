package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f7469a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7470b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7471c;

    /* renamed from: d, reason: collision with root package name */
    private Method f7472d;

    public a(@NonNull Activity activity, int i10, @NonNull String str) {
        this.f7469a = activity;
        this.f7470b = str;
        this.f7471c = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f7472d == null) {
            try {
                Method method = this.f7469a.getClass().getMethod(this.f7470b, View.class);
                if (method != null) {
                    this.f7472d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f7470b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f7471c);
        }
        try {
            this.f7472d.invoke(this.f7469a, view);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
        } catch (InvocationTargetException e11) {
            throw new IllegalStateException("Could not execute method for android:onClick", e11);
        }
    }
}
