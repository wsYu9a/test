package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class d0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f9940a;

    /* renamed from: b */
    @NonNull
    public final TextView f9941b;

    /* renamed from: c */
    @NonNull
    public final ImageView f9942c;

    /* renamed from: d */
    @NonNull
    public final TextView f9943d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f9944e;

    private d0(@NonNull LinearLayout rootView, @NonNull TextView martianAddCoins, @NonNull ImageView martianCoinsType, @NonNull TextView martianMbMessage, @NonNull LinearLayout martianToastContainer) {
        this.f9940a = rootView;
        this.f9941b = martianAddCoins;
        this.f9942c = martianCoinsType;
        this.f9943d = martianMbMessage;
        this.f9944e = martianToastContainer;
    }

    @NonNull
    public static d0 a(@NonNull View rootView) {
        int i2 = R.id.martian_add_coins;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = R.id.martian_coins_type;
            ImageView imageView = (ImageView) rootView.findViewById(i2);
            if (imageView != null) {
                i2 = R.id.martian_mbMessage;
                TextView textView2 = (TextView) rootView.findViewById(i2);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    return new d0(linearLayout, textView, imageView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_toast_message_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9940a;
    }
}
