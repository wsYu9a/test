package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.martian.ads.ad.AdConfig;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
    static final String D = "FragmentManager";
    final FragmentManagerImpl E;
    boolean F;
    int G = -1;

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.E = fragmentManagerImpl;
    }

    private static boolean j(FragmentTransaction.Op op) {
        Fragment fragment = op.f2455b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    void b(int i2, Fragment fragment, @Nullable String str, int i3) {
        super.b(i2, fragment, str, i3);
        fragment.mFragmentManager = this.E;
    }

    void c(int i2) {
        if (this.s) {
            if (FragmentManagerImpl.f2354c) {
                Log.v(D, "Bump nesting in " + this + " by " + i2);
            }
            int size = this.l.size();
            for (int i3 = 0; i3 < size; i3++) {
                FragmentTransaction.Op op = this.l.get(i3);
                Fragment fragment = op.f2455b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManagerImpl.f2354c) {
                        Log.v(D, "Bump nesting of " + op.f2455b + " to " + op.f2455b.mBackStackNesting);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return d(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return d(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.E.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.E.execSingleAction(this, true);
    }

    int d(boolean z) {
        if (this.F) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f2354c) {
            Log.v(D, "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter(D));
            dump("  ", printWriter);
            printWriter.close();
        }
        this.F = true;
        if (this.s) {
            this.G = this.E.allocBackStackIndex(this);
        } else {
            this.G = -1;
        }
        this.E.enqueueAction(this, z);
        return this.G;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.E) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    void e() {
        int size = this.l.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.Op op = this.l.get(i2);
            Fragment fragment = op.f2455b;
            if (fragment != null) {
                fragment.setNextTransition(this.q, this.r);
            }
            switch (op.f2454a) {
                case 1:
                    fragment.setNextAnim(op.f2456c);
                    this.E.addFragment(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f2454a);
                case 3:
                    fragment.setNextAnim(op.f2457d);
                    this.E.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(op.f2457d);
                    this.E.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(op.f2456c);
                    this.E.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(op.f2457d);
                    this.E.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.f2456c);
                    this.E.attachFragment(fragment);
                    break;
                case 8:
                    this.E.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.E.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    this.E.setMaxLifecycle(fragment, op.f2461h);
                    break;
            }
            if (!this.B && op.f2454a != 1 && fragment != null) {
                this.E.a0(fragment);
            }
        }
        if (this.B) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.E;
        fragmentManagerImpl.b0(fragmentManagerImpl.y, true);
    }

    void f(boolean z) {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.l.get(size);
            Fragment fragment = op.f2455b;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.q), this.r);
            }
            switch (op.f2454a) {
                case 1:
                    fragment.setNextAnim(op.f2459f);
                    this.E.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f2454a);
                case 3:
                    fragment.setNextAnim(op.f2458e);
                    this.E.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(op.f2458e);
                    this.E.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(op.f2459f);
                    this.E.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(op.f2458e);
                    this.E.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.f2459f);
                    this.E.detachFragment(fragment);
                    break;
                case 8:
                    this.E.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.E.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.E.setMaxLifecycle(fragment, op.f2460g);
                    break;
            }
            if (!this.B && op.f2454a != 3 && fragment != null) {
                this.E.a0(fragment);
            }
        }
        if (this.B || !z) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.E;
        fragmentManagerImpl.b0(fragmentManagerImpl.y, true);
    }

    Fragment g(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.l.size()) {
            FragmentTransaction.Op op = this.l.get(i2);
            int i3 = op.f2454a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = op.f2455b;
                    int i4 = fragment3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId == i4) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.l.add(i2, new FragmentTransaction.Op(9, fragment4));
                                    i2++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment4);
                                op2.f2456c = op.f2456c;
                                op2.f2458e = op.f2458e;
                                op2.f2457d = op.f2457d;
                                op2.f2459f = op.f2459f;
                                this.l.add(i2, op2);
                                arrayList.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        this.l.remove(i2);
                        i2--;
                    } else {
                        op.f2454a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList.remove(op.f2455b);
                    Fragment fragment5 = op.f2455b;
                    if (fragment5 == fragment2) {
                        this.l.add(i2, new FragmentTransaction.Op(9, fragment5));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.l.add(i2, new FragmentTransaction.Op(9, fragment2));
                        i2++;
                        fragment2 = op.f2455b;
                    }
                }
                i2++;
            }
            arrayList.add(op.f2455b);
            i2++;
        }
        return fragment2;
    }

    @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.f2354c) {
            Log.v(D, "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.s) {
            return true;
        }
        this.E.b(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        return this.x != 0 ? this.E.z.getContext().getText(this.x) : this.y;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.x;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        return this.v != 0 ? this.E.z.getContext().getText(this.v) : this.w;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.v;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.G;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.u;
    }

    boolean h(int i2) {
        int size = this.l.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.l.get(i3).f2455b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.E) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    boolean i(ArrayList<BackStackRecord> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.l.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.l.get(i5).f2455b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    BackStackRecord backStackRecord = arrayList.get(i7);
                    int size2 = backStackRecord.l.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = backStackRecord.l.get(i8).f2455b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.l.isEmpty();
    }

    boolean k() {
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (j(this.l.get(i2))) {
                return true;
            }
        }
        return false;
    }

    void l(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            FragmentTransaction.Op op = this.l.get(i2);
            if (j(op)) {
                op.f2455b.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    Fragment m(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.l.get(size);
            int i2 = op.f2454a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.f2455b;
                            break;
                        case 10:
                            op.f2461h = op.f2460g;
                            break;
                    }
                }
                arrayList.add(op.f2455b);
            }
            arrayList.remove(op.f2455b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.E) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void runOnCommitRunnables() {
        if (this.C != null) {
            for (int i2 = 0; i2 < this.C.size(); i2++) {
                this.C.get(i2).run();
            }
            this.C = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager != this.E) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.E);
        }
        Lifecycle.State state2 = Lifecycle.State.CREATED;
        if (state.isAtLeast(state2)) {
            return super.setMaxLifecycle(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + state2);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl;
        if (fragment == null || (fragmentManagerImpl = fragment.mFragmentManager) == null || fragmentManagerImpl == this.E) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        if (fragmentManagerImpl == null || fragmentManagerImpl == this.E) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.G >= 0) {
            sb.append(" #");
            sb.append(this.G);
        }
        if (this.u != null) {
            sb.append(" ");
            sb.append(this.u);
        }
        sb.append("}");
        return sb.toString();
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.u);
            printWriter.print(" mIndex=");
            printWriter.print(this.G);
            printWriter.print(" mCommitted=");
            printWriter.println(this.F);
            if (this.q != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.r));
            }
            if (this.m != 0 || this.n != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.n));
            }
            if (this.o != 0 || this.p != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.p));
            }
            if (this.v != 0 || this.w != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.v));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.w);
            }
            if (this.x != 0 || this.y != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.x));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.y);
            }
        }
        if (this.l.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.l.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.Op op = this.l.get(i2);
            switch (op.f2454a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = AdConfig.Action.SHOW;
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + op.f2454a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.f2455b);
            if (z) {
                if (op.f2456c != 0 || op.f2457d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.f2456c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.f2457d));
                }
                if (op.f2458e != 0 || op.f2459f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.f2458e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.f2459f));
                }
            }
        }
    }
}
