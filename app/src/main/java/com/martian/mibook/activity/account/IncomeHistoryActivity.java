package com.martian.mibook.activity.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.utils.SectionsPagerAdapter;
import com.martian.mibook.R;
import com.martian.mibook.lib.account.fragment.MartianHistoryDurationListFragment;
import com.martian.mibook.lib.account.fragment.MartianHistoryMoneyListFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class IncomeHistoryActivity extends MiBackableActivity {
    public static final String B = "INCOME_POSITION";
    public int A = 0;

    public static void M2(Context context, int i10) {
        Intent intent = new Intent(context, (Class<?>) IncomeHistoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(B, i10);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final List<SectionsPagerAdapter.a> L2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SectionsPagerAdapter.a().d("金币明细").c(new MartianHistoryDurationListFragment()));
        arrayList.add(new SectionsPagerAdapter.a().d("零钱明细").c(new MartianHistoryMoneyListFragment()));
        return arrayList;
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        if (bundle != null) {
            this.A = bundle.getInt(B);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.A = extras.getInt(B);
            }
        }
        v2(false);
        ViewPager viewPager = (ViewPager) findViewById(R.id.lb_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), L2()));
        ViewStub B2 = B2();
        B2.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
        B2.setVisibility(0);
        E2().setNavigator(viewPager);
        viewPager.setCurrentItem(this.A);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(B, this.A);
    }
}
