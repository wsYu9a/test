package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class ViewFastscrollerBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f12340a;

    /* renamed from: b */
    @NonNull
    public final TextView f12341b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12342c;

    /* renamed from: d */
    @NonNull
    public final FrameLayout f12343d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12344e;

    public ViewFastscrollerBinding(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2) {
        this.f12340a = view;
        this.f12341b = textView;
        this.f12342c = imageView;
        this.f12343d = frameLayout;
        this.f12344e = imageView2;
    }

    @NonNull
    public static ViewFastscrollerBinding a(@NonNull View view) {
        int i10 = R.id.fastscroll_bubble;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.fastscroll_handle;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.fastscroll_scrollbar;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                if (frameLayout != null) {
                    i10 = R.id.fastscroll_track;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        return new ViewFastscrollerBinding(view, textView, imageView, frameLayout, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ViewFastscrollerBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.view_fastscroller, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f12340a;
    }
}
