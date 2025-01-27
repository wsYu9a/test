package com.martian.mibook.activity.account;

import android.os.Bundle;
import com.martian.mibook.f.c4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class TXSCoinsRecordActivity extends com.martian.mibook.lib.model.b.a {
    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        if (((c4) getSupportFragmentManager().findFragmentByTag("txs_coins_record_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new c4(), "txs_coins_record_fragment").commit();
        }
    }
}
