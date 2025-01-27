package com.martian.libmars.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class i1 extends j1 {
    private ProgressBar C;
    private View B = null;
    private int D = 0;

    @Override // me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int id) {
        View view;
        View findViewById = super.findViewById(id);
        return (findViewById != null || (view = this.B) == null) ? findViewById : view.findViewById(id);
    }

    public boolean g2() {
        return this.D == 0;
    }

    public void h2(boolean show) {
        if (this.C == null) {
            this.C = (ProgressBar) super.findViewById(R.id.libmars_pb_loading);
        }
        int i2 = this.D + (show ? 1 : -1);
        this.D = i2;
        if (i2 <= 0) {
            this.D = 0;
            this.C.setVisibility(8);
        } else if (i2 == 1) {
            this.C.setVisibility(0);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int layoutResID) {
        this.B = null;
        super.setContentView(R.layout.libmars_loading_activity);
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.libmars_loading_wrapper);
        View inflate = getLayoutInflater().inflate(layoutResID, (ViewGroup) null);
        this.B = inflate;
        viewGroup.addView(inflate, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view) {
        this.B = null;
        super.setContentView(R.layout.libmars_loading_activity);
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.libmars_loading_wrapper);
        this.B = view;
        viewGroup.addView(view, 0);
    }
}
