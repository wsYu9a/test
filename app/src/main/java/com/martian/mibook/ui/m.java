package com.martian.mibook.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.martian.libmars.utils.n0;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class m implements com.martian.libsupport.bannerView.d<TYActivity> {

    /* renamed from: a */
    private ImageView f14270a;

    @Override // com.martian.libsupport.bannerView.d
    public View b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_banner, (ViewGroup) null);
        this.f14270a = (ImageView) inflate.findViewById(R.id.img_banner);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.martian.libmars.d.h.b(16.0f), 0, com.martian.libmars.d.h.b(16.0f), 0);
        this.f14270a.setLayoutParams(layoutParams);
        return inflate;
    }

    @Override // com.martian.libsupport.bannerView.d
    /* renamed from: c */
    public void a(Context context, int i2, TYActivity tyActivity) {
        n0.z(context, tyActivity.getPosterImage(), this.f14270a, 8, com.martian.libmars.d.h.F().i());
    }
}
