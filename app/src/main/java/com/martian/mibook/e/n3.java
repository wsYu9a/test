package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderLoadMoreFooterView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderLoadMoreFooterView f12422a;

    private n3(@NonNull ReaderLoadMoreFooterView rootView) {
        this.f12422a = rootView;
    }

    @NonNull
    public static n3 a(@NonNull View rootView) {
        if (rootView != null) {
            return new n3((ReaderLoadMoreFooterView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static n3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_reader_irecyclerview_load_more_footer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderLoadMoreFooterView getRoot() {
        return this.f12422a;
    }
}
