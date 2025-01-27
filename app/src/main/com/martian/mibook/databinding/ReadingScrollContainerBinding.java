package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libsliding.SlidingLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class ReadingScrollContainerBinding implements ViewBinding {

    @NonNull
    public final LinearLayout llScrollReadingContainer;

    @NonNull
    public final ReadingFakeLayoutBinding lyFakeReadingLayout;

    @NonNull
    public final ViewStub readingBanner;

    @NonNull
    public final ReadingBonusBinding readingBonus;

    @NonNull
    public final ViewStub readingTtsPosition;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    private final SmartRefreshLayout rootView;

    @NonNull
    public final SlidingLayout slReadingContainer;

    @NonNull
    public final ReaderThemeTextView tvScrollReadingTitle;

    @NonNull
    public final LinearLayout tvScrollReadingTitleView;

    private ReadingScrollContainerBinding(@NonNull SmartRefreshLayout smartRefreshLayout, @NonNull LinearLayout linearLayout, @NonNull ReadingFakeLayoutBinding readingFakeLayoutBinding, @NonNull ViewStub viewStub, @NonNull ReadingBonusBinding readingBonusBinding, @NonNull ViewStub viewStub2, @NonNull SmartRefreshLayout smartRefreshLayout2, @NonNull SlidingLayout slidingLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull LinearLayout linearLayout2) {
        this.rootView = smartRefreshLayout;
        this.llScrollReadingContainer = linearLayout;
        this.lyFakeReadingLayout = readingFakeLayoutBinding;
        this.readingBanner = viewStub;
        this.readingBonus = readingBonusBinding;
        this.readingTtsPosition = viewStub2;
        this.refreshLayout = smartRefreshLayout2;
        this.slReadingContainer = slidingLayout;
        this.tvScrollReadingTitle = readerThemeTextView;
        this.tvScrollReadingTitleView = linearLayout2;
    }

    @NonNull
    public static ReadingScrollContainerBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        int i10 = R.id.ll_scroll_reading_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.ly_fake_reading_layout))) != null) {
            ReadingFakeLayoutBinding bind = ReadingFakeLayoutBinding.bind(findChildViewById);
            i10 = R.id.reading_banner;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
            if (viewStub != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.reading_bonus))) != null) {
                ReadingBonusBinding bind2 = ReadingBonusBinding.bind(findChildViewById2);
                i10 = R.id.reading_tts_position;
                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                if (viewStub2 != null) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view;
                    i10 = R.id.sl_reading_container;
                    SlidingLayout slidingLayout = (SlidingLayout) ViewBindings.findChildViewById(view, i10);
                    if (slidingLayout != null) {
                        i10 = R.id.tv_scroll_reading_title;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView != null) {
                            i10 = R.id.tv_scroll_reading_title_view;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout2 != null) {
                                return new ReadingScrollContainerBinding(smartRefreshLayout, linearLayout, bind, viewStub, bind2, viewStub2, smartRefreshLayout, slidingLayout, readerThemeTextView, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingScrollContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingScrollContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_scroll_container, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public SmartRefreshLayout getRoot() {
        return this.rootView;
    }
}
