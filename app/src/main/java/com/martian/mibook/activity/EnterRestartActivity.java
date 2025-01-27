package com.martian.mibook.activity;

import android.os.Bundle;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.ttbookhd.R;

/* loaded from: classes.dex */
public class EnterRestartActivity extends EnterActivity {
    @Override // com.martian.mibook.activity.EnterActivity
    public void C2() {
        if (!this.F) {
            this.F = true;
        } else {
            if (isFinishing()) {
                return;
            }
            finish();
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override // com.martian.mibook.activity.EnterActivity
    protected void n2() {
    }

    @Override // com.martian.mibook.activity.EnterActivity, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a2(false);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        MiConfigSingleton.V3().Q1(this);
    }
}
