package com.martian.mibook.activity.book;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.f4.i0;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class YWChannelBooksActivity extends com.martian.mibook.lib.model.b.a {
    private String F;
    private String G;
    private int H;
    private int I;
    private int J;

    public static void r2(j1 activity, String title, Integer mcid, int seed, int pageIndex, String ext) {
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.W0, title);
        bundle.putString(MiConfigSingleton.Y0, ext);
        bundle.putInt(MiConfigSingleton.U0, mcid.intValue());
        bundle.putInt(MiConfigSingleton.V0, seed);
        bundle.putInt(MiConfigSingleton.X0, pageIndex);
        activity.startActivity(YWChannelBooksActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        B1();
        if (savedInstanceState != null) {
            this.F = savedInstanceState.getString(MiConfigSingleton.W0);
            this.G = savedInstanceState.getString(MiConfigSingleton.Y0);
            this.H = savedInstanceState.getInt(MiConfigSingleton.U0);
            this.I = savedInstanceState.getInt(MiConfigSingleton.V0);
            this.J = savedInstanceState.getInt(MiConfigSingleton.X0);
        } else {
            this.F = G0(MiConfigSingleton.W0);
            this.G = G0(MiConfigSingleton.Y0);
            this.H = v0(MiConfigSingleton.U0, -1);
            this.I = v0(MiConfigSingleton.V0, -1);
            this.J = v0(MiConfigSingleton.X0, 0);
        }
        if (!com.martian.libsupport.k.p(this.F)) {
            Z1(this.F);
        }
        if (((i0) getSupportFragmentManager().findFragmentByTag("channel_books_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, i0.w(this.F, this.H, this.I, this.J, this.G), "channel_books_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MiConfigSingleton.W0, this.F);
        outState.putString(MiConfigSingleton.Y0, this.G);
        outState.putInt(MiConfigSingleton.U0, this.H);
        outState.putInt(MiConfigSingleton.V0, this.I);
        outState.putInt(MiConfigSingleton.X0, this.J);
    }
}
