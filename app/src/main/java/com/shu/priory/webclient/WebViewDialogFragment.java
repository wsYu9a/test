package com.shu.priory.webclient;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.shu.priory.R;
import com.shu.priory.bridge.DSBridgeWebView;
import com.shu.priory.request.IFLYBrowser;

/* loaded from: classes3.dex */
public class WebViewDialogFragment extends DialogFragment {

    /* renamed from: a */
    WebChromeClient f17454a = new WebChromeClient() { // from class: com.shu.priory.webclient.WebViewDialogFragment.2
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            permissionRequest.grant(permissionRequest.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (i10 != 100) {
                WebViewDialogFragment.this.f17456c.setVisibility(0);
                WebViewDialogFragment.this.f17456c.setProgress(i10);
            } else if (WebViewDialogFragment.this.f17456c != null) {
                WebViewDialogFragment.this.f17456c.setVisibility(8);
            }
        }
    };

    /* renamed from: b */
    private DSBridgeWebView f17455b;

    /* renamed from: c */
    private ProgressBar f17456c;

    /* renamed from: d */
    private RelativeLayout f17457d;

    /* renamed from: e */
    private ImageView f17458e;

    /* renamed from: com.shu.priory.webclient.WebViewDialogFragment$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewDialogFragment.this.dismiss();
        }
    }

    /* renamed from: com.shu.priory.webclient.WebViewDialogFragment$2 */
    public class AnonymousClass2 extends WebChromeClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            permissionRequest.grant(permissionRequest.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (i10 != 100) {
                WebViewDialogFragment.this.f17456c.setVisibility(0);
                WebViewDialogFragment.this.f17456c.setProgress(i10);
            } else if (WebViewDialogFragment.this.f17456c != null) {
                WebViewDialogFragment.this.f17456c.setVisibility(8);
            }
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ifly_ad_web_dialog, viewGroup, false);
        String string = getArguments().getString("url");
        this.f17457d = (RelativeLayout) inflate.findViewById(R.id.rl_ad_web_dialog);
        ProgressBar progressBar = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyleHorizontal);
        this.f17456c = progressBar;
        progressBar.setId(16715776);
        this.f17456c.setMax(100);
        this.f17456c.setProgress(0);
        DSBridgeWebView dSBridgeWebView = new DSBridgeWebView(getActivity());
        this.f17455b = dSBridgeWebView;
        dSBridgeWebView.getSettings().setDomStorageEnabled(true);
        this.f17455b.getSettings().setSavePassword(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 16715776);
        this.f17458e = new ImageView(getActivity());
        int a10 = IFLYBrowser.a(getActivity(), 30.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a10, a10);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        int a11 = IFLYBrowser.a(getActivity(), 30.0f);
        layoutParams2.setMargins(a11, a11, a11, a11);
        this.f17458e.setImageDrawable(getResources().getDrawable(R.drawable.ifly_ad_delete));
        this.f17457d.addView(this.f17456c, -1, 7);
        this.f17457d.addView(this.f17455b, layoutParams);
        this.f17457d.addView(this.f17458e, layoutParams2);
        this.f17455b.setWebChromeClient(this.f17454a);
        this.f17455b.loadUrl(string);
        this.f17458e.setOnClickListener(new View.OnClickListener() { // from class: com.shu.priory.webclient.WebViewDialogFragment.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewDialogFragment.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        getDialog().getWindow().setLayout(-1, -1);
    }

    public static WebViewDialogFragment a(String str) {
        WebViewDialogFragment webViewDialogFragment = new WebViewDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        webViewDialogFragment.setArguments(bundle);
        return webViewDialogFragment;
    }
}
