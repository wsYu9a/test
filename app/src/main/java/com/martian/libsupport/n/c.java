package com.martian.libsupport.n;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.martian.libsupport.R;
import com.martian.libsupport.k;
import com.martian.libsupport.recyclerView.IrcLoadingTip;

/* loaded from: classes3.dex */
public abstract class c extends Fragment {

    /* renamed from: a */
    protected Activity f10619a;

    /* renamed from: f */
    private IrcLoadingTip f10624f;

    /* renamed from: g */
    private ViewStub f10625g;

    /* renamed from: h */
    private View f10626h;

    /* renamed from: b */
    private boolean f10620b = false;

    /* renamed from: c */
    private boolean f10621c = false;

    /* renamed from: d */
    protected boolean f10622d = false;

    /* renamed from: e */
    public SwipeRefreshLayout f10623e = null;

    /* renamed from: i */
    private boolean f10627i = false;

    private void q() {
        if (this.f10620b && this.f10621c && !this.f10622d) {
            e();
            this.f10622d = true;
        }
    }

    public boolean a() {
        if (this.f10627i) {
            return false;
        }
        this.f10627i = true;
        return true;
    }

    public View b() {
        if (this.f10626h == null) {
            this.f10626h = this.f10625g.inflate();
        }
        return this.f10626h;
    }

    public abstract int c();

    public boolean d() {
        return this.f10621c;
    }

    protected abstract void e();

    public void f() {
        this.f10624f.setLoadingTip(IrcLoadingTip.LoadStatus.empty);
    }

    public void g(String reason) {
        this.f10624f.setLoadingTip(IrcLoadingTip.LoadStatus.error);
        if (k.p(reason) || reason.length() >= 20) {
            return;
        }
        this.f10624f.setTips(reason);
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (getActivity() != null) {
            return getActivity();
        }
        return null;
    }

    public void h(String reason) {
        this.f10624f.setLoadingTip(IrcLoadingTip.LoadStatus.error_msg);
        if (k.p(reason) || reason.length() >= 20) {
            return;
        }
        this.f10624f.setTips(reason);
    }

    public void i() {
        this.f10624f.setLoadingTip(IrcLoadingTip.LoadStatus.finish);
    }

    public void j(String tips) {
        this.f10624f.setLoadingTip(IrcLoadingTip.LoadStatus.loading);
        if (k.p(tips)) {
            return;
        }
        this.f10624f.setTips(tips);
    }

    public abstract void k();

    public void l(int color) {
        this.f10623e.setColorSchemeResources(color);
    }

    public void m() {
        if (this.f10623e.isRefreshing()) {
            this.f10623e.setRefreshing(false);
        }
        this.f10627i = false;
    }

    public void n(boolean enable) {
        SwipeRefreshLayout swipeRefreshLayout = this.f10623e;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(enable);
        }
    }

    public void o(SwipeRefreshLayout.OnRefreshListener listener) {
        this.f10623e.setOnRefreshListener(listener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        q();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f10619a = (Activity) context;
        this.f10620b = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.fragment_irc_str, (ViewGroup) null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.irc_str_refresh_layout);
        this.f10623e = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.martian.libsupport.n.a
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                c.this.k();
            }
        });
        l(R.color.support_color_primary);
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.irc_str_container);
        this.f10625g = viewStub;
        viewStub.setLayoutResource(c());
        IrcLoadingTip ircLoadingTip = (IrcLoadingTip) inflate.findViewById(R.id.irc_loadedTip);
        this.f10624f = ircLoadingTip;
        ircLoadingTip.setOnReloadListener(new IrcLoadingTip.b() { // from class: com.martian.libsupport.n.b
            @Override // com.martian.libsupport.recyclerView.IrcLoadingTip.b
            public final void a() {
                c.this.k();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10619a = null;
    }

    public void p(boolean refresh) {
        this.f10623e.setRefreshing(refresh);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.f10621c = isVisibleToUser;
        q();
    }

    public void startActivity(Class<? extends Activity> activity) {
        this.f10619a.startActivity(new Intent(this.f10619a, activity));
    }
}
