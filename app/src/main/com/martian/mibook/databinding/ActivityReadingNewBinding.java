package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeRelativeLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ActivityReadingNewBinding implements ViewBinding {

    @NonNull
    public final ViewStub autoSlideViewStub;

    @NonNull
    public final ConstraintLayout clMainContainer;

    @NonNull
    public final ViewStub firstGuideScrollModeView;

    @NonNull
    public final ViewStub firstGuideView;

    @NonNull
    public final ViewStub networkOfflineView;

    @NonNull
    public final ViewStub readMenuViewStub;

    @NonNull
    public final ViewStub readingErrorView;

    @NonNull
    public final ReadingScrollContainerBinding readingScrollContainer;

    @NonNull
    public final ReaderThemeRelativeLayout rlContent;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvLoadingText;

    private ActivityReadingNewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ViewStub viewStub, @NonNull ConstraintLayout constraintLayout, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull ViewStub viewStub4, @NonNull ViewStub viewStub5, @NonNull ViewStub viewStub6, @NonNull ReadingScrollContainerBinding readingScrollContainerBinding, @NonNull ReaderThemeRelativeLayout readerThemeRelativeLayout, @NonNull ReaderThemeTextView readerThemeTextView) {
        this.rootView = relativeLayout;
        this.autoSlideViewStub = viewStub;
        this.clMainContainer = constraintLayout;
        this.firstGuideScrollModeView = viewStub2;
        this.firstGuideView = viewStub3;
        this.networkOfflineView = viewStub4;
        this.readMenuViewStub = viewStub5;
        this.readingErrorView = viewStub6;
        this.readingScrollContainer = readingScrollContainerBinding;
        this.rlContent = readerThemeRelativeLayout;
        this.tvLoadingText = readerThemeTextView;
    }

    @NonNull
    public static ActivityReadingNewBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.auto_slide_view_stub;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.cl_main_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.first_guide_scroll_mode_view;
                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                if (viewStub2 != null) {
                    i10 = R.id.first_guide_view;
                    ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                    if (viewStub3 != null) {
                        i10 = R.id.network_offline_view;
                        ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                        if (viewStub4 != null) {
                            i10 = R.id.read_menu_view_stub;
                            ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                            if (viewStub5 != null) {
                                i10 = R.id.reading_error_view;
                                ViewStub viewStub6 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                if (viewStub6 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.reading_scroll_container))) != null) {
                                    ReadingScrollContainerBinding bind = ReadingScrollContainerBinding.bind(findChildViewById);
                                    i10 = R.id.rl_content;
                                    ReaderThemeRelativeLayout readerThemeRelativeLayout = (ReaderThemeRelativeLayout) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeRelativeLayout != null) {
                                        i10 = R.id.tv_loading_text;
                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView != null) {
                                            return new ActivityReadingNewBinding((RelativeLayout) view, viewStub, constraintLayout, viewStub2, viewStub3, viewStub4, viewStub5, viewStub6, bind, readerThemeRelativeLayout, readerThemeTextView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityReadingNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityReadingNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_reading_new, viewGroup, false);
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
