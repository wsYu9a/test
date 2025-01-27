package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;

/* loaded from: classes2.dex */
public final class w implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f10062a;

    /* renamed from: b */
    @NonNull
    public final TextView f10063b;

    /* renamed from: c */
    @NonNull
    public final ListView f10064c;

    /* renamed from: d */
    @NonNull
    public final ProgressBar f10065d;

    private w(@NonNull ThemeRelativeLayout rootView, @NonNull TextView libmarsEmptyText, @NonNull ListView list, @NonNull ProgressBar pbLoading) {
        this.f10062a = rootView;
        this.f10063b = libmarsEmptyText;
        this.f10064c = list;
        this.f10065d = pbLoading;
    }

    @NonNull
    public static w a(@NonNull View rootView) {
        int i2 = R.id.libmars_empty_text;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = android.R.id.list;
            ListView listView = (ListView) rootView.findViewById(android.R.id.list);
            if (listView != null) {
                i2 = R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) rootView.findViewById(i2);
                if (progressBar != null) {
                    return new w((ThemeRelativeLayout) rootView, textView, listView, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_list_with_empty_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f10062a;
    }
}
