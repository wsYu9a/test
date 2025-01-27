package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f13013a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f13014b;

    /* renamed from: c */
    @NonNull
    public final ListView f13015c;

    private z2(@NonNull RelativeLayout rootView, @NonNull ReaderThemeTextView emptyText, @NonNull ListView list) {
        this.f13013a = rootView;
        this.f13014b = emptyText;
        this.f13015c = list;
    }

    @NonNull
    public static z2 a(@NonNull View rootView) {
        int i2 = R.id.empty_text;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.empty_text);
        if (readerThemeTextView != null) {
            i2 = android.R.id.list;
            ListView listView = (ListView) rootView.findViewById(android.R.id.list);
            if (listView != null) {
                return new z2((RelativeLayout) rootView, readerThemeTextView, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static z2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_bookmark, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f13013a;
    }
}
