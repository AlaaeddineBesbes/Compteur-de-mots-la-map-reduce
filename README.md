# Compteur de mots map-reduce
### This Project is inspired from the hadoop.

In Order to replicate Hadoop mechanism We used RMI(remote method invocation).
We have 4 different classes and 2 interfaces .
- Server Class which is responsible of Splitting the text into multiple files and making the Client that will process the files
- Client Class that will Map the files then Create the hash map and then send the hash map to the Reducer 
- MapperImp class which the Client classes will call through the interface Mapper
- ReducerImp Class that will get the HashMap from the clients and make one big HashMap
