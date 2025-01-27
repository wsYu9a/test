package com.martian.mibook.activity.account;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.martian.libsupport.R;
import com.martian.mibook.fragment.BookCoinsTxsFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;

/* loaded from: classes3.dex */
public class BookCoinsTxsActivity extends MiBackableActivity {
    public static final String B = "RECHARGE_DIRECTLY";
    public boolean A = false;

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_load_fragment);
        if (bundle != null) {
            this.A = bundle.getBoolean(B);
        } else {
            this.A = getIntent().getBooleanExtra(B, false);
        }
        if (((BookCoinsTxsFragment) getSupportFragmentManager().findFragmentByTag("BOOK_COINS_TXS_TAG")) == null) {
            getSupportFragmentManager().beginTransaction().add(com.martian.mibook.R.id.fragmentContainer, new BookCoinsTxsFragment(), "BOOK_COINS_TXS_TAG").commit();
        }
        if (this.A) {
            startActivity(TXSRechargeActivity.class);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(B, this.A);
    }
}
