package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityTxsRequestRemoveBlacklistBinding implements ViewBinding {

    @NonNull
    public final LinearLayout removeBlackLoading;

    @NonNull
    public final ThemeEditText removeReason;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final ThemeTextView withdrawLeftCount;

    private ActivityTxsRequestRemoveBlacklistBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull LinearLayout linearLayout, @NonNull ThemeEditText themeEditText, @NonNull ThemeTextView themeTextView) {
        this.rootView = themeRelativeLayout;
        this.removeBlackLoading = linearLayout;
        this.removeReason = themeEditText;
        this.withdrawLeftCount = themeTextView;
    }

    @NonNull
    public static ActivityTxsRequestRemoveBlacklistBinding bind(@NonNull View view) {
        int i10 = R.id.remove_black_loading;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.remove_reason;
            ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
            if (themeEditText != null) {
                i10 = R.id.withdraw_left_count;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new ActivityTxsRequestRemoveBlacklistBinding((ThemeRelativeLayout) view, linearLayout, themeEditText, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityTxsRequestRemoveBlacklistBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTxsRequestRemoveBlacklistBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_txs_request_remove_blacklist, viewGroup, false);
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
