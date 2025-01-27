package com.martian.mibook.activity.book;

import android.os.Bundle;
import com.martian.mibook.f.b4;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class RestoreBookStoreActivity extends com.martian.mibook.lib.model.b.a {
    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        B1();
        if (((b4) getSupportFragmentManager().findFragmentByTag("RestoreBookStoreFragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new b4(), "RestoreBookStoreFragment").commit();
        }
    }
}
