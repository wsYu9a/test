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
public final class g4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12005a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12006b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12007c;

    /* renamed from: d */
    @NonNull
    public final TextView f12008d;

    private g4(@NonNull RelativeLayout rootView, @NonNull ImageView rdClose, @NonNull ImageView rulesBg, @NonNull TextView rulesButton) {
        this.f12005a = rootView;
        this.f12006b = rdClose;
        this.f12007c = rulesBg;
        this.f12008d = rulesButton;
    }

    @NonNull
    public static g4 a(@NonNull View rootView) {
        int i2 = R.id.rd_close;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.rd_close);
        if (imageView != null) {
            i2 = R.id.rules_bg;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.rules_bg);
            if (imageView2 != null) {
                i2 = R.id.rules_button;
                TextView textView = (TextView) rootView.findViewById(R.id.rules_button);
                if (textView != null) {
                    return new g4((RelativeLayout) rootView, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_popupwindow_push, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12005a;
    }
}
