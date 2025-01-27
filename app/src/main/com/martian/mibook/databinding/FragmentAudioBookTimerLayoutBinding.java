package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentAudioBookTimerLayoutBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ListView timingListview;

    @NonNull
    public final ThemeImageView timingWindowClose;

    @NonNull
    public final ThemeTextView tvClose;

    private FragmentAudioBookTimerLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull ListView listView, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.timingListview = listView;
        this.timingWindowClose = themeImageView;
        this.tvClose = themeTextView;
    }

    @NonNull
    public static FragmentAudioBookTimerLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.timing_listview;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i10);
        if (listView != null) {
            i10 = R.id.timing_window_close;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.tv_close;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new FragmentAudioBookTimerLayoutBinding((RelativeLayout) view, listView, themeImageView, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentAudioBookTimerLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAudioBookTimerLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_audio_book_timer_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
