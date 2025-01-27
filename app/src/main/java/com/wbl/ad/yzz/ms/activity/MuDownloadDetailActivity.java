package com.wbl.ad.yzz.ms.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.data.view.ListViewForScrollView;
import com.wbl.ad.yzz.ms.f.m.n;
import com.wbl.ad.yzz.ms.supporter.utils.DownloadDialogBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class MuDownloadDetailActivity extends AppCompatActivity {

    /* renamed from: a */
    public ListViewForScrollView f33034a;

    /* renamed from: b */
    public TextView f33035b;

    /* renamed from: c */
    public LinearLayout f33036c;

    /* renamed from: d */
    public TextView f33037d;

    /* renamed from: e */
    public LinearLayout f33038e;

    /* renamed from: f */
    public TextView f33039f;

    /* renamed from: g */
    public LinearLayout f33040g;

    /* renamed from: h */
    public TextView f33041h;

    /* renamed from: i */
    public LinearLayout f33042i;

    /* renamed from: j */
    public TextView f33043j;
    public LinearLayout k;
    public TextView l;
    public LinearLayout m;
    public String n;
    public TextView o;
    public LinearLayout p;
    public List<n> q = new ArrayList();
    public DownloadDialogBean r;
    public ImageView s;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12682, this, view);
        }
    }

    public class b extends BaseAdapter {
        public /* synthetic */ b(MuDownloadDetailActivity muDownloadDetailActivity, a aVar) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12681, this, null);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12684, this, Integer.valueOf(i2));
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-12683, this, Integer.valueOf(i2));
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12678, this, Integer.valueOf(i2), view, viewGroup);
        }

        public b() {
        }
    }

    public static /* synthetic */ List a(MuDownloadDetailActivity muDownloadDetailActivity) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12677, null, muDownloadDetailActivity);
    }

    public static void startActivity(Context context, DownloadDialogBean downloadDialogBean) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12680, null, context, downloadDialogBean);
    }

    public final String a(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12679, this, str);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12674, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12673, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12676, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12675, this, bundle);
    }
}
