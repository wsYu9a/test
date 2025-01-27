package com.kwad.components.offline.api.tk;

import android.content.Intent;

/* loaded from: classes2.dex */
public interface IOfflineTKNativeIntent {
    void callTKBridge(String str);

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
