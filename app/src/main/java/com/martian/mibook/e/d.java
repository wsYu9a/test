package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11809a;

    /* renamed from: b */
    @NonNull
    public final ThemeRelativeLayout f11810b;

    /* renamed from: c */
    @NonNull
    public final ListView f11811c;

    /* renamed from: d */
    @NonNull
    public final TextView f11812d;

    /* renamed from: e */
    @NonNull
    public final ImageView f11813e;

    /* renamed from: f */
    @NonNull
    public final TextView f11814f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f11815g;

    private d(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeRelativeLayout martianIncomeScrollview, @NonNull ListView martianTaskListview, @NonNull TextView taskCoins, @NonNull ImageView taskHeader, @NonNull TextView taskInstall, @NonNull ThemeTextView taskName) {
        this.f11809a = rootView;
        this.f11810b = martianIncomeScrollview;
        this.f11811c = martianTaskListview;
        this.f11812d = taskCoins;
        this.f11813e = taskHeader;
        this.f11814f = taskInstall;
        this.f11815g = taskName;
    }

    @NonNull
    public static d a(@NonNull View rootView) {
        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) rootView;
        int i2 = R.id.martian_task_listview;
        ListView listView = (ListView) rootView.findViewById(R.id.martian_task_listview);
        if (listView != null) {
            i2 = R.id.task_coins;
            TextView textView = (TextView) rootView.findViewById(R.id.task_coins);
            if (textView != null) {
                i2 = R.id.task_header;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.task_header);
                if (imageView != null) {
                    i2 = R.id.task_install;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.task_install);
                    if (textView2 != null) {
                        i2 = R.id.task_name;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.task_name);
                        if (themeTextView != null) {
                            return new d((ThemeRelativeLayout) rootView, themeRelativeLayout, listView, textView, imageView, textView2, themeTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_appwall_task_detail, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11809a;
    }
}
