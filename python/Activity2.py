#Activity 2
'''
Ask the user for a number.
Depending on what number they enter, tell them if the number is an even or odd number
'''
number = int(input("Enter Number:"))
if((number%2)==0):
    print("Given number is an Even number")
else:
    print("Given number is an Odd number")