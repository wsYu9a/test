package com.martian.mibook.activity.book;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.f4.e0;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class FinishedOrNewBooksActivity extends com.martian.mibook.lib.model.b.a {
    private int F;
    private int G;
    private String H;

    public static void startActivity(j1 activity, int tid, int ctype, String channel) {
        Bundle bundle = new Bundle();
        bundle.putInt(e0.f13106j, tid);
        bundle.putInt(MiConfigSingleton.Q0, ctype);
        bundle.putString(e0.k, channel);
        activity.startActivity(FinishedOrNewBooksActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        B1();
        if (savedInstanceState != null) {
            this.F = savedInstanceState.getInt(e0.f13106j);
            this.G = savedInstanceState.getInt(MiConfigSingleton.Q0);
            this.H = savedInstanceState.getString(e0.k);
        } else {
            this.F = v0(e0.f13106j, -1);
            this.G = v0(MiConfigSingleton.Q0, -1);
            this.H = G0(e0.k);
        }
        if (!com.martian.libsupport.k.p(this.H)) {
            Z1(this.H);
        }
        if (((e0) getSupportFragmentManager().findFragmentByTag("finished_or_new_books_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, e0.f0(this.F, this.G, false), "finished_or_new_books_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(e0.f13106j, this.F);
        outState.putInt(MiConfigSingleton.Q0, this.G);
        outState.putString(e0.k, this.H);
    }
}
