package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h3 implements ViewBinding {

    @NonNull
    public final LinearLayout A;

    @NonNull
    public final ImageView B;

    @NonNull
    public final ThemeTextView C;

    @NonNull
    public final LinearLayout D;

    /* renamed from: a */
    @NonNull
    private final ScrollView f12058a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12059b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f12060c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12061d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12062e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12063f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12064g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12065h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12066i;

    /* renamed from: j */
    @NonNull
    public final ImageView f12067j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final TextView s;

    @NonNull
    public final TextView t;

    @NonNull
    public final ImageView u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final CountUpTextView w;

    @NonNull
    public final CountUpTextView x;

    @NonNull
    public final TextView y;

    @NonNull
    public final CountUpTextView z;

    private h3(@NonNull ScrollView rootView, @NonNull LinearLayout bonusSign, @NonNull RecyclerView bonusSignRecyclerView, @NonNull LinearLayout mcBonus1, @NonNull LinearLayout mcBonus2, @NonNull LinearLayout mcBonus3, @NonNull LinearLayout mcBonus4, @NonNull ImageView mcBonusActivity, @NonNull ImageView mcBonusBg1, @NonNull ImageView mcBonusBg2, @NonNull ImageView mcBonusBg3, @NonNull ImageView mcBonusBg4, @NonNull TextView mcBonusNum1, @NonNull TextView mcBonusNum2, @NonNull TextView mcBonusNum3, @NonNull TextView mcBonusNum4, @NonNull TextView mcBonusTitle1, @NonNull TextView mcBonusTitle2, @NonNull TextView mcBonusTitle3, @NonNull TextView mcBonusTitle4, @NonNull ImageView mcHeaderBg, @NonNull LinearLayout mcHeaderView, @NonNull CountUpTextView mcIncomeCoins, @NonNull CountUpTextView mcIncomeCommission, @NonNull TextView mcIncomeCommissionTitle, @NonNull CountUpTextView mcIncomeMoney, @NonNull LinearLayout mcIncomeView, @NonNull ImageView mcSignNotifySwitch, @NonNull ThemeTextView mcSignTitle, @NonNull LinearLayout missionItems) {
        this.f12058a = rootView;
        this.f12059b = bonusSign;
        this.f12060c = bonusSignRecyclerView;
        this.f12061d = mcBonus1;
        this.f12062e = mcBonus2;
        this.f12063f = mcBonus3;
        this.f12064g = mcBonus4;
        this.f12065h = mcBonusActivity;
        this.f12066i = mcBonusBg1;
        this.f12067j = mcBonusBg2;
        this.k = mcBonusBg3;
        this.l = mcBonusBg4;
        this.m = mcBonusNum1;
        this.n = mcBonusNum2;
        this.o = mcBonusNum3;
        this.p = mcBonusNum4;
        this.q = mcBonusTitle1;
        this.r = mcBonusTitle2;
        this.s = mcBonusTitle3;
        this.t = mcBonusTitle4;
        this.u = mcHeaderBg;
        this.v = mcHeaderView;
        this.w = mcIncomeCoins;
        this.x = mcIncomeCommission;
        this.y = mcIncomeCommissionTitle;
        this.z = mcIncomeMoney;
        this.A = mcIncomeView;
        this.B = mcSignNotifySwitch;
        this.C = mcSignTitle;
        this.D = missionItems;
    }

    @NonNull
    public static h3 a(@NonNull View rootView) {
        int i2 = R.id.bonus_sign;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bonus_sign);
        if (linearLayout != null) {
            i2 = R.id.bonus_sign_recycler_view;
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.bonus_sign_recycler_view);
            if (recyclerView != null) {
                i2 = R.id.mc_bonus_1;
                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.mc_bonus_1);
                if (linearLayout2 != null) {
                    i2 = R.id.mc_bonus_2;
                    LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.mc_bonus_2);
                    if (linearLayout3 != null) {
                        i2 = R.id.mc_bonus_3;
                        LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.mc_bonus_3);
                        if (linearLayout4 != null) {
                            i2 = R.id.mc_bonus_4;
                            LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.mc_bonus_4);
                            if (linearLayout5 != null) {
                                i2 = R.id.mc_bonus_activity;
                                ImageView imageView = (ImageView) rootView.findViewById(R.id.mc_bonus_activity);
                                if (imageView != null) {
                                    i2 = R.id.mc_bonus_bg_1;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.mc_bonus_bg_1);
                                    if (imageView2 != null) {
                                        i2 = R.id.mc_bonus_bg_2;
                                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.mc_bonus_bg_2);
                                        if (imageView3 != null) {
                                            i2 = R.id.mc_bonus_bg_3;
                                            ImageView imageView4 = (ImageView) rootView.findViewById(R.id.mc_bonus_bg_3);
                                            if (imageView4 != null) {
                                                i2 = R.id.mc_bonus_bg_4;
                                                ImageView imageView5 = (ImageView) rootView.findViewById(R.id.mc_bonus_bg_4);
                                                if (imageView5 != null) {
                                                    i2 = R.id.mc_bonus_num_1;
                                                    TextView textView = (TextView) rootView.findViewById(R.id.mc_bonus_num_1);
                                                    if (textView != null) {
                                                        i2 = R.id.mc_bonus_num_2;
                                                        TextView textView2 = (TextView) rootView.findViewById(R.id.mc_bonus_num_2);
                                                        if (textView2 != null) {
                                                            i2 = R.id.mc_bonus_num_3;
                                                            TextView textView3 = (TextView) rootView.findViewById(R.id.mc_bonus_num_3);
                                                            if (textView3 != null) {
                                                                i2 = R.id.mc_bonus_num_4;
                                                                TextView textView4 = (TextView) rootView.findViewById(R.id.mc_bonus_num_4);
                                                                if (textView4 != null) {
                                                                    i2 = R.id.mc_bonus_title_1;
                                                                    TextView textView5 = (TextView) rootView.findViewById(R.id.mc_bonus_title_1);
                                                                    if (textView5 != null) {
                                                                        i2 = R.id.mc_bonus_title_2;
                                                                        TextView textView6 = (TextView) rootView.findViewById(R.id.mc_bonus_title_2);
                                                                        if (textView6 != null) {
                                                                            i2 = R.id.mc_bonus_title_3;
                                                                            TextView textView7 = (TextView) rootView.findViewById(R.id.mc_bonus_title_3);
                                                                            if (textView7 != null) {
                                                                                i2 = R.id.mc_bonus_title_4;
                                                                                TextView textView8 = (TextView) rootView.findViewById(R.id.mc_bonus_title_4);
                                                                                if (textView8 != null) {
                                                                                    i2 = R.id.mc_header_bg;
                                                                                    ImageView imageView6 = (ImageView) rootView.findViewById(R.id.mc_header_bg);
                                                                                    if (imageView6 != null) {
                                                                                        i2 = R.id.mc_header_view;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.mc_header_view);
                                                                                        if (linearLayout6 != null) {
                                                                                            i2 = R.id.mc_income_coins;
                                                                                            CountUpTextView countUpTextView = (CountUpTextView) rootView.findViewById(R.id.mc_income_coins);
                                                                                            if (countUpTextView != null) {
                                                                                                i2 = R.id.mc_income_commission;
                                                                                                CountUpTextView countUpTextView2 = (CountUpTextView) rootView.findViewById(R.id.mc_income_commission);
                                                                                                if (countUpTextView2 != null) {
                                                                                                    i2 = R.id.mc_income_commission_title;
                                                                                                    TextView textView9 = (TextView) rootView.findViewById(R.id.mc_income_commission_title);
                                                                                                    if (textView9 != null) {
                                                                                                        i2 = R.id.mc_income_money;
                                                                                                        CountUpTextView countUpTextView3 = (CountUpTextView) rootView.findViewById(R.id.mc_income_money);
                                                                                                        if (countUpTextView3 != null) {
                                                                                                            i2 = R.id.mc_income_view;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) rootView.findViewById(R.id.mc_income_view);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i2 = R.id.mc_sign_notify_switch;
                                                                                                                ImageView imageView7 = (ImageView) rootView.findViewById(R.id.mc_sign_notify_switch);
                                                                                                                if (imageView7 != null) {
                                                                                                                    i2 = R.id.mc_sign_title;
                                                                                                                    ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.mc_sign_title);
                                                                                                                    if (themeTextView != null) {
                                                                                                                        i2 = R.id.mission_items;
                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) rootView.findViewById(R.id.mission_items);
                                                                                                                        if (linearLayout8 != null) {
                                                                                                                            return new h3((ScrollView) rootView, linearLayout, recyclerView, linearLayout2, linearLayout3, linearLayout4, linearLayout5, imageView, imageView2, imageView3, imageView4, imageView5, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageView6, linearLayout6, countUpTextView, countUpTextView2, textView9, countUpTextView3, linearLayout7, imageView7, themeTextView, linearLayout8);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_mission_center, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f12058a;
    }
}
