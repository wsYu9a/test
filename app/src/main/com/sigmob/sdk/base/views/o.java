package com.sigmob.sdk.base.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;

/* loaded from: classes4.dex */
public class o extends g {

    /* renamed from: j */
    public static float f18823j = 10.0f;

    /* renamed from: k */
    public static final float f18824k = 1.0f;

    /* renamed from: h */
    public final com.sigmob.sdk.base.views.b f18825h;

    /* renamed from: i */
    public a f18826i;

    public interface a {
        void a(MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public class b implements View.OnTouchListener {

        /* renamed from: a */
        public boolean f18827a;

        /* renamed from: b */
        public MotionEvent f18828b;

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f18827a = true;
                this.f18828b = MotionEvent.obtain(motionEvent);
            } else {
                if (action != 1 || !this.f18827a) {
                    return false;
                }
                this.f18827a = false;
                if (o.this.f18826i != null) {
                    o.this.f18826i.a(this.f18828b, motionEvent);
                }
            }
            return false;
        }
    }

    public o(Context context, String str, boolean z10, boolean z11) {
        super(context);
        j();
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        a(true);
        setBackgroundColor(0);
        if (z10) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(getContext().getApplicationContext(), 1);
            this.f18825h = bVar;
            bVar.a(str);
            bVar.b(com.sigmob.sdk.base.g.e());
            addView(bVar, layoutParams);
        } else {
            this.f18825h = null;
        }
        setOnTouchListener(new b());
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        SigmobLog.d("CreativeWebView destroy() callSigmobLog.d( \"CreativeWebView destroy() called\");ed");
        super.destroy();
        removeAllViews();
    }

    public final void j() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    public void setLogoClickListener(View.OnClickListener onClickListener) {
        com.sigmob.sdk.base.views.b bVar = this.f18825h;
        if (bVar != null) {
            bVar.setOnClickListener(onClickListener);
        }
    }

    public void setWebViewClickListener(a aVar) {
        this.f18826i = aVar;
    }

    public static o a(Context context, String str, boolean z10, boolean z11) {
        Preconditions.NoThrow.checkNotNull(context);
        return new o(context, str, z10, z11);
    }

    public void a(String str) {
        File a10 = com.sigmob.sdk.base.utils.d.a(str, Md5Util.md5(str) + ".html");
        if (a10 == null || TextUtils.isEmpty(a10.getAbsolutePath())) {
            loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "utf-8", null);
            return;
        }
        loadUrl("file://" + a10.getAbsolutePath());
    }
}
