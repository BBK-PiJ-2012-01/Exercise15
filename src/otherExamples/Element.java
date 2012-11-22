package otherExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:09
 */
public class Element {
    private Element next;
    private final int value;

    public Element(int value) {
        this.value = value;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element getNext() {
        return next;
    }
}
