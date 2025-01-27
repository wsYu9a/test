package com.kwad.components.core.r.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: classes3.dex */
public class a extends com.kwad.components.core.l.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> Vo = new ConcurrentHashMap();
    private static final AtomicInteger Vp = new AtomicInteger(1);
    private StyleTemplate Vh;
    private String Vi;
    private boolean Vj;
    private m Vk;
    private k Vl;
    private com.kwad.components.core.r.b.b Vm;
    private int Vn;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    /* renamed from: com.kwad.components.core.r.a.a$1 */
    public class AnonymousClass1 implements a.InterfaceC0416a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.b.a.InterfaceC0416a
        public final void v(View view) {
            a.this.finish();
        }

        @Override // com.kwad.components.core.b.a.InterfaceC0416a
        public final void w(View view) {
        }
    }

    public static void a(int i10, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = Vo;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i10));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i10), map);
        }
        map.put(str, obj);
    }

    private Object aA(String str) {
        return o(this.Vn, str);
    }

    private static void aL(int i10) {
        Map<String, Object> map = Vo.get(Integer.valueOf(i10));
        if (map != null) {
            map.clear();
        }
    }

    private static Object o(int i10, String str) {
        Map<String, Object> map = Vo.get(Integer.valueOf(i10));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.kwad.components.core.l.b
    /* renamed from: rS */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.a(this.mAdResultData);
        bVar.Vh = this.Vh;
        bVar.mRootContainer = this.mRootContainer;
        bVar.Vk = this.Vk;
        bVar.Vl = this.Vl;
        return bVar;
    }

    public static int rT() {
        return Vp.incrementAndGet();
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, a.class);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        this.Vn = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) aA("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.Vh = styleTemplate;
            } catch (Throwable th2) {
                c.printStackTrace(th2);
                return false;
            }
        }
        if (kVar != null) {
            this.Vl = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData d10 = f.nt().d(intExtra, true);
        this.mAdResultData = d10;
        return intExtra <= 0 || d10 != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.Vj = getIntent().getBooleanExtra("show_navigationBar", true);
        this.Vi = getIntent().getStringExtra("title");
        this.Vk = (m) aA("native_intent");
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.Vj && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0416a() { // from class: com.kwad.components.core.r.a.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0416a
            public final void v(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0416a
            public final void w(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.Vi));
        this.mTitleBarHelper.ai(false);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.r.b.b bVar = this.Vm;
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        if (this.Vh != null) {
            return new com.kwad.components.core.r.b.a();
        }
        if (this.Vm == null) {
            this.Vm = new com.kwad.components.core.r.b.b();
        }
        return this.Vm;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            aL(this.Vn);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
