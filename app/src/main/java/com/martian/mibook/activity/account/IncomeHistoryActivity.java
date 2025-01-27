package com.martian.mibook.activity.account;

import android.os.Bundle;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class IncomeHistoryActivity extends com.martian.mibook.lib.model.b.a {
    public static final String F = "INCOME_POSITION";
    int G = 0;

    private List<v0.a> r2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d("金币明细").c(new com.martian.mibook.lib.account.c.a()));
        arrayList.add(new v0.a().d("零钱明细").c(new com.martian.mibook.lib.account.c.b()));
        return arrayList;
    }

    public static void s2(j1 activity, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("INCOME_POSITION", position);
        activity.startActivity(IncomeHistoryActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        if (savedInstanceState != null) {
            this.G = savedInstanceState.getInt("INCOME_POSITION");
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.G = extras.getInt("INCOME_POSITION");
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
        viewPager.setCurrentItem(this.G);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("INCOME_POSITION", this.G);
    }
}
