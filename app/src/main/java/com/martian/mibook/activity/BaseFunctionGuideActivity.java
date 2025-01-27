package com.martian.mibook.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.g1;
import com.martian.libmars.utils.k0;
import com.martian.mibook.j.s2;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class BaseFunctionGuideActivity extends g1 {
    private com.martian.mibook.e.e F;

    /* renamed from: r2 */
    public /* synthetic */ void s2() {
        s2.c(this, true);
    }

    public void onBaseFunctionClick(View view) {
        com.martian.libmars.utils.k0.Q(this, getString(R.string.confirm_message), getString(R.string.base_function_dialog), getString(R.string.cancel), getString(R.string.confirm), false, new k0.l() { // from class: com.martian.mibook.activity.b
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                BaseFunctionGuideActivity.this.s2();
            }
        }, new k0.j() { // from class: com.martian.mibook.activity.b1
            @Override // com.martian.libmars.utils.k0.j
            public final void a() {
                BaseFunctionGuideActivity.this.finish();
            }
        });
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_function_guide);
        this.F = com.martian.mibook.e.e.a(g2());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
