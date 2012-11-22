package otherExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:09
 */
public class Queue {
    private Element first, last;

    public void add(int value) {
        Element e = new Element(value);

        if (last == null) {
            first = e;
            last = e;
        } else {
            last.setNext(e);
            last = e;
        }
    }

    public int sizeIteratively() {
        Element e = first;

        int size = 0;
        while (e != null) {
            ++size;
            e = e.getNext();
        }
        return size;
    }

    public int sizeRecursively() {
        return getNumberOfElementsAfter(first) + 1;
    }

    private int getNumberOfElementsAfter(Element e) {
        if (e.getNext() == null)
            return 0;
        else
            return getNumberOfElementsAfter(e.getNext()) + 1;
    }
}
