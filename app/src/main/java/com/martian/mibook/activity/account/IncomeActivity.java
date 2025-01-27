package com.martian.mibook.activity.account;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.v0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.application.v0;
import com.martian.mibook.f.v3;
import com.martian.mibook.f.y3;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class IncomeActivity extends com.martian.mibook.lib.model.b.a {
    public static final String F = "INCOME_POSITION";
    public static final String G = "ENTER_PATH";
    public static final int H = 888;
    private String I = "";
    int J = 0;
    private com.martian.libmars.b.d K;

    class a implements c.d {
        a() {
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.d
        public void b(MiTaskAccount miTaskAccount) {
            IncomeActivity.this.K.d(v0.r, 888);
        }
    }

    /* renamed from: R1 */
    public /* synthetic */ void v2() {
        com.martian.mibook.lib.model.g.b.M(this, "插屏广告");
        MiConfigSingleton.V3().N4.s(this, b.d.a.j.b.q, null);
    }

    private List<v0.a> s2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v0.a().d("零钱").c(y3.J(this.I)));
        arrayList.add(new v0.a().d("佣金").c(v3.D(this.I)));
        return arrayList;
    }

    /* renamed from: t2 */
    public /* synthetic */ void u2() {
        this.K.d(com.martian.mibook.application.v0.r, 2);
    }

    public static void w2(j1 activity, int position, String path) {
        Bundle bundle = new Bundle();
        bundle.putInt("INCOME_POSITION", position);
        bundle.putString(G, path);
        activity.startActivity(IncomeActivity.class, bundle);
    }

    private void x2() {
        com.martian.mibook.lib.account.e.c.l(this, new a());
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == 20001 || requestCode == 20003 || requestCode == 20005) && resultCode == -1) {
            this.K.d(com.martian.mibook.application.v0.r, 888);
        } else if (requestCode == 2 && resultCode == -1) {
            MiConfigSingleton.V3().L4.H0(this, new o0.r() { // from class: com.martian.mibook.activity.account.h
                @Override // com.martian.mibook.application.o0.r
                public final void a() {
                    IncomeActivity.this.u2();
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.martian_activity_yw_book_rank_list);
        if (savedInstanceState != null) {
            this.J = savedInstanceState.getInt("INCOME_POSITION");
            this.I = savedInstanceState.getString(G);
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.J = extras.getInt("INCOME_POSITION");
                this.I = extras.getString(G);
            }
        }
        this.K = new com.martian.libmars.b.d();
        d2(false);
        ViewPager viewPager = (ViewPager) findViewById(R.id.lb_content);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new com.martian.libmars.utils.v0(getSupportFragmentManager(), s2()));
        ViewStub viewStub = (ViewStub) findViewById(R.id.actionbar_container);
        viewStub.setLayoutResource(R.layout.layout_xttab);
        viewStub.setVisibility(0);
        ((MagicIndicator) findViewById(R.id.magic_indicator)).setNavigator(viewPager);
        viewPager.setCurrentItem(this.J);
        if (this.I.contains("新手红包")) {
            s2.e0(this, this.I, MartianRPUserManager.f14923j);
        } else {
            if (MiConfigSingleton.V3().j5()) {
                return;
            }
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.account.i
                @Override // java.lang.Runnable
                public final void run() {
                    IncomeActivity.this.v2();
                }
            }, 1000L);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.K.b();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(G, this.I);
        outState.putInt("INCOME_POSITION", this.J);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        x2();
    }
}
