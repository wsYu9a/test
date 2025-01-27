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
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    private WebView Lc;
    private FeedVideoView Ld;
    private LinearLayout Le;
    private TextView Lf;
    private ImageView Lg;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.page.b$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.Le.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.core.page.b$2 */
    final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ DetailWebRecycleView Li;

        AnonymousClass2(DetailWebRecycleView detailWebRecycleView) {
            detailWebRecycleView = detailWebRecycleView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (detailWebRecycleView.getChildCount() > 0) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                com.kwad.sdk.core.d.b.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + findViewHolderForAdapterPosition.itemView.getHeight() + ")");
                detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                View view = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                if (view instanceof FeedVideoView) {
                    b.this.Ld = (FeedVideoView) view;
                }
            }
            if (detailWebRecycleView.getChildCount() > 1) {
                View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                b.this.Lc = (WebView) view2.findViewById(R.id.ksad_video_webView);
                b.this.v(view2);
            }
            com.kwad.sdk.core.d.b.d("AdRecycleWebFragment", "onGlobalLayout");
            detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    static class a extends com.kwad.components.core.page.recycle.d {
        e Lj;
        AdTemplate mAdTemplate;
        private Context mContext;

        a(AdTemplate adTemplate, Context context, e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.Lj = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i2) {
            super.onBindViewHolder(cVar, i2);
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c b(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                View a2 = k.a(this.mContext, R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a(new com.kwad.components.core.page.a.b());
                return new com.kwad.components.core.page.recycle.c(a2, presenter, this.Lj);
            }
            if (i2 != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.c.kwai.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.components.core.page.recycle.c(view, new Presenter(), this.Lj);
            }
            FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
            Presenter presenter2 = new Presenter();
            presenter2.a(new com.kwad.components.core.page.a.a());
            return new com.kwad.components.core.page.recycle.c(feedVideoView, presenter2, this.Lj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i2) {
            return i2;
        }
    }

    public static b K(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void v(View view) {
        this.Le = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.Lf = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.Lg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.Le.setVisibility(8);
            }
        });
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        boolean bn = com.kwad.sdk.core.response.a.a.bn(cb);
        String bj = com.kwad.sdk.core.response.a.a.bj(cb);
        if (!bn) {
            this.Le.setVisibility(8);
            return;
        }
        this.Le.setVisibility(0);
        this.Lf.setText(bj);
        this.Lf.setSelected(true);
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }

    @Override // com.kwad.components.core.l.f, com.kwad.sdk.i.kwai.b
    public final boolean bX() {
        WebView webView = this.Lc;
        if (webView != null && webView.canGoBack()) {
            this.Lc.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.Ld;
        if (feedVideoView != null) {
            return feedVideoView.ry();
        }
        return false;
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final int nX() {
        return R.layout.ksad_detail_webview;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.l.f, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
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
        DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) oE();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            final /* synthetic */ DetailWebRecycleView Li;

            AnonymousClass2(DetailWebRecycleView detailWebRecycleView2) {
                detailWebRecycleView = detailWebRecycleView2;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    com.kwad.sdk.core.d.b.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + findViewHolderForAdapterPosition.itemView.getHeight() + ")");
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof FeedVideoView) {
                        b.this.Ld = (FeedVideoView) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view22 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.Lc = (WebView) view22.findViewById(R.id.ksad_video_webView);
                    b.this.v(view22);
                }
                com.kwad.sdk.core.d.b.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public final void setApkDownloadHelper(com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
