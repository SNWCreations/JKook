package snw.jkook.bot;

/**
 * This exception will be thrown if an unexpected situation happened when the {@link BotLoader} attempting to load a Bot.
 */
public class InvalidBotException extends RuntimeException {

    /**
     * Constructs a new InvalidBotException with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public InvalidBotException() {
    }

    /**
     * Constructs a new InvalidBotException with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public InvalidBotException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidBotException with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this InvalidBotException's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     */
    public InvalidBotException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new InvalidBotException with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for InvalidBotExceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     */
    public InvalidBotException(Throwable cause) {
        super(cause);
    }
}
