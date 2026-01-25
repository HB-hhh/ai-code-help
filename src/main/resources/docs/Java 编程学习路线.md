#### 标题：Java 编程（后端方向）学习路线（从入门到架构师）

##### 第一章 入门基础（0-3 个月）

核心目标：掌握 Java 语法核心，建立编程思维，能编写简单控制台程序。

1. 环境搭建与工具使用

   - 掌握 JDK 安装、环境变量配置（Windows/Mac/Linux），理解 JDK、JRE、JVM 的区别与联系。
   - 熟练使用 IDE 工具（IntelliJ IDEA），掌握项目创建、断点调试、快捷键操作（重构、格式化等）。
   - 了解 Git 基础操作（提交、推送、分支管理），养成版本控制习惯。

   

2. Java 核心语法

   - 基础语法：变量、数据类型（基本类型与引用类型）、运算符、流程控制（条件判断、循环、switch）。
   - 面向对象核心：类与对象、构造方法、封装、继承、多态，理解抽象类与接口的区别及使用场景。
   - 常用 API：String 类及常用方法、集合框架入门（ArrayList、HashMap）、异常处理（try-catch-finally、自定义异常）。
   - 特性理解：static 关键字、this 与 super、final 修饰符、内部类（成员内部类、局部内部类、匿名内部类）。

   

3. 基础进阶

   - 掌握 IO 流基础（字节流、字符流），能实现文件的读写操作。
   - 了解 Java 多线程入门（Thread 类、Runnable 接口），理解线程生命周期。
   - 推荐资源：《Java 核心技术卷 I》（前 8 章）、IDEA 官方教程、B 站尚硅谷 Java 基础视频。

   

##### 第二章 进阶核心（3-6 个月）

核心目标：深入 Java 底层特性，掌握常用框架基础，能开发简单 Web 应用。

1. 集合框架与数据结构

   - 全面掌握集合体系：List（LinkedList、Vector）、Set（HashSet、TreeSet）、Map（HashMap、TreeMap、ConcurrentHashMap）的底层实现（数组 + 链表 / 红黑树）、优缺点及适用场景。
   - 理解集合线程安全问题，掌握线程安全集合（Vector、CopyOnWriteArrayList）的使用。
   - 补充数据结构基础：数组、链表、哈希表、红黑树的核心原理，能分析集合操作的时间复杂度。

   

2. 多线程与并发编程

   - 深入线程机制：线程池（ThreadPoolExecutor）核心参数、工作原理，掌握常见线程池（FixedThreadPool、CachedThreadPool）的使用与场景。
   - 并发安全：synchronized 关键字（对象锁、类锁）、volatile 关键字（可见性、禁止指令重排）、Lock 接口（ReentrantLock、ReadWriteLock）。
   - 并发工具类：CountDownLatch、CyclicBarrier、Semaphore 的使用，理解 ThreadLocal 的原理与应用（如 Spring 事务管理）。
   - 推荐资源：《Java 并发编程实战》、Java 官方文档并发章节。

   

3. JVM 基础

   - 核心组成：类加载器（Bootstrap、Extension、Application）、类加载过程（加载、验证、准备、解析、初始化）、双亲委派模型。
   - 内存模型：堆、栈、方法区、程序计数器的作用，理解 GC（垃圾回收）核心概念（可达性分析、垃圾回收算法、常见收集器）。
   - 性能调优入门：JVM 参数配置（堆大小、垃圾收集器选择），使用 jps、jstat、jmap 等工具分析简单内存问题。

   

4. 数据库与 JDBC

   - 掌握 MySQL 基础：SQL 语句（增删改查、联表查询、索引、事务），理解数据库索引原理（B + 树）。
   - JDBC 编程：加载驱动、建立连接、Statement/PreparedStatement、ResultSet，理解数据库连接池（Druid、HikariCP）的作用与使用。
   - ORM 入门：了解 MyBatis 基础，掌握 XML 配置、Mapper 接口、SQL 映射，能实现简单的数据库 CRUD 操作。

   

##### 第三章 框架与 Web 开发（6-9 个月）

核心目标：熟练使用 Spring 生态框架，能独立开发企业级 Web 应用。

1. Spring 核心

   - 理解 Spring IoC 容器：依赖注入（DI）、控制反转（IoC），掌握 Bean 的创建、配置（注解式、XML 式）、生命周期。
   - Spring AOP：面向切面编程，理解切面、通知、切入点，掌握 AOP 在日志、事务、权限控制中的应用。
   - 事务管理：Spring 声明式事务（@Transactional）、事务隔离级别、传播行为。

   

2. Spring Boot

   - 掌握 Spring Boot 核心特性：自动配置、 starters 依赖、嵌入式服务器（Tomcat）。
   - 熟练开发 RESTful API：请求映射（@GetMapping、@PostMapping）、参数接收、响应封装、异常全局处理（@ControllerAdvice）。
   - 整合常用组件：MyBatis-Plus（简化 CRUD）、Redis、Swagger（接口文档）、Validation（参数校验）。

   

3. Spring Cloud（微服务入门）

   - 核心组件：服务注册与发现（Nacos/Eureka）、负载均衡（Ribbon/OpenFeign）、熔断降级（Sentinel）、配置中心（Nacos）。
   - 理解微服务架构思想，能搭建简单的微服务集群，实现服务间调用。

   

4. 实战项目

   - 开发一个单体 Web 应用（如博客系统、管理后台），涵盖用户登录、权限控制、数据 CRUD、分页查询等功能。
   - 技术栈：Spring Boot + MyBatis-Plus + MySQL + Redis + Swagger。

   

##### 第四章 高级进阶（9-12 个月）

核心目标：深入底层原理，掌握性能调优与分布式技术，具备架构设计意识。

1. 数据库进阶

   - 高级 SQL：存储过程、触发器、视图，优化 SQL 语句（explain 分析执行计划）。
   - 数据库优化：索引优化、分库分表（Sharding-JDBC）、读写分离，理解分布式事务（2PC、TCC、SAGA）。
   - 多数据库适配：了解 PostgreSQL、Oracle 的核心特性，掌握跨数据库开发技巧。

   

2. 分布式技术

   - 缓存技术：Redis 深入（数据结构、持久化、集群模式、缓存穿透 / 击穿 / 雪崩解决方案）。
   - 消息队列：RabbitMQ/Kafka 核心原理、生产者 / 消费者模式、消息可靠性保证、死信队列。
   - 分布式协调：ZooKeeper 基础（节点类型、Watcher 机制），理解其在分布式锁、服务发现中的应用。

   

3. 性能调优

   - JVM 调优：垃圾收集器选型（G1、ZGC）、内存参数优化、解决 OOM、内存泄漏问题。
   - 应用调优：接口性能优化（缓存、异步处理）、数据库调优、Tomcat 参数调优。
   - 监控工具：Prometheus + Grafana 监控系统指标，ELK 日志收集与分析。

   

4. 设计模式

   - 掌握常用设计模式：单例模式、工厂模式、代理模式、装饰器模式、策略模式、观察者模式。
   - 理解设计原则（开闭原则、依赖倒置原则等），能在项目中合理应用设计模式优化代码结构。