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

## Example 1

```java
  LSystem.getInstance().generate("F", new Rule('F', "FF+[+F-F-F]-[-F+F+F]"));
```

### Results:

![l-system](https://user-images.githubusercontent.com/16426370/42795317-03260f68-895a-11e8-8493-12016b24794d.png)

## Example 2
```java
LSystem.getInstance().generate("X",
        Arrays.asList(
                new Rule('X', "F-[[X]+X]+F[+FX]-X"),
                new Rule('F', "FF")
        ),
        "l-system2.png"
);
```

### Results:

![l-system2](https://user-images.githubusercontent.com/16426370/42855822-a63e86c6-8a18-11e8-9ef7-526b6961a194.png)

## Example 3
```java
LSystem.getInstance().setIterations(6);
LSystem.getInstance().generate("X",
        Arrays.asList(
                new Rule('X', "F[+X][-X]FX"),
                new Rule('F', "FF")
        ),
        "l-system3.png"
);
```

### Results:

![l-system3](https://user-images.githubusercontent.com/16426370/42855840-b7cc4cca-8a18-11e8-8e1e-c7272d4eae3b.png)

## Example 4
```java
LSystem.getInstance().setAnglePower(90F);
LSystem.getInstance().generate("X",
        Arrays.asList(
                new Rule('X', "-YF+XFX+FY-"),
                new Rule('Y', "+XF-YFY-FX+")
        ),
        "l-system4.png"
);
```

### Results:

![l-system4](https://user-images.githubusercontent.com/16426370/42855869-de54ed66-8a18-11e8-9249-194ae03d1cd2.png)

## Example 5
```java
LSystem.getInstance().setAnglePower(25F);
LSystem.getInstance().setIterations(LSystem.DEFAULT_ITERATIONS);
LSystem.getInstance().generate("F", new Rule('F', "F[+F]F[-F][F]"), "l-system5.png");
```

### Results:
![l-system5](https://user-images.githubusercontent.com/16426370/42855896-068dfcaa-8a19-11e8-8f5e-aefc86263dc0.png)
