package com.martian.mibook.activity.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ba.l;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.fragment.yuewen.YWCategoriesBookListFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.mibook.lib.yuewen.response.YWCategory;

/* loaded from: classes3.dex */
public class YWCategoriesActivity extends MiBackableActivity {
    public String A = "";
    public Integer B = 1;
    public String C;

    public static void L2(Activity activity, YWCategory yWCategory, int i10, int i11, int i12) {
        String json = GsonUtils.b().toJson(yWCategory);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_ctype", i10);
        bundle.putString(MiConfigSingleton.X0, json);
        bundle.putString(MiConfigSingleton.Y0, yWCategory.getCategoryName());
        bundle.putInt(YWCategoriesBookListFragment.G, i11);
        bundle.putInt(YWCategoriesBookListFragment.H, i12);
        Intent intent = new Intent(activity, (Class<?>) YWCategoriesActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ywcategories);
        if (bundle != null) {
            this.A = bundle.getString(MiConfigSingleton.Y0);
            this.B = Integer.valueOf(bundle.getInt("intent_ctype", 1));
            this.C = bundle.getString(MiConfigSingleton.X0);
        } else {
            this.A = q1(MiConfigSingleton.Y0);
            this.B = Integer.valueOf(g1("intent_ctype", 1));
            this.C = q1(MiConfigSingleton.X0);
        }
        if (!l.q(this.A)) {
            t2(this.A);
        }
        if (((YWCategoriesBookListFragment) getSupportFragmentManager().findFragmentByTag("category_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new YWCategoriesBookListFragment(), "category_list_fragment").commit();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(MiConfigSingleton.Y0, this.A);
        bundle.putInt("intent_ctype", this.B.intValue());
        bundle.putString(MiConfigSingleton.X0, this.C);
        super.onSaveInstanceState(bundle);
    }
}
