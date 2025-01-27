package com.martian.mibook.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.activity.RetryLoadingActivity;
import com.martian.mibook.activity.TeenagerGuideActivity;
import com.martian.mibook.activity.base.MiRetryLoadingActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityTeenagerGuideBinding;
import je.i;
import l9.a;
import l9.i0;
import lb.c;

/* loaded from: classes3.dex */
public class TeenagerGuideActivity extends MiRetryLoadingActivity {
    public boolean L = false;
    public ActivityTeenagerGuideBinding M;

    public /* synthetic */ void j3(View view) {
        boolean z10 = !this.L;
        this.L = z10;
        this.M.intimateIcon.setImageResource(z10 ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        if (this.L) {
            this.M.intimateIcon.clearAnimation();
        }
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
    }

    public final /* synthetic */ void k3(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            P1("密码不能为空,请重试");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (str2.length() == 4) {
                l3(str2, "请再输入一次密码");
                return;
            } else {
                P1("请输入四位数字密码");
                return;
            }
        }
        if (!str2.equals(str)) {
            P1("两次密码输入不致，请重试");
        } else {
            MiConfigSingleton.b2().i3(str);
            i.A(this);
        }
    }

    public final void l3(String str, String str2) {
        i0.D0(this, !l.q(str) ? "确认密码" : "设置密码", str2, false, true, new i0.j() { // from class: qa.a0

            /* renamed from: b */
            public final /* synthetic */ String f29966b;

            public /* synthetic */ a0(String str3) {
                str = str3;
            }

            @Override // l9.i0.j
            public final void a(String str3) {
                TeenagerGuideActivity.this.k3(str, str3);
            }
        });
    }

    public void onCivilizationPledgeClick(View view) {
        c.l(this);
    }

    @Override // com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.martian.mibook.R.layout.activity_teenager_guide);
        this.M = ActivityTeenagerGuideBinding.bind(C2());
        Y2(false);
        S2(RetryLoadingActivity.H);
        this.M.privacyIntimate.setOnClickListener(new View.OnClickListener() { // from class: qa.b0
            public /* synthetic */ b0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeenagerGuideActivity.this.j3(view);
            }
        });
        this.M.intimateLink.getPaint().setFlags(8);
        this.M.intimateCivilization.getPaint().setFlags(8);
    }

    public void onProtectGuideClick(View view) {
        c.p(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onTeenagerOpenClick(View view) {
        if (this.L) {
            l3("", "请设置四位数字密码");
        } else {
            a.f(this.M.privacyIntimate);
        }
    }
}
