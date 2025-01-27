package androidx.media3.session;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionCommands;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class SessionCommands implements Bundleable {
    private static final String TAG = "SessionCommands";
    public final ImmutableSet<SessionCommand> commands;
    public static final SessionCommands EMPTY = new Builder().build();
    private static final String FIELD_SESSION_COMMANDS = Util.intToStringMaxRadix(0);

    @UnstableApi
    public static final Bundleable.Creator<SessionCommands> CREATOR = new Bundleable.Creator() { // from class: p0.d0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            SessionCommands lambda$static$0;
            lambda$static$0 = SessionCommands.lambda$static$0(bundle);
            return lambda$static$0;
        }
    };

    public static final class Builder {
        private final Set<SessionCommand> commands;

        public /* synthetic */ Builder(SessionCommands sessionCommands, AnonymousClass1 anonymousClass1) {
            this(sessionCommands);
        }

        private void addCommandCodes(List<Integer> list) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                add(new SessionCommand(list.get(i10).intValue()));
            }
        }

        @CanIgnoreReturnValue
        public Builder add(SessionCommand sessionCommand) {
            this.commands.add((SessionCommand) Assertions.checkNotNull(sessionCommand));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAllLibraryCommands() {
            addCommandCodes(SessionCommand.LIBRARY_COMMANDS);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAllPredefinedCommands() {
            addAllSessionCommands();
            addAllLibraryCommands();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAllSessionCommands() {
            addCommandCodes(SessionCommand.SESSION_COMMANDS);
            return this;
        }

        public SessionCommands build() {
            return new SessionCommands(this.commands);
        }

        @CanIgnoreReturnValue
        public Builder remove(SessionCommand sessionCommand) {
            this.commands.remove(Assertions.checkNotNull(sessionCommand));
            return this;
        }

        public Builder() {
            this.commands = new HashSet();
        }

        @CanIgnoreReturnValue
        public Builder add(int i10) {
            Assertions.checkArgument(i10 != 0);
            this.commands.add(new SessionCommand(i10));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder remove(int i10) {
            Assertions.checkArgument(i10 != 0);
            Iterator<SessionCommand> it = this.commands.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SessionCommand next = it.next();
                if (next.commandCode == i10) {
                    this.commands.remove(next);
                    break;
                }
            }
            return this;
        }

        private Builder(SessionCommands sessionCommands) {
            this.commands = new HashSet(((SessionCommands) Assertions.checkNotNull(sessionCommands)).commands);
        }
    }

    public /* synthetic */ SessionCommands(Collection collection, AnonymousClass1 anonymousClass1) {
        this(collection);
    }

    private static boolean containsCommandCode(Collection<SessionCommand> collection, int i10) {
        Iterator<SessionCommand> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().commandCode == i10) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ SessionCommands lambda$static$0(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_SESSION_COMMANDS);
        if (parcelableArrayList == null) {
            Log.w(TAG, "Missing commands. Creating an empty SessionCommands");
            return EMPTY;
        }
        Builder builder = new Builder();
        for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
            builder.add(SessionCommand.CREATOR.fromBundle((Bundle) parcelableArrayList.get(i10)));
        }
        return builder.build();
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean contains(SessionCommand sessionCommand) {
        return this.commands.contains(Assertions.checkNotNull(sessionCommand));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionCommands) {
            return this.commands.equals(((SessionCommands) obj).commands);
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.commands);
    }

    @Override // androidx.media3.common.Bundleable
    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        e5.z1<SessionCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        bundle.putParcelableArrayList(FIELD_SESSION_COMMANDS, arrayList);
        return bundle;
    }

    private SessionCommands(Collection<SessionCommand> collection) {
        this.commands = ImmutableSet.copyOf((Collection) collection);
    }

    public boolean contains(int i10) {
        Assertions.checkArgument(i10 != 0, "Use contains(Command) for custom command");
        return containsCommandCode(this.commands, i10);
    }
}
