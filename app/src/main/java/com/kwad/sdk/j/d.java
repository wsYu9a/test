package com.kwad.sdk.j;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
final class d extends ContextWrapper implements a {
    private final Context aDD;
    private Resources.Theme aay;
    private int aaz;
    private LayoutInflater mInflater;

    d(Context context) {
        super(context);
        this.aaz = -1;
        this.aDD = context;
        this.aaz = k.di(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return i.wrapContextIfNeed(this.aDD.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        return baseContext instanceof ContextWrapper ? ((ContextWrapper) baseContext).getBaseContext() : baseContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return i.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.j.a
    @NonNull
    public final Context getDelegatedContext() {
        return this.aDD;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return e.FK().getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return this.aDD.getSystemService(str);
        }
        if (this.mInflater == null) {
            LayoutInflater cloneInContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            this.mInflater = cloneInContext;
            k.a(cloneInContext);
        }
        return this.mInflater;
    }

    @Override // android.content.ContextWrapper, android.content.Context
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
            this.aay = i.replaceTheme(theme, theme2, this.aaz);
        }
        return this.aay;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aDD.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        this.aaz = i2;
        super.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aDD.unregisterComponentCallbacks(componentCallbacks);
    }
}
