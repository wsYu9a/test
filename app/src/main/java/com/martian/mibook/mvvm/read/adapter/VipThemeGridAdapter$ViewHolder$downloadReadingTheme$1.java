package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.martian.mibook.R;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ItemReadingVipThemeBinding;
import com.martian.mibook.mvvm.read.adapter.VipThemeGridAdapter;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import l9.t0;
import x8.c;
import xi.l;
import z8.e;

/* loaded from: classes3.dex */
public final class VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1 implements e.b {

    /* renamed from: a */
    public final /* synthetic */ MiReadingTheme f14592a;

    /* renamed from: b */
    public final /* synthetic */ VipThemeGridAdapter.ViewHolder f14593b;

    /* renamed from: c */
    public final /* synthetic */ VipThemeGridAdapter f14594c;

    public VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1(MiReadingTheme miReadingTheme, VipThemeGridAdapter.ViewHolder viewHolder, VipThemeGridAdapter vipThemeGridAdapter) {
        this.f14592a = miReadingTheme;
        this.f14593b = viewHolder;
        this.f14594c = vipThemeGridAdapter;
    }

    @Override // z8.e.b
    @SuppressLint({"SetTextI18n"})
    public void a(int i10, int i11) {
        ItemReadingVipThemeBinding itemReadingVipThemeBinding;
        Context context;
        int i12 = (i10 * 100) / i11;
        this.f14592a.setDownLoadStatus(1);
        itemReadingVipThemeBinding = this.f14593b.binding;
        TextView textView = itemReadingVipThemeBinding.tvThemeStatus;
        context = this.f14593b.com.umeng.analytics.pro.f.X java.lang.String;
        textView.setText((context != null ? context.getString(R.string.download_desc) : null) + i12 + "%");
    }

    @Override // z8.e.b
    public void b(int i10) {
        ItemReadingVipThemeBinding itemReadingVipThemeBinding;
        Context context;
        Context context2;
        this.f14592a.setDownLoadStatus(2);
        itemReadingVipThemeBinding = this.f14593b.binding;
        TextView textView = itemReadingVipThemeBinding.tvThemeStatus;
        context = this.f14593b.com.umeng.analytics.pro.f.X java.lang.String;
        textView.setText(context != null ? context.getString(R.string.unzip_desc) : null);
        context2 = this.f14593b.com.umeng.analytics.pro.f.X java.lang.String;
        FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
        if (fragmentActivity != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragmentActivity), null, null, new VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1(this.f14592a, this.f14593b, this.f14594c, this, null), 3, null);
        }
    }

    @Override // z8.e.b
    public void c(@l c cVar) {
        ItemReadingVipThemeBinding itemReadingVipThemeBinding;
        Context context;
        Context context2;
        Context context3;
        this.f14592a.setDownLoadStatus(0);
        itemReadingVipThemeBinding = this.f14593b.binding;
        TextView textView = itemReadingVipThemeBinding.tvThemeStatus;
        context = this.f14593b.com.umeng.analytics.pro.f.X java.lang.String;
        textView.setText(context != null ? context.getString(R.string.re_download) : null);
        context2 = this.f14593b.com.umeng.analytics.pro.f.X java.lang.String;
        context3 = this.f14593b.com.umeng.analytics.pro.f.X java.lang.String;
        t0.b(context2, context3.getString(R.string.download_failed));
    }

    @Override // z8.e.b
    public void onCancel() {
    }

    @Override // z8.e.b
    public void onStart() {
    }
}
