package com.martian.mibook.activity.reader;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.SectionsPagerAdapter;
import com.martian.mibook.R;
import com.martian.mibook.activity.reader.TypefaceScanActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ScanningBookTipsTopBinding;
import com.martian.mibook.fragment.BookScanFragment;
import com.martian.mibook.fragment.BookSelectFragment;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import e9.c;
import java.util.ArrayList;
import java.util.List;
import ya.j2;

/* loaded from: classes3.dex */
public class TypefaceScanActivity extends MiBackableActivity {
    public c A;
    public ScanningBookTipsTopBinding B;
    public final Fragment[] C = {S2(), T2()};

    public class a implements ea.b {
        public a() {
        }

        public /* synthetic */ void b() {
            TypefaceScanActivity.this.finish();
        }

        @Override // ea.b
        public void permissionDenied() {
            new Handler().postDelayed(new Runnable() { // from class: wa.d
                public /* synthetic */ d() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TypefaceScanActivity.a.this.b();
                }
            }, 500L);
        }

        @Override // ea.b
        public void permissionGranted() {
            c cVar = TypefaceScanActivity.this.A;
            if (cVar != null) {
                cVar.d(j2.T, Boolean.TRUE);
            }
        }
    }

    public class b implements ea.b {

        /* renamed from: a */
        public final /* synthetic */ int f13192a;

        public b(int i10) {
            this.f13192a = i10;
        }

        @Override // ea.b
        public void permissionDenied() {
            TypefaceScanActivity.this.R2();
            c cVar = TypefaceScanActivity.this.A;
            if (cVar != null) {
                if (this.f13192a == j2.Y) {
                    cVar.d(j2.U, Boolean.FALSE);
                } else {
                    cVar.d(j2.T, Boolean.FALSE);
                }
            }
        }

        @Override // ea.b
        public void permissionGranted() {
            TypefaceScanActivity.this.W2();
            c cVar = TypefaceScanActivity.this.A;
            if (cVar != null) {
                if (this.f13192a == j2.Y) {
                    cVar.d(j2.U, Boolean.TRUE);
                } else {
                    cVar.d(j2.T, Boolean.TRUE);
                }
            }
        }
    }

    private void Q2() {
        c cVar = new c();
        this.A = cVar;
        cVar.c(j2.V, new wj.b() { // from class: wa.c
            public /* synthetic */ c() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                TypefaceScanActivity.this.Y2((Integer) obj);
            }
        });
    }

    public void R2() {
        if (this.B == null) {
            this.B = ScanningBookTipsTopBinding.bind(View.inflate(this, R.layout.scanning_book_tips_top, null));
            Window window = getWindow();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 81);
            layoutParams.bottomMargin = ConfigSingleton.i(60.0f);
            window.addContentView(this.B.getRoot(), layoutParams);
            this.B.scanningTipsClose.setOnClickListener(new View.OnClickListener() { // from class: wa.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TypefaceScanActivity.this.Z2(view);
                }
            });
            this.B.tvGoAuthorize.setOnClickListener(new View.OnClickListener() { // from class: wa.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TypefaceScanActivity.this.a3(view);
                }
            });
        }
    }

    private List<SectionsPagerAdapter.a> U2() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.C.length; i10++) {
            arrayList.add(new SectionsPagerAdapter.a().d(V2(i10)).c(this.C[i10]));
        }
        return arrayList;
    }

    public void W2() {
        ScanningBookTipsTopBinding scanningBookTipsTopBinding = this.B;
        if (scanningBookTipsTopBinding != null) {
            scanningBookTipsTopBinding.scanningTipsClose.performClick();
        }
    }

    private void X2() {
        ViewPager viewPager = (ViewPager) findViewById(com.martian.libmars.R.id.vp_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), U2()));
        ViewStub B2 = B2();
        B2.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
        B2.setVisibility(0);
        E2().setNavigator(viewPager);
    }

    public /* synthetic */ void Y2(Integer num) {
        if (num.intValue() == j2.X) {
            b3(num.intValue());
        } else if (num.intValue() == j2.W) {
            c3();
        } else if (num.intValue() == j2.Y) {
            b3(num.intValue());
        }
    }

    public /* synthetic */ void Z2(View view) {
        this.B.getRoot().setVisibility(8);
    }

    public /* synthetic */ void a3(View view) {
        b3(j2.X);
    }

    private void b3(int i10) {
        ea.c.i(this, MiConfigSingleton.b2().I0(), new b(i10));
    }

    private void c3() {
        ea.c.m(this, "导入", new a());
    }

    public Fragment S2() {
        return BookScanFragment.O(new String[]{"ttf"}, "TYPEFACE");
    }

    public Fragment T2() {
        return BookSelectFragment.H(MiConfigSingleton.b2().U1(), new String[]{"ttf"}, "TYPEFACE");
    }

    public String V2(int i10) {
        if (i10 == 0) {
            return getResources().getString(R.string.ttf_scan);
        }
        if (i10 == 1) {
            return getResources().getString(R.string.book_directory);
        }
        throw new IllegalStateException("Unspecified fragment title.");
    }

    @Override // com.martian.libmars.activity.BackableActivity
    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.martian.libmars.R.layout.activity_load_viewpager);
        u2(true);
        Q2();
        X2();
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.A;
        if (cVar != null) {
            cVar.b();
        }
    }
}
