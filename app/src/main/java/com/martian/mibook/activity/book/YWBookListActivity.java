package com.martian.mibook.activity.book;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import com.martian.libmars.utils.SectionsPagerAdapter;
import com.martian.mibook.R;
import com.martian.mibook.databinding.MartianActivityYwBookRankListBinding;
import com.martian.mibook.fragment.yuewen.YWBookListFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class YWBookListActivity extends MiBackableActivity {
    public static final String D = "BOOK_LIST_BOOK_TYPE";
    public static final String E = "book_rank_ctype";
    public static final String F = "book_rank_position";
    public int A;
    public int B;
    public int C;

    private List<SectionsPagerAdapter.a> M2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SectionsPagerAdapter.a().d(getString(R.string.yw_finished_books_recommend)).c(L2(0)));
        arrayList.add(new SectionsPagerAdapter.a().d(getString(R.string.yw_finished_books_recently)).c(L2(1)));
        return arrayList;
    }

    public final YWBookListFragment L2(int i10) {
        return YWBookListFragment.S(this.A, this.B, Integer.valueOf(i10));
    }

    @Override // com.martian.libmars.activity.BackableActivity
    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        MartianActivityYwBookRankListBinding bind = MartianActivityYwBookRankListBinding.bind(D2());
        if (bundle != null) {
            this.A = bundle.getInt("book_rank_ctype");
            this.B = bundle.getInt(D);
            this.C = bundle.getInt(F);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.A = extras.getInt("book_rank_ctype");
                this.B = extras.getInt(D);
                this.C = extras.getInt(F);
            }
        }
        v2(false);
        bind.lbContent.setOffscreenPageLimit(2);
        bind.lbContent.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), M2()));
        ViewStub B2 = B2();
        B2.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
        B2.setVisibility(0);
        E2().setNavigator(bind.lbContent);
        bind.lbContent.setCurrentItem(this.C);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("book_rank_ctype", this.A);
        bundle.putInt(D, this.B);
        bundle.putInt(F, this.C);
        super.onSaveInstanceState(bundle);
    }
}
