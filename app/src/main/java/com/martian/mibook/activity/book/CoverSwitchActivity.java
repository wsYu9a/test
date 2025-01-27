package com.martian.mibook.activity.book;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import ba.l;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiRetryLoadingActivity;
import com.martian.mibook.activity.book.CoverSwitchActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityCoverSwitchBinding;
import com.martian.mibook.databinding.CoverSwitchItemBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.LinkedList;
import java.util.List;
import je.i;
import l9.m0;
import xb.h;

/* loaded from: classes3.dex */
public class CoverSwitchActivity extends MiRetryLoadingActivity {
    public static final String S = "file:///android_asset/";
    public String L;
    public String M;
    public Book N;
    public BookWrapper O;
    public c P;
    public final LinkedList<TYBookItem> Q = new LinkedList<>();
    public ActivityCoverSwitchBinding R;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ThemeImageView themeImageView = CoverSwitchActivity.this.R.btnClearSearchText;
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) charSequence);
            sb2.append("");
            themeImageView.setVisibility(!l.q(sb2.toString()) ? 0 : 8);
        }
    }

    public class b extends h {
        public b() {
        }

        @Override // xb.h
        public void a(boolean z10) {
            CoverSwitchActivity.this.f3(z10);
        }

        @Override // xb.h
        public void b(List<TYBookItem> list) {
            super.b(list);
        }

        @Override // xb.h
        public void c(List<TYBookItem> list) {
            CoverSwitchActivity.this.p3(list);
        }

        @Override // xb.h
        public void d(x8.c cVar) {
            CoverSwitchActivity.this.p3(null);
        }
    }

    public class c extends BaseAdapter {

        /* renamed from: b */
        public int f13185b = 0;

        /* renamed from: c */
        public final List<TYBookItem> f13186c;

        public c(List<TYBookItem> list) {
            this.f13186c = list;
        }

        public String a() {
            return ((Book) getItem(this.f13185b)).getCover();
        }

        public void b(int i10) {
            this.f13185b = i10;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<TYBookItem> list = this.f13186c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return this.f13186c.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i10, View view, ViewGroup viewGroup) {
            CoverSwitchItemBinding coverSwitchItemBinding;
            if (view == null) {
                view = CoverSwitchActivity.this.getLayoutInflater().inflate(R.layout.cover_switch_item, (ViewGroup) null);
                coverSwitchItemBinding = CoverSwitchItemBinding.bind(view);
                view.setTag(coverSwitchItemBinding);
            } else {
                coverSwitchItemBinding = (CoverSwitchItemBinding) view.getTag();
            }
            m0.l(CoverSwitchActivity.this, ((Book) getItem(i10)).getCover(), coverSwitchItemBinding.ivCover, MiConfigSingleton.b2().L1());
            if (i10 == this.f13185b) {
                coverSwitchItemBinding.ivCoverShadow.setVisibility(0);
                coverSwitchItemBinding.ivCoverSelection.setImageResource(R.drawable.icon_bookrack_batch_checked);
            } else {
                coverSwitchItemBinding.ivCoverShadow.setVisibility(8);
                coverSwitchItemBinding.ivCoverSelection.setImageResource(R.drawable.icon_bookrack_batch_checkin);
            }
            return view;
        }
    }

    public void p3(List<TYBookItem> list) {
        X2();
        H2();
        if ((list == null || list.isEmpty()) && !l.q(this.R.etBookName.getText().toString())) {
            P1("没搜到，换个词吧");
        } else if (list != null) {
            this.Q.addAll(list);
        }
        this.P.notifyDataSetChanged();
    }

    public static void q3(Activity activity, BookWrapper bookWrapper) {
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.U0, bookWrapper.getBookName());
        MiBookStoreItem miBookStoreItem = bookWrapper.item;
        if (miBookStoreItem != null) {
            bundle.putString(MiConfigSingleton.T0, miBookStoreItem.getSourceString());
        }
        Intent intent = new Intent(activity, (Class<?>) CoverSwitchActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.martian.libmars.activity.RetryLoadingActivity
    public void J2() {
        l3(this.M);
    }

    public final void l3(String str) {
        this.Q.clear();
        MiConfigSingleton.b2().M1().n1(str, MiBookManager.L, 0, "", "", new b());
    }

    public final boolean m3(Bundle bundle) {
        if (bundle != null) {
            this.L = bundle.getString(MiConfigSingleton.T0);
            this.M = bundle.getString(MiConfigSingleton.U0);
        } else {
            this.L = q1(MiConfigSingleton.T0);
            this.M = q1(MiConfigSingleton.U0);
        }
        if (TextUtils.isEmpty(this.L)) {
            P1("书籍ID为空");
            finish();
            return true;
        }
        BookWrapper G = MiConfigSingleton.b2().M1().G(this.L);
        this.O = G;
        if (G == null) {
            P1("无效的书籍类型");
            finish();
            return true;
        }
        Book book = G.book;
        this.N = book;
        if (book == null) {
            P1("无效的书籍类型");
            finish();
            return true;
        }
        if (!TextUtils.isEmpty(this.M)) {
            return false;
        }
        this.M = "无封面";
        return false;
    }

    public final /* synthetic */ void n3(AdapterView adapterView, View view, int i10, long j10) {
        this.P.b(i10);
    }

    public final /* synthetic */ void o3(View view) {
        this.R.etBookName.setText("");
    }

    public void onActionMenuClick(View view) {
        i.n(this, this.R.etBookName);
        c cVar = this.P;
        if (cVar == null || cVar.getCount() <= 0) {
            P1("封面更换失败");
        } else {
            this.N.setCover(this.P.a());
            MiBookStoreItem miBookStoreItem = this.O.item;
            if (miBookStoreItem != null) {
                miBookStoreItem.setCoverUrl(this.P.a());
            }
            MiConfigSingleton.b2().M1().P0(this.N);
            MiConfigSingleton.b2().M1().T().J(this.O);
        }
        finish();
    }

    @Override // com.martian.mibook.activity.base.MiRetryLoadingActivity, com.martian.libmars.activity.RetryLoadingActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(MiConfigSingleton.b2().r2().e().themeBackable);
        super.onCreate(bundle);
        if (m3(bundle)) {
            return;
        }
        setContentView(R.layout.activity_cover_switch);
        this.R = ActivityCoverSwitchBinding.bind(C2());
        P2(getString(R.string.save));
        this.R.gvCoverList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ua.c
            public /* synthetic */ c() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                CoverSwitchActivity.this.n3(adapterView, view, i10, j10);
            }
        });
        this.R.etBookName.setText(this.M);
        this.R.etBookName.setSelection(this.M.length());
        this.R.btnClearSearchText.setOnClickListener(new View.OnClickListener() { // from class: ua.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CoverSwitchActivity.this.o3(view);
            }
        });
        this.R.etBookName.addTextChangedListener(new a());
        c cVar = new c(this.Q);
        this.P = cVar;
        this.R.gvCoverList.setAdapter((ListAdapter) cVar);
    }

    @Override // com.martian.libmars.activity.MartianActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.n(this, this.R.etBookName);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(MiConfigSingleton.T0, this.L);
        bundle.putString(MiConfigSingleton.U0, this.M);
    }

    public void onSearchCoverClick(View view) {
        String obj = this.R.etBookName.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            P1("书名不能为空");
            return;
        }
        i.n(this, this.R.etBookName);
        this.M = obj;
        J2();
    }
}
