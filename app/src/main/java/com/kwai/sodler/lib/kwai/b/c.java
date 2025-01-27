package com.kwai.sodler.lib.kwai.b;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.s;

/* loaded from: classes2.dex */
final class c extends ContextThemeWrapper implements b {
    private String aKk;
    private final ContextThemeWrapper aax;
    private Resources.Theme aay;
    private int aaz;

    c(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.aax = contextThemeWrapper;
        this.aKk = str;
        try {
            Object a2 = s.a((Object) contextThemeWrapper, "getThemeResId", new Object[0]);
            if (a2 != null) {
                this.aaz = ((Integer) a2).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.at(this.aax.getApplicationContext(), this.aKk);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aax;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.b(super.getClassLoader(), this.aKk);
    }

    @Override // com.kwai.sodler.lib.kwai.b.b
    public final Context getDelegatedContext() {
        return this.aax;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.aax.getResources(), this.aKk);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aax.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e2) {
            e2.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aay;
        if (theme2 == null || theme2 == theme) {
            this.aay = a.a(theme, theme2, this.aaz, this.aKk);
        }
        return this.aay;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aax.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        this.aaz = i2;
        super.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aax.unregisterComponentCallbacks(componentCallbacks);
    }
}
