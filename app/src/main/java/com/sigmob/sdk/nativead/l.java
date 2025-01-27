package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.CircleImageView;

/* loaded from: classes4.dex */
public class l extends RelativeLayout {

    /* renamed from: a */
    public TextView f19972a;

    /* renamed from: b */
    public TextView f19973b;

    /* renamed from: c */
    public ViewGroup f19974c;

    /* renamed from: d */
    public CircleImageView f19975d;

    public l(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        this.f19972a = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_name"));
        this.f19973b = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_cta"));
        this.f19974c = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_app_icon"));
        CircleImageView circleImageView = new CircleImageView(context);
        this.f19975d = circleImageView;
        circleImageView.setCircle(false);
        this.f19975d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f19974c.addView(this.f19975d, new ViewGroup.LayoutParams(-1, -1));
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_layout");
    }

    public void a(String str, String str2, String str3) {
        this.f19972a.setText(str2);
        this.f19973b.setText(str3);
        ImageManager.with(getContext()).load(str).into(this.f19975d);
    }

    public View getCtaView() {
        return this.f19973b;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f19973b.setOnClickListener(onClickListener);
    }
}
