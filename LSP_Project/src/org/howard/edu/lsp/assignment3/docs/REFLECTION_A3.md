# Reflection – Assignment 3 vs. Assignment 2

**Author:** Miles James  
**Course:** CSCI 363  
**Date:** September 25, 2025

---

## What Changed in the Design
In Assignment 2, my ETL pipeline was basically just one big class called `ETLPipeline`. It handled everything: reading the CSV, parsing values, checking for errors, applying transformations, and then writing the final file. While it technically worked and produced the right output, it felt cluttered. Every time I wanted to fix something or add a feature, I had to scroll through hundreds of lines of mixed responsibilities.  

For Assignment 3, I broke the program down into separate classes. Now, each class has its own clear purpose:
- **`Product`**: holds a single row of product data, like an object version of a CSV line.  
- **`ProductTransformer`**: all the rules for changing the data live here, like uppercasing the name or discounting electronics.  
- **`CSVReader`**: just reads the file and returns the raw data.  
- **`CSVWriter`**: just writes the file with the transformed products.  
- **`PipelineStats`**: keeps track of rows read, transformed, and skipped.  
- **`ETLPipeline`**: now only coordinates the steps, instead of doing all the work itself.  

The main difference is that A2 was procedural (step after step in one place), while A3 is object-oriented (breaking the system into smaller, reusable parts).

---

## How Assignment 3 Is More Object-Oriented
Assignment 3 shows object-oriented thinking in a few ways:

- **Encapsulation**: Each class hides its details. For example, `ProductTransformer` has private helper methods for rounding and classifying price so the rest of the program doesn’t need to know how those work.  
- **Single Responsibility Principle**: Every class has one job. If I want to change how products are transformed, I only touch `ProductTransformer`. If I want to change how the CSV is written, I only touch `CSVWriter`.  
- **Objects vs. Strings**: In A2, I passed around arrays of strings and had to remember what index meant what. In A3, I use actual `Product` objects with getters, which makes the code way clearer and less error-prone.  
- **Extensibility**: This design is easier to expand later. For example, if I wanted to add JSON input or different discount strategies, I could make new classes without breaking everything else.  

---

## Which OO Ideas I Used
- **Objects/Classes**: Products are modeled as objects, not just data strings.  
- **Encapsulation**: Internal details (like rounding math) are hidden in private methods.  
- **Polymorphism (potential use)**: While I didn’t implement it fully, the design leaves room for it. For example, I could have different transformer subclasses (like `ElectronicsTransformer`, `ClothingTransformer`) that extend a base `Transformer` class.  
- **Abstraction**: The main pipeline doesn’t care how a product is transformed or how the file is written; it just calls the methods.  

---

## Testing and Verification
I tested my Assignment 3 code by running the same input files I used for Assignment 2 and checking if the output was identical. Specifically, I looked at:

- **Normal Case**: A CSV with a few electronics, clothing, and other products. Both A2 and A3 gave me the same discounted prices, uppercase names, and correct price ranges.  
- **Empty Input File**: A3 correctly wrote only the header, just like A2.  
- **Missing File**: A3 printed the same error message.  
- **Bad Data**: Lines with missing fields or invalid numbers were skipped and counted, just like in A2.  

Seeing that the outputs matched gave me confidence that the object-oriented redesign didn’t break the actual functionality.

---

## Final Thoughts
Assignment 2 was about making something that *worked*. Assignment 3 was about making something that’s *maintainable*. The two versions of my code do the same thing, but A3 feels much easier to read, test, and modify.  

I think the biggest lesson here is that OOP isn’t about making the program longer or adding extra files just because. It’s about organizing code so that each piece has a clear purpose. I noticed that even though I wrote more classes, the program actually feels simpler now because the logic is separated.  

Overall, A3 gave me a better appreciation of how OOP makes real-world projects more manageable, especially when they grow larger than just a homework assignment.
