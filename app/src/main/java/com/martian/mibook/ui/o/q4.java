package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import com.martian.libcomm.utils.e;
import com.martian.libmars.utils.k0;
import com.martian.libsupport.e;
import com.martian.libsupport.permission.TipInfo;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.TypefaceManager;
import com.martian.mibook.data.TypefaceItem;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.ttbookhd.R;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class q4 extends BaseAdapter {

    /* renamed from: a */
    private final Activity f14638a;

    /* renamed from: c */
    private final d f14640c;

    /* renamed from: d */
    private final e f14641d;

    /* renamed from: e */
    private Integer f14642e = null;

    /* renamed from: b */
    private LinkedList<TypefaceItem> f14639b = new LinkedList<>();

    class a implements com.martian.libsupport.permission.f {

        /* renamed from: a */
        final /* synthetic */ TypefaceItem f14643a;

        /* renamed from: b */
        final /* synthetic */ com.martian.mibook.e.n4 f14644b;

        /* renamed from: com.martian.mibook.ui.o.q4$a$a */
        class C0278a implements c {

            /* renamed from: com.martian.mibook.ui.o.q4$a$a$a */
            class C0279a implements e.b {
                C0279a() {
                }

                @Override // com.martian.libsupport.e.b
                public void a(String destPath) {
                    q4.this.f14642e = null;
                    a.this.f14643a.setFaceStatus(0);
                    a.this.f14644b.f12425c.setVisibility(8);
                    com.martian.libmars.utils.w0.a(q4.this.f14638a, q4.this.f14638a.getString(R.string.unzip_finish));
                    q4.this.notifyDataSetChanged();
                }

                @Override // com.martian.libsupport.e.b
                public void onError(String errMsg) {
                    q4.this.f14642e = null;
                    a.this.f14643a.setFaceStatus(3);
                    a.this.f14644b.f12425c.setVisibility(0);
                    a aVar = a.this;
                    aVar.f14644b.f12425c.setText(q4.this.f14638a.getString(R.string.unzip_failed));
                }

                @Override // com.martian.libsupport.e.b
                public void onLoading(boolean loading) {
                }
            }

            C0278a() {
            }

            @Override // com.martian.mibook.ui.o.q4.c
            public void a(String filepath) {
                a.this.f14643a.setFaceStatus(2);
                a.this.f14644b.f12425c.setVisibility(8);
                a aVar = a.this;
                aVar.f14644b.f12427e.setText(q4.this.f14638a.getString(R.string.unzip_desc));
                com.martian.libsupport.e.C(filepath, com.martian.libmars.d.h.F().u(), new C0279a());
            }

            @Override // com.martian.mibook.ui.o.q4.c
            @SuppressLint({"SetTextI18n"})
            public void b(int percent) {
                a.this.f14643a.setFaceStatus(1);
                a.this.f14644b.f12425c.setVisibility(8);
                a.this.f14644b.f12427e.setText(q4.this.f14638a.getString(R.string.download_desc) + percent + "%");
            }

            @Override // com.martian.mibook.ui.o.q4.c
            public void onError(String errMsg) {
                q4.this.f14642e = null;
                a.this.f14643a.setFaceStatus(3);
                a.this.f14644b.f12425c.setVisibility(0);
                a aVar = a.this;
                aVar.f14644b.f12425c.setText(q4.this.f14638a.getString(R.string.download_failed));
            }
        }

        a(final TypefaceItem val$binding, final com.martian.mibook.e.n4 val$typefaceItem) {
            this.f14643a = val$binding;
            this.f14644b = val$typefaceItem;
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            q4.this.f14642e = null;
            com.martian.libmars.utils.w0.a(q4.this.f14638a, q4.this.f14638a.getString(R.string.lack_storage_permission));
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            String filePath = this.f14643a.getFilePath();
            if (new File(filePath).exists()) {
                MiConfigSingleton.V3().r8(filePath);
                MiConfigSingleton.V3().s8(Boolean.FALSE);
            } else {
                this.f14644b.f12427e.setEnabled(false);
                q4.this.e(this.f14643a.getDownloadPath(), this.f14643a.getDownloadUrl(), new C0278a());
            }
        }
    }

    class b implements e.c {

        /* renamed from: a */
        final /* synthetic */ c f14648a;

        /* renamed from: b */
        final /* synthetic */ String f14649b;

        b(final c val$filepath, final String val$listener) {
            this.f14648a = val$filepath;
            this.f14649b = val$listener;
        }

        @Override // com.martian.libcomm.utils.e.c
        public void a(b.d.c.b.c errorResult) {
            this.f14648a.onError(errorResult.d());
        }

        @Override // com.martian.libcomm.utils.e.c
        public void b(int soFarBytes, int totalBytes) {
            this.f14648a.b((soFarBytes * 100) / totalBytes);
        }

        @Override // com.martian.libcomm.utils.e.c
        public void c(int totalBytes) {
            this.f14648a.a(this.f14649b);
        }

        @Override // com.martian.libcomm.utils.e.c
        public void onCancel() {
        }

        @Override // com.martian.libcomm.utils.e.c
        public void onStart() {
        }
    }

    private interface c {
        void a(String filepath);

        void b(int percent);

        void onError(String errMsg);
    }

    public interface d {
        void a();
    }

    public interface e {
        void a();
    }

    public q4(Activity context, d listener, e deleteListener) {
        this.f14638a = context;
        this.f14640c = listener;
        this.f14641d = deleteListener;
    }

    public void e(final String filepath, String downloadUrl, @NonNull final c listener) {
        com.martian.libcomm.utils.e.c(downloadUrl, filepath, new b(listener, filepath));
    }

    /* renamed from: h */
    public /* synthetic */ boolean i(final TypefaceItem typefaceItem, final int position, final com.martian.mibook.e.n4 binding, View view) {
        if (typefaceItem.getType() != 2) {
            return true;
        }
        Activity activity = this.f14638a;
        com.martian.libmars.utils.k0.P(activity, activity.getString(R.string.prompt), "删除选中的字体?", new k0.l() { // from class: com.martian.mibook.ui.o.b3
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                q4.this.o(position, binding);
            }
        });
        return true;
    }

    /* renamed from: j */
    public /* synthetic */ void k(final TypefaceItem typefaceItem, View view) {
        if (typefaceItem.getType() == 0) {
            MiConfigSingleton.V3().s8(Boolean.TRUE);
        } else if (typefaceItem.getType() == 2) {
            MiConfigSingleton.V3().r8(typefaceItem.getFilePath());
            MiConfigSingleton.V3().s8(Boolean.FALSE);
        } else if (typefaceItem.getType() == 1 && typefaceItem.getFaceStatus() == 0) {
            String filePath = typefaceItem.getFilePath();
            if (new File(filePath).exists()) {
                MiConfigSingleton.V3().r8(filePath);
                MiConfigSingleton.V3().s8(Boolean.FALSE);
            } else {
                Activity activity = this.f14638a;
                com.martian.libmars.utils.w0.a(activity, activity.getString(R.string.download_hint));
            }
        }
        d dVar = this.f14640c;
        if (dVar != null) {
            dVar.a();
        }
        notifyDataSetChanged();
    }

    /* renamed from: l */
    public /* synthetic */ void m(final int position, final TypefaceItem typefaceItem, final com.martian.mibook.e.n4 binding, View v) {
        Integer num = this.f14642e;
        if (num != null) {
            if (num.intValue() == position || typefaceItem.getFaceStatus() == 4) {
                q(typefaceItem);
                return;
            } else {
                q((TypefaceItem) getItem(this.f14642e.intValue()));
                typefaceItem.setFaceStatus(4);
            }
        }
        this.f14642e = Integer.valueOf(position);
        com.martian.libsupport.permission.g.h(this.f14638a, new a(typefaceItem, binding), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo(this.f14638a.getString(R.string.request_permission_title), this.f14638a.getString(R.string.request_permission_desc), this.f14638a.getString(R.string.search_close), this.f14638a.getString(R.string.to_open)), true);
        d dVar = this.f14640c;
        if (dVar != null) {
            dVar.a();
        }
        notifyDataSetChanged();
    }

    /* renamed from: n */
    public /* synthetic */ void o(final int position, final com.martian.mibook.e.n4 binding) {
        d(position, binding.f12426d.getVisibility() == 0);
    }

    private void q(TypefaceItem typefaceItem) {
        if (this.f14638a != null) {
            if (typefaceItem.getFaceStatus() == 1) {
                Activity activity = this.f14638a;
                com.martian.libmars.utils.w0.a(activity, activity.getString(R.string.download_hint2));
            } else if (typefaceItem.getFaceStatus() == 2) {
                Activity activity2 = this.f14638a;
                com.martian.libmars.utils.w0.a(activity2, activity2.getString(R.string.unzip_hint));
            } else if (typefaceItem.getFaceStatus() == 4) {
                Activity activity3 = this.f14638a;
                com.martian.libmars.utils.w0.a(activity3, activity3.getString(R.string.download_hint3));
            }
        }
    }

    public void d(int position, boolean isChecked) {
        TypefaceItem typefaceItem = this.f14639b.get(position);
        if (typefaceItem != null) {
            new TypefaceManager(this.f14638a).b(typefaceItem.getFilePath());
            e eVar = this.f14641d;
            if (eVar != null && isChecked) {
                eVar.a();
            }
        }
        this.f14639b.remove(position);
        notifyDataSetChanged();
    }

    public TypefaceItem f(int position) {
        return this.f14639b.get(position);
    }

    public int g() {
        if (MiConfigSingleton.V3().B4().booleanValue()) {
            return 0;
        }
        for (int i2 = 1; i2 < this.f14639b.size(); i2++) {
            TypefaceItem typefaceItem = this.f14639b.get(i2);
            if (!com.martian.libsupport.k.p(typefaceItem.getFilePath()) && typefaceItem.getFilePath().equalsIgnoreCase(MiConfigSingleton.V3().A4())) {
                return i2;
            }
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        LinkedList<TypefaceItem> linkedList = this.f14639b;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14639b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        final com.martian.mibook.e.n4 n4Var;
        if (convertView == null) {
            convertView = View.inflate(this.f14638a, R.layout.page_item_typeface, null);
            n4Var = com.martian.mibook.e.n4.a(convertView);
            convertView.setTag(n4Var);
        } else {
            n4Var = (com.martian.mibook.e.n4) convertView.getTag();
        }
        final TypefaceItem typefaceItem = (TypefaceItem) getItem(position);
        if (typefaceItem == null) {
            return convertView;
        }
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        n4Var.f12429g.setVisibility(0);
        n4Var.f12424b.setVisibility(8);
        n4Var.f12427e.setEnabled(true);
        n4Var.f12426d.setColorFilter(r.getItemColorPrimary());
        if (typefaceItem.getType() != 0) {
            if (MiConfigSingleton.V3().B4().booleanValue() || com.martian.libsupport.k.p(typefaceItem.getFilePath()) || !typefaceItem.getFilePath().equalsIgnoreCase(MiConfigSingleton.V3().A4())) {
                n4Var.f12426d.setVisibility(8);
                n4Var.f12429g.setTextColor(r.getTextColorPrimary(this.f14638a));
                n4Var.f12424b.setColorFilter(r.getTextColorPrimary(this.f14638a));
            } else {
                n4Var.f12426d.setVisibility(0);
                n4Var.f12429g.setTextColor(r.getItemColorPrimary());
                n4Var.f12424b.setColorFilter(r.getItemColorPrimary());
            }
        }
        int type = typefaceItem.getType();
        if (type == 0) {
            n4Var.f12429g.setTypeface(Typeface.DEFAULT);
            n4Var.f12429g.setText(this.f14638a.getString(R.string.system_used));
            if (MiConfigSingleton.V3().B4().booleanValue()) {
                n4Var.f12426d.setVisibility(0);
                n4Var.f12429g.setTextColor(r.getItemColorPrimary());
            } else {
                n4Var.f12426d.setVisibility(8);
                n4Var.f12429g.setTextColor(r.getTextColorPrimary(this.f14638a));
            }
            n4Var.f12427e.setVisibility(8);
            n4Var.f12430h.setVisibility(8);
        } else if (type == 1) {
            n4Var.f12427e.setVisibility(0);
            n4Var.f12430h.setVisibility(0);
            if (typefaceItem.getFaceStatus() == 0) {
                if (new File(typefaceItem.getFilePath()).exists()) {
                    n4Var.f12427e.setVisibility(8);
                    n4Var.f12430h.setVisibility(8);
                } else {
                    n4Var.f12427e.setText(this.f14638a.getString(R.string.download));
                }
            } else if (typefaceItem.getFaceStatus() == 3) {
                n4Var.f12427e.setText(R.string.click_to_retry);
            } else if (typefaceItem.getFaceStatus() == 4) {
                n4Var.f12427e.setText(R.string.wait_download);
            }
            n4Var.f12430h.setText(typefaceItem.getFileSize());
            n4Var.f12429g.setVisibility(4);
            n4Var.f12424b.setVisibility(0);
            n4Var.f12424b.setImageResource(typefaceItem.getRes());
        } else if (type == 2) {
            String filePath = typefaceItem.getFilePath();
            if (!com.martian.libsupport.k.p(filePath)) {
                File file = new File(filePath);
                if (file.exists()) {
                    Typeface b2 = com.martian.mibook.j.x2.b(filePath);
                    if (b2 != null) {
                        n4Var.f12429g.setTypeface(b2);
                    }
                    n4Var.f12429g.setText(file.getName().substring(0, file.getName().indexOf(46)));
                }
            }
            n4Var.f12427e.setVisibility(8);
            n4Var.f12430h.setVisibility(8);
        } else if (type == 3) {
            n4Var.f12427e.setVisibility(8);
            n4Var.f12430h.setVisibility(8);
        }
        n4Var.f12428f.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.ui.o.c3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return q4.this.i(typefaceItem, position, n4Var, view);
            }
        });
        n4Var.f12428f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.a3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q4.this.k(typefaceItem, view);
            }
        });
        n4Var.f12427e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q4.this.m(position, typefaceItem, n4Var, view);
            }
        });
        return convertView;
    }

    public void p(LinkedList<TypefaceItem> pageList) {
        this.f14639b = pageList;
        notifyDataSetChanged();
    }
}
