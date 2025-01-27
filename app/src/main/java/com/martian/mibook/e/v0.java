package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12808a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12809b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12810c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12811d;

    /* renamed from: e */
    @NonNull
    public final ListView f12812e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12813f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12814g;

    private v0(@NonNull RelativeLayout rootView, @NonNull ThemeTextView bsFileScan, @NonNull LinearLayout bsImport, @NonNull ThemeTextView bsStopScan, @NonNull ListView list, @NonNull ThemeTextView tvAddBookRack, @NonNull ThemeTextView tvSelectAll) {
        this.f12808a = rootView;
        this.f12809b = bsFileScan;
        this.f12810c = bsImport;
        this.f12811d = bsStopScan;
        this.f12812e = list;
        this.f12813f = tvAddBookRack;
        this.f12814g = tvSelectAll;
    }

    @NonNull
    public static v0 a(@NonNull View rootView) {
        int i2 = R.id.bs_file_scan;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_file_scan);
        if (themeTextView != null) {
            i2 = R.id.bs_import;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bs_import);
            if (linearLayout != null) {
                i2 = R.id.bs_stop_scan;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bs_stop_scan);
                if (themeTextView2 != null) {
                    i2 = android.R.id.list;
                    ListView listView = (ListView) rootView.findViewById(android.R.id.list);
                    if (listView != null) {
                        i2 = R.id.tv_add_book_rack;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.tv_add_book_rack);
                        if (themeTextView3 != null) {
                            i2 = R.id.tv_select_all;
                            ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.tv_select_all);
                            if (themeTextView4 != null) {
                                return new v0((RelativeLayout) rootView, themeTextView, linearLayout, themeTextView2, listView, themeTextView3, themeTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static v0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12808a;
    }
}
