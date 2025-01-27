package com.martian.mibook.activity.book;

import android.os.Bundle;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.r3;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BookRankActivity extends com.martian.mibook.lib.model.b.a {
    public static final String F = "BOOK_RANK_INFO";
    public static final String G = "book_rank_ctype";
    private a H;
    private int I;

    public static class a {

        /* renamed from: a */
        private int f10986a;

        /* renamed from: b */
        private int f10987b;

        /* renamed from: d */
        private int f10989d;

        /* renamed from: e */
        private int f10990e;

        /* renamed from: h */
        private int f10993h;

        /* renamed from: i */
        private String f10994i;

        /* renamed from: c */
        private int f10988c = 100;

        /* renamed from: f */
        private int f10991f = 0;

        /* renamed from: g */
        private String f10992g = "";

        private void k(int btype) {
            this.f10986a = btype;
        }

        private void o(int rType) {
            this.f10987b = rType;
        }

        public int a() {
            return this.f10988c;
        }

        public int b() {
            return this.f10986a * 10;
        }

        public String c() {
            return this.f10992g;
        }

        public int d() {
            return this.f10989d;
        }

        public int e() {
            return this.f10990e;
        }

        public int f() {
            return this.f10987b;
        }

        public int g() {
            return this.f10993h;
        }

        public int h() {
            return this.f10991f;
        }

        public String i() {
            return this.f10994i;
        }

        public a j(int brtype) {
            this.f10988c = brtype;
            k(brtype / 10);
            o(brtype % 10);
            return this;
        }

        public a l(String category) {
            this.f10992g = category;
            return this;
        }

        public a m(int categoryId) {
            this.f10989d = categoryId;
            return this;
        }

        public a n(int categoryType) {
            this.f10990e = categoryType;
            return this;
        }

        public void p(int rank) {
            this.f10993h = rank;
        }

        public a q(int rankStatus) {
            this.f10991f = rankStatus;
            return this;
        }

        public a r(String source) {
            this.f10994i = source;
            return this;
        }
    }

    private List<v0.a> t2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d(u2(0)).c(r2()));
        arrayList.add(new v0.a().d(u2(1)).c(s2()));
        return arrayList;
    }

    public static void v2(j1 activity, int cType) {
        Bundle bundle = new Bundle();
        bundle.putInt("book_rank_ctype", cType);
        activity.startActivity(BookRankActivity.class, bundle);
    }

    public static void w2(j1 activity, int cType, a rankInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt("book_rank_ctype", cType);
        bundle.putString(F, GsonUtils.b().toJson(rankInfo));
        activity.startActivity(BookRankActivity.class, bundle);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        if (savedInstanceState != null) {
            this.I = savedInstanceState.getInt("book_rank_ctype");
            str = savedInstanceState.getString(F);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.I = extras.getInt("book_rank_ctype");
                str = extras.getString(F);
            } else {
                str = "";
            }
        }
        if (!com.martian.libsupport.k.p(str)) {
            this.H = (a) GsonUtils.b().fromJson(str, a.class);
        }
        d2(false);
        ViewPager viewPager = (ViewPager) findViewById(R.id.lb_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new v0(getSupportFragmentManager(), t2()));
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.layout_xttab);
        viewStub.setVisibility(0);
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(viewPager);
        viewPager.setCurrentItem(MiConfigSingleton.V3().k() != this.I ? 1 : 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(F, GsonUtils.b().toJson(this.H));
        super.onSaveInstanceState(outState);
    }

    protected r3 r2() {
        return r3.Y(0, MiConfigSingleton.V3().k() != 2 ? 1 : 2, MiConfigSingleton.V3().k() == this.I ? this.H : null);
    }

    protected r3 s2() {
        return r3.Y(1, MiConfigSingleton.V3().k() == 2 ? 1 : 2, MiConfigSingleton.V3().k() == this.I ? null : this.H);
    }

    public String u2(int position) {
        return position == 0 ? MiConfigSingleton.V3().k() == 2 ? getString(R.string.female) : getString(R.string.male) : MiConfigSingleton.V3().k() == 2 ? getString(R.string.male) : getString(R.string.female);
    }
}
