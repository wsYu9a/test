package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityAppwallTaskDetailBinding implements ViewBinding {

    @NonNull
    public final ThemeRelativeLayout martianIncomeScrollview;

    @NonNull
    public final ListView martianTaskListview;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final TextView taskCoins;

    @NonNull
    public final ImageView taskHeader;

    @NonNull
    public final TextView taskInstall;

    @NonNull
    public final ThemeTextView taskName;

    private ActivityAppwallTaskDetailBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeRelativeLayout themeRelativeLayout2, @NonNull ListView listView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ThemeTextView themeTextView) {
        this.rootView = themeRelativeLayout;
        this.martianIncomeScrollview = themeRelativeLayout2;
        this.martianTaskListview = listView;
        this.taskCoins = textView;
        this.taskHeader = imageView;
        this.taskInstall = textView2;
        this.taskName = themeTextView;
    }

    @NonNull
    public static ActivityAppwallTaskDetailBinding bind(@NonNull View view) {
        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) view;
        int i10 = R.id.martian_task_listview;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i10);
        if (listView != null) {
            i10 = R.id.task_coins;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.task_header;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.task_install;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.task_name;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            return new ActivityAppwallTaskDetailBinding(themeRelativeLayout, themeRelativeLayout, listView, textView, imageView, textView2, themeTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityAppwallTaskDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAppwallTaskDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_appwall_task_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
