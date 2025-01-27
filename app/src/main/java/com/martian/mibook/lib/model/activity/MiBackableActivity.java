package com.martian.mibook.lib.model.activity;

import android.os.Bundle;
import com.martian.libmars.activity.BackableActivity;
import com.martian.mibook.lib.model.BaseConfigSingleton;

/* loaded from: classes3.dex */
public class MiBackableActivity extends BackableActivity {
    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(BaseConfigSingleton.r1().s1().themeNoActionBar);
        super.onCreate(bundle);
    }
}
