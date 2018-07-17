# l-system

L-system parser/renderer written in Java.

## Big Work In Progress

For now we have a very limited grammar:
* 'F' -> draw line.
* '+' -> increase the angle by 25.
* '-' -> decrease the angle by 25.
* '[' -> push a Branch.
* ']' -> pop a Branch.

### Branches
'['

We save our current state 'branch' in order to come back when we encounter a ']' character.

```java
  branches.addFirst(new Branch(x, y, angle));
```

']'

```java
  Branch branch = branches.pollFirst();
  if (branch != null) {
      x = branch.getX();
      y = branch.getY();
      angle = branch.getAngle();
  }
```

## Examples

```java
  LSystem.getInstance().generate("F", new Rule('F', "FF+[+F-F-F]-[-F+F+F]"));
```

### Results:

![l-system](https://user-images.githubusercontent.com/16426370/42795317-03260f68-895a-11e8-8493-12016b24794d.png)
