package com.vivo.mobilead.unified.exitFloat;

import android.app.Activity;
import android.content.Context;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.w;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private com.vivo.mobilead.unified.exitFloat.a f30304a;

    /* renamed from: d */
    private String f30307d;

    /* renamed from: e */
    private d f30308e;

    /* renamed from: f */
    private Context f30309f;

    /* renamed from: b */
    private volatile boolean f30305b = false;

    /* renamed from: c */
    private volatile boolean f30306c = false;

    /* renamed from: g */
    private d f30310g = new a();

    class a implements d {
        a() {
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdClick(int i2) {
            try {
                if (f.this.f30308e != null) {
                    f.this.f30308e.onAdClick(i2);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdClose() {
            try {
                if (f.this.f30308e != null) {
                    f.this.f30308e.onAdClose();
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdFailed(VivoAdError vivoAdError) {
            try {
                if (f.this.f30308e != null) {
                    f.this.f30308e.onAdFailed(vivoAdError);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdReady() {
            try {
                if (f.this.f30308e != null) {
                    f.this.f30308e.onAdReady();
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.vivo.mobilead.unified.exitFloat.d
        public void onAdShow() {
            try {
                if (f.this.f30308e != null) {
                    f.this.f30308e.onAdShow();
                }
            } catch (Exception unused) {
            }
        }
    }

    public f(Context context) {
        this.f30309f = context;
    }

    public void b() {
        if (this.f30305b) {
            w.a("", this.f30307d, "1000003", String.valueOf(1), String.valueOf(0), String.valueOf(5), BaseWrapper.ENTER_ID_OAPS_CLOUD);
            return;
        }
        this.f30305b = true;
        if (this.f30309f == null) {
            this.f30309f = com.vivo.mobilead.manager.f.j().c();
        }
        Context context = this.f30309f;
        this.f30307d = context == null ? "" : context.getPackageName();
        if (this.f30309f == null) {
            this.f30310g.onAdFailed(new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
            w.a("", this.f30307d, "1000000", String.valueOf(1), String.valueOf(0), String.valueOf(5), BaseWrapper.ENTER_ID_OAPS_CLOUD);
            return;
        }
        if (com.vivo.mobilead.manager.f.j().e()) {
            this.f30304a = new g(this.f30309f, new AdParams.Builder("").build(), this.f30310g);
        } else {
            this.f30310g.onAdFailed(new VivoAdError(402111, "请先初始化SDK再请求广告"));
            w.a("", this.f30307d, "1000004", String.valueOf(1), String.valueOf(0), String.valueOf(5), BaseWrapper.ENTER_ID_OAPS_CLOUD);
        }
        com.vivo.mobilead.unified.exitFloat.a aVar = this.f30304a;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void a(d dVar) {
        this.f30308e = dVar;
    }

    public void a(Activity activity) {
        if (this.f30306c) {
            return;
        }
        this.f30306c = true;
        com.vivo.mobilead.unified.exitFloat.a aVar = this.f30304a;
        if (aVar != null) {
            aVar.a(activity);
        }
    }

    public boolean a() {
        com.vivo.mobilead.unified.exitFloat.a aVar = this.f30304a;
        if (aVar != null) {
            return aVar.o();
        }
        return false;
    }
}
