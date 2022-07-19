# Automation-DB
My First project that implements automation interacting with database and restful

# Classes Explained:
# Main - Takes data from JSON files and calls appropiate methods to execute, add/remove comments on bottom of the code to do so.
- int index can be changed to decide which document to use in the collection, this program can also be written in loop.
# Operation - Selenium Automation proccess, there's methods for email sign in, facebook signup, and sending emails.
# DataFR ( FacebookRegisteration ) , DataSE ( SendEmail ) - Data management in Java.
# Locator - Selenium Locators, Class that beutifies the code.
# PthonDB - Pymongo creates new documents, new JSON files and updates them accordingly, remove appropiate comments to add new documents.
# UpdateDB - Updates MongoDB document variables with Java, main usage for status and error updates at the moment.

TLDR: 3 things to interact with in the code
1. in Main, Operation's Method invokes to comment or to execute (bottom of the code)
2. in Main index to choose the document
3. in PythonDB remove comments if you want to add new documents

What the code does:
1. Sends Automated Emails from MongoDB with existing microsoft email
2. Registers to Facebook with existing email and variables from MongoDB (doesn't fully work with selenium)
