Exp
=============================
experience game module

Using
=============================
```java
ArrayList<CustomExp> levelTable = new ArrayList<>();
levelTable.add(new CustomExp(1, 0, 100));
levelTable.add(new CustomExp(2, 100, 200));
levelTable.add(new CustomExp(3, 200, 300));
levelTable.add(new CustomExp(4, 300, 400));
Experience experience = Level.process(levelTable, 1, 4, 0, 123);
```

Result
=============================
```text
add_value:		123

level_up_count:		1

before_level:		1
before_value_per:	0.0
before_base_value:	0
before_next_value:	100
before_value:		0

after_level:		2
after_value_per:	23.0
after_base_value:	100
after_next_value:	200
after_value:		123
min_value:		100
min_level:		1

max_level:		4
max_value:		300
```


```js
{
	"before_level":1
	"before_value_per":0
	"level_up_count":0
	"add_value":0
	"after_level":1
	"before_base_value":0
	"before_next_value":100
	"after_base_value":0
	"min_value":100
	"max_level":2
	"after_next_value":100
	"after_value_per":0
	"after_value":0
	"min_level":1
	"before_value":0
	"max_value":10
}
```