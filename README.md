# learnCassandraSpring

This is a sample application whic reads, writes, updates and deletes the data in to the cassandra database.    

## How to run the code in local ?

### Step 1: 

Download Cassandra from the below link.  

[Cassandra 2.8 Download](http://www.apache.org/dyn/closer.lua/cassandra/2.2.8/apache-cassandra-2.2.8-bin.tar.gz)

### Step 2: 

Run cassandra node in your local.  

The below command launches the cassandra node in your local.  

```
<casssandra base folder>/bin/cassandra
```

Launch **CQLSH** :  

```
<casssandra base folder>/bin/cqlsh --cqlversion='3.3.1'
```

Create the keyspace :  

```
create keyspace learncassandra WITH REPLICATION  = {'class': 'SimpleStrategy', 'replication_factor':'3'};
```
Create the Table :  

```
CREATE TABLE COURSES (
ID VARCHAR ,
NAME VARCHAR,
AUTHOR VARCHAR,
AUDIENCE INT,
DURATION INT,
CC BOOLEAN,
RELEASED TIMESTAMP,
MODULE_ID int,
MODULE_NAME varchar,
MODULE_DURATION int,
PRIMARY KEY(id,module_id)
) WITH COMMENT = 'A Table of Courses and modules';
```

### Build the app:  

```
./gradlew build
```

### Launch the app :  

```
 java -jar -Dspring.profiles.active=local build/libs/learnCassandra-0.0.1-SNAPSHOT.jar
```

### Application Output:  

```
******* Reading the Data from Users Table *******
******* No courses available for the provided Course id : Node-JS-Started
******* Inserted the course for the Course id :Node-JS-Started
Selected value from DB is : Node-JS-Started
Successfully Updated the author name to : Samuel Jackson
Selected value from DB is : Samuel Jackson
Deleted Course is : Node-JS-Started

```
