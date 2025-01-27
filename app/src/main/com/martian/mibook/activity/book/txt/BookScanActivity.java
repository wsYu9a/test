package com.martian.mibook.activity.book.txt;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.ActivityLoadViewpagerBinding;
import com.martian.libmars.utils.SectionsPagerAdapter;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.txt.BookScanActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ScanningBookTipsTopBinding;
import com.martian.mibook.fragment.BookScanFragment;
import com.martian.mibook.fragment.BookSelectFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import e9.c;
import java.util.ArrayList;
import java.util.List;
import vb.e;
import ya.j2;

/* loaded from: classes3.dex */
public class BookScanActivity extends MiBackableActivity {
    public ViewStub A;
    public ActivityLoadViewpagerBinding B;
    public c C;
    public ScanningBookTipsTopBinding D;

    public class a implements ea.b {
        public a() {
        }

        public final /* synthetic */ void b() {
            BookScanActivity.this.finish();
        }

        @Override // ea.b
        public void permissionDenied() {
            new Handler().postDelayed(new Runnable() { // from class: va.d
                public /* synthetic */ d() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BookScanActivity.a.this.b();
                }
            }, 500L);
        }

        @Override // ea.b
        public void permissionGranted() {
            c cVar = BookScanActivity.this.C;
            if (cVar != null) {
                cVar.d(j2.T, Boolean.TRUE);
            }
        }
    }

    public class b implements ea.b {

        /* renamed from: a */
        public final /* synthetic */ int f13189a;

        public b(int i10) {
            this.f13189a = i10;
        }

        @Override // ea.b
        public void permissionDenied() {
            BookScanActivity.this.R2();
            c cVar = BookScanActivity.this.C;
            if (cVar != null) {
                if (this.f13189a == j2.Y) {
                    cVar.d(j2.U, Boolean.FALSE);
                } else {
                    cVar.d(j2.T, Boolean.FALSE);
                }
            }
        }

        @Override // ea.b
        public void permissionGranted() {
            BookScanActivity.this.V2();
            c cVar = BookScanActivity.this.C;
            if (cVar != null) {
                if (this.f13189a == j2.Y) {
                    cVar.d(j2.U, Boolean.TRUE);
                } else {
                    cVar.d(j2.T, Boolean.TRUE);
                }
            }
        }
    }

    private List<SectionsPagerAdapter.a> U2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SectionsPagerAdapter.a().d(getResources().getString(R.string.book_scan)).c(S2()));
        arrayList.add(new SectionsPagerAdapter.a().d(getResources().getString(R.string.book_directory)).c(T2()));
        return arrayList;
    }

    public final void Q2() {
        c cVar = new c();
        this.C = cVar;
        cVar.c(j2.V, new wj.b() { // from class: va.c
            public /* synthetic */ c() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                BookScanActivity.this.X2((Integer) obj);
            }
        });
    }

    public final void R2() {
        if (this.D == null) {
            this.D = ScanningBookTipsTopBinding.bind(View.inflate(this, R.layout.scanning_book_tips_top, null));
            Window window = getWindow();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 81);
            layoutParams.bottomMargin = ConfigSingleton.i(60.0f);
            window.addContentView(this.D.getRoot(), layoutParams);
            this.D.scanningTipsClose.setOnClickListener(new View.OnClickListener() { // from class: va.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookScanActivity.this.Y2(view);
                }
            });
            this.D.tvGoAuthorize.setOnClickListener(new View.OnClickListener() { // from class: va.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookScanActivity.this.Z2(view);
                }
            });
        }
    }

    public Fragment S2() {
        return BookScanFragment.O(new String[]{e.f31296c, "ttb"}, "BOOKSTORE");
    }

    public Fragment T2() {
        return BookSelectFragment.H(MiConfigSingleton.b2().U1(), new String[]{e.f31296c, "ttb"}, "BOOKSTORE");
    }

    public final void V2() {
        ScanningBookTipsTopBinding scanningBookTipsTopBinding = this.D;
        if (scanningBookTipsTopBinding != null) {
            scanningBookTipsTopBinding.scanningTipsClose.performClick();
        }
    }

    public final void W2() {
        ActivityLoadViewpagerBinding a10 = ActivityLoadViewpagerBinding.a(D2());
        this.B = a10;
        a10.f12124b.setOffscreenPageLimit(2);
        this.B.f12124b.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), U2()));
        if (this.A == null) {
            ViewStub viewStub = (ViewStub) findViewById(com.martian.libmars.R.id.actionbar_container);
            this.A = viewStub;
            viewStub.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
            this.A.setVisibility(0);
        }
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(this.B.f12124b);
    }

    public final /* synthetic */ void X2(Integer num) {
        if (num.intValue() == j2.X) {
            a3(num.intValue());
        } else if (num.intValue() == j2.W) {
            b3();
        } else if (num.intValue() == j2.Y) {
            a3(num.intValue());
        }
    }

    public final /* synthetic */ void Y2(View view) {
        this.D.getRoot().setVisibility(8);
    }

    public final /* synthetic */ void Z2(View view) {
        a3(j2.X);
    }

    public final void a3(int i10) {
        ea.c.i(this, MiConfigSingleton.b2().I0(), new b(i10));
    }

    public final void b3() {
        ea.c.m(this, "导入", new a());
    }

    @Override // com.martian.libmars.activity.BackableActivity
    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.martian.libmars.R.layout.activity_load_viewpager);
        t2("");
        Q2();
        W2();
        ac.a.o(this, "导入TXT-展示");
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.C;
        if (cVar != null) {
            cVar.b();
        }
    }
}
