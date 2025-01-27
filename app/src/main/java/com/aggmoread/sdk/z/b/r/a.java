package com.aggmoread.sdk.z.b.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.aggmoread.sdk.z.b.t.c;
import com.aggmoread.sdk.z.b.t.d;
import com.aggmoread.sdk.z.b.t.g;
import com.aggmoread.sdk.z.b.u.e;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a */
    private Activity f4791a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.r.b f4792b = new com.aggmoread.sdk.z.b.r.b();

    /* renamed from: c */
    private d f4793c;

    /* renamed from: d */
    private c.b f4794d;

    /* renamed from: com.aggmoread.sdk.z.b.r.a$a */
    public class C0089a implements g.b {
        public C0089a() {
        }

        @Override // com.aggmoread.sdk.z.b.t.g.b
        public void a(int i10, String str) {
        }

        @Override // com.aggmoread.sdk.z.b.t.g.b
        public void a(String str) {
            if (a.this.f4794d != null) {
                a.this.f4794d.onVideoCached();
            }
        }
    }

    public class b implements c.b {
        public b() {
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onRewardClose ");
            if (a.this.f4794d != null) {
                a.this.f4794d.a();
            }
            a.this.f4791a.finish();
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void b() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onVideoSkipClosed ");
            if (a.this.f4794d != null) {
                a.this.f4794d.b();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void c() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onVideoClosed ");
            if (a.this.f4794d != null) {
                a.this.f4794d.c();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void d() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onVideoExposure ");
            if (a.this.f4794d != null) {
                a.this.f4794d.d();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void onVideoCached() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onVideoCached ");
            if (a.this.f4794d != null) {
                a.this.f4794d.onVideoCached();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void onVideoComplete() {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onRewardComplete ");
            if (a.this.f4794d != null) {
                a.this.f4794d.onVideoComplete();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(float f10) {
            if (a.this.f4794d != null) {
                a.this.f4794d.a(f10);
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(Activity activity) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onRewardClick ");
            if (a.this.f4794d != null) {
                a.this.f4794d.a(activity);
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(com.aggmoread.sdk.z.b.s.a aVar) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onVideoShow ");
            if (a.this.f4794d != null) {
                a.this.f4794d.a(aVar);
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(String str) {
            if (a.this.f4794d != null) {
                a.this.f4794d.a(str);
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.c.b
        public void a(Map<String, Object> map) {
            com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "onRewardReward ");
            if (a.this.f4794d != null) {
                a.this.f4794d.a(map);
            }
        }
    }

    private void c() {
        this.f4791a.requestWindowFeature(1);
        Window window = this.f4791a.getWindow();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            window.setFlags(1024, 1024);
            window.getAttributes().layoutInDisplayCutoutMode = 0;
        } else {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
        }
        if (i10 > 23) {
            window.setStatusBarColor(0);
        }
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 13314);
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void onPause() {
        com.aggmoread.sdk.z.b.r.b bVar = this.f4792b;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void onResume() {
        com.aggmoread.sdk.z.b.r.b bVar = this.f4792b;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void a(Activity activity) {
        this.f4791a = activity;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void b() {
        com.aggmoread.sdk.z.b.r.b bVar = this.f4792b;
        if (bVar != null) {
            bVar.a();
        }
        a((Activity) null);
    }

    public void a(Context context, String str) {
        this.f4792b.a(context, str, new C0089a());
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void a(Intent intent) {
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void a(Bundle bundle) {
        Intent intent = this.f4791a.getIntent();
        if (intent != null) {
            c();
            Bundle bundleExtra = intent.getBundleExtra(h3.e.f26408m);
            if (bundleExtra != null && this.f4793c == null) {
                d dVar = new d();
                this.f4793c = dVar;
                dVar.f4944b = bundleExtra.getString("videoUrl");
                this.f4793c.f4947e = bundleExtra.getString("adIconUrl");
                this.f4793c.f4945c = bundleExtra.getString("adTitle");
                this.f4793c.f4946d = bundleExtra.getString("adDesc");
                this.f4793c.f4948f = bundleExtra.getInt("skip");
                this.f4793c.f4949g = bundleExtra.getInt("skipMinTime");
                this.f4793c.f4950h = bundleExtra.getInt("showCountDownView");
                this.f4793c.f4952j = bundleExtra.getString("endCardPicUrl");
                this.f4793c.f4953k = bundleExtra.getString("endIconUrl");
                this.f4793c.f4954l = bundleExtra.getString("endCardTitle");
                this.f4793c.f4955m = bundleExtra.getString("endCardDesc");
                this.f4793c.f4951i = bundleExtra.getString("videoBackGroundPic");
            }
            d dVar2 = this.f4793c;
            if (dVar2 == null) {
                com.aggmoread.sdk.z.b.d.c("ApiRewardVideoPresenter", "视频素材信息为空");
                c.b bVar = this.f4794d;
                if (bVar != null) {
                    bVar.a("视频素材信息为空");
                    return;
                }
                return;
            }
            this.f4792b.a(this.f4791a, dVar2);
            this.f4792b.a(true);
            this.f4792b.a(new b());
            this.f4792b.e();
            if (this.f4793c.f4957o) {
                this.f4791a.setRequestedOrientation(1);
            }
        }
    }

    public void a(c.b bVar) {
        this.f4794d = bVar;
    }

    public void a(d dVar) {
        this.f4793c = dVar;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public boolean a() {
        return true;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public boolean a(MotionEvent motionEvent) {
        return false;
    }
}
