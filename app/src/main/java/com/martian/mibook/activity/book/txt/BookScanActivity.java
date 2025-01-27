package com.martian.mibook.activity.book.txt;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.libsupport.permission.TipInfo;
import com.martian.libsupport.permission.f;
import com.martian.libsupport.permission.g;
import com.martian.mibook.activity.book.txt.BookScanActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.s3;
import com.martian.mibook.f.t3;
import com.martian.mibook.lib.model.g.b;
import com.martian.mibook.lib.model.manager.d;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BookScanActivity extends com.martian.mibook.lib.model.b.a {

    class a implements f {
        a() {
        }

        /* renamed from: a */
        public /* synthetic */ void b() {
            BookScanActivity.this.finish();
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            BookScanActivity.this.k1("缺少存储权限");
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.book.txt.a
                @Override // java.lang.Runnable
                public final void run() {
                    BookScanActivity.a.this.b();
                }
            }, 500L);
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            BookScanActivity.this.v2();
        }
    }

    private List<v0.a> u2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d(getResources().getString(R.string.book_scan)).c(s2()));
        arrayList.add(new v0.a().d(getResources().getString(R.string.book_directory)).c(t2()));
        return arrayList;
    }

    public void v2() {
        com.martian.libmars.e.a a2 = com.martian.libmars.e.a.a(g2());
        a2.f9901b.setOffscreenPageLimit(2);
        a2.f9901b.setAdapter(new v0(getSupportFragmentManager(), u2()));
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.layout_xttab);
        viewStub.setVisibility(0);
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(a2.f9901b);
    }

    private void w2() {
        g.h(this, new a(), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能正常使用导入功能\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
    }

    @Override // com.martian.libmars.activity.g1
    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_viewpager);
        Z1("");
        w2();
        b.q(this, "导入TXT-展示");
    }

    protected Fragment s2() {
        return s3.t(new String[]{d.f14056h, "ttb"}, "BOOKSTORE");
    }

    protected Fragment t2() {
        return t3.r(MiConfigSingleton.V3().y3(), new String[]{d.f14056h, "ttb"}, "BOOKSTORE");
    }
}
