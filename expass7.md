Setup Up:
I had already installed docker in expass 1. The docker system info did not produce an error.

Using a Dockerized application: PostgreSQL:
I downloaded the PostgreSQL with the line "docker pull postgres" this worked without any issue.

I looked at the image documentation and figured out that -p 5432:5432 and
-e POSTGRES_PASSWORD=mysecretpassword was the port to expose and the enviroment variable to set.

Then the container was running, confirmed with "docker ps", inspected that everything looked good
with "docker logs my-postgres".

Installed DBeaver to run the SQL line "CREATE USER jpa_client WITH PASSWORD 'secret';
Added the "implementaion("org.postgresql:postgresql:42.7.4") and replaced the lines needed in 
presistence.xml.

Then I got the schema.up.sql and inserted into DBeaver, I then had some issues with permissions 
in my DB, but fixed it with this SQL line "GRANT ALL PRIVILEGES ON ALL TABLES IN schema public TO jpa_client;"

I did not use the --mount flag for docker as I could not figure out how it worked properly.

This task went fairly smoothly, had some issues implementing this line:
<property name="hibernate.connection.driver_class" value="org.postgresql.Driver"/>

However i figured out i was missing the necessary postgresql.jar file.

After that I had some testing and fixing to do seeing how I had struggled with the 4th assignment,
but using this instead somehow made assignment 4 easier.

Building my own dockerized application was fairly easy tho, just had minor issues where I
missmatched my gradle version.

Link to Dockerfile:
https://github.com/jeb015/pollapp/blob/main/Dockerfile
