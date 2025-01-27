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
public final class f4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11947a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f11948b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11949c;

    /* renamed from: d */
    @NonNull
    public final TextView f11950d;

    /* renamed from: e */
    @NonNull
    public final TextView f11951e;

    private f4(@NonNull RelativeLayout rootView, @NonNull RelativeLayout checkinedBg, @NonNull ImageView checkinedClose, @NonNull TextView checkinedCoins, @NonNull TextView checkinedVideoBonus) {
        this.f11947a = rootView;
        this.f11948b = checkinedBg;
        this.f11949c = checkinedClose;
        this.f11950d = checkinedCoins;
        this.f11951e = checkinedVideoBonus;
    }

    @NonNull
    public static f4 a(@NonNull View rootView) {
        int i2 = R.id.checkined_bg;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.checkined_bg);
        if (relativeLayout != null) {
            i2 = R.id.checkined_close;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.checkined_close);
            if (imageView != null) {
                i2 = R.id.checkined_coins;
                TextView textView = (TextView) rootView.findViewById(R.id.checkined_coins);
                if (textView != null) {
                    i2 = R.id.checkined_video_bonus;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.checkined_video_bonus);
                    if (textView2 != null) {
                        return new f4((RelativeLayout) rootView, relativeLayout, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_popupwindow_checkined, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11947a;
    }
}
