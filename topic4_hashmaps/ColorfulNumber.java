public class Solution {
    public int colorful(int A) {
        // First let's create a collection of all the items that we need to evaluate
        // the product of.
        // In order to do this, I am going to put each of the digits in
        // an array

        int mod = 0;
        int remaining = A;

        int index = 0;
        List<Integer> digits = new ArrayList<Integer>();

        while (remaining > 0) {
            mod = remaining % 10;
            remaining /= 10;
            digits.add(mod);
        }

        // Now we want to iterate it in such a way that 1st we look at it individually.
        // Then by pairs, then by group of 3 ... up until digits.size().
        // Each time we will add it to a set.
        // Warning they are sorted in a reverse way, so we start iterating from
        // the end.

        // NOTE: after I built this solution, I saw that it could be simplified
        // by just having the loop with the j go all the way down. After all we
        // have to accumulate all of the multipliers. Don't be fooled, even if
        // you look at a solution and it looks really simple, in programming
        // simplicity is the hardest, and can only be achieved after you master
        // your skills :)
        Set<Integer> productsStore = new HashSet<Integer>();
        int groupingOf = 1;
        while (groupingOf <= digits.size()) {
            for (int i = digits.size() - 1; i >=0 ; i--) {
                int product = digits.get(i);
                boolean outOfBound = false;
                for (int j = i - 1; j >= i - (groupingOf - 1); j--) {
                    // Let's protect against the ArrayIndexOutOfBound
                    if (j < 0) {
                        outOfBound = true;
                        break;
                    }

                    product *= digits.get(j);
                }

                // Now, if it already exists, then just return false, otherwise
                // Add it to the set collection and keep looking.
                if (productsStore.contains(product) && !outOfBound) {
                    return 0;
                } else {
                    productsStore.add(product);
                }
             }

            groupingOf++;
        }
        return 1;
    }
}
