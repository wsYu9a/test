package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes4.dex */
public interface k {
    void a();

    void a(int i10);

    void a(Class<? extends Activity> cls, int i10, Bundle bundle);

    void onBackPressed();

    void onSetContentView(View view);
}
