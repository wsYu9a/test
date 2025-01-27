package com.martian.mibook.activity.book;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.mibook.e.a4;
import com.martian.mibook.f.f4.d0;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class YWBookListActivity extends com.martian.mibook.lib.model.b.a {
    public static final String F = "BOOK_LIST_BOOK_TYPE";
    public static final String G = "book_rank_ctype";
    public static final String H = "book_rank_position";
    private int I;
    private int J;
    private int K;

    private d0 r2(int type) {
        return d0.y(this.I, this.J, Integer.valueOf(type));
    }

    private List<v0.a> s2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d(getString(R.string.yw_finished_books_recommend)).c(r2(0)));
        arrayList.add(new v0.a().d(getString(R.string.yw_finished_books_recently)).c(r2(1)));
        return arrayList;
    }

    public static void t2(j1 activity, int cType, int bookType) {
        u2(activity, cType, bookType, 0);
    }

    public static void u2(j1 activity, int cType, int bookType, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("book_rank_ctype", cType);
        bundle.putInt(F, bookType);
        bundle.putInt(H, position);
        activity.startActivity(YWBookListActivity.class, bundle);
    }

    @Override // com.martian.libmars.activity.g1
    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        a4 a2 = a4.a(g2());
        if (savedInstanceState != null) {
            this.I = savedInstanceState.getInt("book_rank_ctype");
            this.J = savedInstanceState.getInt(F);
            this.K = savedInstanceState.getInt(H);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.I = extras.getInt("book_rank_ctype");
                this.J = extras.getInt(F);
                this.K = extras.getInt(H);
            }
        }
        d2(false);
        a2.f11691b.setOffscreenPageLimit(2);
        a2.f11691b.setAdapter(new v0(getSupportFragmentManager(), s2()));
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.layout_xttab);
        viewStub.setVisibility(0);
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(a2.f11691b);
        a2.f11691b.setCurrentItem(this.K);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("book_rank_ctype", this.I);
        outState.putInt(F, this.J);
        outState.putInt(H, this.K);
        super.onSaveInstanceState(outState);
    }
}
