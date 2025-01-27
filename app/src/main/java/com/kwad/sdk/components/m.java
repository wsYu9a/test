package com.kwad.sdk.components;

import android.content.Intent;

/* loaded from: classes3.dex */
public interface m {
    void a(p pVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z10, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}
