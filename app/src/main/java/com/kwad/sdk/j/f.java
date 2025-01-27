package com.kwad.sdk.j;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class f extends Application implements a {
    private final Application aDK;
    private final g aDL;

    public f(Application application, g gVar) {
        this.aDK = application;
        this.aDL = gVar;
        attachBaseContext(gVar);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this.aDL.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aDL.getClassLoader();
    }

    @Override // com.kwad.sdk.j.a
    @NonNull
    public final Context getDelegatedContext() {
        return this.aDK;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aDL.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}
