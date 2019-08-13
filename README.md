# BookLibraryApplication

### Simple REST API application to use for get information about books in library from json file.
### Created with:
* Java
* SpringBoot
* Jackson
* JUnit 4
* REST Assured 

## Requirements

* Maven 3.3 or newer
* JDK 8 or newer

## How to build

### Go to project destination and run command "mvn clean install". Project will build automatically.

## How to run

### Go to project destination and run command "mvn spring-boot:run". Project will run automatically.

### You can write command "mvn clean install spring-boot:run" and above steps will do both in order.

## More info

### Application will start on port 8080 on your local host. 

###Go to  http://localhost:8080/api/allbooks for get all of books in JSON file.  (Return in JSON file)

### Go to http://localhost:8080/api/book/isbn for get book by ISBN (Where is "isbn" you should provide value of isbn) (Return in JSON file)

### Go to http://localhost:8080/api/books/category  for get book by ISBN (Where is "category" you should provide value of category) (Return in JSON file)

### Go to http://localhost:8080/api/booksratings for get book authors ratings. (Return in JSON file)

If there are not books matched User get 404 status code.

#### Used Design Pattern: Composite Pattern. Provided json file has complex structure. To make main POJO class with book informations which can be mapped from JSON file (VolumeInfo etc.) I compose few objects to make structure similar as Json items.
