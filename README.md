# Compteur de mots map-reduce
### This Project is inspired from the hadoop.

in Order to replucate hadoop mecanisme We used RMi(remote method invocation).
We have 4 diffrent classes and 2 interfaces .
- Server Class wich is resposible of Splitting the text into multipple files and making the Client that will procces the files
- Client Class that will Map the files Creat the hashmap and then send the hashmap to the Reducer 
- MApperImp class wich the Client classes will call through the interface Mapper
- ReducerImp Class that will get the HashMap from the clinets 
