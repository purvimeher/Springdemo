to start app: ./mvnw spring-boot:run

visit http://localhost:8080/api/greeting

actutator help

Get specific vendorInfo
http://localhost:8080/vendorInfo/2

Get all VendorInfo
http://localhost:8080/vendorInfo/all

Post new VendorInfo
http://localhost:8080/vendorInfo

request sample body
{
"vendorID": 2,
"name": "Purvi",
"location": "London"
}

all references from
https://thinkconstructive.com/

video youtube references:
https://youtube.com/playlist?list=PLcs1FElCmEu121gqGwlQt47d0SqNkzSTK&si=m7bGrIW26TU3IUnd

mongodb java spring connectivity:
https://www.mongodb.com/resources/products/compatibilities/spring-boot

Rest endpoints:


Swagger UI:
https://muralitechblog.com/swagger-rest-api-dcoumentation-for-spring-boot/
//TODO Fix Swagger UI

http://localhost:8080/swagger-ui/ [not working even after adding dependencies]

dev tools dependency added to live reload etc

//TODO
LOGBACK logging

//TODO
Learn Spring Boot annotations

csv upload data
https://github.com/sk444/spring-boot-import-csv-file-app

https://www.pixeltrice.com/import-the-csv-file-into-mysql-database-using-spring-boot-application/

mysql related
CREATE TABLE vendor_info_service.product (
id INT AUTO_INCREMENT primary key NOT NULL,
brand varchar(255),
brand_category varchar(255),
size_ml varchar(255),
maximum_retail_price_per_bottle double(10,2),
price_duration varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



SELECT * FROM vendor_info_service.product ;

alter table vendor_info_service.product add price_duration varchar(255);