package snw.jkook.entity.abilities;

/**
 * Represents an object that can hold an avatar.
 */
public interface AvatarHolder {

    /**
     * Get the avatar url of this object.
     *
     * @param vip True if you want the url of the vip avatar.
     */
    String getAvatarUrl(boolean vip);
}
