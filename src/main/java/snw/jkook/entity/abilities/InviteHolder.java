package snw.jkook.entity.abilities;

import snw.jkook.entity.Invitation;

/**
 * Represents the objects that can hold the invitations.
 * @see Invitation
 */
public interface InviteHolder {

    /**
     * Create an invitation of this object.
     *
     * @param validSeconds The length of time the invitation link is valid (in seconds)
     * @param validTimes Number of times the link is valid.
     * @return The invite link URL string
     */
    String createInvite(int validSeconds, int validTimes);

    /**
     * Mark the invite link that matches the specified url code as invalid.
     *
     * @param urlCode The url code to be marked
     * @see Invitation#getUrlCode()
     */
    void removeInvite(String urlCode);

}
