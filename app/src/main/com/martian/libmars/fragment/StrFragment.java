package com.martian.libmars.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import x8.c;

/* loaded from: classes3.dex */
public abstract class StrFragment extends LazyFragment {

    /* renamed from: g */
    public LoadingTip f12358g;

    /* renamed from: h */
    public ViewStub f12359h;

    /* renamed from: i */
    public View f12360i;

    /* renamed from: f */
    public SwipeRefreshLayout f12357f = null;

    /* renamed from: j */
    public boolean f12361j = false;

    public abstract void A();

    public void B(boolean z10) {
        this.f12361j = z10;
    }

    public void C(int i10, int i11, int i12, int i13) {
        ((RelativeLayout.LayoutParams) this.f12358g.getLayoutParams()).setMargins(i10, i11, i12, i13);
    }

    public void G(int i10) {
        SwipeRefreshLayout swipeRefreshLayout = this.f12357f;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(i10);
        }
    }

    public void H() {
        SwipeRefreshLayout swipeRefreshLayout = this.f12357f;
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            this.f12357f.setRefreshing(false);
        }
        this.f12361j = false;
    }

    public void I(boolean z10) {
        SwipeRefreshLayout swipeRefreshLayout = this.f12357f;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(z10);
        }
    }

    public void K(boolean z10) {
        SwipeRefreshLayout swipeRefreshLayout = this.f12357f;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(z10);
        }
    }

    public void M(boolean z10) {
        if (z10) {
            z("");
        } else {
            y();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = View.inflate(getActivity(), R.layout.libmars_strfragment, null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.libmars_str_refresh_layout);
        this.f12357f = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: h9.b
            public /* synthetic */ b() {
            }

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                StrFragment.this.A();
            }
        });
        G(ConfigSingleton.D().l0());
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.libmars_str_container);
        this.f12359h = viewStub;
        viewStub.setLayoutResource(u());
        LoadingTip loadingTip = (LoadingTip) inflate.findViewById(R.id.loadedTip);
        this.f12358g = loadingTip;
        loadingTip.setOnReloadListener(new LoadingTip.b() { // from class: h9.c
            public /* synthetic */ c() {
            }

            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                StrFragment.this.A();
            }
        });
        return inflate;
    }

    public boolean r() {
        if (this.f12361j) {
            return false;
        }
        this.f12361j = true;
        return true;
    }

    public boolean s() {
        return this.f12361j;
    }

    public View t() {
        if (this.f12360i == null) {
            this.f12360i = this.f12359h.inflate();
        }
        return this.f12360i;
    }

    public abstract int u();

    public final /* synthetic */ void v(c cVar) {
        this.f12358g.setLoadingTip(cVar.c() == -1 ? LoadingTip.LoadStatus.network_error : LoadingTip.LoadStatus.serverError);
        if (l.q(cVar.d()) || cVar.d().length() >= 20) {
            return;
        }
        this.f12358g.setTips(ConfigSingleton.D().s(cVar.d()));
    }

    public void w(String str) {
        if (getActivity() == null) {
            return;
        }
        this.f12358g.setLoadingTip(LoadingTip.LoadStatus.empty);
        if (l.q(str)) {
            return;
        }
        this.f12358g.setTips(ConfigSingleton.D().s(str));
    }

    public void x(c cVar) {
        if (getActivity() == null || cVar == null) {
            return;
        }
        this.f12358g.post(new Runnable() { // from class: h9.d

            /* renamed from: c */
            public final /* synthetic */ x8.c f26507c;

            public /* synthetic */ d(x8.c cVar2) {
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                StrFragment.this.v(cVar);
            }
        });
    }

    public void y() {
        if (getActivity() == null) {
            return;
        }
        this.f12358g.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    public void z(String str) {
        if (getActivity() == null) {
            return;
        }
        this.f12358g.setLoadingTip(LoadingTip.LoadStatus.loading);
        if (l.q(str)) {
            return;
        }
        this.f12358g.setTips(ConfigSingleton.D().s(str));
    }
}
