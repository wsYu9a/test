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
public final class q3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12563a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12564b;

    private q3(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView tvTheEnd) {
        this.f12563a = rootView;
        this.f12564b = tvTheEnd;
    }

    @NonNull
    public static q3 a(@NonNull View rootView) {
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tvTheEnd);
        if (readerThemeTextView != null) {
            return new q3((LinearLayout) rootView, readerThemeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tvTheEnd)));
    }

    @NonNull
    public static q3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_reader_irecyclerview_load_more_footer_the_end_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12563a;
    }
}
