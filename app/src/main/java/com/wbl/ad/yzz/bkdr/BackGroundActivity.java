package com.wbl.ad.yzz.bkdr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.bkdr.a;
import f.b.a.d;
import f.b.a.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0013\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/wbl/ad/yzz/bkdr/BackGroundActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onDestroy", "b", "a", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTvClose", "<init>", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class BackGroundActivity extends AppCompatActivity {

    /* renamed from: a, reason: from kotlin metadata */
    public RecyclerView mRecyclerView;

    /* renamed from: b, reason: from kotlin metadata */
    public TextView mTvClose;

    public static final class a extends RecyclerView.Adapter<C0689a> {

        /* renamed from: a */
        public List<a.b> f31616a;

        /* renamed from: b */
        public final Activity f31617b;

        /* renamed from: com.wbl.ad.yzz.bkdr.BackGroundActivity$a$a */
        public static final class C0689a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public final int f31618a;

            /* renamed from: b */
            public final TextView f31619b;

            /* renamed from: c */
            public final TextView f31620c;

            /* renamed from: d */
            public final CheckBox f31621d;

            /* renamed from: com.wbl.ad.yzz.bkdr.BackGroundActivity$a$a$a */
            public static final class C0690a implements CompoundButton.OnCheckedChangeListener {
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15031, this, compoundButton, Boolean.valueOf(z));
                }
            }

            /* renamed from: com.wbl.ad.yzz.bkdr.BackGroundActivity$a$a$b */
            public static final class b implements View.OnClickListener {

                /* renamed from: a */
                public final /* synthetic */ Activity f31622a;

                /* renamed from: b */
                public final /* synthetic */ a.b f31623b;

                public b(Activity activity, a.b bVar) {
                    this.f31622a = activity;
                    this.f31623b = bVar;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15026, this, view);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0689a(int i2, @d View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f31618a = i2;
                if (i2 == 1) {
                    this.f31619b = null;
                    this.f31620c = null;
                    this.f31621d = (CheckBox) itemView.findViewById(R.id.check_box_log_switch);
                } else {
                    this.f31619b = (TextView) itemView.findViewById(R.id.tv_title_item_background);
                    this.f31620c = (TextView) itemView.findViewById(R.id.tv_content_item_background);
                    this.f31621d = null;
                }
            }

            public final void a(Activity activity, a.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15025, this, activity, bVar, Integer.valueOf(i2));
            }
        }

        public a(@d Activity context, @e List<a.b> list) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f31616a = list;
            this.f31617b = context;
        }

        public C0689a a(ViewGroup viewGroup, int i2) {
            return (C0689a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15028, this, viewGroup, Integer.valueOf(i2));
        }

        public void a(C0689a c0689a, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15027, this, c0689a, Integer.valueOf(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14990, this, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14989, this, Integer.valueOf(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(C0689a c0689a, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14992, this, c0689a, Integer.valueOf(i2));
        }

        /* JADX WARN: Type inference failed for: r3v4, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, com.wbl.ad.yzz.bkdr.BackGroundActivity$a$a] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ C0689a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return (RecyclerView.ViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14991, this, viewGroup, Integer.valueOf(i2));
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14986, this, view);
        }
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14985, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14988, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14987, this, savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14982, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14981, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14984, this, null);
    }
}
