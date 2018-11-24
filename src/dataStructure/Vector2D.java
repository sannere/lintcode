package dataStructure;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> listIter;
    Iterator<Integer> intIter;
    public Vector2D(List<List<Integer>> vec2d) {
        listIter = vec2d.iterator();
        intIter = null;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return intIter.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while ((intIter == null || !intIter.hasNext()) && listIter.hasNext()) {
            intIter = listIter.next().iterator();
        }
        return intIter != null && intIter.hasNext();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
