package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.AudiobookAdFrameLayout;

/* loaded from: classes3.dex */
public final class AudiobookAdLayoutBinding implements ViewBinding {

    @NonNull
    public final CountdownNumberTextView audiobookAdCloseCountdown;

    @NonNull
    public final TextView audiobookAdCloseTitle;

    @NonNull
    public final LinearLayout audiobookAdCloseView;

    @NonNull
    public final AudiobookAdFrameLayout audiobookAdContainer;

    @NonNull
    public final TextView audiobookAdVip;

    @NonNull
    private final RelativeLayout rootView;

    private AudiobookAdLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull CountdownNumberTextView countdownNumberTextView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull AudiobookAdFrameLayout audiobookAdFrameLayout, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.audiobookAdCloseCountdown = countdownNumberTextView;
        this.audiobookAdCloseTitle = textView;
        this.audiobookAdCloseView = linearLayout;
        this.audiobookAdContainer = audiobookAdFrameLayout;
        this.audiobookAdVip = textView2;
    }

    @NonNull
    public static AudiobookAdLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.audiobook_ad_close_countdown;
        CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) ViewBindings.findChildViewById(view, i10);
        if (countdownNumberTextView != null) {
            i10 = R.id.audiobook_ad_close_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.audiobook_ad_close_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.audiobook_ad_container;
                    AudiobookAdFrameLayout audiobookAdFrameLayout = (AudiobookAdFrameLayout) ViewBindings.findChildViewById(view, i10);
                    if (audiobookAdFrameLayout != null) {
                        i10 = R.id.audiobook_ad_vip;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            return new AudiobookAdLayoutBinding((RelativeLayout) view, countdownNumberTextView, textView, linearLayout, audiobookAdFrameLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static AudiobookAdLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AudiobookAdLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.audiobook_ad_layout, viewGroup, false);
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
