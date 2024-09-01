package snw.jkook.permissions;

/**
 * Represents a class which is to be notified when a {@link
 * PermissionAttachment} is removed from a {@link Permissible}
 */
public interface BotOperator {

    boolean isOp();

    void setOp(boolean op);
}
