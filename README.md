# code_challenge

This is an API that allows users to add, retrieve and likes snippet. The API was built with Spring Boot  which is an open source Java-based framework used to create a micro Service. In this project, I used SOLID design principles, repository pattern with JPA(Java persistent API) and h2 database for storing and retrieving data.Also, I have a global error handler that validates user request and return user friendly error message.

This API accepts a snippet of text and makes that snippet available at a URL. 
Example:
Request :  curl -X POST -H "Content-Type: application/json" -d '{"name":"recipe", "expires_in": 30, "snippet":"1 apple"}'  https://example.com/snippets

Response:
 response 201 Created
{
  "url": "https://example.com/snippets/recipe",
  "name": "recipe",
  "expires_at": "2020-02-22T20:02:02Z",
  "snippet": "1 apple"
}

To get a particular Snippet
Get Request:  curl https://example.com/snippets/recipe
response 200 OK
{
  "url": "https://example.com/snippets/recipe",
  "name": "recipe",
  "expires_at": "2020-02-22T20:02:32Z",
  "snippet": "1 apple”,
  “Likes”: 0
}

To like a particular Snippet
Post Request:  curl -X POST https://example.com/snippets/recipe/like
response 200 OK
{
  "url": "https://example.com/snippets/recipe",
  "name": "recipe",
  "expires_at": "2020-02-22T20:02:32Z",
  "snippet": "1 apple",
  "likes": 1
}
