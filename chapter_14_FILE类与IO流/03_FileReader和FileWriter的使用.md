# 03_FileReader和FileWriter的使用

步骤：

- 创建读取或写入的File类的对象。

- 创建输入输出流。
- 具体的读取或写入过程。
  - 读取：`read(char[] cubf)`
  - 写入：`write(String str)`、`write(char[] cubf, 0, len)`
- 关闭流资源，避免内存泄漏。

因为涉及到流资源的关闭操作，所以使用try-catch-finally来处理异常。

对于输入流来讲，要求`File`类的对象对应的物理磁盘文件必须存在，否则，会报`FileNotFoundException`；对于输出流来讲，`File`类的对象对应的物理磁盘文件可以不存在，文件不存在的话会自动创建，文件存在的话和使用的构造器有关，使用`FileWriter(File file)`或`FileWriter(File file, false)`时会对现有文件进行覆盖，使用`FileWriter(File file, true)`会追加到现有文件内容之后。

