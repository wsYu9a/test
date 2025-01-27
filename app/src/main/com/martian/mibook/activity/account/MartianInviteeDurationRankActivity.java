package com.martian.mibook.activity.account;

import android.os.Bundle;
import com.martian.mibook.R;
import com.martian.mibook.fragment.InviteeDurationRankFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;

/* loaded from: classes3.dex */
public class MartianInviteeDurationRankActivity extends MiBackableActivity {
    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.martian_activity_withdraw_order_list);
        u2(true);
        g2();
        if (((InviteeDurationRankFragment) getSupportFragmentManager().findFragmentByTag("invitee_duration_rank_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new InviteeDurationRankFragment(), "invitee_duration_rank_fragment").commit();
        }
    }
}
