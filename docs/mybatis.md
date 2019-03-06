
## SaveOrUpdate
Use `insert into <table> values(...) on duplicate key update` to implement save or update.
Or write this function in service layer.

```java
  @Insert({"INSERT INTO types(id,name) values(#{id}, #{name})", 
      "ON DUPLICATE KEY UPDATE name=#{name}"})
  void save(PetType petType) throws DataAccessException;
```

## One to Many / Many to One

* One to Many

Use collection: `@Result(property = "visits",  column = "pet_id",
      many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.VisitMapper.findByPetId"))`
      
* One to Many

Use association: `@Result(property = "owner",  column = "owner_id", javaType = Owner.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.OwnerMapper.findById"))`
      
Note that the column filed can add more than one parameters to match the method in `select` method      

* For non primitive class, declare the class type explicitly

e.g, `@Result(property = "birthDate",  column = "birth_date", javaType = Date.class)`

```java
@Select("SELECT * FROM pets WHERE id = #{id}")
  @Results({
    @Result(property = "birthDate",  column = "birth_date", javaType = Date.class),
    @Result(property = "type",  column = "type_id", javaType = PetType.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.PetTypeMapper.findById")),
    @Result(property = "owner",  column = "owner_id", javaType = Owner.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.OwnerMapper.findById")),
    @Result(property = "visits",  column = "pet_id",
      many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.VisitMapper.findByPetId")),
  })
  Pet findById(int id) throws DataAccessException;
```

## Reference
* http://www.mybatis.org/mybatis-3/java-api.html