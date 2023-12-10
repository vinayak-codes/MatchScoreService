# MatchScoreService
A simple REST API for getting football match scores.

Project Details

1. JWT is required in the Authorization Header as Bearer space Token.
2. Only 2 users are generated internally for simplicity purposes.

   User 1 : "Vinayak" , "Pass@123", "ADMIN" (Will be able to access both end points)
   User 2 : "Rohan", "Pass@456", "USER" (Will be able to access only the score end point)

3. It was not clear in the problem statement that if I have to fetch the response for all the pages from the API so I implemented only for the first page.


   
* Implemented 3 endpoints :
   1. /login: to generate the JWT token for the user. (POST)
    payload : {
                    "username" : "vinayak",
                    "password" : "Pass@123"
              }
      JWT is not required



   2. /getTokenDetails: to get the details of the token (GET)
       JWT is required


   3. /getDrawMatches : to get the number of draw football matches in the given year (GET)
      Request Parameter: year
      JWT is required
