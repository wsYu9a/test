package com.martian.mibook.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class TextTestActivity extends com.martian.mibook.lib.model.b.a {
    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_test);
        ((TextView) findViewById(R.id.text_id_1)).setVisibility(0);
    }
}
