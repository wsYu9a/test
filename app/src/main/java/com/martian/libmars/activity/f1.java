package com.martian.libmars.activity;

import android.os.Bundle;
import android.view.View;
import com.martian.libmars.R;

/* loaded from: classes.dex */
public abstract class f1 extends j1 {
    private int B = 0;

    public abstract View g2();

    public boolean h2() {
        return this.B != 0;
    }

    public void i2(boolean show) {
        View g2 = g2();
        int i2 = this.B + (show ? 1 : -1);
        this.B = i2;
        if (i2 <= 0) {
            this.B = 0;
            g2.setVisibility(8);
        } else if (i2 == 1) {
            g2.setVisibility(0);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
}
