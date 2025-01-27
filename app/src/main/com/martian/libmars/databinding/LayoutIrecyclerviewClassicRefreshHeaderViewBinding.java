package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class LayoutIrecyclerviewClassicRefreshHeaderViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f12203a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12204b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12205c;

    /* renamed from: d */
    @NonNull
    public final ProgressBar f12206d;

    /* renamed from: e */
    @NonNull
    public final TextView f12207e;

    public LayoutIrecyclerviewClassicRefreshHeaderViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ProgressBar progressBar, @NonNull TextView textView) {
        this.f12203a = view;
        this.f12204b = imageView;
        this.f12205c = imageView2;
        this.f12206d = progressBar;
        this.f12207e = textView;
    }

    @NonNull
    public static LayoutIrecyclerviewClassicRefreshHeaderViewBinding a(@NonNull View view) {
        int i10 = R.id.ivArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.ivSuccess;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                if (progressBar != null) {
                    i10 = R.id.tvRefresh;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        return new LayoutIrecyclerviewClassicRefreshHeaderViewBinding(view, imageView, imageView2, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutIrecyclerviewClassicRefreshHeaderViewBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.layout_irecyclerview_classic_refresh_header_view, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f12203a;
    }
}
