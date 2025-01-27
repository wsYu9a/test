package com.martian.mibook.activity.book;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.v;
import com.martian.mibook.f.f4.e0;
import com.martian.mibook.j.s2;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class TeenagerBookmallActivity extends com.martian.mibook.lib.model.b.a {
    private static final String F = "INTENT_IS_TEENAGER_MODE";
    private boolean G;

    /* renamed from: r2 */
    public /* synthetic */ void s2(final String password, String text) {
        if (com.martian.libsupport.k.p(text)) {
            k1("密码不能为空,请重试");
        } else if (!text.equals(password)) {
            k1("密码输入有误，请重试");
        } else {
            MiConfigSingleton.V3().R7("");
            s2.D(this);
        }
    }

    public static void t2(j1 activity, boolean isTeenagerMode) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(F, isTeenagerMode);
        activity.startActivity(TeenagerBookmallActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teenager_bookmall);
        v a2 = v.a(g2());
        d(false);
        W0(true);
        p2(false);
        n2(true);
        if (savedInstanceState != null) {
            this.G = savedInstanceState.getBoolean(F);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.G = extras.getBoolean(F);
            }
        }
        if (!this.G) {
            a2.f12807h.setText(getString(R.string.app_name));
            a2.f12802c.setVisibility(8);
            a2.f12806g.setVisibility(8);
            a2.f12801b.setVisibility(8);
            a2.f12804e.setVisibility(0);
        }
        ((RelativeLayout.LayoutParams) a2.f12805f.getLayoutParams()).topMargin = F0();
        if (((e0) getSupportFragmentManager().findFragmentByTag("teenager_bookmall_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.teenager_bookmall_container, e0.f0(this.G ? 3 : 4, MiConfigSingleton.V3().k(), false), "teenager_bookmall_fragment").commit();
        }
    }

    public void onExitBaseFunctionModeClick(View view) {
        s2.c(this, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(F, this.G);
    }

    public void onTeenagerCloseClick(View view) {
        final String y4 = MiConfigSingleton.V3().y4();
        if (com.martian.libsupport.k.p(y4)) {
            s2.D(this);
        } else {
            k0.V(this, "输入密码", "请输入四位数字密码", false, true, new k0.i() { // from class: com.martian.mibook.activity.book.u
                @Override // com.martian.libmars.utils.k0.i
                public final void a(String str) {
                    TeenagerBookmallActivity.this.s2(y4, str);
                }
            });
        }
    }
}
