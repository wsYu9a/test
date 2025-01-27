package com.martian.mibook.activity.book;

import android.os.Bundle;
import com.martian.libsupport.R;
import com.martian.mibook.fragment.RestoreBookStoreFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;

/* loaded from: classes3.dex */
public class RestoreBookStoreActivity extends MiBackableActivity {
    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_load_fragment);
        g2();
        if (((RestoreBookStoreFragment) getSupportFragmentManager().findFragmentByTag("RestoreBookStoreFragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(com.martian.mibook.R.id.fragmentContainer, new RestoreBookStoreFragment(), "RestoreBookStoreFragment").commit();
        }
    }
}
