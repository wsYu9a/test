package com.kwai.sodler.lib.kwai.b;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.utils.s;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
final class d extends ContextThemeWrapper implements b {
    private String aKk;
    private final ContextThemeWrapper aaA;
    private Resources.Theme aay;
    private int aaz;

    public d(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.aaA = contextThemeWrapper;
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
        return a.at(this.aaA.getApplicationContext(), this.aKk);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aaA;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.b(super.getClassLoader(), this.aKk);
    }

    @Override // com.kwai.sodler.lib.kwai.b.b
    public final Context getDelegatedContext() {
        return this.aaA;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.aaA.getResources(), this.aKk);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aaA.getSystemService(str), str, this);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
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
        this.aaA.registerComponentCallbacks(componentCallbacks);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        this.aaz = i2;
        super.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aaA.unregisterComponentCallbacks(componentCallbacks);
    }
}
