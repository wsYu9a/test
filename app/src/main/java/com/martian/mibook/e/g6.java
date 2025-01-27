package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12019a;

    /* renamed from: b */
    @NonNull
    public final TextView f12020b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12021c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12022d;

    private g6(@NonNull LinearLayout rootView, @NonNull TextView bpDelete, @NonNull ThemeTextView bpSelectAll, @NonNull LinearLayout readingRecordBatchView) {
        this.f12019a = rootView;
        this.f12020b = bpDelete;
        this.f12021c = bpSelectAll;
        this.f12022d = readingRecordBatchView;
    }

    @NonNull
    public static g6 a(@NonNull View rootView) {
        int i2 = R.id.bp_delete;
        TextView textView = (TextView) rootView.findViewById(R.id.bp_delete);
        if (textView != null) {
            i2 = R.id.bp_select_all;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bp_select_all);
            if (themeTextView != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                return new g6(linearLayout, textView, themeTextView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_record_batch_bottom, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12019a;
    }
}
