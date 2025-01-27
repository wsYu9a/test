package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.martian.libmars.activity.RetryLoadingActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.GenderGuideActivity;
import com.martian.mibook.activity.base.MiRetryLoadingActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityGenderGuideBinding;
import l9.i0;

/* loaded from: classes3.dex */
public class GenderGuideActivity extends MiRetryLoadingActivity {
    public static final int L = 876;

    public static void k3(Activity activity) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, (Class<?>) GenderGuideActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, L);
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
    }

    public final void i3(int i10) {
        if (i10 == MiConfigSingleton.b2().S1()) {
            P1(getString(R.string.gender_change_hint1));
            return;
        }
        String string = getString(com.martian.libmars.R.string.prompt);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R.string.gender_change_hint2));
        sb2.append(getString(i10 == 2 ? R.string.female : R.string.male));
        sb2.append(getString(R.string.novel));
        sb2.append(getString(R.string.gender_change_hint3));
        i0.z0(this, string, sb2.toString(), new i0.l() { // from class: qa.h

            /* renamed from: b */
            public final /* synthetic */ int f29978b;

            public /* synthetic */ h(int i102) {
                i10 = i102;
            }

            @Override // l9.i0.l
            public final void a() {
                GenderGuideActivity.this.j3(i10);
            }
        });
    }

    public final /* synthetic */ void j3(int i10) {
        MiConfigSingleton.b2().b3(i10);
        setResult(-1);
        finish();
    }

    public void onBoyClick(View view) {
        i3(1);
    }

    @Override // com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        super.onCreate(bundle);
        setContentView(R.layout.activity_gender_guide);
        ActivityGenderGuideBinding bind = ActivityGenderGuideBinding.bind(C2());
        Y2(false);
        S2(RetryLoadingActivity.H);
        int i11 = ConfigSingleton.i(28.0f);
        if (j1() > 0 && (i10 = (int) ((((r2 / 2) - ConfigSingleton.i(200.0f)) - p1()) * 0.4f)) > i11) {
            i11 = i10;
        }
        ((RelativeLayout.LayoutParams) bind.genderGuideTitleView.getLayoutParams()).bottomMargin = i11;
        int S1 = MiConfigSingleton.b2().S1();
        bind.guideTitle.setText(getString(R.string.choose_gender));
        bind.genderMaleMore.setVisibility(S1 == 1 ? 0 : 8);
        bind.genderMaleMore.setImageResource(R.drawable.success);
        bind.genderFemaleMore.setVisibility(S1 != 2 ? 8 : 0);
        bind.genderFemaleMore.setImageResource(R.drawable.success);
        MiConfigSingleton.b2().H1().B(this, bind.guideTitle);
    }

    public void onGenderSkipClick(View view) {
    }

    public void onGirlClick(View view) {
        i3(2);
    }
}
