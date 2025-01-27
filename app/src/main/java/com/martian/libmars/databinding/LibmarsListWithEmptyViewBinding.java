package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;

/* loaded from: classes3.dex */
public final class LibmarsListWithEmptyViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeRelativeLayout f12274a;

    /* renamed from: b */
    @NonNull
    public final TextView f12275b;

    /* renamed from: c */
    @NonNull
    public final ListView f12276c;

    /* renamed from: d */
    @NonNull
    public final ProgressBar f12277d;

    public LibmarsListWithEmptyViewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull TextView textView, @NonNull ListView listView, @NonNull ProgressBar progressBar) {
        this.f12274a = themeRelativeLayout;
        this.f12275b = textView;
        this.f12276c = listView;
        this.f12277d = progressBar;
    }

    @NonNull
    public static LibmarsListWithEmptyViewBinding a(@NonNull View view) {
        int i10 = R.id.libmars_empty_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = android.R.id.list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, android.R.id.list);
            if (listView != null) {
                i10 = R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                if (progressBar != null) {
                    return new LibmarsListWithEmptyViewBinding((ThemeRelativeLayout) view, textView, listView, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsListWithEmptyViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsListWithEmptyViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_list_with_empty_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12274a;
    }
}
