package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class l implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final View f10021a;

    /* renamed from: b */
    @NonNull
    public final ImageView f10022b;

    /* renamed from: c */
    @NonNull
    public final ImageView f10023c;

    /* renamed from: d */
    @NonNull
    public final ProgressBar f10024d;

    /* renamed from: e */
    @NonNull
    public final TextView f10025e;

    private l(@NonNull View rootView, @NonNull ImageView ivArrow, @NonNull ImageView ivSuccess, @NonNull ProgressBar progressbar, @NonNull TextView tvRefresh) {
        this.f10021a = rootView;
        this.f10022b = ivArrow;
        this.f10023c = ivSuccess;
        this.f10024d = progressbar;
        this.f10025e = tvRefresh;
    }

    @NonNull
    public static l a(@NonNull View rootView) {
        int i2 = R.id.ivArrow;
        ImageView imageView = (ImageView) rootView.findViewById(i2);
        if (imageView != null) {
            i2 = R.id.ivSuccess;
            ImageView imageView2 = (ImageView) rootView.findViewById(i2);
            if (imageView2 != null) {
                i2 = R.id.progressbar;
                ProgressBar progressBar = (ProgressBar) rootView.findViewById(i2);
                if (progressBar != null) {
                    i2 = R.id.tvRefresh;
                    TextView textView = (TextView) rootView.findViewById(i2);
                    if (textView != null) {
                        return new l(rootView, imageView, imageView2, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.layout_irecyclerview_classic_refresh_header_view, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f10021a;
    }
}
