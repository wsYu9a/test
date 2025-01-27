package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* loaded from: classes4.dex */
public class AppDetailInfoActivity extends Activity {

    /* renamed from: a */
    private ImageView f21253a;

    /* renamed from: b */
    private TextView f21254b;

    /* renamed from: c */
    private LinearLayout f21255c;

    /* renamed from: d */
    private RecyclerView f21256d;

    /* renamed from: e */
    private long f21257e;

    /* renamed from: f */
    private long f21258f;

    /* renamed from: g */
    private List<Pair<String, String>> f21259g;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f21258f);
            AppDetailInfoActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f21258f);
            b.a().b(AppDetailInfoActivity.this.f21258f);
            com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
            com.ss.android.socialbase.appdownloader.c.a(b.a().b());
        }
    }

    public class a extends RecyclerView.Adapter<Object> {
        private a() {
        }

        public /* synthetic */ a(AppDetailInfoActivity appDetailInfoActivity, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private void b() {
        this.f21253a = (ImageView) findViewById(R.id.iv_detail_back);
        this.f21254b = (TextView) findViewById(R.id.tv_empty);
        this.f21256d = (RecyclerView) findViewById(R.id.permission_list);
        this.f21255c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f21259g.isEmpty()) {
            this.f21256d.setVisibility(8);
            this.f21254b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f21256d.setLayoutManager(linearLayoutManager);
            this.f21256d.setAdapter(new a());
        }
        this.f21253a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f21258f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f21255c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f21258f);
                b.a().b(AppDetailInfoActivity.this.f21258f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        g.a("lp_app_detail_click_close", this.f21258f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j10) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j10);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.f21257e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a10 = c.a().a(this.f21257e);
        if (a10 == null) {
            return false;
        }
        this.f21258f = a10.f21190b;
        this.f21259g = a10.f21196h;
        return true;
    }
}
