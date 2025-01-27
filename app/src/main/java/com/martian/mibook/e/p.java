package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class p implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final DrawerLayout f12501a;

    /* renamed from: b */
    @NonNull
    public final DrawerLayout f12502b;

    /* renamed from: c */
    @NonNull
    public final ViewStub f12503c;

    /* renamed from: d */
    @NonNull
    public final ViewStub f12504d;

    /* renamed from: e */
    @NonNull
    public final ViewStub f12505e;

    /* renamed from: f */
    @NonNull
    public final ViewStub f12506f;

    /* renamed from: g */
    @NonNull
    public final ViewStub f12507g;

    /* renamed from: h */
    @NonNull
    public final ViewStub f12508h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f12509i;

    /* renamed from: j */
    @NonNull
    public final ViewStub f12510j;

    @NonNull
    public final r5 k;

    @NonNull
    public final ViewStub l;

    @NonNull
    public final ViewStub m;

    @NonNull
    public final ViewStub n;

    @NonNull
    public final ViewStub o;

    @NonNull
    public final ViewStub p;

    @NonNull
    public final j6 q;

    @NonNull
    public final ViewStub r;

    @NonNull
    public final ViewStub s;

    @NonNull
    public final ViewStub t;

    @NonNull
    public final ViewStub u;

    @NonNull
    public final RelativeLayout v;

    @NonNull
    public final ViewStub w;

    @NonNull
    public final View x;

    @NonNull
    public final ImageView y;

    @NonNull
    public final ReaderThemeTextView z;

    private p(@NonNull DrawerLayout rootView, @NonNull DrawerLayout drawerLayout, @NonNull ViewStub firstGuideScrollModeView, @NonNull ViewStub firstGuideView, @NonNull ViewStub lyAutoSliding, @NonNull ViewStub lyPageSetting, @NonNull ViewStub lyTtsSliding, @NonNull ViewStub networkOfflineView, @NonNull LinearLayout pbUpdateLoading, @NonNull ViewStub readingAddRackView, @NonNull r5 readingBonus, @NonNull ViewStub readingBottomBar, @NonNull ViewStub readingColorPicker, @NonNull ViewStub readingExitDialog, @NonNull ViewStub readingLeftDrawer, @NonNull ViewStub readingMoreSetting, @NonNull j6 readingScrollContainer, @NonNull ViewStub readingSlideMode, @NonNull ViewStub readingTiming, @NonNull ViewStub readingTopBar, @NonNull ViewStub readingTypeFace, @NonNull RelativeLayout rlMainContainer, @NonNull ViewStub slideGuideView, @NonNull View statusBarView, @NonNull ImageView tvLoadingIcon, @NonNull ReaderThemeTextView tvLoadingText) {
        this.f12501a = rootView;
        this.f12502b = drawerLayout;
        this.f12503c = firstGuideScrollModeView;
        this.f12504d = firstGuideView;
        this.f12505e = lyAutoSliding;
        this.f12506f = lyPageSetting;
        this.f12507g = lyTtsSliding;
        this.f12508h = networkOfflineView;
        this.f12509i = pbUpdateLoading;
        this.f12510j = readingAddRackView;
        this.k = readingBonus;
        this.l = readingBottomBar;
        this.m = readingColorPicker;
        this.n = readingExitDialog;
        this.o = readingLeftDrawer;
        this.p = readingMoreSetting;
        this.q = readingScrollContainer;
        this.r = readingSlideMode;
        this.s = readingTiming;
        this.t = readingTopBar;
        this.u = readingTypeFace;
        this.v = rlMainContainer;
        this.w = slideGuideView;
        this.x = statusBarView;
        this.y = tvLoadingIcon;
        this.z = tvLoadingText;
    }

    @NonNull
    public static p a(@NonNull View rootView) {
        DrawerLayout drawerLayout = (DrawerLayout) rootView;
        int i2 = R.id.first_guide_scroll_mode_view;
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.first_guide_scroll_mode_view);
        if (viewStub != null) {
            i2 = R.id.first_guide_view;
            ViewStub viewStub2 = (ViewStub) rootView.findViewById(R.id.first_guide_view);
            if (viewStub2 != null) {
                i2 = R.id.ly_auto_sliding;
                ViewStub viewStub3 = (ViewStub) rootView.findViewById(R.id.ly_auto_sliding);
                if (viewStub3 != null) {
                    i2 = R.id.ly_page_setting;
                    ViewStub viewStub4 = (ViewStub) rootView.findViewById(R.id.ly_page_setting);
                    if (viewStub4 != null) {
                        i2 = R.id.ly_tts_sliding;
                        ViewStub viewStub5 = (ViewStub) rootView.findViewById(R.id.ly_tts_sliding);
                        if (viewStub5 != null) {
                            i2 = R.id.network_offline_view;
                            ViewStub viewStub6 = (ViewStub) rootView.findViewById(R.id.network_offline_view);
                            if (viewStub6 != null) {
                                i2 = R.id.pb_update_loading;
                                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.pb_update_loading);
                                if (linearLayout != null) {
                                    i2 = R.id.reading_add_rack_view;
                                    ViewStub viewStub7 = (ViewStub) rootView.findViewById(R.id.reading_add_rack_view);
                                    if (viewStub7 != null) {
                                        i2 = R.id.reading_bonus;
                                        View findViewById = rootView.findViewById(R.id.reading_bonus);
                                        if (findViewById != null) {
                                            r5 a2 = r5.a(findViewById);
                                            i2 = R.id.reading_bottom_bar;
                                            ViewStub viewStub8 = (ViewStub) rootView.findViewById(R.id.reading_bottom_bar);
                                            if (viewStub8 != null) {
                                                i2 = R.id.reading_color_picker;
                                                ViewStub viewStub9 = (ViewStub) rootView.findViewById(R.id.reading_color_picker);
                                                if (viewStub9 != null) {
                                                    i2 = R.id.reading_exit_dialog;
                                                    ViewStub viewStub10 = (ViewStub) rootView.findViewById(R.id.reading_exit_dialog);
                                                    if (viewStub10 != null) {
                                                        i2 = R.id.reading_left_drawer;
                                                        ViewStub viewStub11 = (ViewStub) rootView.findViewById(R.id.reading_left_drawer);
                                                        if (viewStub11 != null) {
                                                            i2 = R.id.reading_more_setting;
                                                            ViewStub viewStub12 = (ViewStub) rootView.findViewById(R.id.reading_more_setting);
                                                            if (viewStub12 != null) {
                                                                i2 = R.id.reading_scroll_container;
                                                                View findViewById2 = rootView.findViewById(R.id.reading_scroll_container);
                                                                if (findViewById2 != null) {
                                                                    j6 a3 = j6.a(findViewById2);
                                                                    i2 = R.id.reading_slide_mode;
                                                                    ViewStub viewStub13 = (ViewStub) rootView.findViewById(R.id.reading_slide_mode);
                                                                    if (viewStub13 != null) {
                                                                        i2 = R.id.reading_timing;
                                                                        ViewStub viewStub14 = (ViewStub) rootView.findViewById(R.id.reading_timing);
                                                                        if (viewStub14 != null) {
                                                                            i2 = R.id.reading_top_bar;
                                                                            ViewStub viewStub15 = (ViewStub) rootView.findViewById(R.id.reading_top_bar);
                                                                            if (viewStub15 != null) {
                                                                                i2 = R.id.reading_type_face;
                                                                                ViewStub viewStub16 = (ViewStub) rootView.findViewById(R.id.reading_type_face);
                                                                                if (viewStub16 != null) {
                                                                                    i2 = R.id.rl_main_container;
                                                                                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl_main_container);
                                                                                    if (relativeLayout != null) {
                                                                                        i2 = R.id.slide_guide_view;
                                                                                        ViewStub viewStub17 = (ViewStub) rootView.findViewById(R.id.slide_guide_view);
                                                                                        if (viewStub17 != null) {
                                                                                            i2 = R.id.status_bar_view;
                                                                                            View findViewById3 = rootView.findViewById(R.id.status_bar_view);
                                                                                            if (findViewById3 != null) {
                                                                                                i2 = R.id.tv_loading_icon;
                                                                                                ImageView imageView = (ImageView) rootView.findViewById(R.id.tv_loading_icon);
                                                                                                if (imageView != null) {
                                                                                                    i2 = R.id.tv_loading_text;
                                                                                                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_loading_text);
                                                                                                    if (readerThemeTextView != null) {
                                                                                                        return new p((DrawerLayout) rootView, drawerLayout, viewStub, viewStub2, viewStub3, viewStub4, viewStub5, viewStub6, linearLayout, viewStub7, a2, viewStub8, viewStub9, viewStub10, viewStub11, viewStub12, a3, viewStub13, viewStub14, viewStub15, viewStub16, relativeLayout, viewStub17, findViewById3, imageView, readerThemeTextView);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_reading, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public DrawerLayout getRoot() {
        return this.f12501a;
    }
}
