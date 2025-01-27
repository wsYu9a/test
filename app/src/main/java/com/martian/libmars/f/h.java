package com.martian.libmars.f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.martian.libmars.R;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.libsupport.k;

/* loaded from: classes2.dex */
public abstract class h extends e {

    /* renamed from: f */
    private LoadingTip f10088f;

    /* renamed from: g */
    private ViewStub f10089g;

    /* renamed from: h */
    private View f10090h;

    /* renamed from: e */
    private SwipeRefreshLayout f10087e = null;

    /* renamed from: i */
    private boolean f10091i = false;

    public boolean f() {
        if (this.f10091i) {
            return false;
        }
        this.f10091i = true;
        return true;
    }

    public View g() {
        if (this.f10090h == null) {
            this.f10090h = this.f10089g.inflate();
        }
        return this.f10090h;
    }

    public abstract int h();

    public void i(String title) {
        if (n0.C(this.f10082a)) {
            this.f10088f.setLoadingTip(LoadingTip.LoadStatus.empty);
            if (k.p(title)) {
                return;
            }
            this.f10088f.setTips(title);
        }
    }

    public void j(b.d.c.b.c errorResult) {
        if (!n0.C(this.f10082a) || errorResult == null) {
            return;
        }
        this.f10088f.setLoadingTip(errorResult.c() == -1 ? LoadingTip.LoadStatus.error : LoadingTip.LoadStatus.sereverError);
        if (k.p(errorResult.d()) || errorResult.d().length() >= 20) {
            return;
        }
        this.f10088f.setTips(errorResult.d());
    }

    public void k() {
        if (n0.C(this.f10082a)) {
            this.f10088f.setLoadingTip(LoadingTip.LoadStatus.finish);
        }
    }

    public void l(String tips) {
        if (n0.C(this.f10082a)) {
            this.f10088f.setLoadingTip(LoadingTip.LoadStatus.loading);
            if (k.p(tips)) {
                return;
            }
            this.f10088f.setTips(tips);
        }
    }

    public abstract void m();

    public void n(int left, int top, int right, int bottom) {
        ((RelativeLayout.LayoutParams) this.f10088f.getLayoutParams()).setMargins(left, top, right, bottom);
    }

    public void o(int color) {
        this.f10087e.setColorSchemeResources(color);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.libmars_strfragment, (ViewGroup) null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.libmars_str_refresh_layout);
        this.f10087e = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.martian.libmars.f.c
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                h.this.m();
            }
        });
        o(com.martian.libmars.d.h.F().t0());
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.libmars_str_container);
        this.f10089g = viewStub;
        viewStub.setLayoutResource(h());
        LoadingTip loadingTip = (LoadingTip) inflate.findViewById(R.id.loadedTip);
        this.f10088f = loadingTip;
        loadingTip.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.libmars.f.b
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                h.this.m();
            }
        });
        return inflate;
    }

    public void p() {
        if (this.f10087e.isRefreshing()) {
            this.f10087e.setRefreshing(false);
        }
        this.f10091i = false;
    }

    public void q(boolean enable) {
        SwipeRefreshLayout swipeRefreshLayout = this.f10087e;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(enable);
        }
    }

    public void r(SwipeRefreshLayout.OnRefreshListener listener) {
        this.f10087e.setOnRefreshListener(listener);
    }

    public void s(boolean refresh) {
        this.f10087e.setRefreshing(refresh);
    }
}
