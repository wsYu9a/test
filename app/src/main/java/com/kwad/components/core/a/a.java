package com.kwad.components.core.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    @Nullable
    private ImageView HA;

    @Nullable
    private InterfaceC0162a HB;

    @Nullable
    private TextView Hy;

    @Nullable
    private ImageView Hz;
    private ViewGroup sn;

    /* renamed from: com.kwad.components.core.a.a$a */
    public interface InterfaceC0162a {
        void t(View view);

        void u(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.sn = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.Hy = (TextView) this.sn.findViewById(R.id.ksad_kwad_titlebar_title);
        this.Hz = (ImageView) this.sn.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.sn.findViewById(R.id.ksad_kwad_web_navi_close);
        this.HA = imageView;
        imageView.setOnClickListener(this);
        this.Hz.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC0162a interfaceC0162a) {
        this.HB = interfaceC0162a;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.sn == null || (textView = this.Hy) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    @MainThread
    public final void am(boolean z) {
        ImageView imageView = this.HA;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final ViewGroup gK() {
        return this.sn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.HB == null) {
            return;
        }
        if (view.equals(this.HA)) {
            this.HB.u(view);
        } else if (view.equals(this.Hz)) {
            this.HB.t(view);
        }
    }
}
