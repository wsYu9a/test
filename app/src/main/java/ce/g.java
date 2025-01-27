package ce;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ArchiveListItemBinding;
import com.martian.mibook.databinding.PopupwindowListBinding;
import com.martian.mibook.databinding.PopupwindowListItemBinding;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.List;
import je.v0;
import l9.i0;
import l9.m0;
import l9.o0;
import l9.t0;

/* loaded from: classes3.dex */
public class g extends BaseAdapter {

    /* renamed from: b */
    public final Activity f1933b;

    /* renamed from: c */
    public List<MiArchiveBookItem> f1934c;

    /* renamed from: d */
    public final TextView f1935d;

    public class a implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ MiArchiveBookItem f1936a;

        public a(MiArchiveBookItem miArchiveBookItem) {
            this.f1936a = miArchiveBookItem;
        }

        @Override // xb.b
        public void a(Book book) {
            g.this.n(this.f1936a, book);
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
            if (z10) {
                t0.b(g.this.f1933b, ConfigSingleton.D().s("加载书籍信息中，请稍等"));
            }
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            t0.b(g.this.f1933b, ConfigSingleton.D().s("通信失败"));
        }
    }

    public g(Activity activity, List<MiArchiveBookItem> list, TextView textView) {
        this.f1933b = activity;
        this.f1934c = list;
        this.f1935d = textView;
    }

    public static /* synthetic */ boolean k(View view, PopupWindow popupWindow, View view2, MotionEvent motionEvent) {
        int top = view.findViewById(R.id.popupwindow_view).getTop();
        int y10 = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y10 < top) {
            popupWindow.dismiss();
        }
        return true;
    }

    public final View g(String str, int i10, MiArchiveBookItem miArchiveBookItem, PopupWindow popupWindow) {
        View inflate = View.inflate(this.f1933b, R.layout.popupwindow_list_item, null);
        PopupwindowListItemBinding bind = PopupwindowListItemBinding.bind(inflate);
        if (!ba.l.q(str)) {
            bind.popupwindowItemTitle.setText(str);
        }
        bind.popupwindowItemTitle.setOnClickListener(new View.OnClickListener() { // from class: ce.e

            /* renamed from: c */
            public final /* synthetic */ int f1928c;

            /* renamed from: d */
            public final /* synthetic */ MiArchiveBookItem f1929d;

            /* renamed from: e */
            public final /* synthetic */ PopupWindow f1930e;

            public /* synthetic */ e(int i102, MiArchiveBookItem miArchiveBookItem2, PopupWindow popupWindow2) {
                i10 = i102;
                miArchiveBookItem = miArchiveBookItem2;
                popupWindow = popupWindow2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.this.i(i10, miArchiveBookItem, popupWindow, view);
            }
        });
        return inflate;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MiArchiveBookItem> list = this.f1934c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1934c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ArchiveListItemBinding archiveListItemBinding;
        if (view == null) {
            view = LayoutInflater.from(this.f1933b).inflate(R.layout.archive_list_item, (ViewGroup) null);
            archiveListItemBinding = ArchiveListItemBinding.bind(view);
            view.setTag(archiveListItemBinding);
        } else {
            archiveListItemBinding = (ArchiveListItemBinding) view.getTag();
        }
        MiArchiveBookItem h10 = h(i10);
        archiveListItemBinding.tvBookname.setText(h10.getBookName());
        archiveListItemBinding.tvArchiveDate.setText(this.f1933b.getString(R.string.archive_time) + o0.p(h10.getArchiveDate()));
        archiveListItemBinding.tvAuthor.setText(!TextUtils.isEmpty(h10.getAuthor()) ? h10.getAuthor() : "");
        archiveListItemBinding.tvUrlOrChapter.setText(!TextUtils.isEmpty(h10.getLastestChapter()) ? h10.getLastestChapter() : h10.getBookUrl());
        if (TextUtils.isEmpty(h10.getCoverUrl())) {
            archiveListItemBinding.ivCover.setImageResource(R.drawable.cover_default);
        } else {
            m0.l(this.f1933b, h10.getCoverUrl(), archiveListItemBinding.ivCover, MiConfigSingleton.b2().L1());
        }
        archiveListItemBinding.ivPopupHint.setTag(Integer.valueOf(i10));
        archiveListItemBinding.ivPopupHint.setOnClickListener(new View.OnClickListener() { // from class: ce.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.this.j(view2);
            }
        });
        return view;
    }

    public MiArchiveBookItem h(int i10) {
        return this.f1934c.get(i10);
    }

    public final /* synthetic */ void i(int i10, MiArchiveBookItem miArchiveBookItem, PopupWindow popupWindow, View view) {
        if (i10 == 0) {
            q(miArchiveBookItem);
        } else if (i10 == 1) {
            je.i.H(this.f1933b, miArchiveBookItem);
        } else if (i10 == 2) {
            m(miArchiveBookItem);
        }
        popupWindow.dismiss();
    }

    public final /* synthetic */ void j(View view) {
        p(((Integer) view.getTag()).intValue());
    }

    public final /* synthetic */ void l(MiArchiveBookItem miArchiveBookItem) {
        MiConfigSingleton.b2().M1().u(miArchiveBookItem);
        t0.b(this.f1933b, ConfigSingleton.D().s("删除成功"));
        this.f1934c.remove(miArchiveBookItem);
        notifyDataSetChanged();
    }

    public final void m(MiArchiveBookItem miArchiveBookItem) {
        Book I = MiConfigSingleton.b2().M1().I(miArchiveBookItem);
        if (I != null) {
            n(miArchiveBookItem, I);
        } else {
            MiConfigSingleton.b2().M1().k(miArchiveBookItem, new a(miArchiveBookItem));
        }
    }

    public final void n(MiArchiveBookItem miArchiveBookItem, Book book) {
        if (MiConfigSingleton.b2().M1().g(this.f1933b, book) != null) {
            t0.b(this.f1933b, ConfigSingleton.D().s("移回成功"));
            MiConfigSingleton.b2().M1().w0(miArchiveBookItem);
            this.f1934c.remove(miArchiveBookItem);
            notifyDataSetChanged();
        }
    }

    public void o(List<MiArchiveBookItem> list) {
        this.f1934c = list;
        notifyDataSetChanged();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void p(int i10) {
        String[] strArr = {"删除", wd.a.f31697f, "移回书架"};
        MiArchiveBookItem h10 = h(i10);
        View inflate = View.inflate(this.f1933b, R.layout.popupwindow_list, null);
        PopupwindowListBinding bind = PopupwindowListBinding.bind(inflate);
        bind.popupwindowShadeView.setVisibility(MiConfigSingleton.b2().A0() ? 0 : 8);
        bind.popupwindowTitle.setText(h10.getBookName());
        bind.popupwindowLinear.removeAllViews();
        PopupWindow Q = v0.Q(inflate, this.f1935d, this.f1933b);
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: ce.c

            /* renamed from: b */
            public final /* synthetic */ View f1924b;

            /* renamed from: c */
            public final /* synthetic */ PopupWindow f1925c;

            public /* synthetic */ c(View inflate2, PopupWindow Q2) {
                inflate = inflate2;
                Q = Q2;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean k10;
                k10 = g.k(inflate, Q, view, motionEvent);
                return k10;
            }
        });
        for (int i11 = 0; i11 < 3; i11++) {
            bind.popupwindowLinear.addView(g(strArr[i11], i11, h10, Q2));
        }
    }

    public final void q(MiArchiveBookItem miArchiveBookItem) {
        Activity activity = this.f1933b;
        i0.z0(activity, activity.getString(R.string.confirm_message), "是否删除《" + miArchiveBookItem.getBookName() + "》?\n(该书的所有缓存内容将被清空)", new i0.l() { // from class: ce.f

            /* renamed from: b */
            public final /* synthetic */ MiArchiveBookItem f1932b;

            public /* synthetic */ f(MiArchiveBookItem miArchiveBookItem2) {
                miArchiveBookItem = miArchiveBookItem2;
            }

            @Override // l9.i0.l
            public final void a() {
                g.this.l(miArchiveBookItem);
            }
        });
    }
}
