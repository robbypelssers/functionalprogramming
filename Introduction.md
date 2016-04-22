# Introduction #
This project was started to be able to provide typical higher-order functions for Iterables like:
  * filtering
  * mapping
  * slicing
  * ...

Let's take a use case where you need to check which numbers are between 2 and 5.

## Imperative Java style ##
```
List<Integer> numbers = new ArrayList<Integer>();
numbers.add(1);
numbers.add(2);
numbers.add(3);
numbers.add(4);
numbers.add(5);
numbers.add(6);
//now we want a new list containing the numbers between 2 and 5
List<Integer> filtered = new ArrayList<Integer>();
for (Integer number : numbers) {
    if (number.intValue() >= 2 && number.intValue() <= 5) {
        filtered.add(number);
    }
}
return filtered;
```

## Functional Java style ##
```
RichIterable<Integer> numbers = new RichIterator<Integer>(1, 2, 3, 4, 5, 6);
RichIterable<Integer> filtered = numbers.filter(between(2, 5));
```

Saves you some time, doesn't it??

Many other even more impressive examples will follow soon.