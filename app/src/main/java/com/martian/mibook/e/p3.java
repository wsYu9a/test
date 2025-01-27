package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class p3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12521a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12522b;

    private p3(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView tvLoading) {
        this.f12521a = rootView;
        this.f12522b = tvLoading;
    }

    @NonNull
    public static p3 a(@NonNull View rootView) {
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tvLoading);
        if (readerThemeTextView != null) {
            return new p3((LinearLayout) rootView, readerThemeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tvLoading)));
    }

    @NonNull
    public static p3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_reader_irecyclerview_load_more_footer_loading_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12521a;
    }
}
