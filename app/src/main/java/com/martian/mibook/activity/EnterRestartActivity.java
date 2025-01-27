package com.martian.mibook.activity;

import android.os.Bundle;
import com.martian.libmars.R;
import com.martian.mibook.application.MiConfigSingleton;
import l9.m0;

/* loaded from: classes3.dex */
public class EnterRestartActivity extends EnterActivity {
    @Override // com.martian.mibook.activity.EnterActivity
    public void M2() {
    }

    @Override // com.martian.mibook.activity.EnterActivity
    public void X2() {
        if (!this.f13106y) {
            this.f13106y = true;
        } else if (m0.C(this)) {
            finish();
        }
    }

    @Override // com.martian.mibook.activity.EnterActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u2(false);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        MiConfigSingleton.b2().u2().m(this);
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
