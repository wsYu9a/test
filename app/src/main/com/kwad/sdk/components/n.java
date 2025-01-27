package com.kwad.sdk.components;

import android.app.Activity;
import android.view.View;

/* loaded from: classes3.dex */
public interface n {
    void bindActivity(Activity activity);

    View getView();

    boolean onBackPressed();

    void render();
}
