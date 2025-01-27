package com.martian.mibook.activity.book;

import android.os.Bundle;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.f4.j0;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class YWTagsActivity extends com.martian.mibook.lib.model.b.a {
    private String F = "";
    private int G = 1;

    public static void r2(j1 activity, String tag, int freeType, int exposeType) {
        Bundle bundle = new Bundle();
        bundle.putInt(MiConfigSingleton.Q0, freeType);
        bundle.putString(j0.k, tag);
        bundle.putInt(j0.f13133j, exposeType);
        activity.startActivity(YWTagsActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ywcategories);
        d2(false);
        if (savedInstanceState != null) {
            this.F = savedInstanceState.getString(j0.k);
            this.G = savedInstanceState.getInt(MiConfigSingleton.Q0);
        } else {
            this.F = G0(j0.k);
            this.G = v0(MiConfigSingleton.Q0, 1);
        }
        if (!com.martian.libsupport.k.p(this.F)) {
            Z1(this.F);
        }
        if (((j0) getSupportFragmentManager().findFragmentByTag("tag_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new j0(), "tag_list_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(j0.k, this.F);
        outState.putInt(MiConfigSingleton.Q0, this.G);
        super.onSaveInstanceState(outState);
    }
}
