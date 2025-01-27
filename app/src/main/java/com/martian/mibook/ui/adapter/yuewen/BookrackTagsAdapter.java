package com.martian.mibook.ui.adapter.yuewen;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.ui.adapter.yuewen.BookrackTagsAdapter;
import java.util.List;
import l9.i0;
import l9.t0;

/* loaded from: classes3.dex */
public class BookrackTagsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c */
    public final Context f15887c;

    /* renamed from: d */
    public List<String> f15888d;

    /* renamed from: e */
    public a f15889e;

    /* renamed from: f */
    public int f15890f = 0;

    /* renamed from: g */
    public boolean f15891g;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b */
        public final TextView f15892b;

        /* renamed from: c */
        public final View f15893c;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.f15892b = (TextView) view.findViewById(R.id.bookrack_tag_title);
            this.f15893c = view.findViewById(R.id.bookrack_tag_view);
        }
    }

    public interface a {
        void a(String str);
    }

    public interface b {
        void a();
    }

    public BookrackTagsAdapter(Context context, List<String> list, boolean z10) {
        this.f15887c = context;
        this.f15888d = list;
        this.f15891g = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<String> list = this.f15888d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public String m(int i10) {
        return (i10 < 0 || i10 >= getPageSize()) ? "" : this.f15888d.get(i10);
    }

    public String n() {
        List<String> list;
        int i10 = this.f15890f;
        return (i10 < 0 || (list = this.f15888d) == null || i10 >= list.size()) ? BookrackCategoryManager.ALL_BOOK_CATEGORY : this.f15888d.get(this.f15890f);
    }

    public final /* synthetic */ void o(int i10, String str) {
        w(i10);
        a aVar = this.f15889e;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public final /* synthetic */ void p(int i10, String str, View view) {
        if (i10 == this.f15890f) {
            return;
        }
        if (BookrackCategoryManager.SECRETE_CATEGORY.equalsIgnoreCase(str)) {
            z(new b() { // from class: de.b

                /* renamed from: b */
                public final /* synthetic */ int f25505b;

                /* renamed from: c */
                public final /* synthetic */ String f25506c;

                public /* synthetic */ b(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.martian.mibook.ui.adapter.yuewen.BookrackTagsAdapter.b
                public final void a() {
                    BookrackTagsAdapter.this.o(i10, str);
                }
            });
            return;
        }
        w(i102);
        a aVar = this.f15889e;
        if (aVar != null) {
            aVar.a(str2);
        }
    }

    public final /* synthetic */ void q(String str, b bVar, String str2) {
        if (l.q(str2)) {
            t0.b(this.f15887c, ConfigSingleton.D().s("密码不能为空"));
            return;
        }
        if (l.q(str)) {
            if (str2.length() == 4) {
                y(str2, ConfigSingleton.D().s("请再次输入密码"), bVar);
                return;
            } else {
                t0.b(this.f15887c, ConfigSingleton.D().s("请输入四位数字密码"));
                return;
            }
        }
        if (!str2.equals(str)) {
            t0.b(this.f15887c, ConfigSingleton.D().s("两次密码输入不一致，请重试"));
            return;
        }
        t0.b(this.f15887c, ConfigSingleton.D().s("设置成功"));
        MiConfigSingleton.b2().M1().G2(this.f15887c, str2);
        bVar.a();
        this.f15891g = true;
    }

    public final /* synthetic */ void r(b bVar, String str) {
        if (l.q(str)) {
            t0.b(this.f15887c, "密码不能为空,请重试");
        } else if (!MiConfigSingleton.b2().M1().Z1(this.f15887c, str)) {
            t0.b(this.f15887c, "密码不正确，请重试");
        } else {
            this.f15891g = true;
            bVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10) {
        String m10 = m(i10);
        viewHolder.f15892b.setText(m10);
        boolean A0 = ConfigSingleton.D().A0();
        if (i10 == this.f15890f) {
            viewHolder.f15892b.setTextColor(ContextCompat.getColor(this.f15887c, MiConfigSingleton.b2().l0()));
            viewHolder.f15892b.setBackgroundResource(A0 ? com.martian.libmars.R.drawable.border_search_background_night_card : R.drawable.border_mission_button);
            viewHolder.f15892b.getPaint().setFakeBoldText(true);
        } else {
            viewHolder.f15892b.setTextColor(ConfigSingleton.D().j0());
            viewHolder.f15892b.setBackgroundResource(A0 ? com.martian.libmars.R.drawable.border_search_background_night_card : com.martian.libmars.R.drawable.border_search_background_day);
            viewHolder.f15892b.getPaint().setFakeBoldText(false);
        }
        viewHolder.f15893c.setOnClickListener(new View.OnClickListener() { // from class: de.c

            /* renamed from: c */
            public final /* synthetic */ int f25508c;

            /* renamed from: d */
            public final /* synthetic */ String f25509d;

            public /* synthetic */ c(int i102, String m102) {
                i10 = i102;
                m10 = m102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookrackTagsAdapter.this.p(i10, m10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: t */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new ViewHolder(View.inflate(this.f15887c, R.layout.bookrack_tag_item, null));
    }

    public void u(List<String> list, String str) {
        this.f15888d = list;
        int i10 = 0;
        this.f15890f = 0;
        while (true) {
            if (i10 >= list.size()) {
                break;
            }
            if (l.p(str, list.get(i10))) {
                this.f15890f = i10;
                break;
            }
            i10++;
        }
        notifyDataSetChanged();
    }

    public void v(a aVar) {
        this.f15889e = aVar;
    }

    public void w(int i10) {
        int i11;
        if (i10 < 0 || i10 >= getPageSize() || (i11 = this.f15890f) == i10) {
            return;
        }
        this.f15890f = i10;
        notifyItemChanged(i11);
        notifyItemChanged(this.f15890f);
    }

    public final void x(b bVar) {
        y("", "请设置四位数字密码", bVar);
    }

    public final void y(String str, String str2, b bVar) {
        i0.D0((Activity) this.f15887c, ConfigSingleton.D().s(l.q(str) ? "设置密码" : "确认密码"), str2, false, true, new i0.j() { // from class: de.a

            /* renamed from: b */
            public final /* synthetic */ String f25502b;

            /* renamed from: c */
            public final /* synthetic */ BookrackTagsAdapter.b f25503c;

            public /* synthetic */ a(String str3, BookrackTagsAdapter.b bVar2) {
                str = str3;
                bVar = bVar2;
            }

            @Override // l9.i0.j
            public final void a(String str3) {
                BookrackTagsAdapter.this.q(str, bVar, str3);
            }
        });
    }

    public final void z(b bVar) {
        if (this.f15891g) {
            bVar.a();
        } else if (MiConfigSingleton.b2().M1().U1(this.f15887c)) {
            i0.D0((Activity) this.f15887c, ConfigSingleton.D().s("输入密码"), ConfigSingleton.D().s("请输入4位私密分类密码"), true, true, new i0.j() { // from class: de.d

                /* renamed from: b */
                public final /* synthetic */ BookrackTagsAdapter.b f25511b;

                public /* synthetic */ d(BookrackTagsAdapter.b bVar2) {
                    bVar = bVar2;
                }

                @Override // l9.i0.j
                public final void a(String str) {
                    BookrackTagsAdapter.this.r(bVar, str);
                }
            });
        } else {
            x(bVar2);
        }
    }
}
