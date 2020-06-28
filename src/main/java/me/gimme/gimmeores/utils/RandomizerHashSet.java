package me.gimme.gimmeores.utils;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * A normal HashSet but with the ability to efficiently retrieve a random element from the set.
 * @param <E> the type of elements maintained by this set
 */
public class RandomizerHashSet<E> extends HashSet<E> {
    private ArrayList<E> list;

    public RandomizerHashSet(Collection<? extends E> collection) {
        super(collection);
        syncContent();
    }

    /**
     * Synchronize the content in the hash set with the underlying list for retrieving random elements.
     *
     * Has to be called before using {@link #getRandomElement(Random)} if the set has been mutated.
     */
    public void syncContent() {
        this.list = new ArrayList<>(this);
    }

    /**
     * @return a random element from the set in O(1) time
     * @param random the random generator to use
     */
    public E getRandomElement(@NotNull Random random) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
