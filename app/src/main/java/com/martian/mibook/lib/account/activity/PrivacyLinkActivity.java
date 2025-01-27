package com.martian.mibook.lib.account.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.g1;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public class PrivacyLinkActivity extends g1 {
    private com.martian.mibook.lib.account.b.c F;

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_link);
        com.martian.mibook.lib.account.b.c a2 = com.martian.mibook.lib.account.b.c.a(g2());
        this.F = a2;
        ThemeTextView themeTextView = a2.f13833c;
        String string = getString(R.string.privacy_desc_1);
        int i2 = R.string.app_name;
        themeTextView.setText(String.format(string, getString(i2), getString(i2)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
