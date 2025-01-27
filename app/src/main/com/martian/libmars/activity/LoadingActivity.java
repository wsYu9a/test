package com.martian.libmars.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public class LoadingActivity extends MartianActivity {

    /* renamed from: x */
    public ProgressBar f12034x;

    /* renamed from: w */
    public View f12033w = null;

    /* renamed from: y */
    public int f12035y = 0;

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i10) {
        View view;
        View findViewById = super.findViewById(i10);
        return (findViewById != null || (view = this.f12033w) == null) ? findViewById : view.findViewById(i10);
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        this.f12033w = null;
        super.setContentView(R.layout.libmars_loading_activity);
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.libmars_loading_wrapper);
        View inflate = getLayoutInflater().inflate(i10, (ViewGroup) null);
        this.f12033w = inflate;
        viewGroup.addView(inflate, 0);
    }

    public boolean y2() {
        return this.f12035y == 0;
    }

    public void z2(boolean z10) {
        if (this.f12034x == null) {
            this.f12034x = (ProgressBar) super.findViewById(R.id.libmars_pb_loading);
        }
        int i10 = this.f12035y + (z10 ? 1 : -1);
        this.f12035y = i10;
        if (i10 <= 0) {
            this.f12035y = 0;
            this.f12034x.setVisibility(8);
        } else if (i10 == 1) {
            this.f12034x.setVisibility(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        this.f12033w = null;
        super.setContentView(R.layout.libmars_loading_activity);
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.libmars_loading_wrapper);
        this.f12033w = view;
        viewGroup.addView(view, 0);
    }
}
