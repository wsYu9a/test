package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.umeng.analytics.pro.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B/\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001c"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "", "launcher", "callerContract", "Landroidx/activity/result/contract/ActivityResultContract;", "callerInput", "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "getCallerContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "getCallerInput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "resultContract", "getResultContract", "resultContract$delegate", "Lkotlin/Lazy;", "getContract", "launch", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Lkotlin/Unit;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "activity-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {

    @k
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;

    @k
    private final ActivityResultLauncher<I> launcher;

    /* renamed from: resultContract$delegate, reason: from kotlin metadata */
    @k
    private final Lazy resultContract;

    public ActivityResultCallerLauncher(@k ActivityResultLauncher<I> launcher, @k ActivityResultContract<I, O> callerContract, I i10) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.callerInput = i10;
        this.resultContract = LazyKt.lazy(new Function0<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>(this) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "Landroidx/activity/result/contract/ActivityResultContract;", "", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Object;", "activity-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1 */
            public static final class AnonymousClass1<O> extends ActivityResultContract<Unit, O> {
                final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

                public AnonymousClass1(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
                    activityResultCallerLauncher = activityResultCallerLauncher;
                }

                @Override // androidx.activity.result.contract.ActivityResultContract
                public O parseResult(int resultCode, @l Intent intent) {
                    return (O) activityResultCallerLauncher.getCallerContract().parseResult(resultCode, intent);
                }

                @Override // androidx.activity.result.contract.ActivityResultContract
                @k
                public Intent createIntent(@k Context r22, @k Unit input) {
                    Intrinsics.checkNotNullParameter(r22, "context");
                    Intrinsics.checkNotNullParameter(input, "input");
                    return activityResultCallerLauncher.getCallerContract().createIntent(r22, activityResultCallerLauncher.getCallerInput());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<I, O> this) {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final AnonymousClass1 invoke() {
                return new ActivityResultContract<Unit, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
                    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

                    public AnonymousClass1(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
                        activityResultCallerLauncher = activityResultCallerLauncher;
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public O parseResult(int resultCode, @l Intent intent) {
                        return (O) activityResultCallerLauncher.getCallerContract().parseResult(resultCode, intent);
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    @k
                    public Intent createIntent(@k Context r22, @k Unit input) {
                        Intrinsics.checkNotNullParameter(r22, "context");
                        Intrinsics.checkNotNullParameter(input, "input");
                        return activityResultCallerLauncher.getCallerContract().createIntent(r22, activityResultCallerLauncher.getCallerInput());
                    }
                };
            }
        });
    }

    @k
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @k
    public ActivityResultContract<Unit, ?> getContract() {
        return getResultContract();
    }

    @k
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @k
    public final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.resultContract.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@k Unit input, @l ActivityOptionsCompat options) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.launcher.launch(this.callerInput, options);
    }
}
