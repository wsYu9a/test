package com.martian.mibook.mvvm.yuewen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.d;
import com.martian.mibook.R;
import com.martian.mibook.databinding.ActivityReadingRecordBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.yuewen.activity.ReadingRecordActivity;
import com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookShelfViewModel;
import h3.e;
import kc.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.l;

@Route(path = a.f27757m)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/activity/ReadingRecordActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityReadingRecordBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel;", "<init>", "()V", "", "H1", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/martian/mibook/mvvm/yuewen/fragment/ReadingRecordFragment;", "h", "Lcom/martian/mibook/mvvm/yuewen/fragment/ReadingRecordFragment;", "readingRecordFragment", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingRecordActivity extends BaseMVVMActivity<ActivityReadingRecordBinding, BookShelfViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public ReadingRecordFragment readingRecordFragment;

    private final void H1() {
        ReadingRecordFragment b10 = ReadingRecordFragment.Companion.b(ReadingRecordFragment.INSTANCE, false, 1, null);
        this.readingRecordFragment = b10;
        if (b10 != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, b10).commitAllowingStateLoss();
        }
    }

    public static final void I1(ReadingRecordActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void J1(ReadingRecordActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadingRecordFragment readingRecordFragment = this$0.readingRecordFragment;
        if (readingRecordFragment != null) {
            readingRecordFragment.a1(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        d.x2(this, ((ActivityReadingRecordBinding) a1()).toolbar);
        ((ActivityReadingRecordBinding) a1()).actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: sd.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingRecordActivity.I1(ReadingRecordActivity.this, view);
            }
        });
        ((ActivityReadingRecordBinding) a1()).actionbarTitle.setText(getString(R.string.novel_history));
        ((ActivityReadingRecordBinding) a1()).tvManage.setOnClickListener(new View.OnClickListener() { // from class: sd.f
            public /* synthetic */ f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingRecordActivity.J1(ReadingRecordActivity.this, view);
            }
        });
        H1();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @l Intent r32) {
        super.onActivityResult(requestCode, resultCode, r32);
        if (requestCode == 200 && resultCode == -1) {
            ac.a.D(this, "登录成功-同步阅读记录");
        }
    }
}
