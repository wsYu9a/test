package com.kwad.components.core.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    private WebView Qc;
    private FeedVideoView Qd;
    private LinearLayout Qe;
    private TextView Qf;
    private ImageView Qg;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.page.b$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.Qe.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.core.page.b$2 */
    public class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ DetailWebRecycleView Qi;

        public AnonymousClass2(DetailWebRecycleView detailWebRecycleView) {
            detailWebRecycleView = detailWebRecycleView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (detailWebRecycleView.getChildCount() > 0) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + findViewHolderForAdapterPosition.itemView.getHeight() + ")");
                detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                View view = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                if (view instanceof FeedVideoView) {
                    b.this.Qd = (FeedVideoView) view;
                }
            }
            if (detailWebRecycleView.getChildCount() > 1) {
                View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                b.this.Qc = (WebView) view2.findViewById(R.id.ksad_video_webView);
                b.this.x(view2);
            }
            com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "onGlobalLayout");
            detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static class a extends com.kwad.components.core.page.recycle.d {
        e Qj;
        AdTemplate mAdTemplate;
        private Context mContext;

        public a(AdTemplate adTemplate, Context context, e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.Qj = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i10) {
            super.onBindViewHolder(cVar, i10);
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c b(ViewGroup viewGroup, int i10) {
            if (i10 == 1) {
                View a10 = m.a(this.mContext, R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a(new com.kwad.components.core.page.c.b());
                return new com.kwad.components.core.page.recycle.c(a10, presenter, this.Qj);
            }
            if (i10 != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.components.core.page.recycle.c(view, new Presenter(), this.Qj);
            }
            FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
            Presenter presenter2 = new Presenter();
            presenter2.a(new com.kwad.components.core.page.c.a());
            return new com.kwad.components.core.page.recycle.c(feedVideoView, presenter2, this.Qj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public final int getPageSize() {
            return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i10) {
            return i10;
        }
    }

    public static b av(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void x(View view) {
        this.Qe = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.Qf = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.Qg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.Qe.setVisibility(8);
            }
        });
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        boolean by = com.kwad.sdk.core.response.b.a.by(eb2);
        String bu = com.kwad.sdk.core.response.b.a.bu(eb2);
        if (!by) {
            this.Qe.setVisibility(8);
            return;
        }
        this.Qe.setVisibility(0);
        this.Qf.setText(bu);
        this.Qf.setSelected(true);
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        WebView webView = this.Qc;
        if (webView != null && webView.canGoBack()) {
            this.Qc.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.Qd;
        if (feedVideoView != null) {
            return feedVideoView.uy();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) qC();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            final /* synthetic */ DetailWebRecycleView Qi;

            public AnonymousClass2(DetailWebRecycleView detailWebRecycleView2) {
                detailWebRecycleView = detailWebRecycleView2;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + findViewHolderForAdapterPosition.itemView.getHeight() + ")");
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof FeedVideoView) {
                        b.this.Qd = (FeedVideoView) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view22 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.Qc = (WebView) view22.findViewById(R.id.ksad_video_webView);
                    b.this.x(view22);
                }
                com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.h
    public final int pR() {
        return R.layout.ksad_detail_webview;
    }

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }
}
