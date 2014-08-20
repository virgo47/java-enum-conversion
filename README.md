java-enum-conversion
====================

Java enum conversion micro-framework demonstration. Focus is on the way how to map enum instances to
values and how to do it consistently. Examples are all based on JPA 2.1 converters.

Full length blog story is here: http://virgo47.wordpress.com/2014/08/02/converting-java-enums-to-values-and-back/

Follow-up for Java 8 solution is here: http://virgo47.wordpress.com/2014/08/20/converting-java-enums-to-values-and-back-with-java-8/

## Naive approach

Package `_0naive`. Enum to Integer mapping is in JPA AttributeConverter and it's based on switch/case.
Fragile. We need to encapsulate it into enum type.

## Encapsulated

Package `_1encapsulated` solves this. This is the most important step - to get rid of switch. And
especially if it's out of the enum, that is recipe for disaster (as it's mostly not just on one place).

## Introducing "framework"

Package `_2framework` tries to bring some unity into conversion. Enums implement `ConvertedEnum`
and there is base class `EnumAttributeConverter` for `AttributeConverter`s.

## Refinement

Package `_3refined` introduces `ConvertedEnumResolver` which makes static reverse resolving to
enum instances a breeze.

## Let's not go overboard

Package `_4toomuch` tries to push even more to base converter class. There is demonstration
`main` in `SomeEntityTypeConverter` that shows what work and what doesn't. But considering we didn't
save a single line of code and lost compile time safety for static `fromDbValue` method (no way
to enforce the same name on all enums) I'd not go this far.

## More flexible Java 8 solution

Package `_5java8function` utilizes Java 8 method references. Previously our `ConvertedEnumResolver`
was dependent on the existence of `ConvertedEnum` and used its method. With Java 8, you can provide
reference to the method returning value from enum instance directly to the reverse resolver. That is
why this time we don't use "converted" in the name, but call it `ReverseEnumResolver`.

**This reverse resolution is completely separated from the JPA conversion framework now!** :-) That's why
I didn't bother with JPA surroundings in this package. In case of JPA conversion you still have to implement
`ConvertedEnum` if you want to use subclasses of `EnumAttributeConverter`. Alternatively you may use solution
from package `_1encapsulated` - that is no conversion framework and just benefit from "componentized"
reverse resolving.

With this resolving you can have more (in our case two) different other representations, which was not
possible before with a single class `ConvertedEnumResolver`.

Enjoy