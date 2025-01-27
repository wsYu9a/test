package com.martian.mibook.activity.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libsupport.R;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.mibook.mvvm.yuewen.fragment.YWBookMallFragment;
import ya.e0;

/* loaded from: classes3.dex */
public class FinishedOrNewBooksActivity extends MiBackableActivity {
    public int A;
    public String B;

    public static void startActivity(Activity activity, int i10, int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(e0.f33185x0, i10);
        bundle.putInt("intent_ctype", i11);
        bundle.putString(e0.f33187y0, str);
        Intent intent = new Intent(activity, (Class<?>) FinishedOrNewBooksActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_load_fragment);
        g2();
        if (bundle != null) {
            this.A = bundle.getInt(e0.f33185x0);
            this.B = bundle.getString(e0.f33187y0);
        } else {
            this.A = g1(e0.f33185x0, -1);
            this.B = q1(e0.f33187y0);
        }
        if (!l.q(this.B)) {
            t2(ConfigSingleton.D().s(this.B));
        }
        if (((YWBookMallFragment) getSupportFragmentManager().findFragmentByTag("finished_or_new_books_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(com.martian.mibook.R.id.fragmentContainer, YWBookMallFragment.INSTANCE.a(this.A, false), "finished_or_new_books_fragment").commit();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(e0.f33185x0, this.A);
        bundle.putString(e0.f33187y0, this.B);
    }
}
