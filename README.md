# Spring Data JPA

 You can create concrete repositories by creating repository interfaces and letting Spring Data JPA do all the heavy lifting.

[Spring Data JPA Tutorial](http://www.petrikainulainen.net/spring-data-jpa-tutorial/)

using Hibernate as your JPA provider


jpaRepository : List<?> findAll() 

![image](https://dl.dropboxusercontent.com/u/47510080/markdown/spring/3/3.png)

so , I choose to extends jpaRepository .


[CrudRepository](http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)

[PagingAndSortingRepository](http://docs.spring.io/spring-data/data-commons/docs/1.7.0.RELEASE/api//org/springframework/data/repository/PagingAndSortingRepository.html)

[JpaRepository](http://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)


# Spring Data JPA - three types of Query

[link](http://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/)

### 1. Query Creation from Method Name

According to method Name and transform to sql query.

[function name mapping](http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation)

### 2. JPA Named Queries

Code some sql query to Entity .

![image](https://dl.dropboxusercontent.com/u/47510080/markdown/spring/3/4.png)

corresponding repository

![image](https://dl.dropboxusercontent.com/u/47510080/markdown/spring/3/5.png)

It's a special way to do query , but maybe it's not practical.

### 3. @Query Annotation

![image](https://dl.dropboxusercontent.com/u/47510080/markdown/spring/3/6.png)

Using this way can do a lot of elastic way to query .

I think 1 , 3 is enough.



Next goal is : like and date.