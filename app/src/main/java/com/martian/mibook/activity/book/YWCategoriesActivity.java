package com.martian.mibook.activity.book;

import android.os.Bundle;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.f4.g0;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class YWCategoriesActivity extends com.martian.mibook.lib.model.b.a {
    private String F = "";
    private Integer G = 1;
    private String H;

    public static void r2(j1 activity, YWCategory ywCategory, int freeType, int subCategoryId, int exposeType) {
        String json = GsonUtils.b().toJson(ywCategory);
        Bundle bundle = new Bundle();
        bundle.putInt(MiConfigSingleton.Q0, freeType);
        bundle.putString(MiConfigSingleton.R0, json);
        bundle.putString(MiConfigSingleton.T0, ywCategory.getCategoryName());
        bundle.putInt(g0.f13118j, subCategoryId);
        bundle.putInt(g0.k, exposeType);
        activity.startActivity(YWCategoriesActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ywcategories);
        if (savedInstanceState != null) {
            this.F = savedInstanceState.getString(MiConfigSingleton.T0);
            this.G = Integer.valueOf(savedInstanceState.getInt(MiConfigSingleton.Q0));
            this.H = savedInstanceState.getString(MiConfigSingleton.R0);
        } else {
            this.F = G0(MiConfigSingleton.T0);
            this.G = Integer.valueOf(v0(MiConfigSingleton.Q0, -1));
            this.H = G0(MiConfigSingleton.R0);
        }
        if (!com.martian.libsupport.k.p(this.F)) {
            Z1(this.F);
        }
        if (((g0) getSupportFragmentManager().findFragmentByTag("category_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new g0(), "category_list_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(MiConfigSingleton.T0, this.F);
        outState.putInt(MiConfigSingleton.Q0, this.G.intValue());
        outState.putString(MiConfigSingleton.R0, this.H);
        super.onSaveInstanceState(outState);
    }
}
