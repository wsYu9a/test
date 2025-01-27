package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes3.dex */
public final class a implements View.OnClickListener {

    @Nullable
    private TextView KJ;

    @Nullable
    private ImageView KK;

    @Nullable
    private ImageView KL;

    @Nullable
    private InterfaceC0416a KM;

    /* renamed from: uc */
    private ViewGroup f11912uc;

    /* renamed from: com.kwad.components.core.b.a$a */
    public interface InterfaceC0416a {
        void v(View view);

        void w(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.f11912uc = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.KJ = (TextView) this.f11912uc.findViewById(R.id.ksad_kwad_titlebar_title);
        this.KK = (ImageView) this.f11912uc.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.f11912uc.findViewById(R.id.ksad_kwad_web_navi_close);
        this.KL = imageView;
        imageView.setOnClickListener(this);
        this.KK.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC0416a interfaceC0416a) {
        this.KM = interfaceC0416a;
    }

    @MainThread
    public final void ai(boolean z10) {
        ImageView imageView = this.KL;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final ViewGroup ha() {
        return this.f11912uc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.KM == null) {
            return;
        }
        if (view.equals(this.KL)) {
            this.KM.w(view);
        } else if (view.equals(this.KK)) {
            this.KM.v(view);
        }
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.f11912uc == null || (textView = this.KJ) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }
}
