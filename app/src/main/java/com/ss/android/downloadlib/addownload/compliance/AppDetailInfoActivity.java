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

    /* renamed from: g */
    private RecyclerView f24104g;
    private long gv;

    /* renamed from: i */
    private LinearLayout f24105i;

    /* renamed from: j */
    private ImageView f24106j;
    private List<Pair<String, String>> lg;
    private long q;
    private TextView zx;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.j("lp_app_detail_click_close", AppDetailInfoActivity.this.gv);
            AppDetailInfoActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.j("lp_app_detail_click_download", AppDetailInfoActivity.this.gv);
            zx.j().zx(AppDetailInfoActivity.this.gv);
            com.ss.android.socialbase.appdownloader.i.j((Activity) AppDetailInfoActivity.this);
            com.ss.android.socialbase.appdownloader.i.j(zx.j().zx());
        }
    }

    private class j extends RecyclerView.Adapter<Object> {
        private j() {
        }

        /* synthetic */ j(AppDetailInfoActivity appDetailInfoActivity, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private void zx() {
        this.f24106j = (ImageView) findViewById(R.id.iv_detail_back);
        this.zx = (TextView) findViewById(R.id.tv_empty);
        this.f24104g = (RecyclerView) findViewById(R.id.permission_list);
        this.f24105i = (LinearLayout) findViewById(R.id.ll_download);
        if (this.lg.isEmpty()) {
            this.f24104g.setVisibility(8);
            this.zx.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f24104g.setLayoutManager(linearLayoutManager);
            this.f24104g.setAdapter(new j());
        }
        this.f24106j.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.j("lp_app_detail_click_close", AppDetailInfoActivity.this.gv);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f24105i.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.j("lp_app_detail_click_download", AppDetailInfoActivity.this.gv);
                zx.j().zx(AppDetailInfoActivity.this.gv);
                com.ss.android.socialbase.appdownloader.i.j((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.i.j(zx.j().zx());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        q.j("lp_app_detail_click_close", this.gv);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (j()) {
            zx();
        } else {
            com.ss.android.socialbase.appdownloader.i.j((Activity) this);
        }
    }

    public static void j(Activity activity, long j2) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean j() {
        this.q = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.zx.zx j2 = i.j().j(this.q);
        if (j2 == null) {
            return false;
        }
        this.gv = j2.zx;
        this.lg = j2.y;
        return true;
    }
}
