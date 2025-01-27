package com.martian.mibook.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.ttbookhd.R;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class y2 {
    private static void a(final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem, LinearLayout parentView) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_book_list_item, (ViewGroup) null);
        com.martian.mibook.e.q1 a2 = com.martian.mibook.e.q1.a(inflate);
        int B0 = activity.B0() < com.martian.libmars.d.h.b(360.0f) ? (activity.B0() - com.martian.libmars.d.h.b(24.0f)) / 2 : 0;
        if (B0 > 0) {
            a2.f12555d.getLayoutParams().width = B0;
        }
        a2.f12554c.setText(tyBookItem.getTitle());
        MiBookManager.d2(activity, tyBookItem, a2.f12553b);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y2.l(com.martian.libmars.activity.j1.this, tyBookItem, view);
            }
        });
        parentView.addView(inflate);
    }

    public static void b(com.martian.libmars.activity.j1 activity, List<TYBookItem> tyBookItems, LinearLayout gridTopView) {
        if (gridTopView == null || tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        gridTopView.removeAllViews();
        if (tyBookItems.size() > 0) {
            a(activity, tyBookItems.get(0), gridTopView);
        }
        if (tyBookItems.size() > 1) {
            a(activity, tyBookItems.get(1), gridTopView);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public static void c(LinearLayout parentView, final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem, int position) {
        if (parentView == null || tyBookItem == null || !com.martian.libmars.utils.n0.C(activity)) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_rank_item, (ViewGroup) null);
        com.martian.mibook.e.b2 a2 = com.martian.mibook.e.b2.a(inflate);
        MiBookManager.d2(activity, tyBookItem, a2.f11735d);
        if (!TextUtils.isEmpty(tyBookItem.getTitle())) {
            a2.f11734c.setText(tyBookItem.getTitle());
        }
        if (!com.martian.libsupport.k.p(tyBookItem.getRecTitle())) {
            a2.f11733b.setText(tyBookItem.getRecTitle());
        }
        a2.f11736e.setText("" + (position + 1));
        if (position == 0) {
            a2.f11736e.setTextColor(ContextCompat.getColor(activity, R.color.search_rank_1));
        } else if (position == 1) {
            a2.f11736e.setTextColor(ContextCompat.getColor(activity, R.color.search_rank_2));
        } else if (position == 2) {
            a2.f11736e.setTextColor(ContextCompat.getColor(activity, R.color.search_rank_3));
        } else {
            a2.f11736e.setTextColor(com.martian.libmars.d.h.F().r0());
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.U(com.martian.libmars.activity.j1.this, tyBookItem);
            }
        });
        parentView.addView(inflate);
    }

    public static void d(com.martian.libmars.activity.j1 activity, List<TYBookItem> tyBookItems, LinearLayout gridLeftView, LinearLayout gridRightView) {
        if (gridLeftView == null || gridRightView == null || tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        gridLeftView.removeAllViews();
        gridRightView.removeAllViews();
        for (int i2 = 0; i2 < tyBookItems.size(); i2++) {
            TYBookItem tYBookItem = tyBookItems.get(i2);
            if (tYBookItem != null) {
                if (i2 > 7) {
                    return;
                } else {
                    c(i2 % 2 == 0 ? gridLeftView : gridRightView, activity, tYBookItem, i2);
                }
            }
        }
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    public static void e(LinearLayout parentView, final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem, final Integer price, boolean isFree) {
        if (parentView == null || tyBookItem == null || !com.martian.libmars.utils.n0.C(activity) || parentView.findViewWithTag(tyBookItem.getSourceString()) != null) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_grid_item_card, (ViewGroup) null);
        inflate.setTag(tyBookItem.getSourceString());
        com.martian.mibook.e.s1 a2 = com.martian.mibook.e.s1.a(inflate);
        int B0 = activity.B0() < com.martian.libmars.d.h.b(360.0f) ? (activity.B0() - com.martian.libmars.d.h.b(20.0f)) / 4 : 0;
        if (B0 > 0) {
            a2.f12658h.getLayoutParams().width = B0;
            a2.f12659i.getLayoutParams().height = (((B0 - com.martian.libmars.d.h.b(12.0f)) * 98) / 73) + com.martian.libmars.d.h.b(8.0f);
        }
        MiBookManager.d2(activity, tyBookItem, a2.f12653c);
        if (!TextUtils.isEmpty(tyBookItem.getTitle())) {
            a2.f12655e.setText(tyBookItem.getTitle());
        }
        if (isFree) {
            a2.f12652b.setVisibility(8);
            a2.f12656f.setVisibility(8);
            a2.f12654d.setVisibility(0);
            if (tyBookItem.getPrice() > 0) {
                a2.f12657g.setVisibility(0);
                a2.f12657g.setText("" + (tyBookItem.getPrice() / 100) + "元");
                a2.f12657g.getPaint().setFlags(16);
            } else {
                a2.f12657g.setVisibility(8);
            }
        } else if (tyBookItem.getScore() > 0) {
            a2.f12652b.setVisibility(8);
            a2.f12656f.setVisibility(0);
            a2.f12654d.setVisibility(8);
            TextView textView = a2.f12656f;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.getDefault();
            double score = tyBookItem.getScore();
            Double.isNaN(score);
            sb.append(String.format(locale, "%.1f", Double.valueOf(score / 10.0d)));
            sb.append("分");
            textView.setText(sb.toString());
        } else {
            if (com.martian.libsupport.k.p(tyBookItem.getRecTitle())) {
                a2.f12652b.setVisibility(8);
            } else {
                a2.f12652b.setVisibility(0);
                a2.f12652b.setText(tyBookItem.getRecTitle());
            }
            a2.f12656f.setVisibility(8);
            a2.f12654d.setVisibility(8);
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y2.n(price, tyBookItem, activity, view);
            }
        });
        a2.f12653c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y2.o(price, tyBookItem, activity, view);
            }
        });
        parentView.addView(inflate);
    }

    public static void f(com.martian.libmars.activity.j1 activity, List<TYBookItem> tyBookItems, LinearLayout gridTopView, boolean isFree, int index, boolean cardView) {
        if (gridTopView == null || tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        gridTopView.removeAllViews();
        int i2 = 0;
        while (index < tyBookItems.size()) {
            TYBookItem tYBookItem = tyBookItems.get(index);
            if (tYBookItem != null) {
                if (i2 > 3) {
                    return;
                }
                if (cardView) {
                    e(gridTopView, activity, tYBookItem, null, isFree);
                } else {
                    g(gridTopView, activity, tYBookItem, null, isFree);
                }
                i2++;
            }
            index++;
        }
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    public static void g(LinearLayout parentView, final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem, final Integer price, boolean isFree) {
        if (parentView == null || tyBookItem == null || !com.martian.libmars.utils.n0.C(activity) || parentView.findViewWithTag(tyBookItem.getSourceString()) != null) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_grid_item, (ViewGroup) null);
        inflate.setTag(tyBookItem.getSourceString());
        com.martian.mibook.e.r1 a2 = com.martian.mibook.e.r1.a(inflate);
        int B0 = activity.B0() < com.martian.libmars.d.h.b(360.0f) ? (activity.B0() - com.martian.libmars.d.h.b(20.0f)) / 4 : 0;
        if (B0 > 0) {
            a2.f12600h.getLayoutParams().width = B0;
            a2.f12601i.getLayoutParams().height = (((B0 - com.martian.libmars.d.h.b(12.0f)) * 98) / 73) + com.martian.libmars.d.h.b(8.0f);
        }
        MiBookManager.d2(activity, tyBookItem, a2.f12595c);
        if (!TextUtils.isEmpty(tyBookItem.getTitle())) {
            a2.f12597e.setText(tyBookItem.getTitle());
        }
        if (isFree) {
            a2.f12594b.setVisibility(8);
            a2.f12598f.setVisibility(8);
            a2.f12596d.setVisibility(0);
            if (tyBookItem.getPrice() > 0) {
                a2.f12599g.setVisibility(0);
                a2.f12599g.setText("" + (tyBookItem.getPrice() / 100) + "元");
                a2.f12599g.getPaint().setFlags(16);
            } else {
                a2.f12599g.setVisibility(8);
            }
        } else if (tyBookItem.getScore() > 0) {
            a2.f12594b.setVisibility(8);
            a2.f12598f.setVisibility(0);
            a2.f12596d.setVisibility(8);
            TextView textView = a2.f12598f;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.getDefault();
            double score = tyBookItem.getScore();
            Double.isNaN(score);
            sb.append(String.format(locale, "%.1f", Double.valueOf(score / 10.0d)));
            sb.append("分");
            textView.setText(sb.toString());
        } else {
            if (com.martian.libsupport.k.p(tyBookItem.getRecTitle())) {
                a2.f12594b.setVisibility(8);
            } else {
                a2.f12594b.setVisibility(0);
                a2.f12594b.setText(tyBookItem.getRecTitle());
            }
            a2.f12598f.setVisibility(8);
            a2.f12596d.setVisibility(8);
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y2.p(price, tyBookItem, activity, view);
            }
        });
        a2.f12595c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y2.q(price, tyBookItem, activity, view);
            }
        });
        parentView.addView(inflate);
    }

    @SuppressLint({"SetTextI18n"})
    public static void h(LinearLayout parentView, final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem) {
        if (parentView == null || tyBookItem == null || !com.martian.libmars.utils.n0.C(activity)) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_six_item, (ViewGroup) null);
        com.martian.mibook.e.c2 a2 = com.martian.mibook.e.c2.a(inflate);
        MiBookManager.d2(activity, tyBookItem, a2.f11787e);
        if (!TextUtils.isEmpty(tyBookItem.getTitle())) {
            a2.f11785c.setText(tyBookItem.getTitle());
        }
        if (!com.martian.libsupport.k.p(tyBookItem.getRecTitle())) {
            a2.f11784b.setText(tyBookItem.getRecTitle());
        }
        if (tyBookItem.getScore() > 0) {
            a2.f11786d.setVisibility(0);
            TextView textView = a2.f11786d;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.getDefault();
            double score = tyBookItem.getScore();
            Double.isNaN(score);
            sb.append(String.format(locale, "%.1f", Double.valueOf(score / 10.0d)));
            sb.append("分");
            textView.setText(sb.toString());
        } else {
            a2.f11786d.setVisibility(8);
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s2.U(com.martian.libmars.activity.j1.this, tyBookItem);
            }
        });
        parentView.addView(inflate);
    }

    public static void i(com.martian.libmars.activity.j1 activity, List<TYBookItem> tyBookItems, LinearLayout gridLeftView, LinearLayout gridRightView, int index) {
        if (gridLeftView == null || gridRightView == null || tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        gridLeftView.removeAllViews();
        gridRightView.removeAllViews();
        int i2 = 0;
        while (index < tyBookItems.size()) {
            TYBookItem tYBookItem = tyBookItems.get(index);
            if (tYBookItem != null) {
                if (i2 > 5) {
                    return;
                }
                h(i2 <= 2 ? gridLeftView : gridRightView, activity, tYBookItem);
                i2++;
            }
            index++;
        }
    }

    public static void j(com.martian.libmars.activity.j1 activity, LinearLayout categoryView, List<TYBookItem> tyBookItems, boolean infinite) {
        if (categoryView == null || tyBookItems == null || tyBookItems.isEmpty()) {
            return;
        }
        categoryView.removeAllViews();
        int i2 = 0;
        for (TYBookItem tYBookItem : tyBookItems) {
            if (!infinite && i2 > 2) {
                return;
            }
            k(categoryView, activity, tYBookItem, null);
            i2++;
        }
    }

    @SuppressLint({"SetTextI18n"})
    public static void k(LinearLayout parentView, final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem, final Integer price) {
        if (parentView == null || tyBookItem == null) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_item_card, (ViewGroup) null);
        com.martian.mibook.e.u1 a2 = com.martian.mibook.e.u1.a(inflate);
        if (tyBookItem.getScore() > 0) {
            a2.f12767f.setVisibility(0);
            double score = tyBookItem.getScore();
            Double.isNaN(score);
            a2.f12767f.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(score / 10.0d)) + "分");
        } else {
            a2.f12767f.setVisibility(8);
        }
        MiBookManager.d2(activity, tyBookItem, a2.f12766e);
        if (!TextUtils.isEmpty(tyBookItem.getTitle())) {
            a2.f12765d.setText(tyBookItem.getTitle());
        }
        a2.f12764c.setText(tyBookItem.getRecTitle());
        if (!TextUtils.isEmpty(tyBookItem.getIntro())) {
            a2.f12768g.setText(com.martian.libsupport.k.v(tyBookItem.getIntro()));
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.j.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y2.s(price, tyBookItem, activity, view);
            }
        });
        parentView.addView(inflate);
    }

    static /* synthetic */ void l(final com.martian.libmars.activity.j1 activity, final TYBookItem tyBookItem, View v) {
        if (com.martian.apptask.g.g.b(activity, tyBookItem.getDeeplink())) {
            com.martian.apptask.g.g.u(activity, tyBookItem.getDeeplink(), "", "", true);
        } else if (com.martian.libsupport.k.p(tyBookItem.getUrl())) {
            s2.U(activity, tyBookItem);
        } else {
            MiWebViewActivity.f5(activity, tyBookItem.getUrl());
        }
    }

    static /* synthetic */ void n(final Integer price, final TYBookItem tyBookItem, final com.martian.libmars.activity.j1 activity, View v) {
        if (price != null) {
            tyBookItem.setPrice(price);
        }
        s2.U(activity, tyBookItem);
    }

    static /* synthetic */ void o(final Integer price, final TYBookItem tyBookItem, final com.martian.libmars.activity.j1 activity, View v) {
        if (price != null) {
            tyBookItem.setPrice(price);
        }
        s2.U(activity, tyBookItem);
    }

    static /* synthetic */ void p(final Integer price, final TYBookItem tyBookItem, final com.martian.libmars.activity.j1 activity, View v) {
        if (price != null) {
            tyBookItem.setPrice(price);
        }
        s2.U(activity, tyBookItem);
    }

    static /* synthetic */ void q(final Integer price, final TYBookItem tyBookItem, final com.martian.libmars.activity.j1 activity, View v) {
        if (price != null) {
            tyBookItem.setPrice(price);
        }
        s2.U(activity, tyBookItem);
    }

    static /* synthetic */ void s(final Integer price, final TYBookItem tyBookItem, final com.martian.libmars.activity.j1 activity, View v) {
        if (price != null) {
            tyBookItem.setPrice(price);
        }
        s2.U(activity, tyBookItem);
    }
}
