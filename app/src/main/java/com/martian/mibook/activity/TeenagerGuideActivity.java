package com.martian.mibook.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.k1;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class TeenagerGuideActivity extends com.martian.mibook.activity.base.n {
    private boolean Q = false;
    private com.martian.mibook.e.w R;

    /* renamed from: M2 */
    public /* synthetic */ void N2(View v) {
        boolean z = !this.Q;
        this.Q = z;
        this.R.f12853c.setImageResource(z ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        if (this.Q) {
            this.R.f12853c.clearAnimation();
        }
    }

    /* renamed from: O2 */
    public /* synthetic */ void P2(final String firstPwd, String text) {
        if (TextUtils.isEmpty(text)) {
            k1("密码不能为空,请重试");
            return;
        }
        if (TextUtils.isEmpty(firstPwd)) {
            if (text.length() == 4) {
                Q2(text, "请再输入一次密码");
                return;
            } else {
                k1("请输入四位数字密码");
                return;
            }
        }
        if (!text.equals(firstPwd)) {
            k1("两次密码输入不致，请重试");
        } else {
            MiConfigSingleton.V3().R7(firstPwd);
            s2.D(this);
        }
    }

    private void Q2(final String firstPwd, String hint) {
        com.martian.libmars.utils.k0.V(this, !com.martian.libsupport.k.p(firstPwd) ? "确认密码" : "设置密码", hint, false, true, new k0.i() { // from class: com.martian.mibook.activity.y0
            @Override // com.martian.libmars.utils.k0.i
            public final void a(String str) {
                TeenagerGuideActivity.this.P2(firstPwd, str);
            }
        });
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
    }

    public void onCivilizationPledgeClick(View view) {
        com.martian.mibook.lib.account.e.c.d(this);
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teenager_guide);
        this.R = com.martian.mibook.e.w.a(h2());
        C2(false);
        w2(k1.B);
        this.R.f12855e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeenagerGuideActivity.this.N2(view);
            }
        });
        this.R.f12854d.getPaint().setFlags(8);
        this.R.f12852b.getPaint().setFlags(8);
    }

    public void onProtectGuideClick(View view) {
        com.martian.mibook.lib.account.e.c.h(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onTeenagerOpenClick(View view) {
        if (this.Q) {
            Q2("", "请设置四位数字密码");
        } else {
            com.martian.libmars.utils.h0.e(this.R.f12855e);
        }
    }
}
