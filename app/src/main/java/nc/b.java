package nc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemSearchRankBookBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class b extends BaseAdapter {

    /* renamed from: b */
    @k
    public final Context f28843b;

    /* renamed from: c */
    @k
    public final List<TYBookItem> f28844c;

    /* renamed from: d */
    @k
    public final Set<String> f28845d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k Context context, @k List<? extends TYBookItem> dataList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.f28843b = context;
        this.f28844c = dataList;
        this.f28845d = new LinkedHashSet();
    }

    @Override // android.widget.Adapter
    @k
    /* renamed from: a */
    public TYBookItem getItem(int i10) {
        return this.f28844c.get(i10);
    }

    @k
    public final TYBookItem b(int i10) {
        return this.f28844c.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f28844c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @k
    @SuppressLint({"SetTextI18n"})
    public View getView(int i10, @l View view, @k ViewGroup parent) {
        ItemSearchRankBookBinding itemSearchRankBookBinding;
        ThemeTextView themeTextView;
        TextView textView;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (view == null) {
            view = LayoutInflater.from(this.f28843b).inflate(R.layout.item_search_rank_book, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
            itemSearchRankBookBinding = ItemSearchRankBookBinding.bind(view);
            view.setTag(itemSearchRankBookBinding);
        } else {
            Object tag = view.getTag();
            itemSearchRankBookBinding = tag instanceof ItemSearchRankBookBinding ? (ItemSearchRankBookBinding) tag : null;
        }
        if (itemSearchRankBookBinding != null && (textView = itemSearchRankBookBinding.tvRankIndex) != null) {
            textView.setTextColor(i10 != 0 ? i10 != 1 ? i10 != 2 ? ConfigSingleton.D().j0() : ContextCompat.getColor(this.f28843b, R.color.book_mall_rank_3) : ContextCompat.getColor(this.f28843b, R.color.book_mall_rank_2) : ContextCompat.getColor(this.f28843b, R.color.book_mall_rank_1));
        }
        TextView textView2 = itemSearchRankBookBinding != null ? itemSearchRankBookBinding.tvRankIndex : null;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i10 + 1));
        }
        TYBookItem item = getItem(i10);
        ThemeTextView themeTextView2 = itemSearchRankBookBinding != null ? itemSearchRankBookBinding.tvRankBookName : null;
        if (themeTextView2 != null) {
            themeTextView2.setText(ExtKt.c(item.getBookName()));
        }
        if (itemSearchRankBookBinding != null && (themeTextView = itemSearchRankBookBinding.tvRankBookName) != null) {
            themeTextView.setBackgroundResource(com.martian.libmars.R.color.transparent);
        }
        ThemeTextView themeTextView3 = itemSearchRankBookBinding != null ? itemSearchRankBookBinding.tvRankBookDes : null;
        if (themeTextView3 != null) {
            themeTextView3.setText(ExtKt.c(item.getCategoryInfo()));
        }
        MiBookManager.u1(this.f28843b, item, itemSearchRankBookBinding != null ? itemSearchRankBookBinding.bookCover : null);
        Set<String> set = this.f28845d;
        String sourceId = item.getSourceId();
        Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
        if (set.add(sourceId)) {
            MiConfigSingleton.b2().V1().g(0, item.getSourceName(), item.getSourceId(), item.getRecommendId(), "", "展示");
        }
        return view;
    }
}
