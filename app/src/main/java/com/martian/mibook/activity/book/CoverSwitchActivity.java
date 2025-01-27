package com.martian.mibook.activity.book;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.n0;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.f2;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class CoverSwitchActivity extends com.martian.mibook.activity.base.n {
    public static final String Q = "file:///android_asset/";
    private String R;
    private String S;
    private Book T;
    private BookWrapper U;
    private c V;
    private final LinkedList<TYBookItem> W = new LinkedList<>();
    private com.martian.mibook.e.i X;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i22) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i1, int i22) {
            ThemeImageView themeImageView = CoverSwitchActivity.this.X.f12098b;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) charSequence);
            sb.append("");
            themeImageView.setVisibility(!com.martian.libsupport.k.p(sb.toString()) ? 0 : 8);
        }
    }

    class b extends com.martian.mibook.lib.model.d.h {
        b() {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
            CoverSwitchActivity.this.K2(loading);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void b(List<TYBookItem> books) {
            super.b(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            CoverSwitchActivity.this.U2(books);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
            CoverSwitchActivity.this.U2(null);
        }
    }

    class c extends BaseAdapter {

        /* renamed from: a */
        private int f10997a = 0;

        /* renamed from: b */
        private final List<TYBookItem> f10998b;

        public c(List<TYBookItem> books) {
            this.f10998b = books;
        }

        public String a() {
            return ((Book) getItem(this.f10997a)).getCover();
        }

        public void b(int index) {
            this.f10997a = index;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<TYBookItem> list = this.f10998b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return this.f10998b.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int position, View convertView, ViewGroup parent) {
            f2 f2Var;
            if (convertView == null) {
                convertView = CoverSwitchActivity.this.getLayoutInflater().inflate(R.layout.cover_switch_item, (ViewGroup) null);
                f2Var = f2.a(convertView);
                convertView.setTag(f2Var);
            } else {
                f2Var = (f2) convertView.getTag();
            }
            n0.l(CoverSwitchActivity.this, ((Book) getItem(position)).getCover(), f2Var.f11937b, MiConfigSingleton.V3().i3());
            if (position == this.f10997a) {
                f2Var.f11939d.setVisibility(0);
                f2Var.f11938c.setImageResource(R.drawable.icon_bookrack_batch_checked);
            } else {
                f2Var.f11939d.setVisibility(8);
                f2Var.f11938c.setImageResource(R.drawable.icon_bookrack_batch_checkin);
            }
            return convertView;
        }
    }

    private void O2(String bookName) {
        this.W.clear();
        MiConfigSingleton.V3().l3().X1(bookName, MiBookManager.n, 0, "", "", new b());
    }

    private boolean P2() {
        String G0 = G0(MiConfigSingleton.I0);
        this.R = G0;
        if (TextUtils.isEmpty(G0)) {
            k1("书籍ID为空");
            finish();
            return true;
        }
        BookWrapper P = MiConfigSingleton.V3().l3().P(this.R);
        this.U = P;
        if (P == null) {
            k1("无效的书籍类型");
            finish();
            return true;
        }
        Book book = P.book;
        this.T = book;
        if (book == null) {
            k1("无效的书籍类型");
            finish();
            return true;
        }
        String G02 = G0(MiConfigSingleton.L0);
        this.S = G02;
        if (!TextUtils.isEmpty(G02)) {
            return false;
        }
        this.S = "无封面";
        return false;
    }

    /* renamed from: Q2 */
    public /* synthetic */ void R2(AdapterView parent, View view, int position, long id) {
        this.V.b(position);
    }

    /* renamed from: S2 */
    public /* synthetic */ void T2(View view) {
        this.X.f12099c.setText("");
    }

    public void U2(List<TYBookItem> books) {
        B2();
        l2();
        if ((books == null || books.isEmpty()) && !com.martian.libsupport.k.p(this.X.f12099c.getText().toString())) {
            k1("没搜到，换个词吧");
        } else if (books != null) {
            this.W.addAll(books);
        }
        this.V.notifyDataSetChanged();
    }

    @Override // com.martian.libmars.activity.k1
    public void n2() {
        O2(this.S);
    }

    public void onActionMenuClick(View view) {
        s2.n(this, this.X.f12099c);
        c cVar = this.V;
        if (cVar == null || cVar.getCount() <= 0) {
            k1("封面更换失败");
        } else {
            this.T.setCover(this.V.a());
            MiBookStoreItem miBookStoreItem = this.U.item;
            if (miBookStoreItem != null) {
                miBookStoreItem.setCoverUrl(this.V.a());
            }
            MiConfigSingleton.V3().l3().s1(this.T);
            MiConfigSingleton.V3().l3().k1(this.U.item);
        }
        finish();
    }

    @Override // com.martian.mibook.activity.base.n, com.martian.libmars.activity.k1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(MiConfigSingleton.V3().I4.e().themeBackable);
        super.onCreate(savedInstanceState);
        if (P2()) {
            return;
        }
        setContentView(R.layout.activity_cover_switch);
        this.X = com.martian.mibook.e.i.a(h2());
        t2(getString(R.string.save));
        this.X.f12100d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.activity.book.s
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                CoverSwitchActivity.this.R2(adapterView, view, i2, j2);
            }
        });
        this.X.f12099c.setText(this.S);
        this.X.f12099c.setSelection(this.S.length());
        this.X.f12098b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.book.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CoverSwitchActivity.this.T2(view);
            }
        });
        this.X.f12099c.addTextChangedListener(new a());
        c cVar = new c(this.W);
        this.V = cVar;
        this.X.f12100d.setAdapter((ListAdapter) cVar);
    }

    @Override // com.martian.libmars.activity.j1, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        s2.n(this, this.X.f12099c);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MiConfigSingleton.I0, this.R);
        outState.putString(MiConfigSingleton.I0, this.S);
    }

    public void onSearchCoverClick(View view) {
        String obj = this.X.f12099c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            k1("书名不能为空");
            return;
        }
        s2.n(this, this.X.f12099c);
        this.S = obj;
        n2();
    }
}
