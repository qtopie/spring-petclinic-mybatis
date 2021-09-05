
## Use config file to connect to DB easily 

example [`db/.my.cnf`](db/.my.cnf)

```bash
mysql --defaults-extra-file=db/.my.cnf
```

## keywords (reserved words)

 Keyword for mysql 8: https://dev.mysql.com/doc/refman/8.0/en/keywords.html

## deadlock

examples

https://stackoverflow.com/questions/40798084/mysql-select-for-update-deadlock

### reproduce steps

First check isolation is repeatable-read

```sql
show variables like '%isola%';
```

turn on logging

```sql
set global general_log=on;
```

set `autocommit=false` for each session


```sql
set autocommit=off;
SHOW VARIABLES WHERE variable_name='autocommit';
```

execute in each session

```sql
select * from pets where id = 14 for share;
select * from pets where id = 14 for update;
```

check 

```sql
show engine innodb status;
```


References

- https://dev.mysql.com/doc/refman/8.0/en/innodb-locking-reads.html
- https://dev.mysql.com/doc/refman/8.0/en/innodb-deadlock-example.html

