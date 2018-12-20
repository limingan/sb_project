git提交步骤
git clone （这个是你新建本地git仓库，如已有可忽略此步）
复制下git项目的https链接，打开git bash客户端，找到你想要放置的路径下，输入链接，可以在链接后边加个其他的名字进行重命名，要是不加的话就显示git项目的名字。输入你的git账号和密码即可获取到对应的git项目代码。

提交代码
第一步：git status  
查看当前状态
当你忘记修改了哪些文件的时候可以使用 git status  来查看当前状态，
红色的字体显示的就是你修改的文件。

第二步：git add .  或者 git add xxx
如果git status 查看了当前状态发现都要提交，那么可以直接使用 git add .  就可以把内容全部添加到本地git缓存区中
如果git status 查看了当前状态发现有部分文件不想提交，那么就使用git add xxx(红色文字的文件链接)  就可以提交部分文件到本地git缓存区。

第三步：git commit -m "描述"  
推送修改到本地git库中

第四步：git pull <远程主机名> <远程分支名>  
取回远程主机某个分支的更新，再与本地的指定分支合并。
例如：项目所在的远程主机是origin  远程主分支名为master 我们就可以写成 pull origin master

第五步：git push <远程主机名> <远程分支名>  
把当前提交到git本地仓库的代码推送到远程主机的某个远程分之上，入 push origin master，这一步需要输入用户名，然后弹出密码输入
输入完及push成功