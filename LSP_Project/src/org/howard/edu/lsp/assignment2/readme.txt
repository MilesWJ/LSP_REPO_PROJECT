README - Assignment 1: CSV ETL Pipeline in Java

Student Info
Name: Miles James
Course: CSCI 363/540
Assignment No. 2, ETL Pipeline w/ Java!!!

Assumptions
- Input file is located at data/products.csv (relative to project root)
- Input CSV contains 4 columns: ProductID,Name,Price,Category
- Fields contain no commas or quotes (per assignment instructions)
- If the input file is missing, the program prints a clear error and exits
- If the input file has only a header, the program still creates data/transformed_products.csv with just the header row

Design Notes
The program follows a simple Extract -> Transform -> Load structure:

1. Extract - Reads products.csv using BufferedReader
2. Transform - For each row:
   - Converts Name to uppercase
   - Applies 10% discount if category = Electronics
   - If discounted price > 500, recategorizes as "Premium Electronics"
   - Rounds prices to two decimals (using Math.round)
   - Assigns PriceRange based on final price
3. Load - Writes transformed rows to data/transformed_products.csv using BufferedWriter

The code is kept beginner-friendly:
- Uses BufferedReader/BufferedWriter instead of advanced libraries
- Uses simple loops, conditionals, and arrays
- Rounding is done with Math.round
- Variable names use snake_case for clarity

How to Run
1. Place products.csv inside the data/ folder at the project root
   Example project structure:
   ProjectRoot/
   ├── src/
   │   └── org/howard/edu/lsp/assignment2/ETLPipeline.java
   └── data/
       └── products.csv

2. Compile the program (from project root):
   javac src/org/howard/edu/lsp/assignment2/ETLPipeline.java

3. Run the program:
   java -cp src org.howard.edu.lsp.assignment2.ETLPipeline

4. Output will be written to:
   data/transformed_products.csv

Testing
- Case A: Normal Input
  Produces the expected transformed_products.csv with uppercase names, discounts, and correct PriceRange

- Case B: Empty Input (only header row)
  Produces transformed_products.csv with just the header row

- Case C: Missing Input File
  Prints error:
  Error: Input file not found at data/products.csv

AI Usage
I used ChatGPT to further understand the directions and to help create test cases. 

Example Prompt:
"Create a products.csv file for me to test the ETL program."

AI Response (Excerpt):
ChatGPT generated a valid sample products.csv file with product IDs, names, prices, and categories.

How I used it:
I used the generated test data to run my program and verify that the transformations worked correctly. This helped me confirm that my program handled discounts, uppercase conversion, recategorization, and price range classification as required.

External Sources
No external sources were used.

Ending notes: Overall this assignment was pretty fun. Im quite enjoying getting to know Java. Its syntax is a bit tricky still, but the curly braces help so much with readability versus indentation.


