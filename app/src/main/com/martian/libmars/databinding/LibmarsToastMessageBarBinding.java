package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class LibmarsToastMessageBarBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12304a;

    /* renamed from: b */
    @NonNull
    public final TextView f12305b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12306c;

    /* renamed from: d */
    @NonNull
    public final TextView f12307d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12308e;

    public LibmarsToastMessageBarBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f12304a = linearLayout;
        this.f12305b = textView;
        this.f12306c = imageView;
        this.f12307d = textView2;
        this.f12308e = linearLayout2;
    }

    @NonNull
    public static LibmarsToastMessageBarBinding a(@NonNull View view) {
        int i10 = R.id.martian_add_coins;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.martian_coins_type;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.martian_mbMessage;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new LibmarsToastMessageBarBinding(linearLayout, textView, imageView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsToastMessageBarBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsToastMessageBarBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_toast_message_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12304a;
    }
}
