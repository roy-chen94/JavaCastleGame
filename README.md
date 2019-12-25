# JavaCastleGame
This project is the homework for ZJU MOOC "Java OOP"（《面向对象程序设计——Java语言》） week 5. 

这是中国大学MOOC浙江大学《面向对象程序设计——Java语言》第5周的作业（中国大学MOOC ID:pikachu122）

## Rules / 游戏规则

There is a chest in every room. Starting from outside, you can discover all the rooms using "go" command. Using "search" command, you have a certain chance to find a chest in each room. Collect all the chests and finish the game!

从城堡外出发，用“go”命令进入各个房间（其中城堡外还有两个被称为“up”和“down”的“任意门”，可以进入任何一个房间，这两个门的内容也是本周的作业内容），每个房间都有一个宝箱，在各个房间内使用search命令，有一定几率得到宝箱。收集完所有的宝箱后游戏完成并退出。

## Commands / 命令

go < direction >: Enter the room in this direction.

go <方向>: 进入这个方向的房间。

search: Try to search for a chest in current room.

search: 在当前房间寻找宝箱。

help: Show all the commands you can use.

help: 显示所有你可以使用的命令。

show: Show your game process (the number of chests you have got and the total number of chests).

show：显示你的游戏进度（已得到宝箱数和总宝箱数）。

bye: Exit the game. (Your game process will not be saved.)

bye：退出游戏。（你的游戏进度不会被保存。）

*(hidden) cgprob < probability >: Change the probability of finding a chest. (Default value is 0.2. This command is not displayed in the "help" information.)

*（隐藏）cgprob < 概率 >: 改变发现宝箱的概率（默认为0.2。该命令不显示在help信息中。）
