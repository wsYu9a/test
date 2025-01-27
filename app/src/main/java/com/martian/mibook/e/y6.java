package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12996a;

    /* renamed from: b */
    @NonNull
    public final TextView f12997b;

    /* renamed from: c */
    @NonNull
    public final TextView f12998c;

    private y6(@NonNull LinearLayout rootView, @NonNull TextView searchIndex, @NonNull TextView searchKeyword) {
        this.f12996a = rootView;
        this.f12997b = searchIndex;
        this.f12998c = searchKeyword;
    }

    @NonNull
    public static y6 a(@NonNull View rootView) {
        int i2 = R.id.search_index;
        TextView textView = (TextView) rootView.findViewById(R.id.search_index);
        if (textView != null) {
            i2 = R.id.search_keyword;
            TextView textView2 = (TextView) rootView.findViewById(R.id.search_keyword);
            if (textView2 != null) {
                return new y6((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static y6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.search_rank_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12996a;
    }
}
