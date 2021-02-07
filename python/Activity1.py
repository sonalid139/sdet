#Activity 1
'''
Write a program that asks the user to enter their name and their age.
Print out a message addressed to them that tells them the year that they will turn 100 years old
'''
username = input ("Enter Username: ") # get name
age = input ("Enter Age: ") # get age
century = str((2021-int(age))+100)
print("You will get 100 years old in",format(century))
