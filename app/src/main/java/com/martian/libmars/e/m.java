package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;

/* loaded from: classes2.dex */
public final class m implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LoadMoreFooterView f10026a;

    private m(@NonNull LoadMoreFooterView rootView) {
        this.f10026a = rootView;
    }

    @NonNull
    public static m a(@NonNull View rootView) {
        if (rootView != null) {
            return new m((LoadMoreFooterView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static m c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_irecyclerview_load_more_footer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LoadMoreFooterView getRoot() {
        return this.f10026a;
    }
}
