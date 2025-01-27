package je;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.BsBookStoreGridItemBinding;
import com.martian.mibook.databinding.BsBookStoreGridItemCardBinding;
import com.martian.mibook.databinding.BsBookStoreItemCardBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class f1 {
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public static void f(LinearLayout linearLayout, Activity activity, TYBookItem tYBookItem, Integer num, boolean z10) {
        if (linearLayout == null || tYBookItem == null || !l9.m0.C(activity) || linearLayout.findViewWithTag(tYBookItem.getSourceString()) != null) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_grid_item_card, (ViewGroup) null);
        inflate.setTag(tYBookItem.getSourceString());
        BsBookStoreGridItemCardBinding bind = BsBookStoreGridItemCardBinding.bind(inflate);
        int i10 = ba.m.i(activity) < ConfigSingleton.i(360.0f) ? (ba.m.i(activity) - ConfigSingleton.i(20.0f)) / 4 : 0;
        if (i10 > 0) {
            bind.gridItemView.getLayoutParams().width = i10;
            bind.gridViewCover.getLayoutParams().height = (((i10 - ConfigSingleton.i(12.0f)) * 98) / 73) + ConfigSingleton.i(8.0f);
        }
        MiBookManager.s1(activity, tYBookItem, bind.bsBookCover);
        if (!TextUtils.isEmpty(tYBookItem.getTitle())) {
            bind.bsBookName.setText(tYBookItem.getTitle());
        }
        if (z10) {
            bind.bsBookCategory.setVisibility(8);
            bind.bsBookScore.setVisibility(8);
            bind.bsBookFreeView.setVisibility(0);
            if (tYBookItem.getPrice() > 0) {
                bind.bsFreeBookPrice.setVisibility(0);
                bind.bsFreeBookPrice.setText("" + (tYBookItem.getPrice() / 100) + "元");
                bind.bsFreeBookPrice.getPaint().setFlags(16);
            } else {
                bind.bsFreeBookPrice.setVisibility(8);
            }
        } else if (tYBookItem.getScore() > 0) {
            bind.bsBookCategory.setVisibility(8);
            bind.bsBookScore.setVisibility(0);
            bind.bsBookFreeView.setVisibility(8);
            bind.bsBookScore.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(tYBookItem.getScore() / 10.0d)) + "分");
        } else {
            if (ba.l.q(tYBookItem.getRecTitle())) {
                bind.bsBookCategory.setVisibility(8);
            } else {
                bind.bsBookCategory.setVisibility(0);
                bind.bsBookCategory.setText(tYBookItem.getRecTitle());
            }
            bind.bsBookScore.setVisibility(8);
            bind.bsBookFreeView.setVisibility(8);
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: je.d1

            /* renamed from: b */
            public final /* synthetic */ Integer f27400b;

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f27401c;

            /* renamed from: d */
            public final /* synthetic */ Activity f27402d;

            public /* synthetic */ d1(Integer num2, TYBookItem tYBookItem2, Activity activity2) {
                num = num2;
                tYBookItem = tYBookItem2;
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.j(num, tYBookItem, activity, view);
            }
        });
        bind.bsBookCover.setOnClickListener(new View.OnClickListener() { // from class: je.e1

            /* renamed from: b */
            public final /* synthetic */ Integer f27407b;

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f27408c;

            /* renamed from: d */
            public final /* synthetic */ Activity f27409d;

            public /* synthetic */ e1(Integer num2, TYBookItem tYBookItem2, Activity activity2) {
                num = num2;
                tYBookItem = tYBookItem2;
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.k(num, tYBookItem, activity, view);
            }
        });
        linearLayout.addView(inflate);
    }

    public static void g(Activity activity, List<TYBookItem> list, LinearLayout linearLayout, boolean z10, int i10, boolean z11) {
        if (linearLayout == null || list == null || list.isEmpty()) {
            return;
        }
        linearLayout.removeAllViews();
        int i11 = 0;
        while (i10 < list.size()) {
            TYBookItem tYBookItem = list.get(i10);
            if (tYBookItem != null) {
                if (i11 > 3) {
                    return;
                }
                if (z11) {
                    f(linearLayout, activity, tYBookItem, null, z10);
                } else {
                    h(linearLayout, activity, tYBookItem, null, z10);
                }
                i11++;
            }
            i10++;
        }
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    public static void h(LinearLayout linearLayout, Activity activity, TYBookItem tYBookItem, Integer num, boolean z10) {
        if (linearLayout == null || tYBookItem == null || !l9.m0.C(activity) || linearLayout.findViewWithTag(tYBookItem.getSourceString()) != null) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_grid_item, (ViewGroup) null);
        inflate.setTag(tYBookItem.getSourceString());
        BsBookStoreGridItemBinding bind = BsBookStoreGridItemBinding.bind(inflate);
        int i10 = ba.m.i(activity) < ConfigSingleton.i(360.0f) ? (ba.m.i(activity) - ConfigSingleton.i(20.0f)) / 4 : 0;
        if (i10 > 0) {
            bind.gridItemView.getLayoutParams().width = i10;
            bind.gridViewCover.getLayoutParams().height = (((i10 - ConfigSingleton.i(12.0f)) * 98) / 73) + ConfigSingleton.i(8.0f);
        }
        MiBookManager.s1(activity, tYBookItem, bind.bsBookCover);
        if (!TextUtils.isEmpty(tYBookItem.getTitle())) {
            bind.bsBookName.setText(tYBookItem.getTitle());
        }
        if (z10) {
            bind.bsBookCategory.setVisibility(8);
            bind.bsBookScore.setVisibility(8);
            bind.bsBookFreeView.setVisibility(0);
            if (tYBookItem.getPrice() > 0) {
                bind.bsFreeBookPrice.setVisibility(0);
                bind.bsFreeBookPrice.setText("" + (tYBookItem.getPrice() / 100) + "元");
                bind.bsFreeBookPrice.getPaint().setFlags(16);
            } else {
                bind.bsFreeBookPrice.setVisibility(8);
            }
        } else if (tYBookItem.getScore() > 0) {
            bind.bsBookCategory.setVisibility(8);
            bind.bsBookScore.setVisibility(0);
            bind.bsBookFreeView.setVisibility(8);
            bind.bsBookScore.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(tYBookItem.getScore() / 10.0d)) + "分");
        } else {
            if (ba.l.q(tYBookItem.getRecTitle())) {
                bind.bsBookCategory.setVisibility(8);
            } else {
                bind.bsBookCategory.setVisibility(0);
                bind.bsBookCategory.setText(tYBookItem.getRecTitle());
            }
            bind.bsBookScore.setVisibility(8);
            bind.bsBookFreeView.setVisibility(8);
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: je.a1

            /* renamed from: b */
            public final /* synthetic */ Integer f27377b;

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f27378c;

            /* renamed from: d */
            public final /* synthetic */ Activity f27379d;

            public /* synthetic */ a1(Integer num2, TYBookItem tYBookItem2, Activity activity2) {
                num = num2;
                tYBookItem = tYBookItem2;
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.l(num, tYBookItem, activity, view);
            }
        });
        bind.bsBookCover.setOnClickListener(new View.OnClickListener() { // from class: je.b1

            /* renamed from: b */
            public final /* synthetic */ Integer f27384b;

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f27385c;

            /* renamed from: d */
            public final /* synthetic */ Activity f27386d;

            public /* synthetic */ b1(Integer num2, TYBookItem tYBookItem2, Activity activity2) {
                num = num2;
                tYBookItem = tYBookItem2;
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.m(num, tYBookItem, activity, view);
            }
        });
        linearLayout.addView(inflate);
    }

    @SuppressLint({"SetTextI18n"})
    public static void i(LinearLayout linearLayout, Activity activity, TYBookItem tYBookItem, Integer num) {
        if (linearLayout == null || tYBookItem == null) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.bs_book_store_item_card, (ViewGroup) null);
        BsBookStoreItemCardBinding bind = BsBookStoreItemCardBinding.bind(inflate);
        if (tYBookItem.getScore() > 0) {
            bind.bsListScore.setVisibility(0);
            TextView textView = bind.bsListScore;
            textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(tYBookItem.getScore() / 10.0d)) + "分");
        } else {
            bind.bsListScore.setVisibility(8);
        }
        MiBookManager.s1(activity, tYBookItem, bind.bsListCover);
        if (!TextUtils.isEmpty(tYBookItem.getTitle())) {
            bind.bsListBookName.setText(tYBookItem.getTitle());
        }
        bind.bsListAuthorName.setText(tYBookItem.getRecTitle());
        if (!TextUtils.isEmpty(tYBookItem.getIntro())) {
            bind.bsListShortContent.setText(ba.l.y(tYBookItem.getIntro()));
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: je.c1

            /* renamed from: b */
            public final /* synthetic */ Integer f27392b;

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f27393c;

            /* renamed from: d */
            public final /* synthetic */ Activity f27394d;

            public /* synthetic */ c1(Integer num2, TYBookItem tYBookItem2, Activity activity2) {
                num = num2;
                tYBookItem = tYBookItem2;
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.n(num, tYBookItem, activity, view);
            }
        });
        linearLayout.addView(inflate);
    }

    public static /* synthetic */ void j(Integer num, TYBookItem tYBookItem, Activity activity, View view) {
        if (num != null) {
            tYBookItem.setPrice(num);
        }
        i.H(activity, tYBookItem);
    }

    public static /* synthetic */ void k(Integer num, TYBookItem tYBookItem, Activity activity, View view) {
        if (num != null) {
            tYBookItem.setPrice(num);
        }
        i.H(activity, tYBookItem);
    }

    public static /* synthetic */ void l(Integer num, TYBookItem tYBookItem, Activity activity, View view) {
        if (num != null) {
            tYBookItem.setPrice(num);
        }
        i.H(activity, tYBookItem);
    }

    public static /* synthetic */ void m(Integer num, TYBookItem tYBookItem, Activity activity, View view) {
        if (num != null) {
            tYBookItem.setPrice(num);
        }
        i.H(activity, tYBookItem);
    }

    public static /* synthetic */ void n(Integer num, TYBookItem tYBookItem, Activity activity, View view) {
        if (num != null) {
            tYBookItem.setPrice(num);
        }
        i.H(activity, tYBookItem);
    }
}
