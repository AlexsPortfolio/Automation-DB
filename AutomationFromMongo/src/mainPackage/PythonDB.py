# hidden code
#> comment
from pymongo import MongoClient
from bson.json_util import dumps

cluster = MongoClient("mongodb+srv://Alex:3415FD@cluster0.fomem.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")
db = cluster["AutomationDB"]
collectionFB = db["FacebookRegistration"]
collectionEmail = db["SendEmails"]



#> Function that creates documents to MongoDB, don't modify
def create_document_FB(firstName, lastName, email, password, gender, birthDate):
    newID = collectionFB.count()
    newUser = {"_id": newID, "firstName": firstName, "lastName": lastName, "email": email,"password": password, "gender": gender, "birthDate": birthDate, "error": "NONE"}
    collectionFB.insert_one(newUser)
def create_document_Email(email, password, sendList, title, message):
    newID = collectionEmail.count()
    newUser = {"_id": newID, "email": email, "password": password, "sendList": sendList, "title": title, "message": message, "status": "NOT YET SENT"}
    collectionEmail.insert_one(newUser)
    
#> template to add documents: 

#create_document_Email("Alex.anderPopov@outlook.com", "3415FD56d5", 
#                      ["musicalexpopov@gmail.com", "musicalexpopov2@gmail.com", "itsaleksanderpopov@gmail.com"],
#                      "Work of the month announcement", 
#                       "In the upcoming Sunday we will annouce the winning nominee this month with an appropriate award for the hard work!\nGood Luck for everyone")

#create_document_FB("Odin", "Borson", "ValhallaCalls@outlook.com", "ComplicatedPass123", "Male", "01.06.1990")

#> The password must be at least eight characters and should be a mix of uppercase and lowercase characters, numbers and punctuation.
#> birthdate dd.MM.yyyy format
#> email must be microsoft: outlook OR hotmail


#> saves list as a json file for java to use it later
cursor = collectionFB.find({}).sort("_id", 1)
list_cur = list(cursor)
json_data = dumps(list_cur)
with open('dataFB.json', 'w') as file_data:
    file_data.write(json_data)
cursor = collectionEmail.find({}).sort("_id, 1")
list_cur = list(cursor)
json_data = dumps(list_cur)
with open('dataEmail.json', 'w') as file_data:
    file_data.write(json_data)