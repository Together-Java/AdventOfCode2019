# Contributing Guidelines

## Creating a good Pull request
Try to make your code clean and readable. 
If not you can still create a Pull request. 
We will try to give you advice on how to improve your solution.
 
## Structuring your solution
Please try to follow those rough guidelines:

For each day create a class.

- Example: The solution for day 5 should be called `Day5`

Each part should have its own Method and should be called in a main method.
This improves the readability and its easier to understand how you solved the different parts.

 - Rough example for day 5:

```java
public class Day5 {
    public static void main(String[] args) {
        System.out.println("Solution for part one: " + partOne());
        System.out.println("Solution for part two: " + partTwo());
    }
    
    public static int partOne() {
        // implements solution for part one
    }
    
    public static int partTwo() {
        // implements solution for part two
    }
    
    // Additional Methods needed for solutions above
}
```
