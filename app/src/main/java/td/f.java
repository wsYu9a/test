package td;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.mibook.R;
import com.martian.mibook.lib.account.response.TYActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import l9.m0;

/* loaded from: classes3.dex */
public final class f extends BaseAdapter {

    /* renamed from: b */
    @xi.k
    public List<? extends TYActivity> f30805b = new ArrayList();

    /* renamed from: c */
    @xi.l
    public a f30806c;

    public interface a {
        void a(@xi.l TYActivity tYActivity);
    }

    public final class b {

        /* renamed from: a */
        @xi.l
        public ImageView f30807a;

        /* renamed from: b */
        @xi.l
        public TextView f30808b;

        /* renamed from: c */
        @xi.l
        public TextView f30809c;

        public b() {
        }

        @xi.l
        public final TextView a() {
            return this.f30809c;
        }

        @xi.l
        public final ImageView b() {
            return this.f30807a;
        }

        @xi.l
        public final TextView c() {
            return this.f30808b;
        }

        public final void d(@xi.l TextView textView) {
            this.f30809c = textView;
        }

        public final void e(@xi.l ImageView imageView) {
            this.f30807a = imageView;
        }

        public final void f(@xi.l TextView textView) {
            this.f30808b = textView;
        }
    }

    public static final void b(f this$0, TYActivity tyActivity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tyActivity, "$tyActivity");
        a aVar = this$0.f30806c;
        if (aVar != null) {
            aVar.a(tyActivity);
        }
    }

    public final void c(@xi.k List<? extends TYActivity> activities) {
        Intrinsics.checkNotNullParameter(activities, "activities");
        this.f30805b = activities;
        notifyDataSetChanged();
    }

    public final void d(@xi.l a aVar) {
        this.f30806c = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f30805b.size();
    }

    @Override // android.widget.Adapter
    @xi.k
    public Object getItem(int i10) {
        return this.f30805b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @xi.k
    @SuppressLint({"InflateParams"})
    public View getView(int i10, @xi.l View view, @xi.k ViewGroup parent) {
        b bVar;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_activity, (ViewGroup) null);
            bVar = new b();
            bVar.e(view != null ? (ImageView) view.findViewById(R.id.activity_icon) : null);
            bVar.f(view != null ? (TextView) view.findViewById(R.id.activity_title) : null);
            bVar.d(view != null ? (TextView) view.findViewById(R.id.activity_desc) : null);
            if (view != null) {
                view.setTag(bVar);
            }
        } else {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.martian.mibook.mvvm.yuewen.adapter.ActivitiesGridAdapter.ViewHolder");
            bVar = (b) tag;
        }
        TYActivity tYActivity = this.f30805b.get(i10);
        TextView c10 = bVar.c();
        if (c10 != null) {
            c10.setText(tYActivity.getTitle());
        }
        TextView a10 = bVar.a();
        if (a10 != null) {
            a10.setText(tYActivity.getDesc());
        }
        m0.k(parent.getContext(), tYActivity.getIcon(), bVar.b());
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: td.e

                /* renamed from: c */
                public final /* synthetic */ TYActivity f30804c;

                public /* synthetic */ e(TYActivity tYActivity2) {
                    tYActivity = tYActivity2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    f.b(f.this, tYActivity, view2);
                }
            });
        }
        Intrinsics.checkNotNull(view);
        return view;
    }
}
