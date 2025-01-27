package com.martian.libmars.activity;

import android.os.Bundle;
import android.view.View;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public abstract class AbsLoadingActivity extends MartianActivity {

    /* renamed from: w */
    public int f12013w = 0;

    public void A2(boolean z10) {
        View y22 = y2();
        int i10 = this.f12013w + (z10 ? 1 : -1);
        this.f12013w = i10;
        if (i10 <= 0) {
            this.f12013w = 0;
            y22.setVisibility(8);
        } else if (i10 == 1) {
            y22.setVisibility(0);
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    public abstract View y2();

    public boolean z2() {
        return this.f12013w != 0;
    }
}
