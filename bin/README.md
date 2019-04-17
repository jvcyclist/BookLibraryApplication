# BookLibraryApplication

### Simple REST API application to use for get information about books in library.
### Created with:
* Java
* SpringBoot
* Jackson

## How to build

### Go to project destination and run command "mvn clean install". Project will build automatically.

## How to run

### Go to project destination and run command "mvn spring-boot:run". Project will run automatically.

### You can write command "mvn clean install spring-boot:run" and above steps will do both in order.


## More info

### Application will start on port 8080 on your local host. e.g after build and run you should go to http://localhost:8080/book for get all of books in JSON file. Alias /book?="isbn" give you book by "isbn" identificator. /book?category="computers" give you all books which are from computers category.Alias /ratings give you average ratings of authors sorted descending. If there are not books matching by isbn user get 404 status code.
