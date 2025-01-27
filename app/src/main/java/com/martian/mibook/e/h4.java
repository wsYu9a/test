package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12068a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12069b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12070c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12071d;

    /* renamed from: e */
    @NonNull
    public final TextView f12072e;

    private h4(@NonNull RelativeLayout rootView, @NonNull ImageView vipEndBg, @NonNull ImageView vipEndClose, @NonNull ImageView vipEndCover, @NonNull TextView vipEndNickname) {
        this.f12068a = rootView;
        this.f12069b = vipEndBg;
        this.f12070c = vipEndClose;
        this.f12071d = vipEndCover;
        this.f12072e = vipEndNickname;
    }

    @NonNull
    public static h4 a(@NonNull View rootView) {
        int i2 = R.id.vip_end_bg;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.vip_end_bg);
        if (imageView != null) {
            i2 = R.id.vip_end_close;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.vip_end_close);
            if (imageView2 != null) {
                i2 = R.id.vip_end_cover;
                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.vip_end_cover);
                if (imageView3 != null) {
                    i2 = R.id.vip_end_nickname;
                    TextView textView = (TextView) rootView.findViewById(R.id.vip_end_nickname);
                    if (textView != null) {
                        return new h4((RelativeLayout) rootView, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_popupwindow_vip_end, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12068a;
    }
}
