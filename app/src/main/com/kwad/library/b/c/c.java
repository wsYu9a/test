package com.kwad.library.b.c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.w;

/* loaded from: classes3.dex */
final class c extends ContextThemeWrapper implements b {
    private final ContextThemeWrapper alW;
    private Resources.Theme alX;
    private int alY;
    private String alZ;

    public c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.alW = contextThemeWrapper;
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
        return a.i(this.alW.getApplicationContext(), this.alZ);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.alW;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.alZ);
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.alW;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.alW.getResources(), this.alZ);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.alW.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
        this.alW.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        this.alY = i10;
        super.setTheme(i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.alW.unregisterComponentCallbacks(componentCallbacks);
    }
}
