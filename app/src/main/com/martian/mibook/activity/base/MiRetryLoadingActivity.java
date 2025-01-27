package com.martian.mibook.activity.base;

import android.os.Bundle;
import com.martian.libmars.activity.RetryLoadingActivity;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes3.dex */
public abstract class MiRetryLoadingActivity extends RetryLoadingActivity {
    @Override // com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(MiConfigSingleton.b2().r2().e().themeNoActionBar);
        super.onCreate(bundle);
        u2(true);
    }
}
