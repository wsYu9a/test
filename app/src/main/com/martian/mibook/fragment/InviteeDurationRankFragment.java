package com.martian.mibook.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.libmars.R;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.widget.recyclerview.IRecyclerView;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.mibook.lib.account.request.auth.InviterDurationRankParams;
import com.martian.mibook.lib.account.response.TYInviteeList;
import com.martian.mibook.ui.adapter.MartianInviteeDurationRankAdapter;
import java.util.ArrayList;
import kb.r;
import l9.m0;
import x8.c;

/* loaded from: classes3.dex */
public class InviteeDurationRankFragment extends StrFragment implements s9.a {

    /* renamed from: k */
    public int f13676k = 0;

    /* renamed from: l */
    public MartianInviteeDurationRankAdapter f13677l;

    /* renamed from: m */
    public IRecyclerView f13678m;

    public class a extends r {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            InviteeDurationRankFragment.this.R(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                InviteeDurationRankFragment inviteeDurationRankFragment = InviteeDurationRankFragment.this;
                inviteeDurationRankFragment.T(inviteeDurationRankFragment.getString(R.string.loading));
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(TYInviteeList tYInviteeList) {
            InviteeDurationRankFragment.this.Q(tYInviteeList);
        }
    }

    public void R(c cVar) {
        H();
        S(cVar);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        if (m0.C(this.f12349c)) {
            this.f13677l.l().setRefresh(true);
            this.f13676k = 0;
            P();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P() {
        a aVar = new a(j());
        ((InviterDurationRankParams) aVar.k()).setPage(Integer.valueOf(this.f13676k));
        aVar.j();
    }

    public final void Q(TYInviteeList tYInviteeList) {
        H();
        if (tYInviteeList == null || tYInviteeList.getInvitees() == null || tYInviteeList.getInvitees().isEmpty()) {
            S(new c(-1, "数据为空"));
            return;
        }
        y();
        if (this.f13677l.l().isRefresh()) {
            this.f13677l.a(tYInviteeList.getInvitees());
        } else {
            this.f13677l.h(tYInviteeList.getInvitees());
        }
        this.f13676k++;
    }

    public void S(c cVar) {
        MartianInviteeDurationRankAdapter martianInviteeDurationRankAdapter = this.f13677l;
        if (martianInviteeDurationRankAdapter == null || martianInviteeDurationRankAdapter.getSize() <= 0) {
            x(cVar);
            this.f13678m.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            return;
        }
        y();
        if (this.f13677l.getSize() >= 10) {
            this.f13678m.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13678m.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
    }

    public void T(String str) {
        MartianInviteeDurationRankAdapter martianInviteeDurationRankAdapter = this.f13677l;
        if (martianInviteeDurationRankAdapter == null || martianInviteeDurationRankAdapter.getSize() <= 0) {
            z(str);
        }
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        if (m0.C(this.f12349c)) {
            this.f13677l.l().setRefresh(this.f13677l.getSize() <= 0);
            this.f13678m.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        IRecyclerView iRecyclerView = (IRecyclerView) t().findViewById(R.id.str_irc);
        this.f13678m = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MartianInviteeDurationRankAdapter martianInviteeDurationRankAdapter = new MartianInviteeDurationRankAdapter(this.f12349c, new ArrayList());
        this.f13677l = martianInviteeDurationRankAdapter;
        this.f13678m.setAdapter(martianInviteeDurationRankAdapter);
        this.f13678m.setOnLoadMoreListener(this);
        this.f13678m.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        P();
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_str;
    }
}
