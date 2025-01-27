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
public final class c0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f9927a;

    /* renamed from: b */
    @NonNull
    public final ImageView f9928b;

    /* renamed from: c */
    @NonNull
    public final TextView f9929c;

    private c0(@NonNull LinearLayout rootView, @NonNull ImageView toastCustomIv, @NonNull TextView toastCustomTv) {
        this.f9927a = rootView;
        this.f9928b = toastCustomIv;
        this.f9929c = toastCustomTv;
    }

    @NonNull
    public static c0 a(@NonNull View rootView) {
        int i2 = R.id.toast_custom_iv;
        ImageView imageView = (ImageView) rootView.findViewById(i2);
        if (imageView != null) {
            i2 = R.id.toast_custom_tv;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                return new c0((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_toast_custom, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9927a;
    }
}
