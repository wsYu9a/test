package com.aggmoread.sdk.z.b.o;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.m.j;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.b.u.e;
import com.aggmoread.sdk.z.d.a.a.e.l;

/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a */
    private Activity f4741a;

    /* renamed from: b */
    private l f4742b;

    /* renamed from: c */
    private g f4743c;

    /* renamed from: d */
    private d f4744d;

    /* renamed from: e */
    private com.aggmoread.sdk.z.b.s.a f4745e;

    /* renamed from: f */
    private TextView f4746f;

    /* renamed from: com.aggmoread.sdk.z.b.o.a$a */
    public class ViewOnClickListenerC0082a implements View.OnClickListener {
        public ViewOnClickListenerC0082a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f4741a != null) {
                a.this.f4741a.finish();
            }
            if (a.this.f4744d != null) {
                a.this.f4744d.a();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f4744d != null) {
                a.this.f4744d.a(a.this.f4741a);
            }
        }
    }

    public class c implements a.g {

        /* renamed from: com.aggmoread.sdk.z.b.o.a$c$a */
        public class RunnableC0083a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f4750b;

            public RunnableC0083a(Bitmap bitmap) {
                this.f4750b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f4744d != null) {
                    a.this.f4744d.a(a.this.f4745e);
                }
                a.this.f4742b.setImageBitmap(this.f4750b);
                a.this.f4746f.setVisibility(0);
            }
        }

        public c() {
        }

        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.b.g.e eVar) {
            a aVar = a.this;
            if (eVar != null) {
                aVar.d();
                return;
            }
            if (bArr == null) {
                aVar.d();
                return;
            }
            n.a().post(new RunnableC0083a(com.aggmoread.sdk.z.b.n.a.a().a(aVar.f4742b.getWidth(), a.this.f4742b.getHeight(), Bitmap.Config.ARGB_8888, ImageView.ScaleType.CENTER_INSIDE, bArr)));
        }
    }

    public interface d {
        void a();

        void a(int i10, String str);

        void a(Activity activity);

        void a(com.aggmoread.sdk.z.b.s.a aVar);
    }

    private View c() {
        FrameLayout frameLayout = new FrameLayout(this.f4741a);
        frameLayout.setBackgroundColor(Color.parseColor("#50000000"));
        FrameLayout frameLayout2 = new FrameLayout(this.f4741a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 300.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 500.0d));
        layoutParams.gravity = 17;
        int a10 = com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 6.0d);
        Drawable a11 = com.aggmoread.sdk.z.b.m.b.a(-16777216, 1.0f, a10, 0, 0);
        frameLayout2.setBackground(a11);
        frameLayout2.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.f4741a);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        l lVar = new l(this.f4741a);
        this.f4742b = lVar;
        lVar.a(a10);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        this.f4742b.setLayoutParams(layoutParams2);
        this.f4742b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f4742b.setBackground(a11);
        linearLayout.addView(this.f4742b);
        this.f4746f = new TextView(this.f4741a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int a12 = com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 10.0d);
        com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 20.0d);
        layoutParams3.topMargin = a12;
        this.f4746f.setLayoutParams(layoutParams3);
        this.f4746f.setText("查看详情");
        this.f4746f.setTextColor(Color.parseColor("#ffffff"));
        this.f4746f.setTextSize(15.0f);
        this.f4746f.setPadding(a12, a12, a12, a12);
        this.f4746f.setGravity(17);
        this.f4746f.setBackground(com.aggmoread.sdk.z.b.m.b.a(Color.parseColor("#0a81fc"), 1.0f, com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 6.0d), 0, 0));
        this.f4746f.setVisibility(4);
        linearLayout.addView(this.f4746f);
        frameLayout2.addView(linearLayout);
        ImageView imageView = new ImageView(this.f4741a);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 24.0d), com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 24.0d));
        layoutParams4.gravity = 53;
        layoutParams4.topMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 10.0d);
        layoutParams4.rightMargin = com.aggmoread.sdk.z.b.m.b.a(this.f4741a, 10.0d);
        imageView.setLayoutParams(layoutParams4);
        j.a(imageView, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAmZJREFUWEfVlzloFmEQhp+30FIQQVAUBK9ORLQQDyKS1IKaWkjpFQUbU6igQbTQJJYGe2PAq9LCI9opqJ0HaCEKKe3ldT+ZHzabvRIDiwvbfNc8O/POzLei40cd2+f/ArC9ExgA+oG1wJrw4E/gB3APmJH0oa1nW3nA9j7gNHC4cPA34DewsTA+DYxJmmkCaQSwfQU4Hwe9A14Bb4HnkhIAttcBu+M9CGyL9ROSTtVB1ALYTsb2xAHXgcuSftUdaHs1cAs4Guu+SNpctacSwPZnYFNsHJD0tMmd+XnbKWQ3Y+y1pL1l+0sBbI8DJ9MGSY1havCIY35U0khx7bzDQ3AvY+GwpLGFfHlxre2UMU9ifH9RmGUAKZWS2qckDfYOtN2XCa8vc8jFhi8eBu73BBoivQacA6YlHcnvnwNgO6n3PZDyuF/SbA4gGb5QBCvE/W6I71Ie1PYK4EUGth3YJelNb18R4Hgo+Eam9rMl7uwZmOOd+MrKuZifAE4AI5JGqwCeJTcDg5Kmylxte56hsrES+GPAnagfB6oAPgJbgPWSvlfFOm8w1qScn+eVQng2AF+BT5K2VgGkIjMrqZf/lXrLQaQ1tcZzOkoAqyQlTfx9ihroHGAxIVgGHGrygu1WIViwCG0vBx5Fm64Mhe1WIlxUGtpeCTwEUr0vhbDdKg3rCtEQcLvGQGrJDzKQHcAZSb1GlNp1u0IUBaO0FMfckKTJmvRM6XU1S+NJSY9z6m9XisNIuv1014wCort2nHNbdxeSHER3V7IcRHeX0hxEd9fyQkfr5seksiUuwcQ/3XiXwH73P6d/AMNtZjBWZp4QAAAAAElFTkSuQmCC");
        imageView.setOnClickListener(new ViewOnClickListenerC0082a());
        frameLayout2.addView(imageView);
        frameLayout2.setOnClickListener(new b());
        this.f4745e = com.aggmoread.sdk.z.b.s.a.a(frameLayout2, null);
        frameLayout.addView(frameLayout2);
        return frameLayout;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void onPause() {
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void onResume() {
    }

    public void d() {
        d dVar = this.f4744d;
        if (dVar != null) {
            dVar.a(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, "素材加载失败");
        }
    }

    private void e() {
        g gVar = this.f4743c;
        if (gVar == null) {
            d();
        } else if (this.f4742b != null) {
            com.aggmoread.sdk.z.b.p.a.a(gVar.f4505a, null, new c());
        }
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void a(Activity activity) {
        this.f4741a = activity;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void b() {
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void a(Intent intent) {
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public void a(Bundle bundle) {
        Activity activity = this.f4741a;
        if (activity != null) {
            activity.setContentView(c());
            e();
        }
    }

    public void a(g gVar) {
        this.f4743c = gVar;
    }

    public void a(d dVar) {
        this.f4744d = dVar;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public boolean a() {
        return true;
    }

    @Override // com.aggmoread.sdk.z.b.u.e
    public boolean a(MotionEvent motionEvent) {
        return false;
    }
}
