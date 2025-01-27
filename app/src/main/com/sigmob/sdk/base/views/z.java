package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.windad.WindAdError;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class z extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: a */
    public com.sigmob.sdk.base.common.t f18951a;

    /* renamed from: b */
    public View f18952b;

    /* renamed from: c */
    public Window f18953c;

    /* renamed from: d */
    public d f18954d;

    /* renamed from: e */
    public RelativeLayout f18955e;

    /* renamed from: f */
    public com.sigmob.sdk.videoAd.a f18956f;

    /* renamed from: g */
    public BaseAdUnit f18957g;

    /* renamed from: h */
    public com.sigmob.sdk.mraid.d f18958h;

    /* renamed from: i */
    public Context f18959i;

    /* renamed from: j */
    public int f18960j;

    /* renamed from: k */
    public int f18961k;

    /* renamed from: l */
    public boolean f18962l;

    public class a implements d.l {
        public a() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void a() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void b() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void c() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void d() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void e() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void f() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void g() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void h() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void a(Integer num) {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void b(Map<String, String> map) {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void a(Map<String, String> map) {
        }
    }

    public class b implements d.g {
        public b() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a() {
            SigmobLog.i("RecommendDialog onClose()");
            if (z.this.f18954d != null) {
                z.this.f18954d.a();
            }
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void b(float f10) {
            SigmobLog.d("RecommendDialog onSkip()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void c() {
            SigmobLog.i("RecommendDialog onUnload()");
            z.this.dismiss();
            z.this.a(com.sigmob.sdk.base.common.a.f17652e);
            z.this.a();
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void d() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void e() {
            SigmobLog.i("RecommendDialog onFailedToLoad()");
            z.this.f18962l = true;
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void f() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void g() {
            SigmobLog.d("RecommendDialog onExpand()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void h() {
            SigmobLog.d("RecommendDialog onShowSkipTime()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void i() {
            SigmobLog.d("RecommendDialog onEndCardShow()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(String str) {
            SigmobLog.i("RecommendDialog onCompanionClick:" + str);
            boolean z10 = true;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("type");
                    z.this.f18958h.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                    if (optInt != 1) {
                        z.this.a(com.sigmob.sdk.base.common.a.f17670w);
                    } else {
                        z10 = false;
                    }
                } catch (Exception unused) {
                    z.this.f18958h.a("0", "0");
                    z.this.a(com.sigmob.sdk.base.common.a.f17670w);
                }
            }
            z.this.f18956f.a(com.sigmob.sdk.base.a.ENDCARD, z.this.f18958h.g(), z10);
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(View view) {
            SigmobLog.d("RecommendDialog onLoaded()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(boolean z10) {
            SigmobLog.d("RecommendDialog onMute()");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0089  */
        @Override // com.sigmob.sdk.mraid.d.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.net.URI r10, int r11, java.lang.String r12) {
            /*
                r9 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "RecommendDialog  onOpen:"
                r0.append(r1)
                r0.append(r10)
                java.lang.String r1 = "======"
                r0.append(r1)
                r0.append(r11)
                java.lang.String r11 = "====="
                r0.append(r11)
                r0.append(r12)
                java.lang.String r11 = r0.toString()
                com.czhj.sdk.logger.SigmobLog.i(r11)
                boolean r11 = android.text.TextUtils.isEmpty(r12)
                java.lang.String r0 = "click"
                r1 = 0
                r2 = 1
                if (r11 != 0) goto L73
                org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Exception -> L73
                r11.<init>(r12)     // Catch: java.lang.Exception -> L73
                java.lang.String r12 = "type"
                int r12 = r11.optInt(r12)     // Catch: java.lang.Exception -> L73
                java.lang.String r3 = "x"
                int r3 = r11.optInt(r3)     // Catch: java.lang.Exception -> L73
                java.lang.String r4 = "y"
                int r4 = r11.optInt(r4)     // Catch: java.lang.Exception -> L73
                java.lang.String r5 = "disable_landing"
                boolean r5 = r11.optBoolean(r5)     // Catch: java.lang.Exception -> L73
                java.lang.String r6 = "feDisable"
                boolean r11 = r11.optBoolean(r6)     // Catch: java.lang.Exception -> L72
                r11 = r11 ^ r2
                com.sigmob.sdk.base.views.z r6 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L70
                com.sigmob.sdk.mraid.d r6 = com.sigmob.sdk.base.views.z.b(r6)     // Catch: java.lang.Exception -> L70
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L70
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L70
                r6.a(r3, r4)     // Catch: java.lang.Exception -> L70
                if (r12 == r2) goto L6d
                com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L70
                r12.a(r0)     // Catch: java.lang.Exception -> L70
                r8 = r11
            L6b:
                r7 = 1
                goto L87
            L6d:
                r8 = r11
                r7 = 0
                goto L87
            L70:
                r1 = r5
                goto L74
            L72:
                r1 = r5
            L73:
                r11 = 1
            L74:
                com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                com.sigmob.sdk.mraid.d r12 = com.sigmob.sdk.base.views.z.b(r12)
                java.lang.String r3 = "0"
                r12.a(r3, r3)
                com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                r12.a(r0)
                r8 = r11
                r5 = r1
                goto L6b
            L87:
                if (r5 != 0) goto Lb1
                com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                com.sigmob.sdk.base.models.BaseAdUnit r11 = com.sigmob.sdk.base.views.z.h(r11)
                java.lang.String r11 = r11.getLanding_page()
                boolean r11 = android.text.TextUtils.isEmpty(r11)
                if (r11 == 0) goto L9a
                goto Lb1
            L9a:
                com.sigmob.sdk.base.views.z r10 = com.sigmob.sdk.base.views.z.this
                com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.base.views.z.c(r10)
                com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                com.sigmob.sdk.base.views.z r10 = com.sigmob.sdk.base.views.z.this
                com.sigmob.sdk.mraid.d r10 = com.sigmob.sdk.base.views.z.b(r10)
                java.lang.String r6 = r10.g()
                r5 = 0
            Lad:
                r3.a(r4, r5, r6, r7, r8)
                goto Lc8
            Lb1:
                com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.base.views.z.c(r11)
                com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                java.lang.String r5 = r10.toString()
                com.sigmob.sdk.base.views.z r10 = com.sigmob.sdk.base.views.z.this
                com.sigmob.sdk.mraid.d r10 = com.sigmob.sdk.base.views.z.b(r10)
                java.lang.String r6 = r10.g()
                goto Lad
            Lc8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.z.b.a(java.net.URI, int, java.lang.String):void");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(WindAdError windAdError) {
            SigmobLog.i("RecommendDialog onRenderProcessGone:" + windAdError.toString());
            z.this.f18962l = true;
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10) {
            int i14 = z.this.f18959i.getResources().getDisplayMetrics().widthPixels;
            int i15 = z.this.f18959i.getResources().getDisplayMetrics().heightPixels;
            SigmobLog.i("RecommendDialog Origin onResize :" + i10 + "==" + i11 + "==" + i12 + "==" + i13 + "==" + z10);
            z zVar = z.this;
            zVar.f18961k = Dips.dipsToIntPixels((float) i10, zVar.f18959i);
            z zVar2 = z.this;
            zVar2.f18960j = Dips.dipsToIntPixels((float) i11, zVar2.f18959i);
            int dipsToIntPixels = Dips.dipsToIntPixels((float) i12, z.this.f18959i);
            int dipsToIntPixels2 = Dips.dipsToIntPixels((float) i13, z.this.f18959i);
            if (z.this.f18952b != null) {
                if (!z10) {
                    if (dipsToIntPixels < 0) {
                        dipsToIntPixels = 0;
                    }
                    if (dipsToIntPixels > i14) {
                        dipsToIntPixels = i14;
                    }
                    if (dipsToIntPixels2 < 0) {
                        dipsToIntPixels2 = 0;
                    }
                    if (dipsToIntPixels2 > i15) {
                        dipsToIntPixels2 = i15;
                    }
                    if (z.this.f18961k + dipsToIntPixels > i14) {
                        z.this.f18961k = i14 - dipsToIntPixels;
                    }
                    if (z.this.f18960j + dipsToIntPixels2 > i15) {
                        z.this.f18960j = i15 - dipsToIntPixels2;
                    }
                }
                SigmobLog.i("RecommendDialog onResize: " + z.this.f18961k + "==" + z.this.f18960j + "==" + dipsToIntPixels + "==" + dipsToIntPixels2);
                if (z.this.f18961k <= 0 || z.this.f18960j <= 0) {
                    z.this.f18962l = true;
                }
                z.this.f18952b.setX(dipsToIntPixels);
                z.this.f18952b.setY(dipsToIntPixels2);
                z.this.f18952b.setLayoutParams(new RelativeLayout.LayoutParams(z.this.f18961k, z.this.f18960j));
                z.this.f18952b.requestLayout();
            }
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(float f10) {
            SigmobLog.d("RecommendDialog onReward()");
        }
    }

    public class c implements d.h {
        public c() {
        }

        @Override // com.sigmob.sdk.mraid.d.h
        public void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.t tVar) {
            z zVar = z.this;
            if (tVar != null) {
                zVar.f18951a = tVar;
                return;
            }
            zVar.f18951a = new com.sigmob.sdk.base.common.t();
            z zVar2 = z.this;
            zVar2.f18951a.a(zVar2.f18957g);
        }
    }

    public interface d {
        void a();
    }

    public z(Context context, BaseAdUnit baseAdUnit, com.sigmob.sdk.videoAd.a aVar) {
        super(context, com.sigmob.sdk.base.g.i());
        this.f18953c = null;
        this.f18960j = 0;
        this.f18961k = 0;
        this.f18962l = false;
        this.f18959i = context.getApplicationContext();
        this.f18957g = baseAdUnit;
        this.f18956f = aVar;
        this.f18952b = b();
    }

    public void a(String str) {
        com.sigmob.sdk.base.common.t tVar = this.f18951a;
        if (tVar != null) {
            tVar.a(str, 0);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f18955e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f18955e.setBackgroundColor(0);
        setContentView(this.f18955e);
        setOnShowListener(this);
        SigmobLog.i("RecommendDialog onCreate:" + this.f18961k + ":" + this.f18960j);
        View view = this.f18952b;
        if (view != null) {
            this.f18955e.addView(view);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        d();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("RecommendDialog  onShow");
        a(com.sigmob.sdk.base.common.a.f17651d);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(6918);
    }

    public boolean c() {
        if (this.f18961k <= 0 || this.f18960j <= 0) {
            this.f18962l = true;
        }
        return this.f18962l;
    }

    public final void d() {
        Window window = getWindow();
        this.f18953c = window;
        if (window != null) {
            window.setGravity(80);
            int k10 = com.sigmob.sdk.base.g.k();
            if (k10 != 0) {
                this.f18953c.setWindowAnimations(k10);
            }
            this.f18953c.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = this.f18953c.getAttributes();
            int i10 = this.f18959i.getResources().getDisplayMetrics().widthPixels;
            int i11 = this.f18959i.getResources().getDisplayMetrics().heightPixels;
            int i12 = this.f18961k;
            if (i12 - 1 <= i10) {
                attributes.width = -1;
            } else {
                attributes.width = i12;
            }
            int i13 = this.f18960j;
            if (i13 - 1 <= i11) {
                attributes.height = -1;
            } else {
                attributes.height = i13;
            }
            SigmobLog.i("RecommendDialog windowDeploy: " + i10 + "====" + i11 + "====" + attributes.width + "====" + attributes.height);
            this.f18953c.setAttributes(attributes);
        }
    }

    public View b() {
        if (this.f18958h == null) {
            this.f18958h = new com.sigmob.sdk.mraid.d(this.f18959i, this.f18957g, PlacementType.INTERSTITIAL);
        }
        this.f18958h.a(new a());
        this.f18958h.a(new b());
        if (!TextUtils.isEmpty(this.f18957g.getCloseCardHtmlData())) {
            this.f18958h.a(this.f18957g.getCloseCardHtmlData(), new c());
        }
        return this.f18958h.d();
    }

    public void a() {
        com.sigmob.sdk.mraid.d dVar = this.f18958h;
        if (dVar != null) {
            this.f18954d = null;
            dVar.b();
            this.f18958h = null;
        }
    }

    public void a(d dVar) {
        this.f18954d = dVar;
    }
}
