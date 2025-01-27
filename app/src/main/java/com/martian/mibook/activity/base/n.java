package com.martian.mibook.activity.base;

import android.os.Bundle;
import com.martian.libmars.activity.k1;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes3.dex */
public abstract class n extends k1 {
    @Override // com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(MiConfigSingleton.V3().I4.e().themeNoActionBar);
        super.onCreate(savedInstanceState);
        a2(true);
    }
}
