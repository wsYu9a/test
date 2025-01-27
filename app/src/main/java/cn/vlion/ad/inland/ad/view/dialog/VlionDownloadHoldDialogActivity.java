package cn.vlion.ad.inland.ad.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class VlionDownloadHoldDialogActivity extends Activity {

    /* renamed from: d */
    public static c f2443d;

    /* renamed from: e */
    public static WeakReference<VlionDownloadHoldDialogActivity> f2444e;

    /* renamed from: a */
    public TextView f2445a;

    /* renamed from: b */
    public TextView f2446b;

    /* renamed from: c */
    public VlionDownloadProgressBar f2447c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                c cVar = VlionDownloadHoldDialogActivity.f2443d;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            VlionDownloadHoldDialogActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                c cVar = VlionDownloadHoldDialogActivity.f2443d;
                if (cVar != null) {
                    cVar.b();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            VlionDownloadHoldDialogActivity.this.finish();
        }
    }

    public interface c {
        void a();

        void b();
    }

    public final void a(int i10) {
        try {
            if (this.f2445a == null) {
                return;
            }
            if (i10 <= 0) {
                i10 = 1;
            }
            this.f2445a.setText(getString(R.string.vlion_custom_ad_download_progress) + i10 + "%" + getString(R.string.vlion_custom_ad_download_progress_continue));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(17);
            setContentView(R.layout.vlion_cn_ad_activity_vlion_download_hold);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() * 0.7d);
            attributes.height = -2;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            f2444e = new WeakReference<>(this);
            VlionAppInfo.getInstance().hideNavigationBar(this);
            this.f2445a = (TextView) findViewById(R.id.vlion_ad_app_des);
            VlionDownloadProgressBar vlionDownloadProgressBar = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action);
            this.f2447c = vlionDownloadProgressBar;
            vlionDownloadProgressBar.setTextDetail(getString(R.string.vlion_custom_ad_text_continue));
            TextView textView = (TextView) findViewById(R.id.tv_suspend);
            this.f2446b = textView;
            textView.setText(getString(R.string.vlion_custom_ad_text_suspend));
            a(getIntent().getIntExtra("mpercent", 0));
            this.f2446b.setOnClickListener(new a());
            this.f2447c.setOnClickListener(new b());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            WeakReference<VlionDownloadHoldDialogActivity> weakReference = f2444e;
            if (weakReference != null) {
                weakReference.clear();
                f2444e = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(Context context, int i10, c cVar) {
        try {
            Intent intent = new Intent(context, (Class<?>) VlionDownloadHoldDialogActivity.class);
            intent.putExtra("mpercent", i10);
            f2443d = cVar;
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
