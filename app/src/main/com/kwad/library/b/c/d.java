package com.kwad.library.b.c;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.utils.w;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
final class d extends ContextThemeWrapper implements b {
    private Resources.Theme alX;
    private int alY;
    private String alZ;
    private final ContextThemeWrapper ama;

    public d(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.ama = contextThemeWrapper;
        this.alZ = str;
        try {
            Object a10 = w.a((Object) contextThemeWrapper, "android.view.ContextThemeWrapper", "getThemeResId");
            if (a10 != null) {
                this.alY = ((Integer) a10).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.i(this.ama.getApplicationContext(), this.alZ);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.ama;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.alZ);
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.ama;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.ama.getResources(), this.alZ);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.ama.getSystemService(str), str, this);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e10) {
            e10.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.alX;
        if (theme2 == null || theme2 == theme) {
            this.alX = a.a(theme, theme2, this.alY, this.alZ);
        }
        return this.alX;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.ama.registerComponentCallbacks(componentCallbacks);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        this.alY = i10;
        super.setTheme(i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.ama.unregisterComponentCallbacks(componentCallbacks);
    }
}
