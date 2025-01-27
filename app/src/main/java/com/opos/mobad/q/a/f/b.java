package com.opos.mobad.q.a.f;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.q.a.i;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private Context f23292a;

    /* renamed from: b */
    private View f23293b;

    /* renamed from: c */
    private ViewGroup f23294c;

    /* renamed from: d */
    private TextView f23295d;

    /* renamed from: e */
    private View f23296e;

    /* renamed from: f */
    private TextView f23297f;

    /* renamed from: g */
    private ImageView f23298g;

    /* renamed from: h */
    private View f23299h;

    /* renamed from: i */
    private View f23300i;

    /* renamed from: j */
    private a f23301j;

    /* renamed from: com.opos.mobad.q.a.f.b$1 */
    class AnonymousClass1 extends i {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.q.a.i
        public void a(View view, int[] iArr) {
            a aVar = b.this.f23301j;
            if (aVar == null) {
                return;
            }
            if (view == b.this.f23295d) {
                aVar.b(view, iArr);
            } else if (view == b.this.f23298g) {
                aVar.d(view, iArr);
            } else if (view == b.this.f23300i) {
                aVar.c(view, iArr);
            }
        }
    }

    public interface a {
        void b(View view, int[] iArr);

        void c(View view, int[] iArr);

        void d(View view, int[] iArr);
    }

    public b(Context context) {
        this.f23292a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.opos_mob_layout_reward_title, (ViewGroup) null);
        this.f23293b = inflate;
        this.f23294c = (ViewGroup) inflate.findViewById(R.id.opos_mob_video_title_left);
        this.f23295d = (TextView) this.f23293b.findViewById(R.id.opos_mob_video_btn_vip);
        this.f23296e = this.f23293b.findViewById(R.id.opos_mob_txt_video_left_split);
        this.f23297f = (TextView) this.f23293b.findViewById(R.id.opos_mob_txt_video_count);
        this.f23298g = (ImageView) this.f23293b.findViewById(R.id.opos_mob_btn_video_sound);
        this.f23299h = this.f23293b.findViewById(R.id.opos_mob_txt_video_right_split);
        this.f23300i = this.f23293b.findViewById(R.id.opos_mob_btn_video_close);
        AnonymousClass1 anonymousClass1 = new i() { // from class: com.opos.mobad.q.a.f.b.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                a aVar = b.this.f23301j;
                if (aVar == null) {
                    return;
                }
                if (view == b.this.f23295d) {
                    aVar.b(view, iArr);
                } else if (view == b.this.f23298g) {
                    aVar.d(view, iArr);
                } else if (view == b.this.f23300i) {
                    aVar.c(view, iArr);
                }
            }
        };
        this.f23295d.setOnTouchListener(anonymousClass1);
        this.f23300i.setOnTouchListener(anonymousClass1);
        this.f23298g.setOnTouchListener(anonymousClass1);
        this.f23295d.setOnClickListener(anonymousClass1);
        this.f23300i.setOnClickListener(anonymousClass1);
        this.f23298g.setOnClickListener(anonymousClass1);
        b(false);
    }

    private void b(boolean z) {
        this.f23300i.setVisibility(z ? 0 : 8);
        this.f23299h.setVisibility(z ? 0 : 8);
    }

    public void a() {
        b(true);
    }

    public void a(int i2, boolean z) {
        TextView textView;
        String str;
        int i3 = 8;
        if (i2 == 0 && !z) {
            this.f23294c.setVisibility(8);
            return;
        }
        this.f23294c.setVisibility(0);
        this.f23297f.setVisibility(z ? 0 : 8);
        boolean z2 = true;
        if (i2 == 1) {
            textView = this.f23295d;
            str = "跳过广告";
        } else {
            if (i2 != 2) {
                this.f23295d.setVisibility(8);
                z2 = false;
                View view = this.f23296e;
                if (z && z2) {
                    i3 = 0;
                }
                view.setVisibility(i3);
            }
            textView = this.f23295d;
            str = "VIP免广告";
        }
        textView.setText(str);
        this.f23295d.setVisibility(0);
        View view2 = this.f23296e;
        if (z) {
            i3 = 0;
        }
        view2.setVisibility(i3);
    }

    public void a(a aVar) {
        this.f23301j = aVar;
    }

    public void a(String str) {
        this.f23297f.setText(str);
    }

    public void a(boolean z) {
        ImageView imageView;
        Resources resources;
        int i2;
        if (z) {
            imageView = this.f23298g;
            resources = this.f23292a.getResources();
            i2 = R.drawable.opos_mob_drawable_sound_on;
        } else {
            imageView = this.f23298g;
            resources = this.f23292a.getResources();
            i2 = R.drawable.opos_mob_drawable_sound_off;
        }
        imageView.setImageDrawable(resources.getDrawable(i2));
    }

    public View b() {
        return this.f23293b;
    }
}
