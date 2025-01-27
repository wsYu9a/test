package com.martian.mibook.activity.account;

import android.os.Bundle;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class MartianHistoryMoneyListActivity extends com.martian.mibook.lib.model.b.a {
    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_withdraw_order_list);
        if (((com.martian.mibook.lib.account.c.b) getSupportFragmentManager().findFragmentByTag("history_money_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new com.martian.mibook.lib.account.c.b(), "history_money_list_fragment").commit();
        }
    }
}
