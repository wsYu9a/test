package com.martian.mibook.mvvm.home.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.multidex.MultiDex;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.TeenagerBookmallActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityHomeBinding;
import com.martian.mibook.fragment.yuewen.YWCategoryMainFragment;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.DefaultViewModel;
import com.martian.mibook.mvvm.home.activity.HomeActivity;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.fragment.AccountFragment;
import com.martian.mibook.mvvm.yuewen.fragment.BookShelfMainFragment;
import com.martian.mibook.mvvm.yuewen.fragment.MissionCenterFragment;
import com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment;
import com.martian.mibook.receiver.MiAPKInstallReceiver;
import com.sntech.ads.SNAdSdk;
import h3.e;
import i8.g;
import java.util.ArrayList;
import java.util.List;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import l9.t0;
import r3.c;
import wj.b;
import xi.k;
import xi.l;
import ya.e0;
import ya.j2;

@Route(path = kc.a.f27761q)
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005J\u0019\u0010+\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b+\u0010'J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u0005J\u0019\u0010-\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b-\u0010\u0011J\u0017\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J)\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b5\u00106J!\u0010:\u001a\u0002092\u0006\u00107\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b:\u0010;J/\u0010@\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00122\u000e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180<2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0006H\u0014¢\u0006\u0004\bB\u0010\u0005R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020H0G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006["}, d2 = {"Lcom/martian/mibook/mvvm/home/activity/HomeActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityHomeBinding;", "Lcom/martian/mibook/mvvm/base/DefaultViewModel;", "<init>", "()V", "", "d2", "P1", "initView", "b2", "c2", "f2", "X1", "Landroid/content/Intent;", "intent", "V1", "(Landroid/content/Intent;)V", "", "itemPosition", "k2", "(I)V", "tabId", "i2", "", NotificationCompat.CATEGORY_EVENT, "stag", "h2", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", "uri", "l2", "(Landroid/net/Uri;)V", "j2", "T1", "g2", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "u1", c.f30241d, "p1", "c1", "r1", "onNewIntent", "Landroid/view/View;", "view", "onSearchClick", "(Landroid/view/View;)V", "requestCode", "resultCode", e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "keyCode", "Landroid/view/KeyEvent;", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onDestroy", "Le9/c;", "h", "Le9/c;", "rxManager", "", "Landroidx/fragment/app/Fragment;", "i", "Ljava/util/List;", "fragmentList", "Lcom/martian/mibook/receiver/MiAPKInstallReceiver;", "j", "Lkotlin/Lazy;", "U1", "()Lcom/martian/mibook/receiver/MiAPKInstallReceiver;", "miAPKInstallReceiver", "k", "Ljava/lang/Integer;", "batchType", t.f11204d, "Z", "isDoubleClick", "m", "I", "ViewPager2Adapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeActivity.kt\ncom/martian/mibook/mvvm/home/activity/HomeActivity\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n*L\n1#1,578:1\n56#2,4:579\n*S KotlinDebug\n*F\n+ 1 HomeActivity.kt\ncom/martian/mibook/mvvm/home/activity/HomeActivity\n*L\n247#1:579,4\n*E\n"})
/* loaded from: classes3.dex */
public final class HomeActivity extends BaseMVVMActivity<ActivityHomeBinding, DefaultViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public e9.c rxManager;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public Integer batchType;

    /* renamed from: l */
    public boolean isDoubleClick;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public List<Fragment> fragmentList = new ArrayList();

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final Lazy miAPKInstallReceiver = LazyKt.lazy(HomeActivity$miAPKInstallReceiver$2.INSTANCE);

    /* renamed from: m, reason: from kotlin metadata */
    public int itemPosition = j2.f33272m;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/home/activity/HomeActivity$ViewPager2Adapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "Landroidx/fragment/app/Fragment;", "fragments", "<init>", "(Lcom/martian/mibook/mvvm/home/activity/HomeActivity;Landroidx/fragment/app/FragmentActivity;Ljava/util/List;)V", "", "getItemCount", "()I", id.c.f26972i, "createFragment", "(I)Landroidx/fragment/app/Fragment;", "c", "Ljava/util/List;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewPager2Adapter extends FragmentStateAdapter {

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final List<Fragment> fragments;

        /* renamed from: d */
        public final /* synthetic */ HomeActivity f14233d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewPager2Adapter(@k HomeActivity homeActivity, @k FragmentActivity fragmentActivity, List<? extends Fragment> fragments) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
            Intrinsics.checkNotNullParameter(fragments, "fragments");
            this.f14233d = homeActivity;
            this.fragments = fragments;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @k
        public Fragment createFragment(int r22) {
            return this.fragments.get(r22);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return this.fragments.size();
        }
    }

    public static final class a implements MiBookManager.a0 {
        public a() {
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(@l String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            t0.a(HomeActivity.this, str);
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(@l BookWrapper bookWrapper) {
            if ((bookWrapper != null ? bookWrapper.book : null) != null) {
                i.R(HomeActivity.this, bookWrapper.book);
            }
        }
    }

    private final void P1() {
        e9.c cVar = new e9.c();
        this.rxManager = cVar;
        cVar.c(j2.f33262c, new b() { // from class: tc.b
            public /* synthetic */ b() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                HomeActivity.Q1(HomeActivity.this, (Integer) obj);
            }
        });
        e9.c cVar2 = this.rxManager;
        if (cVar2 != null) {
            cVar2.c(j2.f33266g, new b() { // from class: tc.c
                public /* synthetic */ c() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    HomeActivity.R1(HomeActivity.this, ((Integer) obj).intValue());
                }
            });
        }
        e9.c cVar3 = this.rxManager;
        if (cVar3 != null) {
            cVar3.c(j2.S, new b() { // from class: tc.d
                public /* synthetic */ d() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    HomeActivity.S1(HomeActivity.this, (Integer) obj);
                }
            });
        }
    }

    public static final void Q1(HomeActivity this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null) {
            this$0.k2(num.intValue());
        }
    }

    public static final void R1(HomeActivity this$0, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.batchType = Integer.valueOf(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void S1(HomeActivity this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num == null) {
            return;
        }
        ((ActivityHomeBinding) this$0.a1()).bottomNavigationBar.getMenu().findItem(R.id.tab2).setIcon(num.intValue() == j2.I ? R.drawable.main_tab_icon_bookstore_refresh_day : R.drawable.main_tab_icon_bookstore_day);
    }

    public static final void W1(HomeActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e9.c cVar = this$0.rxManager;
        if (cVar != null) {
            cVar.d(j2.f33277r, Integer.valueOf(j2.f33284y));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean Y1(HomeActivity this$0, MenuItem item) {
        int size;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.tab1) {
            size = j2.f33271l;
        } else if (itemId == R.id.tab2) {
            size = j2.f33272m;
        } else if (itemId == R.id.tab3) {
            size = j2.f33273n;
        } else if (itemId == R.id.tab4) {
            size = j2.f33274o;
        } else {
            if (itemId != R.id.tab5) {
                return false;
            }
            size = this$0.fragmentList.size() - 1;
        }
        ((ActivityHomeBinding) this$0.a1()).mainViewpager2.setCurrentItem(size, false);
        this$0.i2(itemId);
        if (itemId == R.id.tab2 || itemId == R.id.tab5) {
            MiConfigSingleton.b2().e2().r0(this$0, this$0.rxManager, itemId == R.id.tab5);
        }
        return true;
    }

    public static final void Z1(HomeActivity this$0, MenuItem item) {
        e9.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.tab1) {
            e9.c cVar2 = this$0.rxManager;
            if (cVar2 != null) {
                cVar2.d(j2.f33277r, Integer.valueOf(j2.f33276q));
                return;
            }
            return;
        }
        if (item.getItemId() != R.id.tab2 || (cVar = this$0.rxManager) == null) {
            return;
        }
        cVar.d(j2.D, Integer.valueOf(j2.E));
    }

    public static final boolean a2(View view) {
        return true;
    }

    private final void b2() {
        MiConfigSingleton.b2().s0();
        MiConfigSingleton.b2().u2().m(this);
        AppViewModel l12 = l1();
        if (l12 != null) {
            AppViewModel.m0(l12, false, 1, null);
        }
        MiConfigSingleton.b2().G1().h(this, false);
        MiConfigSingleton.b2().e2().O0(this, this.rxManager);
        T1();
    }

    private final void d2() {
        MutableLiveData<TYInitialBook> e02;
        j2();
        AppViewModel l12 = l1();
        if (l12 == null || (e02 = l12.e0()) == null) {
            return;
        }
        e02.observe(this, new Observer() { // from class: tc.a
            public /* synthetic */ a() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.e2(Function1.this, obj);
            }
        });
    }

    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f2() {
        if (this.fragmentList.isEmpty()) {
            c2();
        }
        if (!this.fragmentList.isEmpty()) {
            ((ActivityHomeBinding) a1()).mainViewpager2.setAdapter(new ViewPager2Adapter(this, this, this.fragmentList));
            ((ActivityHomeBinding) a1()).mainViewpager2.setOffscreenPageLimit(this.fragmentList.size());
            ((ActivityHomeBinding) a1()).mainViewpager2.setUserInputEnabled(false);
        }
    }

    private final void g2() {
        this.isDoubleClick = true;
        t0.a(this, getString(com.martian.libmars.R.string.one_more_click_to_exit));
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HomeActivity$onClickExit$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        f2();
        X1();
        if (MiConfigSingleton.b2().c2().getGrayMode()) {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            ((ActivityHomeBinding) a1()).getRoot().setLayerType(2, paint);
        }
    }

    private final void j2() {
        MiAPKInstallReceiver U1 = U1();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        Unit unit = Unit.INSTANCE;
        registerReceiver(U1, intentFilter);
    }

    public final void T1() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HomeActivity$checkStorage$1(this, null), 3, null);
    }

    public final MiAPKInstallReceiver U1() {
        return (MiAPKInstallReceiver) this.miAPKInstallReceiver.getValue();
    }

    public final void V1(Intent intent) {
        e9.c cVar;
        if (MiConfigSingleton.b2().J2()) {
            TeenagerBookmallActivity.N2(this, true);
            super.finish();
            return;
        }
        if (intent != null) {
            Uri data = intent.getData();
            Unit unit = null;
            if (data != null) {
                String scheme = data.getScheme();
                if (scheme == null || scheme.length() == 0) {
                    return;
                }
                if (Intrinsics.areEqual(scheme, getString(R.string.scheme)) || Intrinsics.areEqual(scheme, "https")) {
                    String queryParameter = data.getQueryParameter("tab");
                    if (queryParameter != null) {
                        Intrinsics.checkNotNull(queryParameter);
                        k2(Integer.parseInt(queryParameter));
                    }
                    String queryParameter2 = data.getQueryParameter("tid");
                    if (queryParameter2 != null) {
                        e9.c cVar2 = this.rxManager;
                        if (cVar2 != null) {
                            String str = j2.f33268i;
                            Intrinsics.checkNotNull(queryParameter2);
                            cVar2.d(str, Integer.valueOf(Integer.parseInt(queryParameter2)));
                            return;
                        }
                        return;
                    }
                    String queryParameter3 = data.getQueryParameter("sourceId");
                    if (queryParameter3 != null) {
                        String queryParameter4 = data.getQueryParameter("sourceName");
                        String queryParameter5 = data.getQueryParameter("recommendId");
                        String queryParameter6 = data.getQueryParameter("goReading");
                        i.z(this, queryParameter3, queryParameter4, queryParameter5, "Deeplink导入", queryParameter6 != null ? Boolean.parseBoolean(queryParameter6) : false, new i.c() { // from class: tc.e
                            public /* synthetic */ e() {
                            }

                            @Override // je.i.c
                            public final void a() {
                                HomeActivity.W1(HomeActivity.this);
                            }
                        });
                        return;
                    }
                    String queryParameter7 = data.getQueryParameter("deeplink");
                    String queryParameter8 = data.getQueryParameter("url");
                    String queryParameter9 = data.getQueryParameter("stag");
                    String str2 = ke.e.b() + "-" + ConfigSingleton.D().T(ConfigSingleton.H);
                    if (queryParameter7 == null || queryParameter7.length() == 0) {
                        if (queryParameter8 != null && queryParameter8.length() != 0) {
                            h2(str2 + "-url", queryParameter9);
                            if (StringsKt.contains$default((CharSequence) queryParameter8, (CharSequence) "sslocal", false, 2, (Object) null)) {
                                t0.b(this, "不支持的类型");
                            } else {
                                MiWebViewActivity.startWebViewActivity(this, queryParameter8);
                            }
                        }
                    } else if (g.h(this, queryParameter7)) {
                        h2(str2 + "-deeplink", queryParameter9);
                        g.A(this, queryParameter7, "", "", true);
                    } else if (queryParameter8 != null && queryParameter8.length() != 0) {
                        h2(str2 + "-url", queryParameter9);
                        MiWebViewActivity.startWebViewActivity(this, queryParameter8);
                    }
                } else {
                    l2(data);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                int intExtra = intent.getIntExtra(e0.f33181v0, -1);
                int intExtra2 = intent.getIntExtra(e0.f33183w0, -1);
                if (intExtra2 > -1) {
                    k2(intExtra2);
                }
                if (intExtra <= -1 || (cVar = this.rxManager) == null) {
                    return;
                }
                cVar.d(j2.f33268i, Integer.valueOf(intExtra));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X1() {
        if (MiConfigSingleton.b2().C2()) {
            ((ActivityHomeBinding) a1()).bottomNavigationBar.getMenu().findItem(R.id.tab4).setVisible(false);
        }
        ((ActivityHomeBinding) a1()).bottomNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: tc.f
            public /* synthetic */ f() {
            }

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean Y1;
                Y1 = HomeActivity.Y1(HomeActivity.this, menuItem);
                return Y1;
            }
        });
        ((ActivityHomeBinding) a1()).bottomNavigationBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() { // from class: tc.g
            public /* synthetic */ g() {
            }

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener
            public final void onNavigationItemReselected(MenuItem menuItem) {
                HomeActivity.Z1(HomeActivity.this, menuItem);
            }
        });
        k2(this.itemPosition);
        Menu menu = ((ActivityHomeBinding) a1()).bottomNavigationBar.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menu.getItem(i10);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
            View findViewById = ((ActivityHomeBinding) a1()).bottomNavigationBar.findViewById(item.getItemId());
            if (findViewById != null) {
                findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: tc.h
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean a22;
                        a22 = HomeActivity.a2(view);
                        return a22;
                    }
                });
            }
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        g(false);
        d2();
        P1();
        initView();
        b2();
    }

    public final void c2() {
        this.fragmentList.clear();
        this.fragmentList.add(new BookShelfMainFragment());
        this.fragmentList.add(new YWBookMallMainFragment());
        this.fragmentList.add(new YWCategoryMainFragment());
        if (!MiConfigSingleton.b2().C2()) {
            this.fragmentList.add(new MissionCenterFragment());
        }
        this.fragmentList.add(new AccountFragment());
    }

    public final void h2(String r22, String stag) {
        if (!TextUtils.isEmpty(stag)) {
            r22 = r22 + "-" + stag;
        }
        ac.a.I(this, r22);
    }

    public final void i2(int tabId) {
        String str;
        if (tabId == R.id.tab1) {
            ac.a.x(this, "书架-展示");
            return;
        }
        if (tabId == R.id.tab2) {
            ac.a.w(this, "书城-展示");
            return;
        }
        if (tabId == R.id.tab3) {
            if (MiConfigSingleton.b2().p() == 2) {
                str = "女频分类展示";
            } else {
                str = "男频分类展示";
            }
            ac.a.z(this, str);
            return;
        }
        if (tabId == R.id.tab4) {
            ac.a.E(this, "赚钱-展示");
            return;
        }
        if (tabId == R.id.tab5) {
            ac.a.k(this, "我的-展示");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k2(int itemPosition) {
        if (itemPosition < 0 || itemPosition >= ((ActivityHomeBinding) a1()).bottomNavigationBar.getMenu().size()) {
            return;
        }
        this.itemPosition = itemPosition;
        if (!this.fragmentList.isEmpty()) {
            ((ActivityHomeBinding) a1()).bottomNavigationBar.setSelectedItemId(((ActivityHomeBinding) a1()).bottomNavigationBar.getMenu().getItem(itemPosition).getItemId());
        }
    }

    public final void l2(Uri uri) {
        ac.a.J(this, uri != null ? uri.getPath() : null);
        t0.a(this, "正在加载文件中...");
        k2(j2.f33271l);
        MiConfigSingleton.b2().M1().e1(this, ba.g.w(this, uri), false, new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @l Intent r14) {
        AppViewModel l12;
        int intExtra;
        super.onActivityResult(requestCode, resultCode, r14);
        if ((requestCode == 10001 || (requestCode >= 1000 && requestCode <= 1024)) && resultCode == -1) {
            ac.a.D(this, MiConfigSingleton.b2().G1().k("登录成功", requestCode));
            AppViewModel l13 = l1();
            if (l13 != null) {
                l13.n0();
            }
            AppViewModel l14 = l1();
            if (l14 != null) {
                AppViewModel.m0(l14, false, 1, null);
                return;
            }
            return;
        }
        if (requestCode == 200) {
            if (resultCode != -1 || r14 == null || (intExtra = r14.getIntExtra(e0.f33179u0, 0)) <= 10) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HomeActivity$onActivityResult$1(this, intExtra, null), 3, null);
            return;
        }
        if (requestCode == 20003 && resultCode == -1) {
            e9.c cVar = this.rxManager;
            if (cVar != null) {
                cVar.d(j2.O, 8);
                return;
            }
            return;
        }
        if (requestCode == 10002 && resultCode == -1) {
            AppViewModel l15 = l1();
            if (l15 != null) {
                l15.n0();
            }
            AppViewModel l16 = l1();
            if (l16 != null) {
                AppViewModel.m0(l16, false, 1, null);
                return;
            }
            return;
        }
        if (requestCode == 1001) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HomeActivity$onActivityResult$2(this, null), 3, null);
            return;
        }
        if (requestCode != 876 || resultCode != -1) {
            if (requestCode != 10024 || (l12 = l1()) == null) {
                return;
            }
            l12.l0(resultCode == -1);
            return;
        }
        e9.c cVar2 = this.rxManager;
        if (cVar2 != null) {
            cVar2.d(j2.D, Integer.valueOf(j2.G));
        }
        e9.c cVar3 = this.rxManager;
        if (cVar3 != null) {
            cVar3.d(j2.M, Integer.valueOf(j2.N));
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, com.martian.mibook.mvvm.base.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@l Bundle savedInstanceState) {
        MultiDex.install(this);
        super.onCreate(savedInstanceState);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
        unregisterReceiver(U1());
        MiConfigSingleton.b2().e2().u0();
        MiConfigSingleton.b2().H1().H();
        MiConfigSingleton.b2().o2().i();
        b8.e.s().C();
        MiConfigSingleton.b2().M1().T().f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x001f, code lost:
    
        if (r0.intValue() != r3) goto L128;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r5, @xi.l android.view.KeyEvent r6) {
        /*
            r4 = this;
            r0 = 4
            if (r5 != r0) goto L74
            java.lang.Integer r0 = r4.batchType
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L49
            int r3 = ya.j2.f33282w
            if (r0 != 0) goto Le
            goto L14
        Le:
            int r0 = r0.intValue()
            if (r0 == r3) goto L21
        L14:
            java.lang.Integer r0 = r4.batchType
            int r3 = ya.j2.B
            if (r0 != 0) goto L1b
            goto L49
        L1b:
            int r0 = r0.intValue()
            if (r0 != r3) goto L49
        L21:
            java.lang.Integer r5 = r4.batchType
            int r6 = ya.j2.f33282w
            if (r5 != 0) goto L28
            goto L2f
        L28:
            int r5 = r5.intValue()
            if (r5 != r6) goto L2f
            r1 = 1
        L2f:
            e9.c r5 = r4.rxManager
            if (r5 == 0) goto L48
            if (r1 == 0) goto L38
            java.lang.String r6 = ya.j2.f33277r
            goto L3a
        L38:
            java.lang.String r6 = ya.j2.A
        L3a:
            if (r1 == 0) goto L3f
            int r0 = ya.j2.f33283x
            goto L41
        L3f:
            int r0 = ya.j2.C
        L41:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.d(r6, r0)
        L48:
            return r2
        L49:
            androidx.viewbinding.ViewBinding r0 = r4.a1()
            com.martian.mibook.databinding.ActivityHomeBinding r0 = (com.martian.mibook.databinding.ActivityHomeBinding) r0
            androidx.viewpager2.widget.ViewPager2 r0 = r0.mainViewpager2
            int r0 = r0.getCurrentItem()
            int r3 = ya.j2.f33272m
            if (r0 == r3) goto L5d
            r4.k2(r3)
            return r2
        L5d:
            boolean r0 = r4.isDoubleClick
            if (r0 == 0) goto L70
            boolean r0 = com.martian.mibook.mvvm.tts.TTSReadManager.q()
            if (r0 == 0) goto L6b
            r4.moveTaskToBack(r2)
            return r2
        L6b:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        L70:
            r4.g2()
            return r1
        L74:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.home.activity.HomeActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@l Intent intent) {
        super.onNewIntent(intent);
        V1(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @k String[] permissions, @k int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (b8.e.s().q()) {
            SNAdSdk.getAdManager().onRequestPermissionResult(this, requestCode, permissions, grantResults);
        }
    }

    public final void onSearchClick(@l View view) {
        ac.a.w(this, (MiConfigSingleton.b2().p() == 2 ? "女频" : "男频") + "搜索");
        Object tag = view != null ? view.getTag() : null;
        String str = tag instanceof String ? (String) tag : null;
        if (str == null) {
            str = "";
        }
        kc.b.w(str);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void p1() {
        super.p1();
        V1(getIntent());
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void r1() {
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void u1() {
        overridePendingTransition(com.martian.libmars.R.anim.fade_in, com.martian.libmars.R.anim.fade_out);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void v1() {
        overridePendingTransition(com.martian.libmars.R.anim.fade_in, com.martian.libmars.R.anim.fade_out);
    }
}
