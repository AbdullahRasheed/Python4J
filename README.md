# Python4J
Allows the use and output of python scripts with parameters and changeable variables from the script

```python
s=""
lst=[]
print(s)
for i in lst :
  print(i)
```
```java
for(String s : Python.runScript(PATH, "Hello World!", Arrays.toString(new int[]{1,2,3,4}))){
  System.out.println(s);
}
```
```
Hello World!
1
2
3
4
```
