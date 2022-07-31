t_emp:
    CREATE TABLE `t_emp` (
      `emp_id` int(11) NOT NULL AUTO_INCREMENT,
      `emp_name` varchar(20) NOT NULL,
      `age` int NOT NULL,
      `gender` varchar(20) NOT NULL,
      `dept_id` int ,
      PRIMARY KEY (`emp_id`),
      CONSTRAINT `FK_emp` FOREIGN KEY (`dept_id`) REFERENCES `t_dept` (`dept_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

    insert into t_emp(emp_name,age,gender,dept_id)
    values("张三",23,"男",1),("李四",24,"男",1),("王五",25,"女",2)
t_dept:
    CREATE TABLE t_dept (dept_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    			dept_name VARCHAR(20))