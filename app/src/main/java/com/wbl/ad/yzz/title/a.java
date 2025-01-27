package com.wbl.ad.yzz.title;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.innerconfig.d.j;
import com.wbl.ad.yzz.network.b.b.j0;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.view.RoundProgressBar;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public final Context f33839a;

    /* renamed from: b */
    public final ImageView f33840b;

    /* renamed from: c */
    public final LinearLayout f33841c;

    /* renamed from: d */
    public final TextView f33842d;

    /* renamed from: e */
    public final TextView f33843e;

    /* renamed from: f */
    public final TextView f33844f;

    /* renamed from: g */
    public final TextView f33845g;

    /* renamed from: h */
    public final LinearLayout f33846h;

    /* renamed from: i */
    public final TextView f33847i;

    /* renamed from: j */
    public final TextView f33848j;
    public final TextView k;
    public final ImageView l;
    public final TextView m;
    public final ImageView n;
    public final RelativeLayout o;
    public final ImageView p;
    public final View q;
    public final View r;
    public final View s;
    public final RoundProgressBar t;
    public final TextView u;
    public boolean v = false;
    public int w = -1;
    public boolean x = true;
    public final j y;

    public a(Context context, View view, j jVar) {
        this.f33839a = context;
        this.f33840b = (ImageView) view.findViewById(R.id.iv_title_bg);
        this.r = view.findViewById(R.id.ll_title_content_container);
        this.o = (RelativeLayout) view.findViewById(R.id.rela_leave_ad);
        this.n = (ImageView) view.findViewById(R.id.iv_leave_ad);
        this.m = (TextView) view.findViewById(R.id.tv_leave);
        this.p = (ImageView) view.findViewById(R.id.iv_title_red_circle);
        this.k = (TextView) view.findViewById(R.id.tv_title_title);
        this.l = (ImageView) view.findViewById(R.id.iv_title_icon);
        this.f33841c = (LinearLayout) view.findViewById(R.id.lin_title_type_2);
        this.f33842d = (TextView) view.findViewById(R.id.tv_type2_hour_rp_msg);
        this.f33843e = (TextView) view.findViewById(R.id.tv_type2_hour_rp_number);
        this.f33844f = (TextView) view.findViewById(R.id.tv_type2_my_rp_msg);
        this.f33845g = (TextView) view.findViewById(R.id.tv_type2_my_rp_number);
        this.f33846h = (LinearLayout) view.findViewById(R.id.lin_type_1);
        this.f33847i = (TextView) view.findViewById(R.id.tv_type1_msg);
        this.f33848j = (TextView) view.findViewById(R.id.tv_type1_number);
        this.q = view.findViewById(R.id.view_line);
        this.s = view.findViewById(R.id.ll_limit_turn_around_hongbao_container);
        this.t = (RoundProgressBar) view.findViewById(R.id.progess_limit_hongbao);
        this.u = (TextView) view.findViewById(R.id.tv_limit_hongbao_num);
        this.y = jVar;
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9734, this, null);
    }

    public void a(float f2, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9733, this, Float.valueOf(f2), Integer.valueOf(i2));
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9736, this, Integer.valueOf(i2));
    }

    public void a(int i2, int i3, int i4) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9735, this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void a(int i2, u.g gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9730, this, Integer.valueOf(i2), gVar);
    }

    public void a(View.OnClickListener onClickListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9729, this, onClickListener);
    }

    public final void a(TextView textView, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9732, this, textView, Integer.valueOf(i2));
    }

    public final void a(TextView textView, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9731, this, textView, str);
    }

    public void a(AdPageNeedData adPageNeedData, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9758, this, adPageNeedData, Boolean.valueOf(z));
    }

    public final void a(j0 j0Var, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9757, this, j0Var, Integer.valueOf(i2));
    }

    public void a(u uVar, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9760, this, uVar, Boolean.valueOf(z));
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9759, this, str);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9754, this, str, imageView);
    }

    public final void a(String str, ImageView imageView, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9753, this, str, imageView, Integer.valueOf(i2));
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9756, this, null);
    }

    public void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9755, this, Integer.valueOf(i2));
    }

    public final void b(TextView textView, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9750, this, textView, str);
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9749, this, str);
    }

    public int c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9752, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9751, this, null);
    }
}
