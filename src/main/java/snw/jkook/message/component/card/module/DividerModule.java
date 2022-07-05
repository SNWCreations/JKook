package snw.jkook.message.component.card.module;

/**
 * Represents a divider module.
 */
public class DividerModule extends BaseModule {

    /** Only one the instance of this module. One per VM. */
    public static final DividerModule INSTANCE = new DividerModule();

    /*
       Because this class does not provide more operations,
       so I think it is not necessary to make the constructor public.
    */
    protected DividerModule() {}
}
