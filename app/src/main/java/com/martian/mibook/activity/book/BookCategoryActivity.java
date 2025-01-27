package com.martian.mibook.activity.book;

import android.os.Bundle;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.f4.b0;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BookCategoryActivity extends com.martian.mibook.lib.model.b.a {
    public static final String F = "book_category_ctype";
    public static final String G = "book_category_fullscreen";
    private int H;

    private List<v0.a> r2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d(s2(0)).c(b0.v(MiConfigSingleton.V3().k(), false)));
        arrayList.add(new v0.a().d(s2(1)).c(b0.v(MiConfigSingleton.V3().q4(), false)));
        return arrayList;
    }

    public static void t2(j1 activity, int cType) {
        Bundle bundle = new Bundle();
        bundle.putInt(F, cType);
        activity.startActivity(BookCategoryActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        if (savedInstanceState != null) {
            this.H = savedInstanceState.getInt(F);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.H = extras.getInt(F);
            }
        }
        d2(false);
        ViewPager viewPager = (ViewPager) findViewById(R.id.lb_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new v0(getSupportFragmentManager(), r2()));
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.layout_xttab);
        viewStub.setVisibility(0);
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(viewPager);
        viewPager.setCurrentItem(MiConfigSingleton.V3().k() != this.H ? 1 : 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(F, this.H);
        super.onSaveInstanceState(outState);
    }

    public String s2(int position) {
        return position == 0 ? MiConfigSingleton.V3().k() == 2 ? getString(R.string.female) : getString(R.string.male) : MiConfigSingleton.V3().k() == 2 ? getString(R.string.male) : getString(R.string.female);
    }
}
