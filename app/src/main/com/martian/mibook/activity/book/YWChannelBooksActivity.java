package com.martian.mibook.activity.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.libsupport.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.mibook.mvvm.yuewen.fragment.YWChannelBookListFragment;

/* loaded from: classes3.dex */
public class YWChannelBooksActivity extends MiBackableActivity {
    public String A;
    public String B;
    public int C;
    public int D;
    public int E;

    public static void L2(Activity activity, String str, Integer num, int i10, int i11, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.f13316b1, str);
        bundle.putString(MiConfigSingleton.f13318d1, str2);
        bundle.putInt(MiConfigSingleton.Z0, num.intValue());
        bundle.putInt(MiConfigSingleton.f13315a1, i10);
        bundle.putInt(MiConfigSingleton.f13317c1, i11);
        Intent intent = new Intent(activity, (Class<?>) YWChannelBooksActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_load_fragment);
        g2();
        if (bundle != null) {
            this.A = bundle.getString(MiConfigSingleton.f13316b1);
            this.B = bundle.getString(MiConfigSingleton.f13318d1);
            this.C = bundle.getInt(MiConfigSingleton.Z0);
            this.D = bundle.getInt(MiConfigSingleton.f13315a1);
            this.E = bundle.getInt(MiConfigSingleton.f13317c1);
        } else {
            this.A = q1(MiConfigSingleton.f13316b1);
            this.B = q1(MiConfigSingleton.f13318d1);
            this.C = g1(MiConfigSingleton.Z0, -1);
            this.D = g1(MiConfigSingleton.f13315a1, -1);
            this.E = g1(MiConfigSingleton.f13317c1, 0);
        }
        if (!l.q(this.A)) {
            t2(this.A);
        }
        if (((YWChannelBookListFragment) getSupportFragmentManager().findFragmentByTag("channel_books_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(com.martian.mibook.R.id.fragmentContainer, YWChannelBookListFragment.INSTANCE.a(this.A, this.C, this.D, this.E, this.B), "channel_books_fragment").commit();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(MiConfigSingleton.f13316b1, this.A);
        bundle.putString(MiConfigSingleton.f13318d1, this.B);
        bundle.putInt(MiConfigSingleton.Z0, this.C);
        bundle.putInt(MiConfigSingleton.f13315a1, this.D);
        bundle.putInt(MiConfigSingleton.f13317c1, this.E);
    }
}
