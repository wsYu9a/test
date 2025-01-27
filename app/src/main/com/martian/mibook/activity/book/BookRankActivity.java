package com.martian.mibook.activity.book;

import android.os.Bundle;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import ba.l;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.SectionsPagerAdapter;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.fragment.BookRankFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BookRankActivity extends MiBackableActivity {
    public static final String C = "BOOK_RANK_INFO";
    public static final String D = "book_rank_ctype";
    public RankInfo A;
    public int B;

    public static class RankInfo implements Serializable {
        private int btype;
        private int categoryId;
        private int rType;
        private int rank;
        private String source;
        private int brtype = 100;
        private int rankStatus = 0;
        private String category = "";

        private void setBtype(int i10) {
            this.btype = i10;
        }

        private void setRType(int i10) {
            this.rType = i10;
        }

        public int getBrtype() {
            return this.brtype;
        }

        public int getBtype() {
            return this.btype * 10;
        }

        public String getCategory() {
            return this.category;
        }

        public int getCategoryId() {
            return this.categoryId;
        }

        public int getRType() {
            return this.rType;
        }

        public int getRank() {
            return this.rank;
        }

        public int getRankStatus() {
            return this.rankStatus;
        }

        public String getSource() {
            return this.source;
        }

        public RankInfo setBrtype(int i10) {
            this.brtype = i10;
            setBtype(i10 / 10);
            setRType(i10 % 10);
            return this;
        }

        public RankInfo setCategory(String str) {
            this.category = str;
            return this;
        }

        public RankInfo setCategoryId(int i10) {
            this.categoryId = i10;
            return this;
        }

        public void setRank(int i10) {
            this.rank = i10;
        }

        public void setRankStatus(int i10) {
            this.rankStatus = i10;
        }

        public RankInfo setSource(String str) {
            this.source = str;
            return this;
        }
    }

    private List<SectionsPagerAdapter.a> N2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SectionsPagerAdapter.a().d(O2(0)).c(L2()));
        arrayList.add(new SectionsPagerAdapter.a().d(O2(1)).c(M2()));
        return arrayList;
    }

    public BookRankFragment L2() {
        return BookRankFragment.t0(0, MiConfigSingleton.b2().p() != 2 ? 1 : 2, MiConfigSingleton.b2().p() == this.B ? this.A : null);
    }

    public BookRankFragment M2() {
        return BookRankFragment.t0(1, MiConfigSingleton.b2().p() == 2 ? 1 : 2, MiConfigSingleton.b2().p() == this.B ? null : this.A);
    }

    public String O2(int i10) {
        if (i10 == 0) {
            return getString(MiConfigSingleton.b2().p() == 2 ? R.string.female : R.string.male);
        }
        return getString(MiConfigSingleton.b2().p() == 2 ? R.string.male : R.string.female);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        if (bundle != null) {
            this.B = bundle.getInt("book_rank_ctype");
            str = bundle.getString(C);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.B = extras.getInt("book_rank_ctype");
                str = extras.getString(C);
            } else {
                str = "";
            }
        }
        if (!l.q(str)) {
            this.A = (RankInfo) GsonUtils.b().fromJson(str, RankInfo.class);
        }
        v2(false);
        ViewPager viewPager = (ViewPager) findViewById(R.id.lb_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), N2()));
        ViewStub B2 = B2();
        B2.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
        B2.setVisibility(0);
        E2().setNavigator(viewPager);
        viewPager.setCurrentItem(MiConfigSingleton.b2().p() != this.B ? 1 : 0);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(C, GsonUtils.b().toJson(this.A));
        super.onSaveInstanceState(bundle);
    }
}
