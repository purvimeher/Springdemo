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


video youtube references:
https://youtube.com/playlist?list=PLcs1FElCmEu121gqGwlQt47d0SqNkzSTK&si=m7bGrIW26TU3IUnd

mongodb java spring connectivity:
https://www.mongodb.com/resources/products/compatibilities/spring-boot