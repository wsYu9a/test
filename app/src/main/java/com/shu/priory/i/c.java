package com.shu.priory.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.shu.priory.c.a;
import com.shu.priory.config.AdError;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.e;
import com.shu.priory.i.c;
import com.shu.priory.listener.IFLYVideoListener;
import com.shu.priory.utils.h;
import com.shu.priory.videolib.JZPlayer;
import com.shu.priory.videolib.JZVPStandard;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private final Context f17124a;

    /* renamed from: b */
    private final int f17125b;

    /* renamed from: c */
    private volatile d f17126c;

    /* renamed from: d */
    private JZVPStandard f17127d;

    /* renamed from: e */
    private final IFLYVideoListener f17128e;

    /* renamed from: f */
    private volatile String f17129f;

    /* renamed from: com.shu.priory.i.c$1 */
    public class AnonymousClass1 implements e.a {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.download.e.a
        public void a() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Looper.prepare();
                h.a(SDKConstants.TAG, "not main thread");
            }
            c.this.f17128e.onAdFailed(new AdError(ErrorCode.ERROR_VIDEO_CACHE));
        }

        @Override // com.shu.priory.download.e.a
        public void a(String str) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Looper.prepare();
                h.a(SDKConstants.TAG, "not main thread");
            }
            c.this.f17129f = str;
            h.a(SDKConstants.TAG, "video cache path " + c.this.f17129f);
            c.this.f17128e.onVideoCached();
        }
    }

    public c(Context context, int i10, IFLYVideoListener iFLYVideoListener) {
        this.f17124a = context;
        this.f17125b = i10;
        this.f17127d = new JZVPStandard(context);
        this.f17128e = iFLYVideoListener;
    }

    public void c() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.f17332l.performClick();
    }

    public void d() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.f();
        this.f17127d.setVideoOutListener(null);
        this.f17127d = null;
    }

    public void e() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.g();
    }

    public void f() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.e();
    }

    public void g() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.d();
    }

    public boolean h() {
        JZVPStandard jZVPStandard = this.f17127d;
        return jZVPStandard != null && jZVPStandard.f17326f == 3;
    }

    public boolean i() {
        if (this.f17127d == null) {
            return false;
        }
        return JZPlayer.a();
    }

    public void j() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.h();
    }

    public void k() {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.i();
    }

    public JZVPStandard a() {
        return this.f17127d;
    }

    public void b() {
        try {
            if (this.f17126c.f17138h != null) {
                String optString = this.f17126c.f17138h.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                new com.shu.priory.c.a(this.f17124a.getApplicationContext(), optString).a(new a.InterfaceC0551a() { // from class: yf.a
                    public /* synthetic */ a() {
                    }

                    @Override // com.shu.priory.c.a.InterfaceC0551a
                    public final void imageLoad(Bitmap bitmap) {
                        c.this.a(bitmap);
                    }
                });
            }
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "loadCoverImg:" + th2.getMessage());
        }
    }

    public void c(boolean z10) {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.setDirectJump(z10);
    }

    public void b(boolean z10) {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.setShowWifiTip(z10);
    }

    public /* synthetic */ void a(Bitmap bitmap) {
        JZVPStandard jZVPStandard;
        if (bitmap == null || (jZVPStandard = this.f17127d) == null) {
            return;
        }
        jZVPStandard.U.setImageBitmap(bitmap);
    }

    public void a(d dVar) {
        this.f17126c = dVar;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.shu.priory.download.e.a(this.f17124a.getApplicationContext(), jSONObject, new e.a() { // from class: com.shu.priory.i.c.1
            public AnonymousClass1() {
            }

            @Override // com.shu.priory.download.e.a
            public void a() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    Looper.prepare();
                    h.a(SDKConstants.TAG, "not main thread");
                }
                c.this.f17128e.onAdFailed(new AdError(ErrorCode.ERROR_VIDEO_CACHE));
            }

            @Override // com.shu.priory.download.e.a
            public void a(String str) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    Looper.prepare();
                    h.a(SDKConstants.TAG, "not main thread");
                }
                c.this.f17129f = str;
                h.a(SDKConstants.TAG, "video cache path " + c.this.f17129f);
                c.this.f17128e.onVideoCached();
            }
        });
    }

    public void a(boolean z10) {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        jZVPStandard.setVolume(z10);
    }

    public void a(Object... objArr) {
        JZVPStandard jZVPStandard = this.f17127d;
        if (jZVPStandard == null) {
            return;
        }
        try {
            jZVPStandard.setVideoInfo(this.f17126c);
            this.f17127d.setVideoOutListener(this.f17128e);
            this.f17127d.setVideoType(this.f17125b);
            int i10 = this.f17125b;
            if (i10 == 0) {
                b();
                this.f17127d.a(this.f17129f, "", 0, new Object[0]);
            } else if (i10 == 1) {
                b();
                com.shu.priory.videolib.e.a(this.f17124a, ((Integer) objArr[0]).intValue());
                this.f17127d.a(this.f17129f, "", 1, new Object[0]);
                this.f17127d.f17332l.performClick();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            h.d(SDKConstants.TAG, "video show ad " + th2.getMessage());
        }
    }
}
