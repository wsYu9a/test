package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final View f11996a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11997b;

    /* renamed from: c */
    @NonNull
    public final TextView f11998c;

    /* renamed from: d */
    @NonNull
    public final TextView f11999d;

    private g2(@NonNull View rootView, @NonNull ImageView icon, @NonNull TextView largeLabel, @NonNull TextView smallLabel) {
        this.f11996a = rootView;
        this.f11997b = icon;
        this.f11998c = largeLabel;
        this.f11999d = smallLabel;
    }

    @NonNull
    public static g2 a(@NonNull View rootView) {
        int i2 = R.id.icon;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.icon);
        if (imageView != null) {
            i2 = R.id.largeLabel;
            TextView textView = (TextView) rootView.findViewById(R.id.largeLabel);
            if (textView != null) {
                i2 = R.id.smallLabel;
                TextView textView2 = (TextView) rootView.findViewById(R.id.smallLabel);
                if (textView2 != null) {
                    return new g2(rootView, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g2 b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.design_bottom_navigation_item, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f11996a;
    }
}
