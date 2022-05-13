Coverage: 34%
# IMS Starter Project

First Project for QA -- IMS Customer/Item/Order
This is a CRUD Project meaning it has a Create, Read, Update and Delete interacting with a SQL Database using a connection within Java. I started with
Customers.java, controller and DAO and added an address field myself. I also created Item and Order so that the customer could create a order and add a item to it 
with a functioning price calculator in order to find how much it will cost.

## Testing

### Controller Testing using Mockito

Using Mockito we can pass variables assigned values into tests and would be compared with inputs when running the application to ensure that the values match.
For example the item create test would create an item and use assertEquals to match the values inserted, same would be completed with customer and order, however with the delete method then assertEquals would expected nothing due to you delete the values inserted.

### DAO Tests

These tests would create a connection with the database and again use the assertEquals to ensure that the values inserted into the test matches the first entry into
the database.

## Domain tests

The Domain.java tests are a basically test to ensure that the setters and getters are working as well as the hashcode and equals too.


## Technologies
* Java
* GitHub
* Maven
* SQL Workbench
* Jira
* Mockito


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Eli Stribley** - *Initial work* - [elistribley](https://github.com/elistribley)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Pawel
