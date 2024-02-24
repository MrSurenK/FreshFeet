# FreshFeet
A full stack ecommerce shoe retailer application 

## Set up MYSQL on docker 
1. Run the following command (replace the password field with your password and make sure it matches in application.properties 
   ```
   $ docker run --name freshFeet-MySQL -v freshet-db:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=<password> -d mysql
   ```
2. Get into the MySQL container shell and run the following commands to set up the table and the user with access rights (Ensure that user is able to connect to the database outside of the container) 
   ```
    docker exec -it <container name> mysql -uroot -p
    CREATE DATABASE <DATABASE NAME>
    CREATE USER '<username>'@'%' IDENTIFIED BY '<password>';
    GRANT ALL PRIVILEGES ON *.* TO '<username>'@'%' WITH GRANT OPTION;
   ```
3. Now go onto applications.properties and ensure that the above settings are reflected according to your enviornment variables

