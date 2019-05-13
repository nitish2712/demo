# demo
Structure of the app was created using spring initializer https://start.spring.io/.

This application is developed using spring boot.


# To run the App 

mvnw spring-boot:run

# To pass on the args with option

mvnw spring-boot:run -Dspring-boot.run.arguments="--enable" // enable is a option

args without options

mvnw spring-boot:run -Dspring-boot.run.arguments="arg1,arg2"

together

mvnw spring-boot:run -Dspring-boot.run.arguments="--enable,arg1,arg2"

# to change the spring profiles ("dev" in current scenario)

mvnw spring-boot:run -Dspring.profiles.active=dev


# to change the properties file name

mvnw spring-boot:run -Dspring.config.name=mycfg

# to change path of properties file

mvnw clean spring-boot:run -Dspring.config.location=classpath:META-INF/conf/