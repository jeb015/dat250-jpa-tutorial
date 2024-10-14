I had a lot of issues and misunderstandings with this task, 
solved them by googling and studying the ins and outs of the JPA which eventually lead me to solve 
the task.  The issues involved installation, writing the correct code for the db and relationships, also still could not get the "assertEquals(address.getOwners(), Set.of(customer));" due to what i am assuming is a mismatch in datatype somewhere in my code.


Link to code:
https://github.com/jeb015/dat250-jpa-tutorial

These lines allowed me to see the databases that was being created:
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="create"/>


![b55417f0df2c30e9697139277a468eab](https://github.com/user-attachments/assets/21d892c1-5f4d-47a7-96e7-d46ead2e3ba4)
