package com.martian.mibook.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.BackableActivity;
import com.martian.mibook.R;
import com.martian.mibook.activity.BaseFunctionGuideActivity;
import com.martian.mibook.databinding.ActivityBaseFunctionGuideBinding;
import je.i;
import l9.i0;

/* loaded from: classes3.dex */
public class BaseFunctionGuideActivity extends BackableActivity {
    public final /* synthetic */ void M2() {
        i.h(this, true);
    }

    public void onBaseFunctionClick(View view) {
        i0.x0(this, getString(R.string.confirm_message), getString(R.string.base_function_dialog), getString(com.martian.libmars.R.string.cancel), getString(R.string.confirm), false, new i0.l() { // from class: qa.a
            public /* synthetic */ a() {
            }

            @Override // l9.i0.l
            public final void a() {
                BaseFunctionGuideActivity.this.M2();
            }
        }, new i0.k() { // from class: qa.b
            public /* synthetic */ b() {
            }

            @Override // l9.i0.k
            public final void a() {
                BaseFunctionGuideActivity.this.finish();
            }
        });
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_function_guide);
        ActivityBaseFunctionGuideBinding.bind(D2()).baseFunction.setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
