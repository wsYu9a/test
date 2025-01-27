package com.sigmob.sdk.nativead;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.g0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.c;
import com.sigmob.sdk.nativead.n;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends Dialog implements s, DialogInterface.OnShowListener, DialogInterface.OnDismissListener, View.OnClickListener {

    /* renamed from: a */
    public Context f19888a;

    /* renamed from: b */
    public Window f19889b;

    /* renamed from: c */
    public int f19890c;

    /* renamed from: d */
    public int f19891d;

    /* renamed from: e */
    public BaseAdUnit f19892e;

    /* renamed from: f */
    public WindNativeAdData.DislikeInteractionCallback f19893f;

    /* renamed from: g */
    public List<String> f19894g;

    /* renamed from: h */
    public TextView f19895h;

    /* renamed from: i */
    public TextView f19896i;

    /* renamed from: j */
    public TextView f19897j;

    /* renamed from: k */
    public TextView f19898k;

    /* renamed from: l */
    public EditText f19899l;

    /* renamed from: m */
    public n f19900m;

    /* renamed from: n */
    public ViewGroup f19901n;

    /* renamed from: o */
    public boolean f19902o;

    /* renamed from: com.sigmob.sdk.nativead.a$a */
    public class RunnableC0612a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ BidResponse f19903a;

        /* renamed from: b */
        public final /* synthetic */ Context f19904b;

        /* renamed from: c */
        public final /* synthetic */ String f19905c;

        /* renamed from: com.sigmob.sdk.nativead.a$a$a */
        public class C0613a implements c.a {

            /* renamed from: com.sigmob.sdk.nativead.a$a$a$a */
            public class RunnableC0614a implements Runnable {
                public RunnableC0614a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Context context;
                    String str;
                    RunnableC0612a runnableC0612a = RunnableC0612a.this;
                    if (a.this.a(runnableC0612a.f19904b, runnableC0612a.f19905c)) {
                        context = RunnableC0612a.this.f19904b;
                        str = "反馈上报成功，广告请求ID已复制到剪贴板";
                    } else {
                        context = RunnableC0612a.this.f19904b;
                        str = "反馈上报成功,广告请求ID:" + RunnableC0612a.this.f19905c;
                    }
                    g0.makeText(context, str, 1).show();
                }
            }

            /* renamed from: com.sigmob.sdk.nativead.a$a$a$b */
            public class b implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ VolleyError f19909a;

                public b(VolleyError volleyError) {
                    this.f19909a = volleyError;
                }

                @Override // java.lang.Runnable
                public void run() {
                    NetworkResponse networkResponse;
                    VolleyError volleyError = this.f19909a;
                    int i10 = (volleyError == null || (networkResponse = volleyError.networkResponse) == null) ? 0 : networkResponse.statusCode;
                    g0.makeText(RunnableC0612a.this.f19904b, "反馈上报失败，错误码: " + i10, 1).show();
                }
            }

            public C0613a() {
            }

            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                WindAds.sharedAds().getHandler().post(new b(volleyError));
            }

            @Override // com.sigmob.sdk.base.network.c.a
            public void onSuccess(JSONObject jSONObject) {
                WindAds.sharedAds().getHandler().post(new RunnableC0614a());
            }
        }

        public RunnableC0612a(BidResponse bidResponse, Context context, String str) {
            this.f19903a = bidResponse;
            this.f19904b = context;
            this.f19905c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.base.network.c cVar = new com.sigmob.sdk.base.network.c(com.sigmob.sdk.base.l.w().t(), this.f19903a, new C0613a());
            SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
            if (sigRequestQueue != null) {
                sigRequestQueue.add(cVar);
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable.toString()) || a.this.f19898k == null) {
                return;
            }
            a.this.f19898k.setTextColor(Color.parseColor("#C2C2C2"));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (a.this.f19898k != null) {
                a.this.f19898k.setTextColor(Color.parseColor("#FE7E03"));
            }
        }
    }

    public class c implements n.e {
        public c() {
        }

        @Override // com.sigmob.sdk.nativead.n.e
        public void a(int i10, String str) {
            a.this.d();
            a.this.a(PointCategory.DISLIKE, "report", String.valueOf(i10), "");
            if (a.this.f19893f != null) {
                a.this.f19893f.onSelected(4, str, true);
                a.this.dismiss();
            }
        }
    }

    public class d implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f19913a;

        /* renamed from: b */
        public final /* synthetic */ String f19914b;

        public d(String str, String str2) {
            this.f19913a = str;
            this.f19914b = str2;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setAdtype(String.valueOf(a.this.f19892e.getAd_type()));
                pointEntitySigmob.setLoad_id(a.this.f19892e.getLoad_id());
                pointEntitySigmob.setRequest_id(a.this.f19892e.getRequestId());
                pointEntitySigmob.setReason(this.f19913a);
                pointEntitySigmob.setContent(this.f19914b);
                pointEntitySigmob.setVid(a.this.f19892e.getVid());
            }
        }
    }

    public a(Context context, BaseAdUnit baseAdUnit) {
        super(context, com.sigmob.sdk.base.g.i());
        this.f19889b = null;
        this.f19894g = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.f19888a = applicationContext;
        this.f19892e = baseAdUnit;
        int i10 = applicationContext.getResources().getDisplayMetrics().widthPixels;
        int i11 = this.f19888a.getResources().getDisplayMetrics().heightPixels;
        int dipsToIntPixels = Dips.dipsToIntPixels(40.0f, this.f19888a);
        if (i11 > i10) {
            this.f19891d = i10 - dipsToIntPixels;
            this.f19890c = -2;
        } else {
            int i12 = i11 - dipsToIntPixels;
            this.f19891d = i12;
            this.f19890c = i12;
        }
        c();
    }

    public final void e() {
        Window window = getWindow();
        this.f19889b = window;
        if (window != null) {
            window.setGravity(17);
            int k10 = com.sigmob.sdk.base.g.k();
            if (k10 != 0) {
                this.f19889b.setWindowAnimations(k10);
            }
            this.f19889b.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = this.f19889b.getAttributes();
            attributes.width = this.f19891d;
            attributes.height = this.f19890c;
            this.f19889b.setAttributes(attributes);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i10;
        EditText editText;
        String obj;
        String str = "";
        if (view.equals(this.f19896i)) {
            String str2 = (String) this.f19896i.getText();
            a(PointCategory.DISLIKE, PointCategory.ADNORMAL_SHOW, "", "");
            str = str2;
            i10 = 1;
        } else {
            if (view.equals(this.f19897j)) {
                obj = (String) this.f19897j.getText();
                a(PointCategory.DISLIKE, PointCategory.CANNOT_CLOSE, "", "");
                i10 = 2;
            } else if (view.equals(this.f19895h)) {
                obj = (String) this.f19895h.getText();
                a(PointCategory.DISLIKE, PointCategory.NOINTEREST_CLICK, "", "");
                i10 = 3;
            } else {
                i10 = 0;
                if (view.equals(this.f19898k) && (editText = this.f19899l) != null) {
                    obj = editText.getText().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        a(PointCategory.DISLIKE, PointCategory.ADVICE, "", Base64.encodeToString(obj.getBytes(), 0));
                        i10 = 5;
                    }
                }
            }
            str = obj;
        }
        d();
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.f19893f;
        if (dislikeInteractionCallback == null || i10 == 0) {
            return;
        }
        dislikeInteractionCallback.onSelected(i10, str, true);
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtil.getLayoutId(this.f19888a, "sig_dislike_layout"));
        this.f19896i = (TextView) findViewById(ResourceUtil.getId(this.f19888a, "sig_not_show_tv"));
        this.f19897j = (TextView) findViewById(ResourceUtil.getId(this.f19888a, "sig_not_close_tv"));
        this.f19895h = (TextView) findViewById(ResourceUtil.getId(this.f19888a, "sig_dislike_tv"));
        this.f19898k = (TextView) findViewById(ResourceUtil.getId(this.f19888a, "sig_commit_sl"));
        this.f19899l = (EditText) findViewById(ResourceUtil.getId(this.f19888a, "sig_suggest_et"));
        this.f19895h.setOnClickListener(this);
        this.f19896i.setOnClickListener(this);
        this.f19897j.setOnClickListener(this);
        this.f19898k.setOnClickListener(this);
        this.f19899l.addTextChangedListener(new b());
        this.f19901n = (ViewGroup) findViewById(ResourceUtil.getId(this.f19888a, "sig_flow_sl"));
        n nVar = new n(this.f19888a);
        this.f19900m = nVar;
        nVar.setList(this.f19894g);
        this.f19900m.setOnItemClickListener(new c());
        this.f19901n.addView(this.f19900m, new ViewGroup.LayoutParams(-1, -2));
        setOnShowListener(this);
        setOnDismissListener(this);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        e();
        SigmobLog.i("DisLikeDialog onCreate:" + this.f19891d + ":" + this.f19890c);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("DisLikeDialog  onDismiss");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.f19893f;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onCancel();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("DisLikeDialog  onShow");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.f19893f;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onShow();
        }
        n nVar = this.f19900m;
        if (nVar != null) {
            nVar.a();
        }
    }

    public void b() {
        TextView textView = this.f19895h;
        if (textView != null) {
            textView.setOnClickListener(null);
            this.f19895h = null;
        }
        TextView textView2 = this.f19896i;
        if (textView2 != null) {
            textView2.setOnClickListener(null);
            this.f19896i = null;
        }
        TextView textView3 = this.f19897j;
        if (textView3 != null) {
            textView3.setOnClickListener(null);
            this.f19897j = null;
        }
        TextView textView4 = this.f19898k;
        if (textView4 != null) {
            textView4.setOnClickListener(null);
            this.f19898k = null;
        }
        if (this.f19893f != null) {
            this.f19893f = null;
        }
        setOnShowListener(null);
        setOnDismissListener(null);
        this.f19889b = null;
    }

    public final void c() {
        this.f19894g.clear();
        this.f19894g.add("违法违规");
        this.f19894g.add("疑似抄袭");
        this.f19894g.add("虚假欺诈");
        this.f19894g.add("低俗色情");
        this.f19894g.add("诱导点击");
    }

    public final void d() {
        Context d10 = com.sigmob.sdk.a.d();
        BaseAdUnit baseAdUnit = this.f19892e;
        if (baseAdUnit != null) {
            baseAdUnit.dislikeReport();
            if (com.sigmob.sdk.base.l.w().a0()) {
                String requestId = this.f19892e.getRequestId();
                BidResponse d11 = com.sigmob.sdk.base.common.h.d(requestId);
                if (d11 != null) {
                    ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new RunnableC0612a(d11, d10, requestId));
                    return;
                }
                return;
            }
        }
        g0.makeText(d10, "感谢反馈", 1).show();
    }

    public final void a(String str, String str2, String str3, String str4) {
        com.sigmob.sdk.base.common.b0.a(str, str2, this.f19892e, new d(str3, str4));
    }

    @Override // com.sigmob.sdk.nativead.s
    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f19893f = dislikeInteractionCallback;
    }

    @Override // com.sigmob.sdk.nativead.s
    public void a() {
        BaseAdUnit baseAdUnit = this.f19892e;
        if (baseAdUnit == null || (baseAdUnit.isDislikeReported() && this.f19892e.getAd_type() != 5)) {
            g0.makeText(getContext(), "已提交反馈", 1).show();
        } else {
            show();
            a(PointCategory.DISLIKE, "click", "", "");
        }
    }

    public final boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
