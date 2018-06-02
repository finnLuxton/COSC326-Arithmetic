COSC326 - Arithmetic
Finn Luxton 6362897

The main difference between LTR cases and Normal cases, is that Normal cases follows the rules of BEDMAS,
meaning that multiplacation takes a higher precedence over addition. This changes the outcome of the input numbers

eg for LTR 1 + 2 + 3 * 4 + 5 = 29
    Normal 1 + 2 + (3 * 4) + 5 = 20


Coding LTR is relatively simple. This is because when coding it recursively, a sum is calculated with each new number.

eg for 1 2 3 4 with a target of 13 , the steps of adding sums would look like so
       0 + 1 = 1
       1 + 2 = 3
       3 * 3 = 9
       9 + 4 = 13


No tricks are required for this, just simply keeping the sum updated for future recursions, and seeing if the final sum is
equal to the target.

This is not the case for normal, as BEDMAS is applied, a different way of tracking operands is required, such as checking to
see if an operation requires multiplication, it would times the previous number input instead of the previous sum with
the current input, and then add that sum to the previous sum to find a BEDMAS output.

eg for 1 2 3 4 with a target of 15 , the steps of adding sums would look like so
       0 + 1 = 1
       1 + 2 = 3
       3 + 3 = 6
         // Next number requires a multiplication, so the sum (6) is substituted with previous number (3)
         3 * 4 = 12
         // Current sum is previous sum (3) added with multiplcation output (12)
         3 + 12 = 15


This would be more tricky to keep track of recursively, as it would require multiple depths of information to be
available for calculations, and since a sum might not be always be stable (the sum 6 on step 3 is thrown away since
a multiplication was required), building a string backwards would also prove to be difficult.
       
