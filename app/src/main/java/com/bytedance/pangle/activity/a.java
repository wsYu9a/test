package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f5992a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5993b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5994c;

    /* renamed from: d, reason: collision with root package name */
    private Method f5995d;

    public a(@NonNull Activity activity, int i2, @NonNull String str) {
        this.f5992a = activity;
        this.f5993b = str;
        this.f5994c = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f5995d == null) {
            try {
                Method method = this.f5992a.getClass().getMethod(this.f5993b, View.class);
                if (method != null) {
                    this.f5995d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f5993b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f5994c);
        }
        try {
            this.f5995d.invoke(this.f5992a, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Could not execute method for android:onClick", e3);
        }
    }
}
