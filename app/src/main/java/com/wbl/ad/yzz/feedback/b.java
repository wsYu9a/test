package com.wbl.ad.yzz.feedback;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.network.b.b.n;
import com.wbl.ad.yzz.network.b.b.o;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public Context f32170a;

    /* renamed from: b */
    public final View f32171b;

    /* renamed from: c */
    public final TextView f32172c;

    /* renamed from: d */
    public final TextView f32173d;

    /* renamed from: e */
    public final TextView f32174e;

    /* renamed from: f */
    public final TextView f32175f;

    /* renamed from: g */
    public final TextView f32176g;

    /* renamed from: h */
    public final TextView f32177h;

    /* renamed from: i */
    public final TextView f32178i;

    /* renamed from: j */
    public final ImageView f32179j;
    public final View k;
    public final EditText l;
    public final com.wbl.ad.yzz.feedback.c.b m;
    public a n;
    public final o o;
    public final int p;
    public boolean q;
    public int r;
    public com.wbl.ad.yzz.innerconfig.d.d s;

    public interface a {
        void a();

        void a(int i2);

        void a(@f.b.a.e UploadFeedbackReq uploadFeedbackReq);
    }

    /* renamed from: com.wbl.ad.yzz.feedback.b$b */
    public static final class ViewOnClickListenerC0722b implements View.OnClickListener {
        public ViewOnClickListenerC0722b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14038, this, view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32182b;

        public c(Context context) {
            this.f32182b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14037, this, view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32184b;

        public d(Context context) {
            this.f32184b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14040, this, view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32186b;

        public e(Context context) {
            this.f32186b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14039, this, view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32188b;

        public static final class a implements d.b0<n> {
            public a() {
            }

            public void a(String str, n nVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14034, this, str, nVar);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14033, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, n nVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14036, this, str, nVar);
            }
        }

        public f(Context context) {
            this.f32188b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14035, this, view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Context f32191b;

        public g(Context context) {
            this.f32191b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14126, this, view);
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14125, this, view);
        }
    }

    public b(@f.b.a.e Context context, @f.b.a.e View view, @f.b.a.e o oVar, int i2, boolean z, int i3, @f.b.a.e com.wbl.ad.yzz.innerconfig.d.d dVar) {
        this.f32170a = context;
        this.o = oVar;
        this.p = i2;
        this.q = !z;
        this.r = i3;
        this.s = dVar;
        this.f32171b = view != null ? view.findViewById(R.id.cl_feedback_container) : null;
        this.f32172c = view != null ? (TextView) view.findViewById(R.id.tv_feedback_submit) : null;
        this.f32173d = view != null ? (TextView) view.findViewById(R.id.tv_feedback_other_suggestions) : null;
        this.f32174e = view != null ? (TextView) view.findViewById(R.id.tv_feedback_wechat_number) : null;
        this.f32175f = view != null ? (TextView) view.findViewById(R.id.tv_feedback_problem) : null;
        this.f32176g = view != null ? (TextView) view.findViewById(R.id.tv_feedback_function) : null;
        this.f32177h = view != null ? (TextView) view.findViewById(R.id.tv_feedback_customer_service_telephone) : null;
        this.f32178i = view != null ? (TextView) view.findViewById(R.id.tv_feedback_customer_service_wechat) : null;
        this.f32179j = view != null ? (ImageView) view.findViewById(R.id.iv_close) : null;
        this.k = view != null ? view.findViewById(R.id.view_line) : null;
        this.l = view != null ? (EditText) view.findViewById(R.id.edit_feedback) : null;
        this.m = new com.wbl.ad.yzz.feedback.c.a();
        d();
        e();
        c();
        a();
    }

    public static final /* synthetic */ o a(b bVar) {
        return (o) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14128, null, bVar);
    }

    public static final /* synthetic */ String a(b bVar, EditText editText) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14127, null, bVar, editText);
    }

    public static final /* synthetic */ EditText b(b bVar) {
        return (EditText) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14119, null, bVar);
    }

    public static final /* synthetic */ a d(b bVar) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14115, null, bVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d e(b bVar) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14142, null, bVar);
    }

    public static final /* synthetic */ TextView g(b bVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14144, null, bVar);
    }

    public static final /* synthetic */ TextView h(b bVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14143, null, bVar);
    }

    public final String a(EditText editText) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14138, this, editText);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14137, this, null);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14140, this, Integer.valueOf(i2));
    }

    public final void a(Context context, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14139, this, context, str);
    }

    public final void a(View view, View view2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14134, this, view, view2);
    }

    public final void a(View view, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14133, this, view, Boolean.valueOf(z));
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14136, this, aVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14135, this, str);
    }

    public final boolean a(View view) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14130, this, view);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14129, this, null);
    }

    public final void b(View view, View view2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14132, this, view, view2);
    }

    public final void b(View view, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14131, this, view, Boolean.valueOf(z));
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14094, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14093, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14096, this, null);
    }
}
