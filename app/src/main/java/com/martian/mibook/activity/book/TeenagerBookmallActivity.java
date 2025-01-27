package com.martian.mibook.activity.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.TeenagerBookmallActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityTeenagerBookmallBinding;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.mibook.mvvm.yuewen.fragment.YWBookMallFragment;
import je.i;
import l9.i0;

/* loaded from: classes3.dex */
public class TeenagerBookmallActivity extends MiBackableActivity {
    public static final String B = "INTENT_IS_TEENAGER_MODE";
    public boolean A;

    public static void N2(Activity activity, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(B, z10);
        Intent intent = new Intent(activity, (Class<?>) TeenagerBookmallActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final /* synthetic */ void M2(String str, String str2) {
        if (l.q(str2)) {
            P1("密码不能为空,请重试");
        } else if (!str2.equals(str)) {
            P1("密码输入有误，请重试");
        } else {
            MiConfigSingleton.b2().i3("");
            i.A(this);
        }
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_teenager_bookmall);
        ActivityTeenagerBookmallBinding bind = ActivityTeenagerBookmallBinding.bind(D2());
        g(false);
        C1(true);
        J2(false);
        I2(true);
        if (bundle != null) {
            this.A = bundle.getBoolean(B);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.A = extras.getBoolean(B);
            }
        }
        if (!this.A) {
            bind.teenagerBookmallTitle.setText(getString(R.string.app_name));
            bind.teenagerBookmallButton.setVisibility(8);
            bind.teenagerBookmallLogo.setVisibility(8);
            bind.teenagerBookmallBg.setVisibility(8);
            bind.teenagerBookmallExit.setVisibility(0);
        }
        ((RelativeLayout.LayoutParams) bind.teenagerBookmallHeader.getLayoutParams()).topMargin = p1();
        if (((YWBookMallFragment) getSupportFragmentManager().findFragmentByTag("teenager_bookmall_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.teenager_bookmall_container, YWBookMallFragment.INSTANCE.a(this.A ? 3 : 4, false), "teenager_bookmall_fragment").commit();
        }
    }

    public void onExitBaseFunctionModeClick(View view) {
        i.h(this, false);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(B, this.A);
    }

    public void onTeenagerCloseClick(View view) {
        String q22 = MiConfigSingleton.b2().q2();
        if (l.q(q22)) {
            i.A(this);
        } else {
            i0.D0(this, "输入密码", "请输入四位数字密码", false, true, new i0.j() { // from class: ua.e

                /* renamed from: b */
                public final /* synthetic */ String f30969b;

                public /* synthetic */ e(String q222) {
                    q22 = q222;
                }

                @Override // l9.i0.j
                public final void a(String str) {
                    TeenagerBookmallActivity.this.M2(q22, str);
                }
            });
        }
    }
}
