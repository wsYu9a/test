package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class q4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12565a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeImageView f12566b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f12567c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeItemTextView f12568d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeLinearLayout f12569e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeItemTextView f12570f;

    private q4(@NonNull RelativeLayout rootView, @NonNull ReaderThemeImageView closeAdsCancel, @NonNull ReaderThemeTextView closeAdsTitle, @NonNull ReaderThemeItemTextView closeAdsVideo, @NonNull ReaderThemeLinearLayout closeAdsView, @NonNull ReaderThemeItemTextView openVipMember) {
        this.f12565a = rootView;
        this.f12566b = closeAdsCancel;
        this.f12567c = closeAdsTitle;
        this.f12568d = closeAdsVideo;
        this.f12569e = closeAdsView;
        this.f12570f = openVipMember;
    }

    @NonNull
    public static q4 a(@NonNull View rootView) {
        int i2 = R.id.close_ads_cancel;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.close_ads_cancel);
        if (readerThemeImageView != null) {
            i2 = R.id.close_ads_title;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.close_ads_title);
            if (readerThemeTextView != null) {
                i2 = R.id.close_ads_video;
                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.close_ads_video);
                if (readerThemeItemTextView != null) {
                    i2 = R.id.close_ads_view;
                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.close_ads_view);
                    if (readerThemeLinearLayout != null) {
                        i2 = R.id.open_vip_member;
                        ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.open_vip_member);
                        if (readerThemeItemTextView2 != null) {
                            return new q4((RelativeLayout) rootView, readerThemeImageView, readerThemeTextView, readerThemeItemTextView, readerThemeLinearLayout, readerThemeItemTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static q4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static q4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_close_reader_ads, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12565a;
    }
}
