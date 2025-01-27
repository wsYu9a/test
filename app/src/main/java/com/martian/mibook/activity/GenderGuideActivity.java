package com.martian.mibook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.martian.libmars.activity.j1;
import com.martian.libmars.activity.k1;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class GenderGuideActivity extends com.martian.mibook.activity.base.n {
    public static final int Q = 876;
    private int R = 0;
    private long S = -1;

    private void M2(final int changeGender) {
        if (changeGender == MiConfigSingleton.V3().v3()) {
            k1(getString(R.string.gender_change_hint1));
            return;
        }
        String string = getString(R.string.prompt);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.gender_change_hint2));
        sb.append(getString(changeGender == 2 ? R.string.female : R.string.male));
        sb.append(getString(R.string.novel));
        sb.append(getString(R.string.gender_change_hint3));
        com.martian.libmars.utils.k0.P(this, string, sb.toString(), new k0.l() { // from class: com.martian.mibook.activity.o
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                GenderGuideActivity.this.O2(changeGender);
            }
        });
    }

    /* renamed from: N2 */
    public /* synthetic */ void O2(final int changeGender) {
        MiConfigSingleton.V3().q7(changeGender);
        setResult(-1);
        finish();
    }

    /* renamed from: P2 */
    public /* synthetic */ void Q2(View v) {
        T2();
    }

    static /* synthetic */ boolean R2(View v) {
        if (!com.martian.libmars.d.h.F().Q0() || !MiConfigSingleton.V3().x5()) {
            return false;
        }
        MiUser C4 = MiConfigSingleton.V3().C4();
        C4.setUid(Long.valueOf(MartianRPUserManager.t()));
        MiConfigSingleton.V3().O6(C4);
        return false;
    }

    public static void S2(j1 activity) {
        activity.startActivityForResult(GenderGuideActivity.class, new Bundle(), Q);
    }

    private void T2() {
        if (this.R <= 0 || System.currentTimeMillis() - this.S <= 2000) {
            this.R++;
        } else {
            this.R = 1;
        }
        this.S = System.currentTimeMillis();
        if (this.R >= 8) {
            this.R = 0;
            MiConfigSingleton.V3().S8(this);
        }
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
    }

    public void onBoyClick(View view) {
        M2(1);
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        int b2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_guide);
        com.martian.mibook.e.k a2 = com.martian.mibook.e.k.a(h2());
        C2(false);
        w2(k1.B);
        int b3 = com.martian.libmars.d.h.b(28.0f);
        if (z0() > 0 && (b2 = (int) ((((r2 / 2) - com.martian.libmars.d.h.b(200.0f)) - F0()) * 0.4f)) > b3) {
            b3 = b2;
        }
        ((RelativeLayout.LayoutParams) a2.f12219h.getLayoutParams()).bottomMargin = b3;
        int v3 = MiConfigSingleton.V3().v3();
        a2.k.setText(getString(R.string.choose_gender));
        a2.f12220i.setVisibility(v3 == 1 ? 0 : 8);
        a2.f12220i.setImageResource(R.drawable.success);
        a2.f12215d.setVisibility(v3 != 2 ? 8 : 0);
        a2.f12215d.setImageResource(R.drawable.success);
        a2.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenderGuideActivity.this.Q2(view);
            }
        });
        a2.k.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return GenderGuideActivity.R2(view);
            }
        });
    }

    public void onGenderSkipClick(View view) {
    }

    public void onGirlClick(View view) {
        M2(2);
    }
}
