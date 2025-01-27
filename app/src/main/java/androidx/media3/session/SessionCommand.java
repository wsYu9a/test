package androidx.media3.session;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionCommand;
import b5.r;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public final class SessionCommand implements Bundleable {
    public static final int COMMAND_CODE_CUSTOM = 0;
    public final int commandCode;
    public final String customAction;
    public final Bundle customExtras;
    public static final int COMMAND_CODE_SESSION_SET_RATING = 40010;
    static final ImmutableList<Integer> SESSION_COMMANDS = ImmutableList.of(Integer.valueOf(COMMAND_CODE_SESSION_SET_RATING));
    public static final int COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT = 50000;
    public static final int COMMAND_CODE_LIBRARY_SUBSCRIBE = 50001;
    public static final int COMMAND_CODE_LIBRARY_UNSUBSCRIBE = 50002;
    public static final int COMMAND_CODE_LIBRARY_GET_CHILDREN = 50003;
    public static final int COMMAND_CODE_LIBRARY_GET_ITEM = 50004;
    public static final int COMMAND_CODE_LIBRARY_SEARCH = 50005;
    public static final int COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT = 50006;
    static final ImmutableList<Integer> LIBRARY_COMMANDS = ImmutableList.of(Integer.valueOf(COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT), Integer.valueOf(COMMAND_CODE_LIBRARY_SUBSCRIBE), Integer.valueOf(COMMAND_CODE_LIBRARY_UNSUBSCRIBE), Integer.valueOf(COMMAND_CODE_LIBRARY_GET_CHILDREN), Integer.valueOf(COMMAND_CODE_LIBRARY_GET_ITEM), Integer.valueOf(COMMAND_CODE_LIBRARY_SEARCH), Integer.valueOf(COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT));
    private static final String FIELD_COMMAND_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_CUSTOM_ACTION = Util.intToStringMaxRadix(1);
    private static final String FIELD_CUSTOM_EXTRAS = Util.intToStringMaxRadix(2);

    @UnstableApi
    public static final Bundleable.Creator<SessionCommand> CREATOR = new Bundleable.Creator() { // from class: p0.c0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            SessionCommand lambda$static$0;
            lambda$static$0 = SessionCommand.lambda$static$0(bundle);
            return lambda$static$0;
        }
    };

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CommandCode {
    }

    public SessionCommand(int i10) {
        Assertions.checkArgument(i10 != 0, "commandCode shouldn't be COMMAND_CODE_CUSTOM");
        this.commandCode = i10;
        this.customAction = "";
        this.customExtras = Bundle.EMPTY;
    }

    public static /* synthetic */ SessionCommand lambda$static$0(Bundle bundle) {
        int i10 = bundle.getInt(FIELD_COMMAND_CODE, 0);
        if (i10 != 0) {
            return new SessionCommand(i10);
        }
        String str = (String) Assertions.checkNotNull(bundle.getString(FIELD_CUSTOM_ACTION));
        Bundle bundle2 = bundle.getBundle(FIELD_CUSTOM_EXTRAS);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionCommand(str, bundle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SessionCommand)) {
            return false;
        }
        SessionCommand sessionCommand = (SessionCommand) obj;
        return this.commandCode == sessionCommand.commandCode && TextUtils.equals(this.customAction, sessionCommand.customAction);
    }

    public int hashCode() {
        return r.b(this.customAction, Integer.valueOf(this.commandCode));
    }

    @Override // androidx.media3.common.Bundleable
    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_COMMAND_CODE, this.commandCode);
        bundle.putString(FIELD_CUSTOM_ACTION, this.customAction);
        bundle.putBundle(FIELD_CUSTOM_EXTRAS, this.customExtras);
        return bundle;
    }

    public SessionCommand(String str, Bundle bundle) {
        this.commandCode = 0;
        this.customAction = (String) Assertions.checkNotNull(str);
        this.customExtras = new Bundle((Bundle) Assertions.checkNotNull(bundle));
    }
}
